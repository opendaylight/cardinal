/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.apache.sshd.client.future.ConnectFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class FeatureList {
    String host = "localhost";
    static String user = "karaf";
    static String password = "karaf";
    static String command1 = "feature:list | grep \" x\"";
    static String command2 = "feature:list | grep \"\\|           \\|\"";
    Map<String, String> insfeature = new HashMap<String, String>();
    Map<String, String> featureListOid = new HashMap<String, String>();
    static StringBuffer result = new StringBuffer();
    static SshClient client = null;
    SnmpSet set = new SnmpSet();

    private static final Logger LOG = LoggerFactory.getLogger(FeatureList.class);

    public Map<String, String> odlKarafFeatureList() {
        FeatureList featureList = new FeatureList();
        List<String> installFeatures = new ArrayList<String>();
        List<String> uninstallFeatures = new ArrayList<String>();
        Map<String, String> insfeature = new HashMap<String, String>();
        installFeatures = featureList.odlKarafFeatureInstalled();
        uninstallFeatures = featureList.odlKarafFeatureUnInstalled();
        for (int i = 0; i < installFeatures.size(); i++) {
            insfeature.put(installFeatures.get(i), "Installed");
        }
        for (int i = 0; i < uninstallFeatures.size(); i++) {
            insfeature.put(uninstallFeatures.get(i), "UnInstalled");
        }
        LOG.info("Value set for installed features");

        return insfeature;
    }

    public List<String> odlKarafFeatureInstalled() {
        List<String> installFeatures = new ArrayList<String>();
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 8101);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            LOG.info("Connected");
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command1);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            channel.connect();
            Reader reader = new InputStreamReader(channel.getInputStream());
            char[] buf = new char[20000];
            int numRead;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                result.append(readData);
                buf = new char[20000];
                List<String> items = Arrays.asList(readData.split("\\s+"));

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals("x[m[m")) {
                        installFeatures.add(items.get(i - 4));
                    }
                }
                LOG.info("Value set for installed features");
                return installFeatures;
            }
            channel.disconnect();
            session.disconnect();
            LOG.info("DONE");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return installFeatures;
    }

    public List<String> odlKarafFeatureUnInstalled() {
        List<String> uninstallFeatures = new ArrayList<String>();
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 8101);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            LOG.info("Connected");
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command2);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            channel.connect();
            Reader reader = new InputStreamReader(channel.getInputStream());
            char[] buf = new char[20000];
            int numRead;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                result.append(readData);
                buf = new char[20000];
                List<String> items = Arrays.asList(readData.split("\\s+"));

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals("[43;30m|")) {
                        uninstallFeatures.add(items.get(i - 3));
                    }
                }
                LOG.info("Value set for installed features");
                return uninstallFeatures;
            }
            channel.disconnect();
            session.disconnect();
            LOG.info("DONE");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return uninstallFeatures;
    }

    public Map<String, String> odlKarafFeatureOid() {
        int c = 1;
        FeatureList featureList = new FeatureList();
        List<String> installFeatures = new ArrayList<String>();
        List<String> uninstallFeatures = new ArrayList<String>();
        installFeatures = featureList.odlKarafFeatureInstalled();
        uninstallFeatures = featureList.odlKarafFeatureUnInstalled();
        for (int i = 0; i < installFeatures.size(); i++) {
            featureListOid.put(installFeatures.get(i), ".1.3.6.1.3.1.1.2." + c + ".0");
            try {
                set.setVariableString(".1.3.6.1.3.1.1.2." + c + ".0", installFeatures.get(i));
                c++;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int i = 0; i < uninstallFeatures.size(); i++) {
            featureListOid.put(uninstallFeatures.get(i), ".1.3.6.1.3.1.1.2." + c + ".0");
            try {
                set.setVariableString(".1.3.6.1.3.1.1.2." + c + ".0", uninstallFeatures.get(i));
                c++;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return featureListOid;

    }

}
