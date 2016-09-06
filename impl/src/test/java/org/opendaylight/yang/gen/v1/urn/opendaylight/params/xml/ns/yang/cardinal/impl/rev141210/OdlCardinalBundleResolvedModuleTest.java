package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalBundleResolvedModule;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlCardinalBundleResolvedModuleTest {
	SnmpMib myMib;
	MBeanServer server;
	OdlCardinalBundleResolvedModule odlCardinalBundleResolvedModule = new OdlCardinalBundleResolvedModule(myMib,server);
	OdlCardinalBundleResolvedModule odlCardinalBundleResolvedMod = new OdlCardinalBundleResolvedModule(myMib);
	@Before
	public void setUp() {
		//
	}
	@After
	@Test
	public void getResolvedBundle5Test() throws SnmpStatusException{
		String x = "ResolvedBundle5";
		odlCardinalBundleResolvedModule.setResolvedBundle5(x);
		String y=odlCardinalBundleResolvedModule.getResolvedBundle5();
		assertEquals(x, y);
	}
	@Test
	public void getResolvedBundle4Test() throws SnmpStatusException{
		String x = "ResolvedBundle4";
		odlCardinalBundleResolvedModule.setResolvedBundle4(x);
		String y=odlCardinalBundleResolvedModule.getResolvedBundle4();
		assertEquals(x, y);
	}
	@Test
	public void getResolvedBundle3Test() throws SnmpStatusException{
		String x = "ResolvedBundle3";
		odlCardinalBundleResolvedModule.setResolvedBundle3(x);
		String y=odlCardinalBundleResolvedModule.getResolvedBundle3();
		assertEquals(x, y);
	}
	@Test
	public void getResolvedBundle2Test() throws SnmpStatusException{
		String x = "ResolvedBundle2";
		odlCardinalBundleResolvedModule.setResolvedBundle2(x);
		String y=odlCardinalBundleResolvedModule.getResolvedBundle2();
		assertEquals(x, y);
	}
	@Test
	public void getResolvedBundle1Test() throws SnmpStatusException{
		String x = "ResolvedBundle1";
		odlCardinalBundleResolvedModule.setResolvedBundle1(x);
		String y=odlCardinalBundleResolvedModule.getResolvedBundle1();
		assertEquals(x, y);
	}
	@Test
	public void getOdlKarafBundleListResolvedTest() throws SnmpStatusException{
		String x = "ResolvedBundle";
		odlCardinalBundleResolvedModule.setOdlKarafBundleListResolved(x);
		String y=odlCardinalBundleResolvedModule.getOdlKarafBundleListResolved();
	   assertEquals(x, y);
    }
}
	