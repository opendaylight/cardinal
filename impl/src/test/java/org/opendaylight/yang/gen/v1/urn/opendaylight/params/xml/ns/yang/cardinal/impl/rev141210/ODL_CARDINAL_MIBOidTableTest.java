package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.ODL_CARDINAL_MIBOidTable;

public class ODL_CARDINAL_MIBOidTableTest {
	ODL_CARDINAL_MIBOidTable odlTable = new ODL_CARDINAL_MIBOidTable();
	@Before
	public void setUp() {
		ODL_CARDINAL_MIBOidTable odlTable1 = new ODL_CARDINAL_MIBOidTable();
	//	SnmpSet set = new SnmpSet();
	   }
	@After
	@Test
	public void isTest() throws Exception{
		odlTable.getAllEntries();
		//assertEquals(true,ocpm);
	}
}
