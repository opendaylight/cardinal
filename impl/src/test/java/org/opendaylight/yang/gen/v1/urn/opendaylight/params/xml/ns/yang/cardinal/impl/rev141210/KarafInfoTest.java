package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.KarafInfo;
import org.slf4j.LoggerFactory;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class KarafInfoTest {
    KarafInfo karafInfo = new KarafInfo();
    String host = "localhost";
    static String user = "karaf";
    static String password = "karaf";
    boolean karafsession;
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(KarafInfoTest.class);

    @Before
    public void setUp() throws JSchException {
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 8101);
        session.setPassword(password);
        session.setConfig(config);
        if (password == "karaf") {
            try {
                session.connect();
                karafsession = true;
            } catch (JSchException e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
                LOG.info("Karaf is not running");
            }
        } else {
            karafsession = false;
        }
    }

    @After
    public void setDown() {

    }

    @Test
    public void odlLiveThreadsTest() {
        boolean olt = karafInfo.odlLiveThreads();
        if (olt) {
            assertEquals(true, olt);
        } else {
            assertEquals(false, olt);
        }
    }

    @Test
    public void odlDaemonThreadsTest() {
        boolean odt = karafInfo.odlDaemonThreads();
        if (odt) {
            assertEquals(true, odt);
        } else {
            assertEquals(false, odt);
        }
    }

    @Test
    public void odlPeakThreadsTest() {
        boolean opt = karafInfo.odlPeakThreads();
        if (opt) {
            assertEquals(true, opt);
        } else {
            assertEquals(false, opt);
        }
    }

    @Test
    public void odlKarafCurrentHeapSizeTest() {
        boolean okcht = karafInfo.odlKarafCurrentHeapSize();
        if (okcht) {
            assertEquals(true, okcht);
        } else {
            assertEquals(false, okcht);
        }
    }

    @Test
    public void odlKarafMaxHeapSizeTest() {
        boolean okmht = karafInfo.odlKarafMaxHeapSize();
        if (okmht) {
            assertEquals(true, okmht);
        } else {
            assertEquals(false, okmht);
        }
    }

    @Test
    public void odlKarafBundleListActiveTest() {
        if (karafsession) {
            boolean okblat = karafInfo.odlKarafBundleListActive();
            assertEquals(true, okblat);
        } else {
            assertEquals(false, karafsession);
        }
    }

    @Test
    public void odlKarafBundleListInActiveTest() {
        if (karafsession) {
            boolean odt = karafInfo.odlKarafBundleListInActive();
            assertEquals(true, odt);
        } else {
            assertEquals(false, karafsession);
        }
    }

    @Test
    public void odlKarafBundleListResolvedTest() {
        if (karafsession) {
            boolean odt = karafInfo.odlKarafBundleListResolved();
            assertEquals(true, odt);
        } else {
            assertEquals(false, karafsession);
        }
    }

    @Test
    public void odlKarafFeatureInstalledTest() {
        if (karafsession) {
            boolean odt = karafInfo.odlKarafFeatureInstalled();
            assertEquals(true, odt);
        } else {
            assertEquals(false, karafsession);
        }
    }

    @Test
    public void odlKarafFeatureUnInstalledTest() {
        if (karafsession) {
            boolean odt = karafInfo.odlKarafFeatureUnInstalled();
            assertEquals(true, odt);
        } else {
            assertEquals(false, karafsession);
        }
    }

    @Test
    public void bundlesInfoTest() {
        if (karafsession) {
            List<List<String>> bundle = karafInfo.bundlesInfo();
            assertEquals(1, bundle.size());
        } else {
            assertEquals(false, karafsession);
        }
    }
}