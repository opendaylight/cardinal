package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalBundleResolvedModuleMeta;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

public class OdlCardinalBundleResolvedModuleMetaTest {
	SnmpMib myMib;
	SnmpStandardObjectServer objserv;
	OdlCardinalBundleResolvedModuleMeta odlCardinalBundleResolvedModuleMeta = new OdlCardinalBundleResolvedModuleMeta(myMib,objserv);
	@Before
	public void setUp() {
	//	SnmpSet set = new SnmpSet();
	   }
	@After
	@Test
	public void isVariableTrueTest() throws Exception{
		long arc=1;
		boolean ocpm = odlCardinalBundleResolvedModuleMeta.isVariable(arc);
		assertEquals(true,ocpm);
	}
	@Test
	public void isVariableFalseTest() throws Exception{
		long arc=20;
		boolean ocpm = odlCardinalBundleResolvedModuleMeta.isVariable(arc);
		assertEquals(false,ocpm);
	}
	@Test
	public void isReadableTest() throws Exception{
		long arc=1;
		boolean ocpm = odlCardinalBundleResolvedModuleMeta.isReadable(arc);
		assertEquals(true,ocpm);
	}
	@Test
	public void isReadableFalseTest() throws Exception{
		long arc=20;
		boolean ocpm = odlCardinalBundleResolvedModuleMeta.isReadable(arc);
		assertEquals(false,ocpm);
	}
	@Test
	public void getAttributeNameTest() throws Exception{
		long arc=1;
		String ocpm = odlCardinalBundleResolvedModuleMeta.getAttributeName(arc);
		assertEquals("ResolvedBundle1",ocpm);
	}
	@Test
	public void isTableTest() throws Exception{
		long arc=1;
		boolean ocpm = odlCardinalBundleResolvedModuleMeta.isTable(arc);
		assertEquals(false,ocpm);
	}
	@Test
	public void getTableTest() throws Exception{
		long arc=1;
		SnmpMibTable ocpm = odlCardinalBundleResolvedModuleMeta.getTable(arc);
		assertEquals(null,ocpm);
	}
}
