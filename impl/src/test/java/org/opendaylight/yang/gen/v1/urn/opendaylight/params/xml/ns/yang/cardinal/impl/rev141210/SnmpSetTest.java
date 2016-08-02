package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.SnmpSet;

/** 
 * @author Subodh Roy
 * 
 */ 
public class SnmpSetTest {
		SnmpSet snmpSet = new SnmpSet();
	//OID oid = new OID(str);
	
	@Before
	public void setUp() {
	//	SnmpSet set = new SnmpSet();
	   }
	
	@After
	
	
	@Test
	public void setVariableStringTest() throws Exception{
		
		String oid = ".1.3.6.1.3.1.1.1.6.0";
		String str = "localhost";
		snmpSet.setVariableString(oid, str);
		//assertEquals();
			
	}

	@Test
	public void setVariableIntTest() throws Exception{
		
		String oid = ".1.3.6.1.3.1.1.1.6.0";
		int hname = 161;
		snmpSet.setVariableInt(oid, hname);
		//assertEquals();
				
	}
	
}
