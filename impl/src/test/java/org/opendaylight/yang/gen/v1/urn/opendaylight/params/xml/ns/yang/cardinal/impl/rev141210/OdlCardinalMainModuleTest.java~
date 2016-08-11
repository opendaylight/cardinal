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
public class OdlCardinalMainModuleTest {
	SnmpMib myMib;
	MBeanServer server;
	
	org.opendaylight.cardinal.impl.OdlCardinalMainModule OdlCardinalMainModule= new org.opendaylight.cardinal.impl.OdlCardinalMainModule(myMib);
	
	@Before
	public void setUp() {
		//SnmpSet set = new SnmpSet();
		//final
	   }
	
	@After
	public void setDown() {
		
		   }
	
	@Test
	public void getOdlSystemOdlNodeInfoTest() throws SnmpStatusException{
		String x="localhost";
		OdlCardinalMainModule.setOdlSystemOdlNodeInfo(x);
		String y=OdlCardinalMainModule.getOdlSystemOdlNodeInfo();
		assertEquals(x, y);
	
	}
	
	@Test
	public void getOdlSystemOdlUptimeTest() throws SnmpStatusException{
		String x="localhost";
		OdlCardinalMainModule.setOdlSystemOdlUptime(x);
		String y=OdlCardinalMainModule.getOdlSystemOdlUptime();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlSystemSysInfoTest() throws SnmpStatusException{
		String x="localhost";
		OdlCardinalMainModule.setOdlSystemSysInfo(x);
		String y=OdlCardinalMainModule.getOdlSystemSysInfo();
		assertEquals(x, y);
	
	}
	
	@Test
	public void getOdlSystemHostAddressTest() throws SnmpStatusException{
		String x="localhost";
		OdlCardinalMainModule.setOdlSystemHostAddress(x);
		String y=OdlCardinalMainModule.getOdlSystemHostAddress();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlSystemMemUsage() throws SnmpStatusException{
		Integer x=100;
		OdlCardinalMainModule.setOdlSystemMemUsage(x);
		Integer y=OdlCardinalMainModule.getOdlSystemMemUsage();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlMDSALGBPResolvedpoliciesTest() throws SnmpStatusException{
		String x="localhost";
		OdlCardinalMainModule.setOdlMDSALGBPResolvedpolicies(x);
		String y=OdlCardinalMainModule.getOdlMDSALGBPResolvedpolicies();
		assertEquals(x, y);
	
	}
	@Test
	public void getOdlSystemCpuUsageTest() throws SnmpStatusException{
		Integer x=1024;
		OdlCardinalMainModule.setOdlSystemCpuUsage(x);
		Integer y=OdlCardinalMainModule.getOdlSystemCpuUsage();
		assertEquals(x, y);
	
	}
}
