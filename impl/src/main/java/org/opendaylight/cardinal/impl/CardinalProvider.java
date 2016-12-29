/*
 * Copyright © 2016 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.util.ArrayList;
import java.util.List;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.Devices;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.DevicesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.Openflow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.OpenflowBuilder;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardinalProvider implements BindingAwareProvider, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(CardinalProvider.class);
    private ProviderContext providerContext;
    public static DataBroker dataService;
    final OdlCardinalOpenflowInfoApi odlOpenflowApi = new OdlCardinalOpenflowInfoApi();

    @Override
    public void onSessionInitiated(ProviderContext session) {
        LOG.info("CardinalProvider Session Initiated");
        LOG.info("RPC Implementation added");
        this.providerContext = session;
        this.dataService = session.getSALService(DataBroker.class);
        initCardinalOperational();
        LOG.info("Initial Operational data added");
    }

    private void initCardinalOperational() {
        // TODO Auto-generated method stub
        DevicesBuilder builder = new DevicesBuilder();
        OpenflowBuilder flow = new OpenflowBuilder();
        flow.setNodeName(null).setInterface(null).setMacAddress(null).setManufacturer(null).setStatus(null)
                .setFlowStats(null).setMeterStats(null).build();
        List<Openflow> openflowlist = new ArrayList<Openflow>();
        openflowlist.add(flow.build());
        builder.setOpenflow(openflowlist);
        Devices devices = builder.build();
        WriteTransaction tx = dataService.newWriteOnlyTransaction();
        tx.put(LogicalDatastoreType.OPERATIONAL, OdlCardinalOpenflowInfoApi.Cardinal_IID_OPENFLOW, devices);
        tx.submit();
    }

    @Override
    public void close() throws Exception {
        LOG.info("CardinalProvider Closed");
    }
}