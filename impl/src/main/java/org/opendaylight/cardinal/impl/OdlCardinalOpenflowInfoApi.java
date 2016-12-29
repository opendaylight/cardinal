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

public class OdlCardinalOpenflowInfoApi implements AutoCloseable {

    private DataBroker dataProvider;
    DevicesBuilder builder = new DevicesBuilder();
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalOpenflowInfoApi.class);
    public static final InstanceIdentifier<Devices> Cardinal_IID_OPENFLOW = InstanceIdentifier.builder(Devices.class)
            .build();

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

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
    }
}
