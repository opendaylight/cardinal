package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalFeatureInstallModule;
import com.sun.management.snmp.agent.SnmpMib;
/** 
 * @author Subodh Roy
 * 
 */ 
public class OdlCardinalFeatureInstallModuleTest {
	SnmpMib myMib;
	MBeanServer server;
	OdlCardinalFeatureInstallModule odlCardinalFeatureInstallModule = new OdlCardinalFeatureInstallModule(myMib,server);
	@Before
	public void setUp() {
	//	SnmpSet set = new SnmpSet();
	   }
	@After
	@Test
	public void getFeatureInstalled10Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled10(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled10();
		assertEquals(x, y);
	}
	@Test
	public void getFeatureInstalled9Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled9(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled9();
		assertEquals(x, y);
	}
	@Test
	public void getFeatureInstalled8Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled8(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled8();
		assertEquals(x, y);
	}
	@Test
	public void getFeatureInstalled7Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled7(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled7();
		assertEquals(x, y);
	}
	@Test
	public void getFeatureInstalled6Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled6(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled6();
		assertEquals(x, y);
	}
	@Test
	public void getFeatureInstalled5Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled5(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled5();
		assertEquals(x, y);
	}
	@Test
	public void getFeatureInstalled4Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled4(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled4();
		assertEquals(x, y);
	}
	@Test
	public void getFeatureInstalled3Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled3(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled3();
		assertEquals(x, y);
	}
	@Test
	public void getFeatureInstalled2Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled2(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled2();
		assertEquals(x, y);
	}
	@Test
	public void getFeatureInstalled1Test() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setFeatureInstalled1(x);
		String y=odlCardinalFeatureInstallModule.getFeatureInstalled1();
		assertEquals(x, y);
	}
		@Test
	public void getOdlKarafFeatureListUnInstalledTest() throws Exception{
		String x="karaf";
		odlCardinalFeatureInstallModule.setOdlKarafFeatureListInstalled(x);
		String y=odlCardinalFeatureInstallModule.getOdlKarafFeatureListInstalled();
		assertEquals(x, y);
	}
}
