/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import java.io.IOException;
import java.util.List;

import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.CardinalProvider;
import org.opendaylight.cardinal.impl.KarafInfo;
import org.opendaylight.cardinal.impl.OdlCardinalKarafInfoApi;
import org.opendaylight.cardinal.impl.OdlCardinalSysInfoApis;
import org.opendaylight.cardinal.impl.OdlCardinalKarafManager;
import org.opendaylight.cardinal.impl.OdlCardinalPolling;
import org.opendaylight.cardinal.impl.OdlCardinalSendTrap;
import org.opendaylight.cardinal.impl.OdlCardinalSetTrapReceiver;
import org.opendaylight.cardinal.impl.SetCardinalMibValues;
import org.opendaylight.cardinal.impl.odlCardinalProjectManager;
import org.slf4j.LoggerFactory;

import com.sun.management.snmp.SnmpStatusException;

;

/*import com.sun.management.snmp.SnmpStatusException;*/

public class CardinalModule extends
        org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210.AbstractCardinalModule {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(CardinalModule.class);
    final SetCardinalMibValues setSnmpValues = new SetCardinalMibValues();
    final Agent snmpDaemonStart = new Agent();
    final OdlCardinalSysInfoApis cardinalApi = new OdlCardinalSysInfoApis();
    final OdlCardinalKarafInfoApi cardinalKarafApi = new OdlCardinalKarafInfoApi();
    final KarafInfo manager = new KarafInfo();
    final OdlCardinalSetTrapReceiver cardinal = new OdlCardinalSetTrapReceiver();
    final OdlCardinalSendTrap sendTrap = new OdlCardinalSendTrap();
    final odlCardinalProjectManager pmanager = new odlCardinalProjectManager();
    public CardinalModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public CardinalModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            org.opendaylight.controller.config.api.DependencyResolver dependencyResolver,
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210.CardinalModule oldModule,
            java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {

        CardinalProvider provider = new CardinalProvider();
        getBrokerDependency().registerProvider(provider);
        cardinalApi.setDataProvider(getDataBrokerDependency());
        cardinalKarafApi.setDataProvider(getDataBrokerDependency());
        LOG.info("Starting Snmp Daemon");
        // Starting the SNMP Daemon
        try {
            snmpDaemonStart.startSnmpDaemon();
        } catch (SnmpStatusException e) {
            e.printStackTrace();
        }
        LOG.info("Fetching system information");
        // Fetching the system values and setting those values to our mib
        try {
            setSnmpValues.setMibValues();
            cardinalApi.setValues();
            manager.odlDaemonThreads();
            manager.odlKarafBundleListActive();
            manager.odlKarafBundleListInActive();
            manager.odlKarafBundleListResolved();
            manager.odlKarafCurrentHeapSize();
            manager.odlKarafFeatureInstalled();
            manager.odlKarafFeatureUnInstalled();
            manager.odlKarafMaxHeapSize();
            manager.odlLiveThreads();
            manager.odlPeakThreads();
            pmanager.odlMDSALIotDMListofcse();
            cardinalKarafApi.setValues();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
        return provider;

    }
    
  
}