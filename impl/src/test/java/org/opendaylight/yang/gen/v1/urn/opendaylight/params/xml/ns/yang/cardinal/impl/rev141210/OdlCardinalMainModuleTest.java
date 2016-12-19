package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlCardinalMainModuleTest {
	SnmpMib myMib;
	MBeanServer server;

	org.opendaylight.cardinal.impl.OdlCardinalMainModule OdlCardinalMainModule = new org.opendaylight.cardinal.impl.OdlCardinalMainModule(
			myMib);

	@Before
	public void setUp() {
	}

	@After
	public void setDown() {
	}

	@Test
	public void getOdlSystemOdlNodeInfoTest() throws SnmpStatusException {
		String x = "localhost";
		OdlCardinalMainModule.setOdlSystemOdlNodeInfo(x);
		String y = OdlCardinalMainModule.getOdlSystemOdlNodeInfo();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlSystemSysInfoTest() throws SnmpStatusException {
		String x = "localhost";
		OdlCardinalMainModule.setOdlSystemSysInfo(x);
		String y = OdlCardinalMainModule.getOdlSystemSysInfo();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlSystemHostAddressTest() throws SnmpStatusException {
		String x = "localhost";
		OdlCardinalMainModule.setOdlSystemHostAddress(x);
		String y = OdlCardinalMainModule.getOdlSystemHostAddress();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlSystemMemUsage() throws SnmpStatusException {
		Integer x = 100;
		OdlCardinalMainModule.setOdlSystemMemUsage(x);
		Integer y = OdlCardinalMainModule.getOdlSystemMemUsage();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlSystemCpuUsageTest() throws SnmpStatusException {
		Integer x = 1024;
		OdlCardinalMainModule.setOdlSystemCpuUsage(x);
		Integer y = OdlCardinalMainModule.getOdlSystemCpuUsage();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void checkOdlSystemCpuUsageTest() throws SnmpStatusException {
		Integer x = 1024;
		OdlCardinalMainModule.checkOdlSystemCpuUsage(x);
	}

	@Test
	public void checkOdlSystemHostAddressTest() throws SnmpStatusException {
		String x = "172.21.88.148";
		OdlCardinalMainModule.checkOdlSystemHostAddress(x);
	}

	@Test
	public void checkOdlSystemMemUsageTest() throws SnmpStatusException {
		Integer x = 1024;
		OdlCardinalMainModule.checkOdlSystemMemUsage(x);
	}

	@Test
	public void checkOdlSystemOdlNodeInfoTest() throws SnmpStatusException {
		String x = "Opendaylight Node A";
		OdlCardinalMainModule.checkOdlSystemOdlNodeInfo(x);
	}

	@Test
	public void checkOdlSystemSysInfoTest() throws SnmpStatusException {
		String x = "Opendaylight";
		OdlCardinalMainModule.checkOdlSystemSysInfo(x);
	}
}