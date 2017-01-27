package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlNetconfStats2;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlNetconfStats2Test {
    SnmpMib myMib;
    MBeanServer server;
    OdlNetconfStats2 odlNetconfStats = new OdlNetconfStats2(myMib, server);

    @Before
    public void setUp() {
    }

    @After
    public void setDown() {
    }

    @Test
    public void getOdlNetconfNodeIdTest() throws SnmpStatusException {
        String x = "OdlNetconfNodeId";
        odlNetconfStats.setOdlNetconfNodeId2(x);
        String y = odlNetconfStats.getOdlNetconfNodeId2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlNetconfHostTest() throws SnmpStatusException {
        String x = "OdlNetconfHost";
        odlNetconfStats.setOdlNetconfHost2(x);
        String y = odlNetconfStats.getOdlNetconfHost2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlNetconfPortTest() throws SnmpStatusException {
        String x = "OdlNetconfPort";
        odlNetconfStats.setOdlNetconfPort2(x);
        String y = odlNetconfStats.getOdlNetconfPort2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlNetconfStatusTest() throws SnmpStatusException {
        String x = "OdlNetconfStatus";
        odlNetconfStats.setOdlNetconfStatus2(x);
        String y = odlNetconfStats.getOdlNetconfStatus2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void checkOdlNetconfNodeIdTest() throws SnmpStatusException {
        String x = "OdlNetconfNodeId";
        odlNetconfStats.checkOdlNetconfNodeId2(x);
    }

    @Test
    public void checkOdlNetconfHostTest() throws SnmpStatusException {
        String x = "OdlNetconfHost";
        odlNetconfStats.checkOdlNetconfHost2(x);
    }

    @Test
    public void checkOdlNetconfPortTest() throws SnmpStatusException {
        String x = "OdlNetconfPort";
        odlNetconfStats.checkOdlNetconfPort2(x);
    }

    @Test
    public void checkOdlNetconfStatusTest() throws SnmpStatusException {
        String x = "OdlNetconfStatus";
        odlNetconfStats.checkOdlNetconfStatus2(x);
    }
}

