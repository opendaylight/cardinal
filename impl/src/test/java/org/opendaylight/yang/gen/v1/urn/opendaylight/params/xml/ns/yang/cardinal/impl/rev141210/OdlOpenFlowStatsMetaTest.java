package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlOpenFlowStatsMeta;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

public class OdlOpenFlowStatsMetaTest {
	SnmpMib myMib;
	SnmpStandardObjectServer objserv;
	OdlOpenFlowStatsMeta odlOpenFlowStatsMeta = new OdlOpenFlowStatsMeta(myMib, objserv);

	@Before
	public void setUp() {
	}

	@After
	public void setDown() {
	}

	@Test
	public void isVariableTrueTest() throws Exception {
		long arc = 1;
		boolean ocpm = odlOpenFlowStatsMeta.isVariable(arc);
		if (ocpm == true) {
			assertEquals(true, ocpm);
		} else {
			assertEquals(false, ocpm);
		}
	}

	@Test
	public void isVariableFalseTest() throws Exception {
		long arc = 20;
		boolean ocpm = odlOpenFlowStatsMeta.isVariable(arc);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}

	@Test
	public void isReadableTest() throws Exception {
		long arc = 1;
		boolean ocpm = odlOpenFlowStatsMeta.isReadable(arc);
		if (ocpm == true) {
			assertEquals(true, ocpm);
		} else {
			assertEquals(false, ocpm);
		}
	}

	@Test
	public void isReadableFalseTest() throws Exception {
		long arc = 20;
		boolean ocpm = odlOpenFlowStatsMeta.isReadable(arc);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}

	@Test
	public void getAttributeNameTest() throws Exception {
		long arc = 1;
		String ocpm = odlOpenFlowStatsMeta.getAttributeName(arc);
		if (ocpm == "OdlOpenflowNode") {
			assertEquals("OdlOpenflowNode", ocpm);
		} else {
			assertEquals(false, ocpm);
		}
	}

	@Test
	public void isTableTest() throws Exception {
		long arc = 1;
		boolean ocpm = odlOpenFlowStatsMeta.isTable(arc);
		if (ocpm == false) {
			assertEquals(false, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}

	@Test
	public void getTableTest() throws Exception {
		long arc = 1;
		SnmpMibTable ocpm = odlOpenFlowStatsMeta.getTable(arc);
		if (ocpm == null) {
			assertEquals(null, ocpm);
		} else {
			assertEquals(true, ocpm);
		}
	}
}
