package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalFeatureInstallModule;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlCardinalFeatureInstallModuleTest {
    SnmpMib myMib;
    MBeanServer server;
    OdlCardinalFeatureInstallModule odlCardinalFeatureInstallModule = new OdlCardinalFeatureInstallModule(myMib,
            server);

    @Before
    public void setUp() {
    }

    @After
    public void setDown() {
    }

    @Test
    public void getFeatureInstalled10Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled10(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled10();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getFeatureInstalled9Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled9(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled9();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getFeatureInstalled8Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled8(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled8();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getFeatureInstalled7Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled7(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled7();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getFeatureInstalled6Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled6(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled6();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getFeatureInstalled5Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled5(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled5();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getFeatureInstalled4Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled4(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled4();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getFeatureInstalled3Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled3(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled3();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getFeatureInstalled2Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled2(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getFeatureInstalled1Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setFeatureInstalled1(x);
        String y = odlCardinalFeatureInstallModule.getFeatureInstalled1();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlKarafFeatureListUnInstalledTest() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.setOdlKarafFeatureListInstalled(x);
        String y = odlCardinalFeatureInstallModule.getOdlKarafFeatureListInstalled();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void checkFeatureInstalled10Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled10(x);
    }

    @Test
    public void checkFeatureInstalled9Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled9(x);
    }

    @Test
    public void checkFeatureInstalled8Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled8(x);
    }

    @Test
    public void checkFeatureInstalled7Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled7(x);
    }

    @Test
    public void checkFeatureInstalled6Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled6(x);
    }

    @Test
    public void checkFeatureInstalled5Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled5(x);
    }

    @Test
    public void checkFeatureInstalled4Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled4(x);
    }

    @Test
    public void checkFeatureInstalled3Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled3(x);
    }

    @Test
    public void checkFeatureInstalled2Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled2(x);
    }

    @Test
    public void checkFeatureInstalled1Test() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkFeatureInstalled1(x);
    }

    @Test
    public void checkOdlKarafFeatureListUnInstalledTest() throws Exception {
        String x = "karaf";
        odlCardinalFeatureInstallModule.checkOdlKarafFeatureListInstalled(x);
    }
}