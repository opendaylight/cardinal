package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlOpenFlowStats1;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlOpenFlowStats1Test {
    SnmpMib myMib;
    MBeanServer server;
    OdlOpenFlowStats1 odlOpenFlowStats = new OdlOpenFlowStats1(myMib, server);

    @Before
    public void setUp() {
    }

    @After
    public void setDown() {
    }

    @Test
    public void getOdlOpenflowFlowstatsTest() throws SnmpStatusException {
        String x = "OdlOpenflowFlowstats";
        odlOpenFlowStats.setOdlOpenflowFlowstats1(x);
        String y = odlOpenFlowStats.getOdlOpenflowFlowstats1();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowMeterstatsTest() throws SnmpStatusException {
        String x = "OdlOpenflowMeterstats";
        odlOpenFlowStats.setOdlOpenflowMeterstats1(x);
        String y = odlOpenFlowStats.getOdlOpenflowMeterstats1();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowStatusTest() throws SnmpStatusException {
        String x = "OdlOpenflowStatus";
        odlOpenFlowStats.setOdlOpenflowStatus1(x);
        String y = odlOpenFlowStats.getOdlOpenflowStatus1();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowManufacturerTest() throws SnmpStatusException {
        String x = "OdlOpenflowManufacturer";
        odlOpenFlowStats.setOdlOpenflowManufacturer1(x);
        String y = odlOpenFlowStats.getOdlOpenflowManufacturer1();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowMacAddressTest() throws SnmpStatusException {
        String x = "OdlOpenflowMacAddress";
        odlOpenFlowStats.setOdlOpenflowMacAddress1(x);
        String y = odlOpenFlowStats.getOdlOpenflowMacAddress1();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowInterfaceTest() throws SnmpStatusException {
        String x = "OdlOpenflowInterface";
        odlOpenFlowStats.setOdlOpenflowInterface1(x);
        String y = odlOpenFlowStats.getOdlOpenflowInterface1();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowNodeTest() throws SnmpStatusException {
        String x = "OdlOpenflowNode";
        odlOpenFlowStats.setOdlOpenflowNode1(x);
        String y = odlOpenFlowStats.getOdlOpenflowNode1();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void checkOdlOpenflowFlowstatsTest() throws SnmpStatusException {
        String x = "OdlOpenflowFlowstats";
        odlOpenFlowStats.checkOdlOpenflowFlowstats1(x);
    }

    @Test
    public void checkOdlOpenflowMeterstatsTest() throws SnmpStatusException {
        String x = "OdlOpenflowMeterstats";
        odlOpenFlowStats.checkOdlOpenflowMeterstats1(x);
    }

    @Test
    public void checkOdlOpenflowMacAddressTest() throws SnmpStatusException {
        String x = "OdlOpenflowMacAddress";
        odlOpenFlowStats.checkOdlOpenflowMacAddress1(x);
    }

    @Test
    public void checkOdlOpenflowManufacturerTest() throws SnmpStatusException {
        String x = "OdlOpenflowManufacturer";
        odlOpenFlowStats.checkOdlOpenflowManufacturer1(x);
    }

    @Test
    public void checkOdlOpenflowInterfaceTest() throws SnmpStatusException {
        String x = "OdlOpenflowInterface";
        odlOpenFlowStats.checkOdlOpenflowInterface1(x);
    }

    @Test
    public void checkOdlOpenflowNodeTest() throws SnmpStatusException {
        String x = "OdlOpenflowNode";
        odlOpenFlowStats.checkOdlOpenflowNode1(x);
    }

    @Test
    public void checkOdlOpenflowStatusTest() throws SnmpStatusException {
        String x = "OdlOpenflowStatus";
        odlOpenFlowStats.checkOdlOpenflowStatus1(x);
    }
}

