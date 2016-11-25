package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalKarafShellModule;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlCardinalKarafShellModuleTest {
    SnmpMib myMib;
    OdlCardinalKarafShellModule odlCardinalKarafShellModule = new OdlCardinalKarafShellModule(myMib);

    @Before
    public void setUp() {
    }

    @After
    public void setDown() {
    }

    @Test
    public void getOdlKarafMaxHeapSizeTest() throws SnmpStatusException {
        String x = "localhost";
        odlCardinalKarafShellModule.setOdlKarafMaxHeapSize(x);
        String y = odlCardinalKarafShellModule.getOdlKarafMaxHeapSize();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlKarafCurrentHeapSizeTest() throws SnmpStatusException {
        String x = "localhost";
        odlCardinalKarafShellModule.setOdlKarafCurrentHeapSize(x);
        String y = odlCardinalKarafShellModule.getOdlKarafCurrentHeapSize();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlKarafPeakThreadsTest() throws SnmpStatusException {
        String x = "localhost";
        odlCardinalKarafShellModule.setOdlKarafPeakThreads(x);
        String y = odlCardinalKarafShellModule.getOdlKarafPeakThreads();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlKarafDaemonThreadsTest() throws SnmpStatusException {
        String x = "localhost";
        odlCardinalKarafShellModule.setOdlKarafDaemonThreads(x);
        String y = odlCardinalKarafShellModule.getOdlKarafDaemonThreads();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }

    @Test
    public void getOdlKarafLiveThreadsTest() throws SnmpStatusException {
        String x = "localhost";
        odlCardinalKarafShellModule.setOdlKarafLiveThreads(x);
        String y = odlCardinalKarafShellModule.getOdlKarafLiveThreads();
        if (y != null) {
            assertEquals(x, y);
        } else {
            assertNotEquals(x, y);
        }
    }
}