/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sun.jdmk.comm.HtmlAdaptorServer;
import com.sun.management.comm.SnmpAdaptorServer;
import com.sun.management.snmp.SnmpStatusException;

@SuppressWarnings("all")
public class Agent implements AutoCloseable {
	private static final Logger LOG = LoggerFactory.getLogger(Agent.class);
	static SnmpAdaptorServer snmpAdaptor = null;

	public void startSnmpDaemon() throws SnmpStatusException {

		final MBeanServer server;
		final ObjectName htmlObjName;
		final ObjectName snmpObjName;
		final ObjectName mibObjName;
		int htmlPort = 8082;
		int snmpPort = 161;

		try {
			server = MBeanServerFactory.createMBeanServer();
			String domain = server.getDefaultDomain();

			// Create and start the HTML adaptor.
			//
			LOG.info("starting Html adaptor service");
			htmlObjName = new ObjectName(domain + ":class=HtmlAdaptorServer,protocol=html,port=" + htmlPort);
			HtmlAdaptorServer htmlAdaptor = new HtmlAdaptorServer(htmlPort);
			server.registerMBean(htmlAdaptor, htmlObjName);
			htmlAdaptor.start();
			LOG.info("started Html adaptor service");

			// Create and start the SNMP adaptor.
			//
			snmpObjName = new ObjectName(domain + ":class=SnmpAdaptorServer,protocol=snmp,port=" + snmpPort);
			snmpAdaptor = new SnmpAdaptorServer(snmpPort);
			server.registerMBean(snmpAdaptor, snmpObjName);
			snmpAdaptor.start();

			// Create the ODL-CARDINAL-MIB and add it to the MBean server.
			//

			mibObjName = new ObjectName("snmp:class=ODL_CARDINAL_MIB");
			ODL_CARDINAL_MIB mib2 = new ODL_CARDINAL_MIB();
			server.registerMBean(mib2, mibObjName);
			mib2.setSnmpAdaptorName(snmpObjName);
			snmpAdaptor.addMib(mib2);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Needed to get a reference on the SNMP adaptor object
	public static SnmpAdaptorServer getSnmpAdaptor() {
		return snmpAdaptor;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		LOG.info("All Daemons are killed successfully");
	}

}
