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
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.karaf.rev160620.CardinalKarafInfo;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.karaf.rev160620.CardinalKarafInfoBuilder;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.LoggerFactory;

public class OdlCardinalKarafInfoApi {
    // public DataBroker dataProvider;
    private DataBroker dataProvider;
    CardinalKarafInfoBuilder builder = new CardinalKarafInfoBuilder();
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalKarafInfoApi.class);
    public static final InstanceIdentifier<CardinalKarafInfo> Cardinal_IID_KARAF = InstanceIdentifier
            .builder(CardinalKarafInfo.class).build();

    public OdlCardinalKarafInfoApi() {
    }

    public void setDataProvider(final DataBroker salDataProvider) {
        this.dataProvider = salDataProvider;
        LOG.info("set data broker");
    }

    /**
     * setting mib values to the yang variables.
     */
    public CardinalKarafInfo getOidValues() {
        OdlCardinalGet get = new OdlCardinalGet();
        String odlKarafBundleListInstalled1 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.5.1.0");
        String odlKarafBundleListInstalled2 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.5.2.0");
        String odlKarafBundleListInstalled3 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.5.3.0");
        String odlKarafBundleListInstalled4 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.5.4.0");
        String odlKarafBundleListInstalled5 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.5.5.0");

        String odlKarafBundleListResolved1 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.6.1.0");
        String odlKarafBundleListResolved2 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.6.2.0");
        String odlKarafBundleListResolved3 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.6.3.0");
        String odlKarafBundleListResolved4 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.6.4.0");
        String odlKarafBundleListResolved5 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.6.5.0");

        String odlKarafBundleListActive1 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.1.0");
        String odlKarafBundleListActive2 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.2.0");
        String odlKarafBundleListActive3 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.3.0");
        String odlKarafBundleListActive4 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.4.0");
        String odlKarafBundleListActive5 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.5.0");
        String odlKarafBundleListActive6 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.6.0");
        String odlKarafBundleListActive7 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.7.0");
        String odlKarafBundleListActive8 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.8.0");
        String odlKarafBundleListActive9 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.9.0");
        String odlKarafBundleListActive10 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.4.10.0");

        String odlKarafFeatureListUnInstalled1 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.1.0");
        String odlKarafFeatureListUnInstalled2 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.2.0");
        String odlKarafFeatureListUnInstalled3 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.3.0");
        String odlKarafFeatureListUnInstalled4 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.4.0");
        String odlKarafFeatureListUnInstalled5 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.5.0");
        String odlKarafFeatureListUnInstalled6 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.6.0");
        String odlKarafFeatureListUnInstalled7 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.7.0");
        String odlKarafFeatureListUnInstalled8 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.8.0");
        String odlKarafFeatureListUnInstalled9 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.9.0");
        String odlKarafFeatureListUnInstalled10 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.3.10.0");

        String odlKarafFeatureListInstalled1 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.1.0");
        String odlKarafFeatureListInstalled2 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.2.0");
        String odlKarafFeatureListInstalled3 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.3.0");
        String odlKarafFeatureListInstalled4 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.4.0");
        String odlKarafFeatureListInstalled5 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.5.0");
        String odlKarafFeatureListInstalled6 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.6.0");
        String odlKarafFeatureListInstalled7 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.7.0");
        String odlKarafFeatureListInstalled8 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.8.0");
        String odlKarafFeatureListInstalled9 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.9.0");
        String odlKarafFeatureListInstalled10 = get.snmpGet("localhost", "public", ".1.3.6.1.3.1.1.2.10.0");

        builder.setOdlKarafBundleListActive1(odlKarafBundleListActive1);
        builder.setOdlKarafBundleListActive2(odlKarafBundleListActive2);
        builder.setOdlKarafBundleListActive3(odlKarafBundleListActive3);
        builder.setOdlKarafBundleListActive4(odlKarafBundleListActive4);
        builder.setOdlKarafBundleListActive5(odlKarafBundleListActive5);
        builder.setOdlKarafBundleListActive6(odlKarafBundleListActive6);
        builder.setOdlKarafBundleListActive7(odlKarafBundleListActive7);
        builder.setOdlKarafBundleListActive8(odlKarafBundleListActive8);
        builder.setOdlKarafBundleListActive9(odlKarafBundleListActive9);
        builder.setOdlKarafBundleListActive10(odlKarafBundleListActive10);

        builder.setOdlKarafBundleListResolved1(odlKarafBundleListResolved1);
        builder.setOdlKarafBundleListResolved2(odlKarafBundleListResolved2);
        builder.setOdlKarafBundleListResolved3(odlKarafBundleListResolved3);
        builder.setOdlKarafBundleListResolved4(odlKarafBundleListResolved4);
        builder.setOdlKarafBundleListResolved5(odlKarafBundleListResolved5);

        builder.setOdlKarafBundleListInstalled1(odlKarafBundleListInstalled1);
        builder.setOdlKarafBundleListInstalled2(odlKarafBundleListInstalled2);
        builder.setOdlKarafBundleListInstalled3(odlKarafBundleListInstalled3);
        builder.setOdlKarafBundleListInstalled4(odlKarafBundleListInstalled4);
        builder.setOdlKarafBundleListInstalled5(odlKarafBundleListInstalled5);

        builder.setOdlKarafFeatureListInstalled1(odlKarafFeatureListInstalled1);
        builder.setOdlKarafFeatureListInstalled2(odlKarafFeatureListInstalled2);
        builder.setOdlKarafFeatureListInstalled3(odlKarafFeatureListInstalled3);
        builder.setOdlKarafFeatureListInstalled4(odlKarafFeatureListInstalled4);
        builder.setOdlKarafFeatureListInstalled5(odlKarafFeatureListInstalled5);
        builder.setOdlKarafFeatureListInstalled6(odlKarafFeatureListInstalled6);
        builder.setOdlKarafFeatureListInstalled7(odlKarafFeatureListInstalled7);
        builder.setOdlKarafFeatureListInstalled8(odlKarafFeatureListInstalled8);
        builder.setOdlKarafFeatureListInstalled9(odlKarafFeatureListInstalled9);
        builder.setOdlKarafFeatureListInstalled10(odlKarafFeatureListInstalled10);

        builder.setOdlKarafFeatureListUnInstalled1(odlKarafFeatureListUnInstalled1);
        builder.setOdlKarafFeatureListUnInstalled2(odlKarafFeatureListUnInstalled2);
        builder.setOdlKarafFeatureListUnInstalled3(odlKarafFeatureListUnInstalled3);
        builder.setOdlKarafFeatureListUnInstalled4(odlKarafFeatureListUnInstalled4);
        builder.setOdlKarafFeatureListUnInstalled5(odlKarafFeatureListUnInstalled5);
        builder.setOdlKarafFeatureListUnInstalled6(odlKarafFeatureListUnInstalled6);
        builder.setOdlKarafFeatureListUnInstalled7(odlKarafFeatureListUnInstalled7);
        builder.setOdlKarafFeatureListUnInstalled8(odlKarafFeatureListUnInstalled8);
        builder.setOdlKarafFeatureListUnInstalled9(odlKarafFeatureListUnInstalled9);
        builder.setOdlKarafFeatureListUnInstalled10(odlKarafFeatureListUnInstalled10);
        LOG.info("initiating read write transaction");

        return builder.build();
    }

    public boolean setValues() {
        getOidValues();
        ReadWriteTransaction txn = dataProvider.newReadWriteTransaction();
        if (txn != null) {
            txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_KARAF, builder.build());
            // txn.put(LogicalDatastoreType.CONFIGURATION, PRIMES_IID, p1);
            txn.submit();
            return true;
        } else {
            return false;
        }
    }
}
