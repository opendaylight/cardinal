/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.IOException;

import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.CommunityTarget;
import org.snmp4j.MessageDispatcher;
import org.snmp4j.MessageDispatcherImpl;
import org.snmp4j.MessageException;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.mp.StateReference;
import org.snmp4j.mp.StatusInformation;
import org.snmp4j.security.Priv3DES;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TcpAddress;
import org.snmp4j.smi.TransportIpAddress;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.AbstractTransportMapping;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;

public class OdlCardinalTrapReceiver implements CommandResponder {
        /**
         * Trap Listner
         */
        public synchronized void listen(TransportIpAddress address)
                        throws IOException {
                AbstractTransportMapping transport;
                if (address instanceof TcpAddress) {
                        transport = new DefaultTcpTransportMapping((TcpAddress) address);
                } else {
                        transport = new DefaultUdpTransportMapping((UdpAddress) address);
                }

                ThreadPool threadPool = ThreadPool.create("DispatcherPool", 10);
                MessageDispatcher mDispathcher = new MultiThreadedMessageDispatcher(
                                threadPool, new MessageDispatcherImpl());

                // add message processing models
                mDispathcher.addMessageProcessingModel(new MPv1());
                mDispathcher.addMessageProcessingModel(new MPv2c());

                // add all security protocols
                SecurityProtocols.getInstance().addDefaultProtocols();
                SecurityProtocols.getInstance().addPrivacyProtocol(new Priv3DES());

                // Create Target
                CommunityTarget target = new CommunityTarget();
                target.setCommunity(new OctetString("public"));

                Snmp snmp = new Snmp(mDispathcher, transport);
                snmp.addCommandResponder(this);

                transport.listen();
                System.out.println("Listening on " + address);

                try {
                        this.wait();
                } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                }
        }

        /**
         * This method will be called whenever a pdu is received on the given port
         * specified in the listen() method
         */
        public synchronized void processPdu(CommandResponderEvent cmdRespEvent) {
                System.out.println("Received PDU...");
                PDU pdu = cmdRespEvent.getPDU();
                if (pdu != null) {
                        System.out.println("Trap Type = " + pdu.getType());
                        System.out.println("Variables = " + pdu.getVariableBindings());
                        }
                }
        }
