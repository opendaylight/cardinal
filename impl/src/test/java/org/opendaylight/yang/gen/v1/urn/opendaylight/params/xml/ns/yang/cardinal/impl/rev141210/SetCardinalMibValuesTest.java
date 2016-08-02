package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.apache.sshd.client.future.ConnectFuture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.SetCardinalMibValues;
import org.opendaylight.cardinal.impl.SnmpSet;
import org.slf4j.LoggerFactory;

/**
 * @author Subodh Roy
 *
 */

public class SetCardinalMibValuesTest {
	SetCardinalMibValues setCardinalMibValues =new SetCardinalMibValues();
	SshClient client = null;
	@Before
	public void setUp() {
		//final 
	   }
	
	@After
	public void setDown() {

        }
		
	@Test
	public void setSystemNameTest(){
		boolean setSystemName=setCardinalMibValues.setSystemName();
		
		assertEquals(true, setSystemName);
				
	}
	
	@Test
	public void setOdlNodeNameTest(){
		boolean setSystemName=setCardinalMibValues.setOdlNodeName();
		
		assertEquals(true, setSystemName);
				
	}
	
	@Test
	public void setSystemIpAddressTest(){
		boolean setSystemName;
		try {
			setSystemName = setCardinalMibValues.setSystemIpAddress();
			assertEquals(true, setSystemName);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
