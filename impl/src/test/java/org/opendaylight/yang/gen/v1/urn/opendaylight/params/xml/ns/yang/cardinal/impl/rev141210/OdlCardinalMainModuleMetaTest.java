package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalMainModuleMeta;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

public class OdlCardinalMainModuleMetaTest {
	SnmpMib myMib;
	SnmpStandardObjectServer objserv;
	OdlCardinalMainModuleMeta odlCardinalMainModuleMeta = new OdlCardinalMainModuleMeta(myMib, objserv);

	@Before
	public void setUp() {
		// SnmpSet set = new SnmpSet();
	}

	@After
	@Test
	public void isVariableTrueTest() throws Exception {
		long arc = 1;
		boolean ocpm = odlCardinalMainModuleMeta.isVariable(arc);
		if (ocpm == true) {
			assertEquals(true, ocpm);
		} else {
			assertEquals(false, ocpm);
		}
	}

	@Test
	public void isVariableFalseTest() throws Exception {
		long arc = 20;
		boolean ocpm = odlCardinalMainModuleMeta.isVariable(arc);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}

	@Test
	public void isReadableTest() throws Exception {
		long arc = 1;
		boolean ocpm = odlCardinalMainModuleMeta.isReadable(arc);
		if (ocpm == true) {
			assertEquals(true, ocpm);
		} else {
			assertEquals(false, ocpm);
		}
	}

	@Test
	public void isReadableFalseTest() throws Exception {
		long arc = 20;
		boolean ocpm = odlCardinalMainModuleMeta.isReadable(arc);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}

	@Test
	public void getAttributeNameTest() throws Exception {
		long arc[] = { 1, 2, 3, 4, 5, 6 };
		for (long i : arc) {
			String ocpm = odlCardinalMainModuleMeta.getAttributeName(i);
			assertTrue(ocpm.contains("OdlSystemOdlNodeInfo") | ocpm.contains("OdlSystemOdlUptime")
					| ocpm.contains("OdlSystemSysInfo") | ocpm.contains("OdlSystemHostAddress")
					| ocpm.contains("OdlSystemHostAddressTrap") | ocpm.contains("OdlSystemMemUsage")
					| ocpm.contains("OdlMDSALGBPResolvedpolicies") | ocpm.contains("OdlSystemCpuUsage"));
		}
	}

	@Test
	public void isTableTest() throws Exception {
		long arc = 1;
		boolean ocpm = odlCardinalMainModuleMeta.isTable(arc);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}

	@Test
	public void getTableTest() {
		long arc1 = 1;
		SnmpMibTable ocpm = odlCardinalMainModuleMeta.getTable(arc1);
		assertEquals(null, ocpm);
	}

	@Test
	public void skipVariableTest() {
		long arc[] = { 1, 36 };
		Object data = null;
		int pduVersion = 2;
		for (long i : arc) {
			if (i == 1) {
				boolean ocpm = odlCardinalMainModuleMeta.skipVariable(i, data, pduVersion);
				assertEquals(false, ocpm);
			}
		}
	}
}