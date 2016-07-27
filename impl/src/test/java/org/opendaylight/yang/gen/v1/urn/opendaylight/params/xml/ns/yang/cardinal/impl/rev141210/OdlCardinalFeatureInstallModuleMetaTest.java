package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.apache.sshd.client.future.ConnectFuture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.OdlCardinalFeatureInstallModuleMBean;

import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;
/** 
 * @author Subodh Roy
 * 
 */ 
public class OdlCardinalFeatureInstallModuleMetaTest {
    protected OdlCardinalFeatureInstallModuleMBean node;
    protected SnmpStandardObjectServer objectserver = null;
    SnmpMib myMib; 
    SnmpStandardObjectServer objserv;
	    org.opendaylight.cardinal.impl.OdlCardinalFeatureInstallModuleMeta OdlCardinalFeatureInstallModuleMeta = 
	 new org.opendaylight.cardinal.impl.OdlCardinalFeatureInstallModuleMeta(myMib,objserv);  
	    long var=1;
		Object data=null;
		@Before
		public void setUp() throws IOException, InterruptedException {

		//	SnmpSet set = new SnmpSet();
		   }
		
		@After

		 @Test 
		   public void isVariableTest(){
		       long arc=1;
		       boolean bool = OdlCardinalFeatureInstallModuleMeta.isVariable(arc);
		       assertEquals(true,bool);
		   }
		   @Test
		   public void isReadableTest(){
		       long arc=1;
		       boolean bool = OdlCardinalFeatureInstallModuleMeta.isReadable(arc);
		       assertEquals(true,bool);  
		   }
		   @Test
		   public void getAttributeNameTest() throws SnmpStatusException{
		       long arc=1;
		       String str = OdlCardinalFeatureInstallModuleMeta.getAttributeName(arc);
		       assertEquals("FeatureInstalled1",str);  
		   }
		   @Test
		   public void isTableTest(){
		       long arc=1;
		       boolean bool = OdlCardinalFeatureInstallModuleMeta.isTable(arc);
		       assertEquals(false,bool);  
		   }

}
