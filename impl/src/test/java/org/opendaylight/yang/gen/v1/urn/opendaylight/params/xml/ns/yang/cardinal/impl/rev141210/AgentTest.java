package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.opendaylight.cardinal.impl.Agent;

public class AgentTest {
	
	MBeanServer mockserver;
	ObjectName mockhtmlObjName;
	ObjectName mocksnmpObjName;
	ObjectName mockmibObjName;
	Agent mockagent= new Agent();
	int htmlPort =8082;
	int snmpPort =161;
		    @Before
		    public void setUp() throws Exception {
		    	mockagent.startSnmpDaemon();
		        mockserver = MBeanServerFactory.createMBeanServer();
		        String mockdomain = mockserver.getDefaultDomain();
		        mockhtmlObjName = new ObjectName(mockdomain + ":class=HtmlAdaptorServer,protocol=html,port=" + htmlPort);
		        mocksnmpObjName = new ObjectName(mockdomain + ":class=SnmpAdaptorServer,protocol=snmp,port=" + snmpPort);      
		    }

		    @After
		    public void tearDown() throws Exception {
		        
		    }

		    @Test
		    public void teststartingHtmlAdaptor() throws MalformedObjectNameException {
		         //mockagent.startSnmpDaemon();
		        boolean mockstarted = mockagent.startingHtmlAdaptor(htmlPort, mockhtmlObjName, mockserver);
		        assertEquals(true, mockstarted);
		    }
		    @Test
		    public void teststartingSnmpAdaptor() throws MalformedObjectNameException {
		         //mockagent.startSnmpDaemon();
		        boolean mockstarted = mockagent.startingSnmpAdaptor(snmpPort, mocksnmpObjName, mockserver);
		        assertEquals(true, mockstarted);
		    }
}
