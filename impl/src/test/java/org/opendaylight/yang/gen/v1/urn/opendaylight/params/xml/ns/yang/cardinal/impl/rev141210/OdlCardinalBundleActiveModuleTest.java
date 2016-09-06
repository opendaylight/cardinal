package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalBundleActiveModule;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;
public class OdlCardinalBundleActiveModuleTest {
	SnmpMib myMib;
	MBeanServer server;
	OdlCardinalBundleActiveModule odlCardinalBundleActiveModule = new OdlCardinalBundleActiveModule(myMib,server);
	OdlCardinalBundleActiveModule odlCardinalBundleActiveMod = new OdlCardinalBundleActiveModule(myMib);
	@Before
	public void setUp() {
		//
	}
	@After
	@Test
	public void getActivebundle10Test() throws SnmpStatusException{
		String x = "Activebundle10";
		odlCardinalBundleActiveModule.setActivebundle10(x);
		String y=odlCardinalBundleActiveModule.getActivebundle10();
		assertEquals(x, y);
	}
	@Test
	public void getActivebundle9Test() throws SnmpStatusException{
		String x = "Activebundle9";
		odlCardinalBundleActiveModule.setActivebundle9(x);
		String y=odlCardinalBundleActiveModule.getActivebundle9();
		assertEquals(x, y);
	}
	@Test
	public void getActivebundle8Test() throws SnmpStatusException{
		String x = "Activebundle8";
		odlCardinalBundleActiveModule.setActivebundle8(x);
		String y=odlCardinalBundleActiveModule.getActivebundle8();
		assertEquals(x, y);
	}
	@Test
	public void getActivebundle7Test() throws SnmpStatusException{
		String x = "Activebundle7";
		odlCardinalBundleActiveModule.setActivebundle7(x);
		String y=odlCardinalBundleActiveModule.getActivebundle7();
		assertEquals(x, y);
	}
	@Test
	public void getActivebundle6Test() throws SnmpStatusException{
		String x = "Activebundle6";
		odlCardinalBundleActiveModule.setActivebundle6(x);
		String y=odlCardinalBundleActiveModule.getActivebundle6();
		assertEquals(x, y);
	}
	@Test
	public void getActivebundle5Test() throws SnmpStatusException{
		String x = "Activebundle5";
		odlCardinalBundleActiveModule.setActivebundle5(x);
		String y=odlCardinalBundleActiveModule.getActivebundle5();
		assertEquals(x, y);
	}
	@Test
	public void getActivebundle4Test() throws SnmpStatusException{
		String x = "Activebundle4";
		odlCardinalBundleActiveModule.setActivebundle4(x);
		String y=odlCardinalBundleActiveModule.getActivebundle4();
		assertEquals(x, y);
	}
	@Test
	public void getActivebundle3Test() throws SnmpStatusException{
		String x = "Activebundle3";
		odlCardinalBundleActiveModule.setActivebundle3(x);
		String y=odlCardinalBundleActiveModule.getActivebundle3();
		assertEquals(x, y);
	}
	@Test
	public void getActivebundle2Test() throws SnmpStatusException{
		String x = "Activebundle2";
		odlCardinalBundleActiveModule.setActivebundle2(x);
		String y=odlCardinalBundleActiveModule.getActivebundle2();
		assertEquals(x, y);
	}
	@Test
	public void getActivebundle1Test() throws SnmpStatusException{
		String x = "Activebundle1";
		odlCardinalBundleActiveModule.setActivebundle1(x);
		String y=odlCardinalBundleActiveModule.getActivebundle1();
		assertEquals(x, y);
	}
	@Test
	public void getOdlKarafBundleListInstalledTest() throws SnmpStatusException{
		String x = "Activebundle";
		odlCardinalBundleActiveModule.setOdlKarafBundleListActive(x);
		String y=odlCardinalBundleActiveModule.getOdlKarafBundleListActive();
	   assertEquals(x, y);
    }
}

