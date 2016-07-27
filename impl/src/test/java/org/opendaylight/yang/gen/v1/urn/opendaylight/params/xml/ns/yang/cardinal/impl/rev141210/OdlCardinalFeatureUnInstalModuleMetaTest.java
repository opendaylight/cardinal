package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.apache.sshd.client.future.ConnectFuture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.OdlCardinalFeatureUnInstalModule;
import org.opendaylight.cardinal.impl.OdlCardinalFeatureUnInstalModuleMBean;
import org.snmp4j.Snmp;
import org.snmp4j.event.ResponseEvent;

import com.sun.management.snmp.SnmpStatusException;
import com.sun.management.snmp.SnmpString;
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;
/** 
 * @author Subodh Roy
 * 
 */ 
public class OdlCardinalFeatureUnInstalModuleMetaTest  {
    protected OdlCardinalFeatureUnInstalModuleMBean node;
    protected SnmpStandardObjectServer objectserver = null;
    SnmpMib myMib; 
    SnmpStandardObjectServer objserv;
    
    org.opendaylight.cardinal.impl.OdlCardinalFeatureUnInstalModuleMeta OdlCardinalFeatureUnInstalModuleMeta =new org.opendaylight.cardinal.impl.OdlCardinalFeatureUnInstalModuleMeta(myMib,objserv);
	   long var=1;

	   @Before
	public void setUp() throws IOException, InterruptedException, SnmpStatusException {
//
	   }
	
	@After
   
   @Test 
   public void isVariableTest(){
       long arc=1;
       boolean bool = OdlCardinalFeatureUnInstalModuleMeta.isVariable(arc);
       assertEquals(true,bool);
   }
   @Test
   public void isReadableTest(){
       long arc=1;
       boolean bool = OdlCardinalFeatureUnInstalModuleMeta.isReadable(arc);
       assertEquals(true,bool);  
   }
   @Test
   public void getAttributeNameTest() throws SnmpStatusException{
       long arc=1;
       String str = OdlCardinalFeatureUnInstalModuleMeta.getAttributeName(arc);
       assertEquals("FeatureUnInstalled1",str);  
   }
   @Test
   public void isTableTest(){
       long arc=1;
       boolean bool = OdlCardinalFeatureUnInstalModuleMeta.isTable(arc);
       assertEquals(false,bool);  
   }
   
 
   
   
}
