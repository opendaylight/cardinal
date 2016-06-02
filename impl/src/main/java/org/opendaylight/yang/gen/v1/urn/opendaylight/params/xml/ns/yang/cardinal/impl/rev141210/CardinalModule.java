/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.CardinalProvider;
import org.opendaylight.cardinal.impl.OdlCardinalImpl;
import org.opendaylight.cardinal.impl.SetCardinalMibValues;
import org.slf4j.LoggerFactory;

import com.sun.management.snmp.SnmpStatusException;

public class CardinalModule extends
        org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210.AbstractCardinalModule {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(CardinalModule.class);
    final SetCardinalMibValues setSnmpValues = new SetCardinalMibValues();
    final Agent snmpDaemonStart = new Agent();

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

        // Starting the SNMP Daemon
        try {

            snmpDaemonStart.StartSnmpDaemon();
        } catch (SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Fetching the system values and setting those values to our mib

        final long timeInterval = 2000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        setSnmpValues.setMibValues();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }     

                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread setSnmpValuethread = new Thread(runnable);
        setSnmpValuethread.start();        
        return provider;

    }
}
