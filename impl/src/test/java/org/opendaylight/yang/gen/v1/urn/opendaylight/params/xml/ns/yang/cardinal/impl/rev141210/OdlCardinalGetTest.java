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
import org.slf4j.LoggerFactory;
import org.snmp4j.Snmp;
import org.snmp4j.event.ResponseEvent;

/** 
 * @author Subodh Roy
 * 
 */ 
public class OdlCardinalGetTest {
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalGetTest.class);

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
        public void TestSnmpGet(){
           String cardinalString = get.snmpGet("localhost", "public",
                                     ".1.3.6.1.3.1.1.1.6.0");
           String mockString="";
           if (cardinalString!=null)
           {
           if(cardinalString.contains(" Opendaylight Node Information") || cardinalString.contains(" Opendaylight Node A") || cardinalString.contains(" localhost") )
        	   mockString=cardinalString;
               assertEquals(mockString, cardinalString);
           }
           else{
        	  
        	   LOG.info("cardinal response is null because pdu response is null ");
           }
        }

}
