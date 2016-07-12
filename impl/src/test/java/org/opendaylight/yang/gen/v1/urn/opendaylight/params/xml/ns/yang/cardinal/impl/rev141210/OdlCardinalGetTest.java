/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.*;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.OdlCardinalGet;
import org.snmp4j.Snmp;
import org.snmp4j.event.ResponseEvent;

/**
 * @author Amandeep Singh Rattenpal
 * This class provides the test case for snmpGet scenarios
 *
 */
public class OdlCardinalGetTest {

	MBeanServer mockserver;

	ObjectName mockhtmlObjName;
	ObjectName mocksnmpObjName;
	ObjectName mockmibObjName;
	Agent mockagent = new Agent();
	int htmlPort = 8082;
	int snmpPort = 161;
	String strResponse = "";
	ResponseEvent response;
	Snmp snmp;
	OdlCardinalGet get = new OdlCardinalGet();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mockagent.startSnmpDaemon();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestSnmpGet() throws MalformedObjectNameException {
		String cardinalString = get.snmpGet("localhost", "public",
				".1.3.6.1.3.1.1.1.6.0");
		String mockString = "Opendaylight Node Information";

		assertEquals(mockString, cardinalString);

	}

}

