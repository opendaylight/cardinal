package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalBundleResolvedModule;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlCardinalBundleResolvedModuleTest {
    SnmpMib myMib;
    MBeanServer server;
    OdlCardinalBundleResolvedModule odlCardinalBundleResolvedModule = new OdlCardinalBundleResolvedModule(myMib,
            server);
    OdlCardinalBundleResolvedModule odlCardinalBundleResolvedMod = new OdlCardinalBundleResolvedModule(myMib);

    @Before
    public void setUp() {
    }

    @After
    public void setDown() {
    }

    @Test
    public void getResolvedBundle5Test() throws SnmpStatusException {
        String x = "ResolvedBundle5";
        odlCardinalBundleResolvedModule.setResolvedBundle5(x);
        String y = odlCardinalBundleResolvedModule.getResolvedBundle5();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getResolvedBundle4Test() throws SnmpStatusException {
        String x = "ResolvedBundle4";
        odlCardinalBundleResolvedModule.setResolvedBundle4(x);
        String y = odlCardinalBundleResolvedModule.getResolvedBundle4();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getResolvedBundle3Test() throws SnmpStatusException {
        String x = "ResolvedBundle3";
        odlCardinalBundleResolvedModule.setResolvedBundle3(x);
        String y = odlCardinalBundleResolvedModule.getResolvedBundle3();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getResolvedBundle2Test() throws SnmpStatusException {
        String x = "ResolvedBundle2";
        odlCardinalBundleResolvedModule.setResolvedBundle2(x);
        String y = odlCardinalBundleResolvedModule.getResolvedBundle2();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getResolvedBundle1Test() throws SnmpStatusException {
        String x = "ResolvedBundle1";
        odlCardinalBundleResolvedModule.setResolvedBundle1(x);
        String y = odlCardinalBundleResolvedModule.getResolvedBundle1();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlKarafBundleListResolvedTest() throws SnmpStatusException {
        String x = "ResolvedBundle";
        odlCardinalBundleResolvedModule.setOdlKarafBundleListResolved(x);
        String y = odlCardinalBundleResolvedModule.getOdlKarafBundleListResolved();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void checkOdlKarafBundleListResolvedTest() throws SnmpStatusException {
        String x = "ResolvedBundle";
        odlCardinalBundleResolvedModule.checkOdlKarafBundleListResolved(x);
    }

    @Test
    public void checkResolvedBundle5Test() throws SnmpStatusException {
        String x = "ResolvedBundle";
        odlCardinalBundleResolvedModule.checkResolvedBundle5(x);
    }

    @Test
    public void checkResolvedBundle4Test() throws SnmpStatusException {
        String x = "ResolvedBundle";
        odlCardinalBundleResolvedModule.checkResolvedBundle4(x);
    }

    @Test
    public void checkResolvedBundle3Test() throws SnmpStatusException {
        String x = "ResolvedBundle";
        odlCardinalBundleResolvedModule.checkResolvedBundle3(x);
    }

    @Test
    public void checkResolvedBundle2Test() throws SnmpStatusException {
        String x = "ResolvedBundle";
        odlCardinalBundleResolvedModule.checkResolvedBundle2(x);
    }

    @Test
    public void checkResolvedBundle1Test() throws SnmpStatusException {
        String x = "ResolvedBundle";
        odlCardinalBundleResolvedModule.checkResolvedBundle1(x);
    }
}