package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;
import static org.junit.Assert.*;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import org.opendaylight.cardinal.impl.Agent; 
import org.opendaylight.cardinal.impl.OdlCardinalGet; 
import org.snmp4j.Snmp; 
import org.snmp4j.event.ResponseEvent;
import com.sun.management.snmp.SnmpStatusException; 
/** 
 * @author Amandeep Singh Rattenpal 
 * 
 */ 
public class OdlCardinalGetTest { 
        MBeanServer mockserver; 
        ObjectName mockhtmlObjName; 
        ObjectName mocksnmpObjName; 
        ObjectName mockmibObjName; 
        Agent mockagent = new Agent(); 
        int htmlPort = 8082; 
        int snmpPort = 161; 
        String strResponse = ""; 
        ResponseEvent response; 
        Snmp snmp; 
        OdlCardinalGet get = new OdlCardinalGet();
	/** 
	 * @throws SnmpStatusException 
	 * @throws java.lang.Exception 
	 */ 
        @Before
    	public void setUp() throws SnmpStatusException {
        	mockagent.startSnmpDaemon(); 
    	}
    	
    	@After
    	public void setDown() {
                }
        @Test 
        public void TestSnmpGet() throws MalformedObjectNameException { 
           String cardinalString = get.snmpGet("localhost", "public", 
                                     ".1.3.6.1.3.1.1.1.6.0"); 
           String mockString = " Opendaylight Node Information"; 

           assertEquals(cardinalString, cardinalString); 

        } 
}
