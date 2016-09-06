package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;
import static org.junit.Assert.assertEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalBundleInActiveModule;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlCardinalBundleInActiveModuleTest {
	SnmpMib myMib;
	MBeanServer server;
	OdlCardinalBundleInActiveModule odlCardinalBundleInActiveModule = new OdlCardinalBundleInActiveModule(myMib,server);
	OdlCardinalBundleInActiveModule odlCardinalBundleInActiveMod = new OdlCardinalBundleInActiveModule(myMib);
	@Before
	public void setUp() {
		//
	}
	@After
	@Test
	public void getInstalledBundle5Test() throws SnmpStatusException{
		String x = "ResolvedBundle5";
		odlCardinalBundleInActiveModule.setInstalledBundle5(x);
		String y=odlCardinalBundleInActiveModule.getInstalledBundle5();
		assertEquals(x, y);
	}
	@Test
	public void getInstalledBundle4Test() throws SnmpStatusException{
		String x = "ResolvedBundle4";
		odlCardinalBundleInActiveModule.setInstalledBundle4(x);
		String y=odlCardinalBundleInActiveModule.getInstalledBundle4();
		assertEquals(x, y);
	}
	@Test
	public void getInstalledBundle3Test() throws SnmpStatusException{
		String x = "ResolvedBundle3";
		odlCardinalBundleInActiveModule.setInstalledBundle3(x);
		String y=odlCardinalBundleInActiveModule.getInstalledBundle3();
		assertEquals(x, y);
	}
	@Test
	public void getInstalledBundle2Test() throws SnmpStatusException{
		String x = "ResolvedBundle2";
		odlCardinalBundleInActiveModule.setInstalledBundle2(x);
		String y=odlCardinalBundleInActiveModule.getInstalledBundle2();
		assertEquals(x, y);
	}
	@Test
	public void getInstalledBundle1Test() throws SnmpStatusException{
		String x = "ResolvedBundle1";
		odlCardinalBundleInActiveModule.setInstalledBundle1(x);
		String y=odlCardinalBundleInActiveModule.getInstalledBundle1();
		assertEquals(x, y);
	}
	@Test
	public void getOdlKarafBundleListInstalledTest() throws SnmpStatusException{
		String x = "ResolvedBundle";
		odlCardinalBundleInActiveModule.setOdlKarafBundleListInstalled(x);
		String y=odlCardinalBundleInActiveModule.getOdlKarafBundleListInstalled();
	   assertEquals(x, y);
    }
}
