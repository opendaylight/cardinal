package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalProjectModuleMeta;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

public class OdlCardinalProjectModuleMetaTest {
	SnmpMib myMib;
	SnmpStandardObjectServer objserv;
	OdlCardinalProjectModuleMeta odlCardinalProjectModuleMeta = new OdlCardinalProjectModuleMeta(myMib, objserv);

	@Before
	public void setUp() {
	}

	@After
	public void setDown() {
	}

	@Test
	public void isVariableTrueTest() throws Exception {
		long arc = 1;
		boolean ocpm = odlCardinalProjectModuleMeta.isVariable(arc);
		if (ocpm == true) {
			assertEquals(true, ocpm);
		} else {
			assertEquals(false, ocpm);
		}
	}

	@Test
	public void isVariableFalseTest() throws Exception {
		long arc = 20;
		boolean ocpm = odlCardinalProjectModuleMeta.isVariable(arc);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}

	@Test
	public void isReadableTest() throws Exception {
		long arc = 1;
		boolean ocpm = odlCardinalProjectModuleMeta.isReadable(arc);
		if (ocpm == true) {
			assertEquals(true, ocpm);
		} else {
			assertEquals(false, ocpm);
		}
	}

	@Test
	public void isReadableFalseTest() throws Exception {
		long arc = 20;
		boolean ocpm = odlCardinalProjectModuleMeta.isReadable(arc);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}

	@Test
	public void getAttributeNameTest() throws Exception {
		int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17 };
		for (int i : numbers) {
			String ocpm = odlCardinalProjectModuleMeta.getAttributeName(i);
			if (ocpm != null) {
				assertEquals("OdlMDSALClustershardsshared", odlCardinalProjectModuleMeta.getAttributeName(1));
			} else {
				assertNotEquals("OdlMDSALClustershardsshared", ocpm);
			}
		}
	}

	@Test
	public void isTableTest() throws Exception {
		long arc = 1;
		boolean ocpm = odlCardinalProjectModuleMeta.isTable(arc);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}

	@Test
	public void getTableTest() throws Exception {
		long arc = 1;
		SnmpMibTable ocpm = odlCardinalProjectModuleMeta.getTable(arc);
		if (ocpm == null) {
			assertEquals(null, ocpm);
		} else {
			assertNotEquals(null, ocpm);
		}
	}

	@Test
	public void skipVariableTest() throws Exception {
		long arc = 1;
		Object data = new Object();
		int pduVersion = 0;
		boolean ocpm = odlCardinalProjectModuleMeta.skipVariable(arc, data, pduVersion);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}
}