package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.FeatureList;
import org.slf4j.LoggerFactory;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class FeatureListTest {
    FeatureList featureList = new FeatureList();
    String host = "localhost";
    static String user = "karaf";
    static String password = "karaf";
    boolean karafsession;
    private static final org.slf4j.Logger LOG = LoggerFactory
            .getLogger(KarafInfoTest.class);

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
    public void odlKarafFeatureListTest() {
        boolean flag = false;
        if (karafsession) {
            Map<String, String> odlfeatureList = featureList
                    .odlKarafFeatureList();
            if (odlfeatureList.size() > 0)
                flag = true;

            assertTrue(flag);
        } else {
            assertFalse(flag);
        }
    }

    @Test
    public void odlKarafFeatureInstalledTest() {
        boolean flag = false;
        if (karafsession) {
            List<String> installFeatures = featureList
                    .odlKarafFeatureInstalled();
            if (installFeatures.size() > 0)
                flag = true;
            assertTrue(flag);
        } else {
            assertFalse(flag);
        }
    }

    @Test
    public void odlKarafFeatureUnInstalledTest() {
        boolean flag = false;
        if (karafsession) {
            List<String> uninstallFeatures = featureList
                    .odlKarafFeatureUnInstalled();
            if (uninstallFeatures.size() > 0)
                flag = true;
            assertTrue(flag);
        } else {
            assertFalse(flag);
        }
    }

    @Test
    public void odlKarafFeatureOidTest() {
        boolean flag = false;
        if (karafsession) {
            Map<String, String> featureListOid = featureList
                    .odlKarafFeatureOid();
            if (featureListOid.size() > 0)
                flag = true;
            assertTrue(flag);
        } else {
            assertFalse(flag);
            ;
        }
    }
}
