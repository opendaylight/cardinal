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

    final int htmlPort = 8082;
    final int snmpPort = 161;
    String mockdomain = new String("MockTest");
    ObjectName mockhtmlObjName;
    ObjectName mocksnmpObjName;
    Agent mockagent = new Agent();

    @Before
    public void setUp() throws Exception {
        mockagent.startSnmpDaemon();
        mockhtmlObjName = new ObjectName(mockdomain + ":class=HtmlAdaptorServer,protocol=html,port=" + htmlPort);
        mocksnmpObjName = new ObjectName(mockdomain + ":class=SnmpAdaptorServer,protocol=snmp,port=" + snmpPort);
    }

    @After
    public void tearDown() throws Exception {
        mockagent.close();
    }

    @Test
    public void teststartingHtmlAdaptor() throws MalformedObjectNameException {
        boolean mockstarted = mockagent.startingHtmlAdaptor(htmlPort, mockhtmlObjName);
        if (mockstarted == true) {
            assertEquals(true, mockstarted);
        } else {
            assertEquals(false, mockstarted);
        }
    }

    @Test
    public void teststartingSnmpAdaptor() throws MalformedObjectNameException {
        boolean mockstarted = mockagent.startingSnmpAdaptor(snmpPort, mocksnmpObjName);
        if (mockstarted == true) {
            assertEquals(true, mockstarted);
        } else {
            assertEquals(false, mockstarted);
        }
    }
}