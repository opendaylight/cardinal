package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.management.snmp.agent.SnmpMib;
/** 
 * @author Subodh Roy
 * 
 */ 
public class OdlCardinalFeatureUnInstalModuleTest {
	SnmpMib myMib;
	org.opendaylight.cardinal.impl.OdlCardinalFeatureUnInstalModule OdlCardinalFeatureUnInstalModule = new org.opendaylight.cardinal.impl.OdlCardinalFeatureUnInstalModule(myMib);

	
	@Before
	public void setUp() {
	//	SnmpSet set = new SnmpSet();
	   }
	
	@After
	
	@Test
	public void getFeatureUnInstalled9Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled9(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled9();
		assertEquals(x, y);
	}
	

	@Test
	public void getFeatureUnInstalled8Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled8(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled8();
		assertEquals(x, y);
	}

	@Test
	public void getFeatureUnInstalled7Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled7(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled7();
		assertEquals(x, y);
	}
	

	@Test
	public void getFeatureUnInstalled6Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled6(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled6();
		assertEquals(x, y);
	}
	

	@Test
	public void getFeatureUnInstalled5Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled5(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled5();
		assertEquals(x, y);
	}
	

	@Test
	public void getFeatureUnInstalled4Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled4(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled4();
		assertEquals(x, y);
	}
	

	@Test
	public void getFeatureUnInstalled3Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled3(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled3();
		assertEquals(x, y);
	}
	

	@Test
	public void getFeatureUnInstalled2Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled2(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled2();
		assertEquals(x, y);
	}
	

	@Test
	public void getFeatureUnInstalled1Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled1(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled1();
		assertEquals(x, y);
	}
	
	@Test
	public void getFeatureUnInstalled10Test() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setFeatureUnInstalled10(x);
		String y=OdlCardinalFeatureUnInstalModule.getFeatureUnInstalled10();
		assertEquals(x, y);
	}
	

	@Test
	public void getOdlKarafFeatureListUnInstalledTest() throws Exception{
		String x="karaf";
		OdlCardinalFeatureUnInstalModule.setOdlKarafFeatureListUnInstalled(x);
		String y=OdlCardinalFeatureUnInstalModule.getOdlKarafFeatureListUnInstalled();
		assertEquals(x, y);
	}
	
	
	
	
	
}
