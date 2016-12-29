package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlOpenFlowStats;
import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

public class OdlOpenFlowStatsTest {
	SnmpMib myMib;
	MBeanServer server;
	OdlOpenFlowStats odlOpenFlowStats = new OdlOpenFlowStats(myMib, server);

	@Before
	public void setUp() {
	}

	@After
	public void setDown() {
	}

	@Test
	public void getOdlOpenflowFlowstatsTest() throws SnmpStatusException {
		String x = "OdlOpenflowFlowstats";
		odlOpenFlowStats.setOdlOpenflowFlowstats(x);
		String y = odlOpenFlowStats.getOdlOpenflowFlowstats();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlOpenflowMeterstatsTest() throws SnmpStatusException {
		String x = "OdlOpenflowMeterstats";
		odlOpenFlowStats.setOdlOpenflowMeterstats(x);
		String y = odlOpenFlowStats.getOdlOpenflowMeterstats();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlOpenflowStatusTest() throws SnmpStatusException {
		String x = "OdlOpenflowStatus";
		odlOpenFlowStats.setOdlOpenflowStatus(x);
		String y = odlOpenFlowStats.getOdlOpenflowStatus();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlOpenflowManufacturerTest() throws SnmpStatusException {
		String x = "OdlOpenflowManufacturer";
		odlOpenFlowStats.setOdlOpenflowManufacturer(x);
		String y = odlOpenFlowStats.getOdlOpenflowManufacturer();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlOpenflowMacAddressTest() throws SnmpStatusException {
		String x = "OdlOpenflowMacAddress";
		odlOpenFlowStats.setOdlOpenflowMacAddress(x);
		String y = odlOpenFlowStats.getOdlOpenflowMacAddress();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlOpenflowInterfaceTest() throws SnmpStatusException {
		String x = "OdlOpenflowInterface";
		odlOpenFlowStats.setOdlOpenflowInterface(x);
		String y = odlOpenFlowStats.getOdlOpenflowInterface();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlOpenflowNodeTest() throws SnmpStatusException {
		String x = "OdlOpenflowNode";
		odlOpenFlowStats.setOdlOpenflowNode(x);
		String y = odlOpenFlowStats.getOdlOpenflowNode();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void checkOdlOpenflowFlowstatsTest() throws SnmpStatusException {
		String x = "OdlOpenflowFlowstats";
		odlOpenFlowStats.checkOdlOpenflowFlowstats(x);
	}

	@Test
	public void checkOdlOpenflowMeterstatsTest() throws SnmpStatusException {
		String x = "OdlOpenflowMeterstats";
		odlOpenFlowStats.checkOdlOpenflowMeterstats(x);
	}

	@Test
	public void checkOdlOpenflowMacAddressTest() throws SnmpStatusException {
		String x = "OdlOpenflowMacAddress";
		odlOpenFlowStats.checkOdlOpenflowMacAddress(x);
	}

	@Test
	public void checkOdlOpenflowManufacturerTest() throws SnmpStatusException {
		String x = "OdlOpenflowManufacturer";
		odlOpenFlowStats.checkOdlOpenflowManufacturer(x);
	}

	@Test
	public void checkOdlOpenflowInterfaceTest() throws SnmpStatusException {
		String x = "OdlOpenflowInterface";
		odlOpenFlowStats.checkOdlOpenflowInterface(x);
	}

	@Test
	public void checkOdlOpenflowNodeTest() throws SnmpStatusException {
		String x = "OdlOpenflowNode";
		odlOpenFlowStats.checkOdlOpenflowNode(x);
	}

	@Test
	public void checkOdlOpenflowStatusTest() throws SnmpStatusException {
		String x = "OdlOpenflowStatus";
		odlOpenFlowStats.checkOdlOpenflowStatus(x);
	}
}