package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlNetconfStats2Meta;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

public class OdlNetconfStats2MetaTest {
    SnmpMib myMib;
    SnmpStandardObjectServer objserv;
    OdlNetconfStats2Meta odlNetconfStatsMeta = new OdlNetconfStats2Meta(myMib, objserv);

    @Before
    public void setUp() {
    }

    @After
    public void setDown() {
    }

    @Test
    public void isVariableTrueTest() throws Exception {
        long arc = 1;
        boolean ocpm = odlNetconfStatsMeta.isVariable(arc);
        if (ocpm == true) {
            assertEquals(true, ocpm);
        } else {
            assertEquals(false, ocpm);
        }
    }

    @Test
    public void isVariableFalseTest() throws Exception {
        long arc = 20;
        boolean ocpm = odlNetconfStatsMeta.isVariable(arc);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void isReadableTest() throws Exception {
        long arc = 1;
        boolean ocpm = odlNetconfStatsMeta.isReadable(arc);
        if (ocpm == true) {
            assertEquals(true, ocpm);
        } else {
            assertEquals(false, ocpm);
        }
    }

    @Test
    public void isReadableFalseTest() throws Exception {
        long arc = 20;
        boolean ocpm = odlNetconfStatsMeta.isReadable(arc);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void getAttributeNameTest() throws Exception {
        long arc = 1;
        String ocpm = odlNetconfStatsMeta.getAttributeName(arc);
        if (ocpm == "OdlNetconfNodeId2") {
            assertEquals("OdlNetconfNodeId2", ocpm);
        } else {
            assertEquals(false, ocpm);
        }
    }

    @Test
    public void isTableTest() throws Exception {
        long arc = 1;
        boolean ocpm = odlNetconfStatsMeta.isTable(arc);
        if (ocpm == false) {
            assertEquals(false, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }

    @Test
    public void getTableTest() throws Exception {
        long arc = 1;
        SnmpMibTable ocpm = odlNetconfStatsMeta.getTable(arc);
        if (ocpm == null) {
            assertEquals(null, ocpm);
        } else {
            assertEquals(true, ocpm);
        }
    }
}

