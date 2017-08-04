/*
 * Copyright © 2016 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import com.sun.management.snmp.SnmpStatusException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.Devices;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.DevicesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.Openflow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.OpenflowBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardinalProvider implements AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(CardinalProvider.class);
    private final DataBroker dataService;
    private final Agent snmpDaemon = new Agent();
    private final CallTimer callTimer = new CallTimer();
    private SnmpAgent snmpAgent;
    private OpenflowDeviceManager openflowDeviceManager;
    private NetconfDeviceManager netconfDeviceManager;

    public CardinalProvider(DataBroker dataService) {
        this.dataService = dataService;
    }

    public void init() {
        LOG.info("CardinalProvider initializing...");

        initCardinalOperational();

        startSnmpDaemon();

        setMIBValues();

        startSnmpAgent();
    }

    private void startSnmpAgent() {
        try {
            snmpAgent = new SnmpAgent("0.0.0.0/2003");
            snmpAgent.start();

            openflowDeviceManager = new OpenflowDeviceManager(dataService, snmpAgent);
            //netconfDeviceManager = new NetconfDeviceManager(dataService);
        } catch (IOException e) {
            LOG.error("Error starting snmp agent", e);
        }
    }

    private void setMIBValues() {
        final SetCardinalMibValues setSnmpValues = new SetCardinalMibValues();
        try {
            boolean settingFirstTimePassed = setSnmpValues.setMibValues();
            if (!settingFirstTimePassed) {
                LOG.warn("You may be not logged in as root!!!");
                return;
            }

            final OdlCardinalSysInfoApis cardinalApi = new OdlCardinalSysInfoApis();
            cardinalApi.setDataProvider(dataService);
            cardinalApi.setValues();

            final KarafInfo karafInfo = new KarafInfo();
            karafInfo.odlDaemonThreads();
            karafInfo.odlKarafBundleListActive();
            karafInfo.odlKarafBundleListInActive();
            karafInfo.odlKarafBundleListResolved();
            karafInfo.odlKarafCurrentHeapSize();
            karafInfo.odlKarafFeatureInstalled();
            karafInfo.odlKarafFeatureUnInstalled();
            karafInfo.odlKarafMaxHeapSize();
            karafInfo.odlLiveThreads();
            karafInfo.odlPeakThreads();

            final odlCardinalProjectManager pmanager = new odlCardinalProjectManager();
            pmanager.odlMDSALIotDMListofcse();

            final OdlCardinalKarafInfoApi cardinalKarafApi = new OdlCardinalKarafInfoApi();
            cardinalKarafApi.setDataProvider(dataService);
            cardinalKarafApi.setValues();

            //callTimer.CallTimerMain();
        } catch (Exception e) {
            LOG.error("Error setting MIB values", e);
        }
    }

    private void startSnmpDaemon() {
        LOG.info("Starting Snmp Daemon");
        try {
            snmpDaemon.startSnmpDaemon();
        } catch (SnmpStatusException e) {
            LOG.error("Error starting snmp deamon", e);
        }
    }

    private void initCardinalOperational() {
        DevicesBuilder builder = new DevicesBuilder();
        OpenflowBuilder flow = new OpenflowBuilder();
        flow.setNodeName(null).setInterface(null).setMacAddress(null).setManufacturer(null).setStatus(null)
                .setFlowStats(null).setMeterStats(null).build();
        List<Openflow> openflowlist = new ArrayList<>();
        openflowlist.add(flow.build());
        builder.setOpenflow(openflowlist);
        Devices devices = builder.build();
        WriteTransaction tx = dataService.newWriteOnlyTransaction();
        tx.put(LogicalDatastoreType.OPERATIONAL, OdlCardinalOpenflowInfoApi.Cardinal_IID_OPENFLOW, devices);
        tx.submit();

        LOG.info("Initial Operational data added");
    }

    @Override
    public void close() {
        snmpDaemon.close();
        callTimer.close();

        if (snmpAgent != null) {
            snmpAgent.stop();
        }

        if (openflowDeviceManager != null) {
            openflowDeviceManager.close();
        }

        if (netconfDeviceManager != null) {
            netconfDeviceManager.close();
        }

        LOG.info("CardinalProvider Closed");
    }
}
