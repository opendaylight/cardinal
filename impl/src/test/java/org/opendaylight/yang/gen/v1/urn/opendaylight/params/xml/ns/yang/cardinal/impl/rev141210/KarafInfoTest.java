package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.KarafInfo;
import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.apache.sshd.client.future.ConnectFuture;
/**
 * @author Subodh Roy
 *
 */

public class KarafInfoTest {
	KarafInfo karafInfo =new KarafInfo();
	
	@Before
	public void setUp() {

	}
	
	@After
	public void setDown() {

        }
	
	@Test
	 public void odlLiveThreadsTest(){
		boolean olt = karafInfo.odlLiveThreads();
		assertEquals(true, olt);

	}
	

	@Test
	 public void odlDaemonThreadsTest(){
		boolean odt = karafInfo.odlDaemonThreads();
		assertEquals(true, odt);
		
	}
	
	@Test
	 public void odlPeakThreadsTest(){
		boolean opt = karafInfo.odlDaemonThreads();
		assertEquals(true, opt);
		
	}
	@Test
	 public void odlKarafCurrentHeapSizeTest(){
		boolean okcht = karafInfo.odlDaemonThreads();
		assertEquals(true, okcht);
		
	}
	
	@Test
	 public void odlKarafMaxHeapSizeTest(){
		boolean okmht = karafInfo.odlDaemonThreads();
		assertEquals(true, okmht);
		
	}
	
	@Test
	 public void odlKarafBundleListActiveTest(){
		boolean okblat = karafInfo.odlDaemonThreads();
		assertEquals(true, okblat);
		
	}
	
	@Test
	 public void odlKarafBundleListInActiveTest(){
		boolean odt = karafInfo.odlDaemonThreads();
		assertEquals(true, odt);
		
	}
	
	@Test
	 public void odlKarafBundleListResolvedTest(){
		boolean odt = karafInfo.odlDaemonThreads();
		assertEquals(true, odt);
		
	}
	@Test
	 public void odlKarafFeatureInstalledTest(){
		boolean odt = karafInfo.odlDaemonThreads();
		assertEquals(true, odt);
		
	}
	
	@Test
	 public void odlKarafFeatureUnInstalledTest(){
		boolean odt = karafInfo.odlDaemonThreads();
		assertEquals(true, odt);
		
	}

}
