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
import java.util.Map;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.netconf.rev161227.Devices;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.netconf.rev161227.DevicesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.netconf.rev161227.cardinalnetconfinfogrouping.Netconf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.netconf.rev161227.cardinalnetconfinfogrouping.NetconfBuilder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.LoggerFactory;

public class OdlCardinalNetconfInfoApi implements AutoCloseable {

    private DataBroker dataProvider;
    DevicesBuilder builder = new DevicesBuilder();
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalNetconfInfoApi.class);
    public static final InstanceIdentifier<Devices> Cardinal_IID_NETCONF = InstanceIdentifier.builder(Devices.class)
            .build();

    public OdlCardinalNetconfInfoApi() {
        // TODO Auto-generated constructor stub

    }

    public void setDataProvider(final DataBroker salDataProvider) {
        this.dataProvider = salDataProvider;
        LOG.info("set data broker");
    }

    public Devices getValues(Map<String, List<String>> netconfList) {
        NetconfBuilder flow = new NetconfBuilder();
        OdlCardinalGet get = new OdlCardinalGet();
        List<Netconf> netconflist = new ArrayList<Netconf>();
        int j = 14;
        for (int i = 0; i < netconfList.size(); i++) {
            String nodeName = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1." + j + ".1.0");
            String host = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1." + j + ".2.0");
            String port = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1." + j + ".3.0");
            String status = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1." + j + ".4.0");
            j++;
            flow.setNodeId(nodeName).setHost(host).setPort(port).setStatus(status).build();
            netconflist.add(flow.build());
        }
        builder.setNetconf(netconflist);
        return builder.build();
    }

    public boolean setValues(Map<String, List<String>> netconfList) {
        getValues(netconfList);
        WriteTransaction txn = dataProvider.newWriteOnlyTransaction();
        if (txn != null) {
            txn.put(LogicalDatastoreType.CONFIGURATION, Cardinal_IID_NETCONF, builder.build());
            LOG.info("create - RPC data added to Configuration datastore");
            txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_NETCONF, builder.build());
            LOG.info("create - RPC data added to Operational datastore");
            txn.merge(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_NETCONF, builder.build());
            txn.merge(LogicalDatastoreType.CONFIGURATION, Cardinal_IID_NETCONF, builder.build());
            txn.submit();
            return true;
        } else {
            return false;
        }
    }

    public boolean setNetConfValues(Devices devices) {
        LOG.info("NetConf devices {}:", devices);
        WriteTransaction txn = dataProvider.newWriteOnlyTransaction();
        if (txn != null) {
            txn.put(LogicalDatastoreType.CONFIGURATION, Cardinal_IID_NETCONF, devices);
            LOG.info("create - RPC data added to Configuration datastore");
            txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_NETCONF, devices);
            LOG.info("create - RPC data added to Operational datastore");
            txn.merge(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_NETCONF, devices);
            txn.merge(LogicalDatastoreType.CONFIGURATION, Cardinal_IID_NETCONF, devices);
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
