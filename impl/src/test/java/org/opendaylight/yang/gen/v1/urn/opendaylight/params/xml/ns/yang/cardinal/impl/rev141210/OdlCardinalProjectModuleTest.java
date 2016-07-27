package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;

import javax.management.MBeanServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.agent.SnmpMib;
/** 
 * @author Subodh Roy
 * 
 */ 
public class OdlCardinalProjectModuleTest {
	SnmpMib myMib;
	MBeanServer server;
	org.opendaylight.cardinal.impl.OdlCardinalProjectModule odlCardinalProjectModule= new org.opendaylight.cardinal.impl.OdlCardinalProjectModule(myMib);

	@Before
	public void setUp() {
	//	SnmpSet set = new SnmpSet();
		//final org.slf4j.Logger LOG = LoggerFactory.getLogger(SetCardinalMibValues.class);
	     //
	   }
	
	@After
	public void setDown() {
		
		   }
	
	@Test
	public void getOdlMDSALBGPBMPinfoTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALBGPBMPinfo(x);
		String y=odlCardinalProjectModule.getOdlMDSALBGPBMPinfo();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALBGPRIBInfoTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALBGPRIBInfo(x);
		String y=odlCardinalProjectModule.getOdlMDSALBGPRIBInfo();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALBGPPeerInfoTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALBGPPeerInfo(x);
		String y=odlCardinalProjectModule.getOdlMDSALBGPPeerInfo();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALOpenFlowOVSconnectedDevicesTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALOpenFlowOVSconnectedDevices(x);
		String y=odlCardinalProjectModule.getOdlMDSALOpenFlowOVSconnectedDevices();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALIotDMlistofNodesTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALIotDMlistofNodes(x);
		String y=odlCardinalProjectModule.getOdlMDSALIotDMlistofNodes();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALIotDMlistofAEsTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALIotDMlistofAEs(x);
		String y=odlCardinalProjectModule.getOdlMDSALIotDMlistofAEs();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALIotDMListofcseTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALIotDMListofcse(x);
		String y=odlCardinalProjectModule.getOdlMDSALIotDMListofcse();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALGBPPolicytenantsTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALGBPPolicytenants(x);
		String y=odlCardinalProjectModule.getOdlMDSALGBPPolicytenants();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALGBPFaaslogicalnetworkTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALGBPFaaslogicalnetwork(x);
		String y=odlCardinalProjectModule.getOdlMDSALGBPFaaslogicalnetwork();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALServiceTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALService(x);
		String y=odlCardinalProjectModule.getOdlMDSALService();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALServicefunctiontypeTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALServicefunctiontype(x);
		String y=odlCardinalProjectModule.getOdlMDSALServicefunctiontype();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALSfcfunctionAlgorithms() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALSfcfunctionAlgorithms(x);
		String y=odlCardinalProjectModule.getOdlMDSALSfcfunctionAlgorithms();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALSfcfunctiongroupsTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALSfcfunctiongroups(x);
		String y=odlCardinalProjectModule.getOdlMDSALSfcfunctiongroups();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALNetconfConnectedDevicesTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALNetconfConnectedDevices(x);
		String y=odlCardinalProjectModule.getOdlMDSALNetconfConnectedDevices();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALSfcfunctionTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALSfcfunction(x);
		String y=odlCardinalProjectModule.getOdlMDSALSfcfunction();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALClustershardssharedTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALClustershardsshared(x);
		String y=odlCardinalProjectModule.getOdlMDSALClustershardsshared();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALClusterControllerRoleTest() throws SnmpStatusException{
		String x="localhost";
		odlCardinalProjectModule.setOdlMDSALClusterControllerRole(x);
		String y=odlCardinalProjectModule.getOdlMDSALClusterControllerRole();
		assertEquals(x, y);
	
	}
	
	
}
