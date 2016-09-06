package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalMainModuleMeta;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

public class OdlCardinalMainModuleMetaTest {
	SnmpMib myMib;
	SnmpStandardObjectServer objserv;
	OdlCardinalMainModuleMeta odlCardinalMainModuleMeta = new OdlCardinalMainModuleMeta(myMib,objserv);
	@Before
	public void setUp() {
	//	SnmpSet set = new SnmpSet();
	   }
	@After
	@Test
	public void isVariableTrueTest() throws Exception{
		long arc=1;
		boolean ocpm = odlCardinalMainModuleMeta.isVariable(arc);
		assertEquals(true,ocpm);
	}
	@Test
	public void isVariableFalseTest() throws Exception{
		long arc=20;
		boolean ocpm = odlCardinalMainModuleMeta.isVariable(arc);
		assertEquals(false,ocpm);
	}
	@Test
	public void isReadableTest() throws Exception{
		long arc=1;
		boolean ocpm = odlCardinalMainModuleMeta.isReadable(arc);
		assertEquals(true,ocpm);
	}
	@Test
	public void isReadableFalseTest() throws Exception{
		long arc=20;
		boolean ocpm = odlCardinalMainModuleMeta.isReadable(arc);
		assertEquals(false,ocpm);
	}
	@Test
	public void getAttributeNameTest() throws Exception{
		long arc=1;
		String ocpm = odlCardinalMainModuleMeta.getAttributeName(arc);
		assertEquals("OdlSystemCpuUsage",ocpm);
	}
	@Test
	public void isTableTest() throws Exception{
		long arc=1;
		boolean ocpm = odlCardinalMainModuleMeta.isTable(arc);
		assertEquals(false,ocpm);
	}
}

