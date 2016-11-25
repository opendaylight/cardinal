package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalKarafShellModuleMeta;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

/**
 * @author Subodh Roy
 */
public class OdlCardinalKarafShellModuleMetaTest {
    SnmpMib myMib;
    SnmpStandardObjectServer objserv;
    OdlCardinalKarafShellModuleMeta odlCardinalKarafShellModuleMeta = new OdlCardinalKarafShellModuleMeta(myMib,
            objserv);

    @Before
    public void setUp() {
        // SnmpSet set = new SnmpSet();
    }

    @After
    @Test
    public void isVariableTrueTest() throws Exception {
        long arc = 1;
        boolean ocpm = odlCardinalKarafShellModuleMeta.isVariable(arc);
        if (ocpm == true) {
            assertEquals(true, ocpm);
        } else {
            assertEquals(false, ocpm);
        }
    }

    @Test
    public void isVariableFalseTest() throws Exception {
        long arc = 20;
        boolean ocpm = odlCardinalKarafShellModuleMeta.isVariable(arc);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void isReadableTest() throws Exception {
        long arc = 1;
        boolean ocpm = odlCardinalKarafShellModuleMeta.isReadable(arc);
        if (ocpm == true) {
            assertEquals(true, ocpm);
        } else {
            assertEquals(false, ocpm);
        }
    }

    @Test
    public void isReadableFalseTest() throws Exception {
        long arc = 20;
        boolean ocpm = odlCardinalKarafShellModuleMeta.isReadable(arc);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void getAttributeNameTest() {

        String ocpm = null;
        long i = 0;
        for (i = 0; i < 5; i++) {
            try {
                ocpm = odlCardinalKarafShellModuleMeta.getAttributeName(i);
                assertTrue(ocpm.contains("OdlKarafMaxHeapSize") | ocpm.contains("OdlKarafCurrentHeapSize")
                        | ocpm.contains("OdlKarafPeakThreads") | ocpm.contains("OdlKarafDaemonThreads")
                        | ocpm.contains("OdlKarafLiveThreads"));
            } catch (SnmpStatusException e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
            }
        }
    }

    @Test
    public void isTableTest() throws Exception {
        long arc = 1;
        boolean ocpm = odlCardinalKarafShellModuleMeta.isTable(arc);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void skipVariableTest() throws Exception {
        long arc = 1;
        Object data = null;
        int pduVersion = 2;
        boolean ocpm = odlCardinalKarafShellModuleMeta.skipVariable(arc, data, pduVersion);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void getTableTest() throws Exception {
        long arc = 1;
        SnmpMibTable ocpm = odlCardinalKarafShellModuleMeta.getTable(arc);
        assertEquals(null, ocpm);
    }
}