package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.management.MBeanServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalProjectModule;

import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;

/**
 * @author Subodh Roy
 * 
 */
public class OdlCardinalProjectModuleTest {
	SnmpMib myMib;
	MBeanServer server;
	OdlCardinalProjectModule odlCardinalProjectModule = new OdlCardinalProjectModule(myMib);
	OdlCardinalProjectModule odlCardinalProjectModule1 = new OdlCardinalProjectModule(myMib, server);

	@Before
	public void setUp() {
	}

	@After
	public void setDown() {
	}

	@Test
	public void getOdlMDSALBGPBMPinfoTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALBGPBMPinfo(x);
		String y = odlCardinalProjectModule.getOdlMDSALBGPBMPinfo();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALBGPRIBInfoTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALBGPRIBInfo(x);
		String y = odlCardinalProjectModule.getOdlMDSALBGPRIBInfo();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALBGPPeerInfoTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALBGPPeerInfo(x);
		String y = odlCardinalProjectModule.getOdlMDSALBGPPeerInfo();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALOpenFlowOVSconnectedDevicesTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALOpenFlowOVSconnectedDevices(x);
		String y = odlCardinalProjectModule.getOdlMDSALOpenFlowOVSconnectedDevices();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALIotDMlistofNodesTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALIotDMlistofNodes(x);
		String y = odlCardinalProjectModule.getOdlMDSALIotDMlistofNodes();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALIotDMlistofAEsTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALIotDMlistofAEs(x);
		String y = odlCardinalProjectModule.getOdlMDSALIotDMlistofAEs();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALIotDMListofcseTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALIotDMListofcse(x);
		String y = odlCardinalProjectModule.getOdlMDSALIotDMListofcse();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALGBPPolicytenantsTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALGBPPolicytenants(x);
		String y = odlCardinalProjectModule.getOdlMDSALGBPPolicytenants();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALGBPFaaslogicalnetworkTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALGBPFaaslogicalnetwork(x);
		String y = odlCardinalProjectModule.getOdlMDSALGBPFaaslogicalnetwork();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALServiceTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALService(x);
		String y = odlCardinalProjectModule.getOdlMDSALService();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALServicefunctiontypeTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALServicefunctiontype(x);
		String y = odlCardinalProjectModule.getOdlMDSALServicefunctiontype();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALSfcfunctionAlgorithms() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALSfcfunctionAlgorithms(x);
		String y = odlCardinalProjectModule.getOdlMDSALSfcfunctionAlgorithms();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALSfcfunctiongroupsTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALSfcfunctiongroups(x);
		String y = odlCardinalProjectModule.getOdlMDSALSfcfunctiongroups();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALNetconfConnectedDevicesTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALNetconfConnectedDevices(x);
		String y = odlCardinalProjectModule.getOdlMDSALNetconfConnectedDevices();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALSfcfunctionTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALSfcfunction(x);
		String y = odlCardinalProjectModule.getOdlMDSALSfcfunction();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALClustershardssharedTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALClustershardsshared(x);
		String y = odlCardinalProjectModule.getOdlMDSALClustershardsshared();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void getOdlMDSALClusterControllerRoleTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.setOdlMDSALClusterControllerRole(x);
		String y = odlCardinalProjectModule.getOdlMDSALClusterControllerRole();
		if (y != null) {
			assertEquals(x, y);
		} else {
			assertNotEquals(x, y);
		}
	}

	@Test
	public void checkOdlMDSALBGPBMPinfoTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALBGPBMPinfo(x);
	}

	@Test
	public void checkOdlMDSALBGPPeerInfoTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALBGPPeerInfo(x);
	}

	@Test
	public void checkOdlMDSALBGPRIBInfoTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALBGPRIBInfo(x);
	}

	@Test
	public void checkOdlMDSALClusterControllerRoleTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALClusterControllerRole(x);
	}

	@Test
	public void checkOdlMDSALClustershardssharedTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALClustershardsshared(x);
	}

	@Test
	public void checkOdlMDSALGBPFaaslogicalnetworkTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALGBPFaaslogicalnetwork(x);
	}

	@Test
	public void checkOdlMDSALGBPPolicytenantsTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALGBPPolicytenants(x);
	}

	@Test
	public void checkOdlMDSALIotDMlistofAEsTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALIotDMlistofAEs(x);
	}

	@Test
	public void checkOdlMDSALIotDMListofcseTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALIotDMListofcse(x);
	}

	@Test
	public void checkOdlMDSALIotDMlistofNodesTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALIotDMlistofNodes(x);
	}

	@Test
	public void checkOdlMDSALNetconfConnectedDevicesTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALNetconfConnectedDevices(x);
	}

	@Test
	public void checkOdlMDSALOpenFlowOVSconnectedDevicesTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALOpenFlowOVSconnectedDevices(x);
	}

	@Test
	public void checkOdlMDSALServiceTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALService(x);
	}

	@Test
	public void checkOdlMDSALServicefunctiontypeTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALServicefunctiontype(x);
	}

	@Test
	public void checkOdlMDSALSfcfunctionTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALSfcfunction(x);
	}

	@Test
	public void checkOdlMDSALSfcfunctionAlgorithmsTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALSfcfunctionAlgorithms(x);
	}

	@Test
	public void checkOdlMDSALSfcfunctionchainTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALSfcfunctionchain(x);
	}

	@Test
	public void checkOdlMDSALSfcfunctiongroupsTest() throws SnmpStatusException {
		String x = "localhost";
		odlCardinalProjectModule.checkOdlMDSALSfcfunctiongroups(x);
	}

}