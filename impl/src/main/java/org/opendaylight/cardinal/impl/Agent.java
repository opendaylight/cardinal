/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import com.sun.management.comm.SnmpAdaptorServer;
import com.sun.management.snmp.InetAddressAcl;
import com.sun.management.snmp.SnmpOid;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.SnmpTimeticks;
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.SnmpVarBind;
import com.sun.management.snmp.SnmpVarBindList;
import com.sun.management.snmp.IPAcl.JdmkAcl;
import com.sun.management.snmp.agent.SnmpMibAgent;

import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.util.Enumeration;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class Agent implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(Agent.class);

    private final int htmlPort = 8082;
    private final int snmpPort = 161;
    private final String domain = new String("Cardinal");

    private final String aclFilePath = new String("etc/opendaylight/karaf/");
    private final String aclFileName = new String("snmp.acl");
    private JdmkAcl odlAcl;

    private ObjectName htmlAdaptorObjName = null;
    private ObjectName snmpAdaptorObjName = null;

    private boolean snmpAdaptorStarted = false;
    private MBeanServer server = null;
    private SnmpAdaptorServer snmpAdaptor = null;

    public void init() {
        LOG.info("Starting Cardinal Snmp Agent");
        try {
            startSnmpDaemon();
        } catch (Exception e) {
            LOG.error("Exception: " + e.toString());
        }
    }

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
            odlAcl = new JdmkAcl("root" ,aclFilePath + aclFilePath);
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

    public synchronized void registerMib(final SnmpMibAgent mib) throws RuntimeException {
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

    public synchronized void unregisterMib(final SnmpMibAgent mib) {
        snmpAdaptor.removeMib(mib);
        try {
            ObjectName mibObjName =
                new ObjectName(domain + ":class=" + mib.getMibName());
            server.unregisterMBean(mibObjName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void setTrapAddress(final String trap_community, final String trapIpv4Address) {
        LOG.info("Setting new trap address : " + trapIpv4Address);
        final char LINEFEED = '\n';
        RandomAccessFile aclFile;

        try {
            aclFile = new RandomAccessFile(aclFilePath + aclFileName, "rw");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            aclFile.setLength(0L);
            aclFile.seek(0L);
            aclFile.writeBytes("acl={{" + LINEFEED);
            aclFile.writeBytes("    communities = " + trap_community + LINEFEED);
            aclFile.writeBytes("    access = read-only" + LINEFEED);
            aclFile.writeBytes("    managers = " + trapIpv4Address + LINEFEED);
            aclFile.writeBytes("}}" + LINEFEED);
            aclFile.writeBytes("trap={{" + LINEFEED);
            aclFile.writeBytes("    trap-community = " + trap_community + LINEFEED);
            aclFile.writeBytes("    hosts = " + trapIpv4Address + LINEFEED);
            aclFile.writeBytes("}}" + LINEFEED);
            aclFile.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            odlAcl.setAuthorizedListFile(aclFilePath + aclFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }

    // Needed to get a reference on the SNMP adaptor object
    public SnmpAdaptorServer getSnmpAdaptor() {
        return snmpAdaptor;
    }

    // Get a reference on the Mbean Server object
    public MBeanServer getMbeanServer() {
        return server;
    }

    @Override
    public void close() {
        if (snmpAdaptor != null) {
            snmpAdaptor.stop();
            snmpAdaptor = null;
        }
        snmpAdaptorStarted = false;
        LOG.info("All Daemons are killed successfully");
    }
}
