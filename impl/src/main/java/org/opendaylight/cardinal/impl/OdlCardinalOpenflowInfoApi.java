/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.util.ArrayList;
import java.util.List;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.Devices;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.DevicesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.Openflow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.OpenflowBuilder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.LoggerFactory;
import org.snmp4j.smi.OID;

/**
 *
 * @author Subodh Roy
 *
 */

public class OdlCardinalOpenflowInfoApi implements AutoCloseable {

    private DataBroker dataProvider;
    DevicesBuilder builder = new DevicesBuilder();
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalOpenflowInfoApi.class);
    public static final InstanceIdentifier<Devices> Cardinal_IID_OPENFLOW = InstanceIdentifier.builder(Devices.class)
            .build();
    final OID sysDescr = new OID(".1.3.6.1.2.1.1.1.0");
    final OID interfacesTable = new OID(".1.3.6.1.3.1.1.11.1");
    List<Openflow> openflowlist = new ArrayList<Openflow>();

    public OdlCardinalOpenflowInfoApi() {
        // TODO Auto-generated constructor stub
    }

    public void setDataProvider(final DataBroker salDataProvider) {
        this.dataProvider = salDataProvider;
        LOG.info("set data broker");
    }

    public Devices getValues() {
        OpenflowBuilder flow = new OpenflowBuilder();
        OdlCardinalGet get = new OdlCardinalGet();
        String openFlowNode = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.11.1.0");
        String interfaceName = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.11.2.0");
        String macaddress = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.11.3.0");
        String manufacturer = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.11.4.0");
        String status = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.11.5.0");
        String openFlowStats = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.11.6.0");
        String openFlowMeterstats = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.11.7.0");
        flow.setNodeName(openFlowNode).setInterface(interfaceName).setMacAddress(macaddress)
                .setManufacturer(manufacturer).setStatus(status).setFlowStats(openFlowStats)
                .setMeterStats(openFlowMeterstats).build();
        List<Openflow> openflowlist = new ArrayList<Openflow>();
        openflowlist.add(flow.build());
        builder.setOpenflow(openflowlist);
        return builder.build();
    }

    public boolean setValues() {
        getValues();
        WriteTransaction txn = dataProvider.newWriteOnlyTransaction();
        if (txn != null) {
            txn.put(LogicalDatastoreType.CONFIGURATION, Cardinal_IID_OPENFLOW, builder.build());
            LOG.info("create - RPC data added to Configuration datastore");
            txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_OPENFLOW, builder.build());
            LOG.info("create - RPC data added to Operational datastore");
            txn.merge(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_OPENFLOW, builder.build());
            txn.merge(LogicalDatastoreType.CONFIGURATION, Cardinal_IID_OPENFLOW, builder.build());
            txn.submit();
            return true;
        } else {
            return false;
        }
    }

    public Devices getOvsValues() {
        OpenflowBuilder flow = new OpenflowBuilder();
        final OID interfacesTable = new OID(".1.3.6.1.3.1.1.11.1");
        SimpleSnmpClient client = new SimpleSnmpClient("udp:127.0.0.1/2003");
        List<List<String>> tableContents = client
                .getTableAsStrings(new OID[] { new OID(interfacesTable.toString() + ".1"),
                        new OID(interfacesTable.toString() + ".2"), new OID(interfacesTable.toString() + ".3"),
                        new OID(interfacesTable.toString() + ".4"), new OID(interfacesTable.toString() + ".5") });
        for (int i = 0; i < tableContents.size(); i++) {
            String openFlowNode = tableContents.get(i).get(0);
            String interfaceName = tableContents.get(i).get(1);
            String macaddress = tableContents.get(i).get(2);
            String manufacturer = tableContents.get(i).get(3);
            String status = tableContents.get(i).get(4);
            String openFlowStats = "";
            String openFlowMeterstats = "";
            flow.setNodeName(openFlowNode).setInterface(interfaceName).setMacAddress(macaddress)
                    .setManufacturer(manufacturer).setStatus(status).setFlowStats(openFlowStats)
                    .setMeterStats(openFlowMeterstats).build();
            openflowlist.add(flow.build());
        }
        LOG.info("openflowlist {}:", openflowlist);
        builder.setOpenflow(openflowlist);
        return builder.build();
    }

    public boolean setOvsValues(Devices devices) {
        LOG.info("devices {}:", devices);
        WriteTransaction txn = dataProvider.newWriteOnlyTransaction();
        if (txn != null) {
            txn.put(LogicalDatastoreType.CONFIGURATION, Cardinal_IID_OPENFLOW, devices);
            LOG.info("create - RPC data added to Configuration datastore");
            txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_OPENFLOW, devices);
            LOG.info("create - RPC data added to Operational datastore");
            txn.merge(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_OPENFLOW, devices);
            txn.merge(LogicalDatastoreType.CONFIGURATION, Cardinal_IID_OPENFLOW, devices);
            txn.submit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
    }
}
