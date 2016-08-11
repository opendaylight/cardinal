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
	OdlCardinalProjectModuleMeta odlCardinalProjectModuleMeta = new OdlCardinalProjectModuleMeta(myMib,objserv);
	@Before
	public void setUp() {
		OdlCardinalProjectModuleMeta odlCardinalProjectModuleMetaInit = new OdlCardinalProjectModuleMeta(myMib,objserv);
	//	SnmpSet set = new SnmpSet();
	   }
	@After
	@Test
	public void isVariableTrueTest() throws Exception{
		long arc=1;
		boolean ocpm = odlCardinalProjectModuleMeta.isVariable(arc);
		assertEquals(true,ocpm);
	}
	@Test
	public void isVariableFalseTest() throws Exception{
		long arc=20;
		boolean ocpm = odlCardinalProjectModuleMeta.isVariable(arc);
		assertEquals(false,ocpm);
	}
	@Test
	public void isReadableTest() throws Exception{
		long arc=1;
		boolean ocpm = odlCardinalProjectModuleMeta.isReadable(arc);
		assertEquals(true,ocpm);
	}
	@Test
	public void isReadableFalseTest() throws Exception{
		long arc=20;
		boolean ocpm = odlCardinalProjectModuleMeta.isReadable(arc);
		assertEquals(false,ocpm);
	}
	@Test
	public void getAttributeNameTest() throws Exception{
		long arc=1;
		 int [] numbers = {0,1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,17,18};

		for (int i :numbers) {
		String ocpmi = odlCardinalProjectModuleMeta.getAttributeName(i);
		
		}
		String ocpm = odlCardinalProjectModuleMeta.getAttributeName(arc);
		assertEquals("OdlMDSALClustershardsshared",ocpm);
		
	}
	@Test
	public void isTableTest() throws Exception{
		long arc=1;
		boolean ocpm = odlCardinalProjectModuleMeta.isTable(arc);
		assertEquals(false,ocpm);
	}
	@Test
	public void getTableTest() throws Exception{
		long arc=1;
		SnmpMibTable ocpm = odlCardinalProjectModuleMeta.getTable(arc);
		assertEquals(null,ocpm);
	}
	@Test
	public void skipVariableTest() throws Exception{
		long arc=1;
		Object data = new Object();
		int pduVersion = 0;
		boolean ocpm = odlCardinalProjectModuleMeta.skipVariable(arc,data,pduVersion);
		assertEquals(false,ocpm);
	}
}
