/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.rev160515.CardinalSystemInfo;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.rev160515.CardinalSystemInfoBuilder;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;

import com.google.common.collect.Sets.SetView;

public class OdlCardinalImpl implements AutoCloseable {
    private DataBroker dataProvider;
    public static final InstanceIdentifier<CardinalSystemInfo> Cardinal_IID = InstanceIdentifier
            .builder(CardinalSystemInfo.class).build();

    public OdlCardinalImpl() {
        // TODO Auto-generated constructor stub

    }

    public void setDataProvider(final DataBroker salDataProvider) {

        this.dataProvider = salDataProvider;
        System.out.println("set data broker");
    }

    public void setValues() {
        System.out.println("inside setvalues");
        CardinalSystemInfoBuilder v = new CardinalSystemInfoBuilder();
        v.setOdlSystemSysInfo("Odl-system-information");
        v.setOdlSystemHostAddress("172.21.182.254");
        v.setOdlSystemCpuUsage("89%");
        v.setOdlSystemMemUsage("23%");
        v.setOdlSystemOdlUptime("234sec");
        System.out.println("read write");
        ReadWriteTransaction txn = dataProvider.newReadWriteTransaction();
        txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID, v.build());
        // txn.put(LogicalDatastoreType.CONFIGURATION, PRIMES_IID, p1);
        txn.submit();

    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub

    }

}
