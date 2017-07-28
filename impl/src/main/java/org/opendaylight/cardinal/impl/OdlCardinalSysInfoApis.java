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
import org.slf4j.LoggerFactory;

public class OdlCardinalSysInfoApis {
    private DataBroker dataProvider;
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalSysInfoApis.class);
    public static final InstanceIdentifier<CardinalSystemInfo> Cardinal_IID = InstanceIdentifier
            .builder(CardinalSystemInfo.class).build();

    public void setDataProvider(final DataBroker salDataProvider) {
        this.dataProvider = salDataProvider;
        LOG.info("set data broker");
    }

    /**
     * setting mib values to the yang variables.
     */
    public void setValues() {
        CardinalSystemInfo cardinalSystemInfo = getValues();
        LOG.info("initiating read write transaction");
        ReadWriteTransaction txn = dataProvider.newReadWriteTransaction();
        txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID, cardinalSystemInfo);
        // txn.put(LogicalDatastoreType.CONFIGURATION, PRIMES_IID, p1);
        txn.submit();
    }

    public CardinalSystemInfo getValues() {
        OdlCardinalGet get = new OdlCardinalGet();
        String sysInfo = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.1.6.0");
        String sysHostAddress = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.1.3.0");
        final String sysCpuUsage = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.1.1.0");
        final String sysMemUsage = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.1.2.0");
        final String sysUptime = get.snmpGet("localhost", "public", "1.3.6.1.3.1.1.1.5.0");
        LOG.info("wrting data to operational datastore");
        CardinalSystemInfoBuilder builder = new CardinalSystemInfoBuilder();
        builder.setOdlSystemSysInfo(sysInfo);
        builder.setOdlSystemHostAddress(sysHostAddress);
        builder.setOdlSystemCpuUsage(sysCpuUsage);
        builder.setOdlSystemMemUsage(sysMemUsage);
        builder.setOdlSystemOdlUptime(sysUptime);
        CardinalSystemInfo cardinalSystemInfo = builder.build();
        return cardinalSystemInfo;
    }
}
