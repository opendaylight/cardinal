/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.net.InetAddress;
import java.util.Enumeration;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import com.sun.management.comm.SnmpAdaptorServer;
import com.sun.management.snmp.*;
import com.sun.management.snmp.IPAcl.JdmkAcl;
import com.sun.management.snmp.agent.SnmpMibAgent;

import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.opendaylight.cardinal.api.SnmpMibService;

@SuppressWarnings("all")
public class Agent implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(Agent.class);

    private final int htmlPort = 8082;
    private final int snmpPort = 161;
    private final String domain = new String("Cardinal");

    private InetAddressAcl odlAcl;
    private ObjectName htmlAdaptorObjName = null;
    private ObjectName snmpAdaptorObjName = null;

    private boolean snmpAdaptorStarted = false;
    private MBeanServer server = null;
    private static SnmpAdaptorServer snmpAdaptor = null;

    private BundleContext context = null;

    /**
     * @throws SnmpStatusException
     *         when snmp reaches abnormal state.
     * @throws RuntimeException
     *         when snmp fails to start.
     */
    public void startSnmpDaemon() throws SnmpStatusException, RuntimeException {
        ObjectName mibObjName;
        try {
            server = MBeanServerFactory.createMBeanServer(domain + ":name=smnpMibMBeans");

            /**
             * Create and start the HTML adaptor.
             */
            htmlAdaptorObjName =
                    new ObjectName(domain +
                            ":class=HtmlAdaptorServer,protocol=html,port=" +
                            htmlPort);
            boolean htmlAdaptorStarted = startingHtmlAdaptor(htmlPort, htmlAdaptorObjName);

            /**
             * Create and start the SNMP adaptor.
             */
            snmpAdaptorObjName =
                    new ObjectName(domain + ":class=SnmpAdaptorServer,protocol=snmp,port=" + snmpPort);
            snmpAdaptorStarted = startingSnmpAdaptor(snmpPort, snmpAdaptorObjName);

            /**
             * Create the ODL-CARDINAL-MIB and add it to the MBean server.
              */
            if (snmpAdaptorStarted) {
                LOG.info("SNMP Service started");
                /**
                 * Add the cardinal experimental MIB
                 */
                SnmpMibAgent mib = new ODL_CARDINAL_MIB();
                registerMib(mib);

                /* Register the SNMP API service */
                Bundle bundle = FrameworkUtil.getBundle(Agent.class);
                /*
                 * No Bundles or bundle context during build tests.
                 */
                if (bundle != null) {
                    context = bundle.getBundleContext();
                    context.registerService(SnmpMibService.class.getName(),
                            new SnmpMibSecviceImpl(this), null);
                } else {
                    LOG.info("Failed to get the bundle");
                }
            } else {
                LOG.info("SNMP Adaptor Server failed to start");
                throw new RuntimeException("SNMP Adaptor failed");
            }

            snmpAdaptor.setTrapPort(new Integer(snmpPort + 1));
        } catch (Exception e) {
            LOG.info("Exception: " + e.toString());
            throw new RuntimeException(e);
        }
    }

    /**
     * @param snmpPort.
     * @param snmpObjName.
     * @return when a value the Daemon fails to starts.
     */
    public boolean startingSnmpAdaptor(int snmpPort, ObjectName snmpObjName) {
        try {
            odlAcl = new JdmkAcl("root", "etc/opendaylight/karaf/snmp.acl");
        } catch (Exception e) {
            e.printStackTrace();
        }

        snmpAdaptor = new SnmpAdaptorServer(odlAcl, snmpPort);
        try {
            server.registerMBean(snmpAdaptor, snmpObjName);
        } catch (InstanceAlreadyExistsException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        } catch (MBeanRegistrationException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        } catch (NotCompliantMBeanException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
        snmpAdaptor.start();
        if (snmpAdaptor.getStateString().equals("STARTING")) {
            InetAddressAcl a = snmpAdaptor.getInetAddressAcl();
            Enumeration e = a.getTrapDestinations();
            while(e.hasMoreElements()) {
                LOG.info("cardinal trap acl: " + ((InetAddress)e.nextElement()).toString());
            }
            e = a.getInformDestinations();
            while(e.hasMoreElements()) {
                LOG.info("cardinal inform acl: " + ((InetAddress)e.nextElement()).toString());
            }
            return true;
        }
        return false;
    }

    /**
     * @param htmlPort.
     * @param htmlObjName.
     * @return false when a Htmladaptor fails to start.
     */
    public boolean startingHtmlAdaptor(int htmlPort, ObjectName htmlObjName) {
        HtmlAdaptorServer htmlAdaptor = new HtmlAdaptorServer(htmlPort);
        try {
            server.registerMBean(htmlAdaptor, htmlObjName);
        } catch (InstanceAlreadyExistsException e) {
            throw new RuntimeException(e);
        } catch (MBeanRegistrationException e) {
            throw new RuntimeException(e);
        } catch (NotCompliantMBeanException e) {
            throw new RuntimeException(e);
        }
        htmlAdaptor.start();
        if (htmlAdaptor.getStateString().equals("STARTING")) {
            return true;
        }
        return false;
    }

    private synchronized void registerMib(final SnmpMibAgent mib) throws RuntimeException {
        if (snmpAdaptorStarted) {
            try {
                ObjectName mibObjName =
                        new ObjectName(domain + ":class=" + mib.getMibName());
                server.registerMBean(mib, mibObjName);
                snmpAdaptor.addMib(mib);
                /**
                 * Send a trap for MIB registration.
                 */
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LOG.info("SNMP Adaptor not started yet!!!");
            throw new RuntimeException("MIB " +
                    mib.getMibName() + " registration failed");
        }
    }

    private synchronized void unregisterMib(final SnmpMibAgent mib) {
        snmpAdaptor.removeMib(mib);
        try {
            ObjectName mibObjName =
                new ObjectName(domain + ":class=" + mib.getMibName());
            server.unregisterMBean(mibObjName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Needed to get a reference on the SNMP adaptor object
    public static SnmpAdaptorServer getSnmpAdaptor() {
        return snmpAdaptor;
    }

    // Get a reference on the Mbean Server object
    public MBeanServer getMbeanServer() {
        return server;
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        snmpAdaptor.stop();
        snmpAdaptorStarted = false;
        LOG.info("All Daemons are killed successfully");
    }


    /**
     * Created by anirban on 25/12/16.
     */
    private class SnmpMibSecviceImpl implements SnmpMibService {
        private final Logger LOG = LoggerFactory.getLogger(SnmpMibSecviceImpl.class);

        private Agent agent = null;
        public SnmpMibSecviceImpl(Agent agent) {
            this.agent = agent;
        }

        public void loadMib(SnmpMibAgent mib){
            LOG.info("Loading Mib " + mib.getMibName());
            agent.registerMib(mib);
        }

        public void unloadMib(SnmpMibAgent mib){
            LOG.info("Unloading Mib " + mib.getMibName());
            agent.unregisterMib(mib);
        }

        public void setTrapAddress(InetAddress trapReceiver) {
            LOG.info("setTrapAddress called " + trapReceiver.toString());
        }

        public void sendSnmpTrap(SnmpOid ntOid, Enumeration<SnmpOid> payloadOid, Enumeration<SnmpString> payloadData) {
            LOG.info("sendSnmpTrap called");
            try {
                SnmpVarBindList varBindList = new SnmpVarBindList();
                SnmpTimeticks sysTime = new SnmpTimeticks(5000);
                SnmpVarBind sysTimeBind = new SnmpVarBind(new SnmpOid("1.3.6.1.2.1.1.3"), sysTime);
                varBindList.addVarBind(sysTimeBind);
                while(payloadOid.hasMoreElements())
                {
                    SnmpOid tempOid = payloadOid.nextElement();
                    SnmpVarBind ntBindPayload = new SnmpVarBind(ntOid, tempOid);
                    varBindList.addVarBind(ntBindPayload);
                    SnmpVarBind payloadOidBindData = new SnmpVarBind(tempOid, (SnmpValue)(payloadData.nextElement()));
                    varBindList.addVarBind(payloadOidBindData);
                }
                snmpAdaptor.snmpV2Trap(ntOid, varBindList);
                LOG.info("SnmpV2Trap Alarm sent  " + payloadData);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
