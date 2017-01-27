package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlOpenFlowStats2;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlOpenFlowStats2Test {
    SnmpMib myMib;
    MBeanServer server;
    OdlOpenFlowStats2 odlOpenFlowStats = new OdlOpenFlowStats2(myMib, server);

    @Before
    public void setUp() {
    }

    @After
    public void setDown() {
    }

    @Test
    public void getOdlOpenflowFlowstatsTest() throws SnmpStatusException {
        String x = "OdlOpenflowFlowstats";
        odlOpenFlowStats.setOdlOpenflowFlowstats2(x);
        String y = odlOpenFlowStats.getOdlOpenflowFlowstats2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowMeterstatsTest() throws SnmpStatusException {
        String x = "OdlOpenflowMeterstats";
        odlOpenFlowStats.setOdlOpenflowMeterstats2(x);
        String y = odlOpenFlowStats.getOdlOpenflowMeterstats2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowStatusTest() throws SnmpStatusException {
        String x = "OdlOpenflowStatus";
        odlOpenFlowStats.setOdlOpenflowStatus2(x);
        String y = odlOpenFlowStats.getOdlOpenflowStatus2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowManufacturerTest() throws SnmpStatusException {
        String x = "OdlOpenflowManufacturer";
        odlOpenFlowStats.setOdlOpenflowManufacturer2(x);
        String y = odlOpenFlowStats.getOdlOpenflowManufacturer2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowMacAddressTest() throws SnmpStatusException {
        String x = "OdlOpenflowMacAddress";
        odlOpenFlowStats.setOdlOpenflowMacAddress2(x);
        String y = odlOpenFlowStats.getOdlOpenflowMacAddress2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowInterfaceTest() throws SnmpStatusException {
        String x = "OdlOpenflowInterface";
        odlOpenFlowStats.setOdlOpenflowInterface2(x);
        String y = odlOpenFlowStats.getOdlOpenflowInterface2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlOpenflowNodeTest() throws SnmpStatusException {
        String x = "OdlOpenflowNode";
        odlOpenFlowStats.setOdlOpenflowNode2(x);
        String y = odlOpenFlowStats.getOdlOpenflowNode2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void checkOdlOpenflowFlowstatsTest() throws SnmpStatusException {
        String x = "OdlOpenflowFlowstats";
        odlOpenFlowStats.checkOdlOpenflowFlowstats2(x);
    }

    @Test
    public void checkOdlOpenflowMeterstatsTest() throws SnmpStatusException {
        String x = "OdlOpenflowMeterstats";
        odlOpenFlowStats.checkOdlOpenflowMeterstats2(x);
    }

    @Test
    public void checkOdlOpenflowMacAddressTest() throws SnmpStatusException {
        String x = "OdlOpenflowMacAddress";
        odlOpenFlowStats.checkOdlOpenflowMacAddress2(x);
    }

    @Test
    public void checkOdlOpenflowManufacturerTest() throws SnmpStatusException {
        String x = "OdlOpenflowManufacturer";
        odlOpenFlowStats.checkOdlOpenflowManufacturer2(x);
    }

    @Test
    public void checkOdlOpenflowInterfaceTest() throws SnmpStatusException {
        String x = "OdlOpenflowInterface";
        odlOpenFlowStats.checkOdlOpenflowInterface2(x);
    }

    @Test
    public void checkOdlOpenflowNodeTest() throws SnmpStatusException {
        String x = "OdlOpenflowNode";
        odlOpenFlowStats.checkOdlOpenflowNode2(x);
    }

    @Test
    public void checkOdlOpenflowStatusTest() throws SnmpStatusException {
        String x = "OdlOpenflowStatus";
        odlOpenFlowStats.checkOdlOpenflowStatus2(x);
    }
}

