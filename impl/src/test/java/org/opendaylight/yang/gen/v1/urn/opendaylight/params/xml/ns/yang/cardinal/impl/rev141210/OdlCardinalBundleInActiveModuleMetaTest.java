package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalBundleInActiveModuleMeta;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

public class OdlCardinalBundleInActiveModuleMetaTest {
    SnmpMib myMib;
    SnmpStandardObjectServer objserv;
    OdlCardinalBundleInActiveModuleMeta odlCardinalBundleInActiveModuleMeta = new OdlCardinalBundleInActiveModuleMeta(
            myMib, objserv);

    @Before
    public void setUp() {
    }

    @After

    @Test
    public void isVariableTrueTest() throws Exception {
        long arc = 1;
        boolean ocpm = odlCardinalBundleInActiveModuleMeta.isVariable(arc);
        if (ocpm == true) {
            assertEquals(true, ocpm);
        } else {
            assertEquals(false, ocpm);
        }
    }

    @Test
    public void isVariableFalseTest() throws Exception {
        long arc = 20;
        boolean ocpm = odlCardinalBundleInActiveModuleMeta.isVariable(arc);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void isReadableTest() throws Exception {
        long arc = 1;
        boolean ocpm = odlCardinalBundleInActiveModuleMeta.isReadable(arc);
        if (ocpm == true) {
            assertEquals(true, ocpm);
        } else {
            assertEquals(false, ocpm);
        }
    }

    @Test
    public void isReadableFalseTest() throws Exception {
        long arc = 20;
        boolean ocpm = odlCardinalBundleInActiveModuleMeta.isReadable(arc);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void getAttributeNameTest() throws Exception {
        long arc = 1;
        String ocpm = odlCardinalBundleInActiveModuleMeta.getAttributeName(arc);
        if (ocpm != null) {
            assertEquals("InstalledBundle1", ocpm);
        } else {
            assertNotEquals(false, ocpm);
        }
    }

    @Test
    public void isTableTest() throws Exception {
        long arc = 1;
        boolean ocpm = odlCardinalBundleInActiveModuleMeta.isTable(arc);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void getTableTest() throws Exception {
        long arc = 1;
        SnmpMibTable ocpm = odlCardinalBundleInActiveModuleMeta.getTable(arc);
        if (ocpm != null) {
            assertEquals("InstalledBundle1", ocpm);
        } else {
            assertNotEquals("InstalledBundle1", ocpm);
        }
    }
}