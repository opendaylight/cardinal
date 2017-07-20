/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.cardinal.impl;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.LoggerFactory;

public class KarafInfo {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalKarafManager.class);

    private NumberFormat fmtI = new DecimalFormat("###,###", new DecimalFormatSymbols(Locale.ENGLISH));
    private int active = 32;
    private int resolved = 4;
    List<List<String>> bundlesDetails = new ArrayList<List<String>>();
    static String live_thread;
    static String daemon_Thread;
    static String peak;
    static String total_threads;
    static String current_heap_size;
    static String maximum_heap_size;
    String bundle_list_active = "";
    static String bundle_list_inactive = "";
    static String bundle_list_resolved = "";
    static StringBuffer result = new StringBuffer();
    String host = "localhost";
    static String user = "karaf";
    static String password = "karaf";
    static String command1 = "feature:list | grep \" x\"";
    static String command2 = "feature:list | grep \"\\|           \\|\"";
    SnmpSet set = new SnmpSet();

    public List<List<String>> bundlesInfo() {
        BundleContext bundleContext = FrameworkUtil.getBundle(OdlCardinalKarafManager.class).getBundleContext();
        Bundle[] list = bundleContext.getBundles();
        ArrayList<String> resolvedBundles = new ArrayList<String>();
        ArrayList<String> activeBundles = new ArrayList<String>();
        ArrayList<String> inactiveBundles = new ArrayList<String>();

        for (int i = 0; i < list.length; i++) {
            if (list[i].getState() == active) {
                activeBundles.add(list[i].toString());
                bundle_list_active = bundle_list_active + activeBundles.add(list[i].toString());
            }
            if (list[i].getState() == resolved) {
                resolvedBundles.add(list[i].toString());
                bundle_list_resolved = bundle_list_resolved + resolvedBundles.add(list[i].toString());
            } else {
                inactiveBundles.add(list[i].toString());
                bundle_list_inactive = bundle_list_inactive + inactiveBundles.add(list[i].toString());
            }
        }

        bundlesDetails.add(activeBundles);
        bundlesDetails.add(resolvedBundles);
        bundlesDetails.add(inactiveBundles);
        return bundlesDetails;

    }

    public boolean odlLiveThreads() {
        ThreadMXBean threads = ManagementFactory.getThreadMXBean();
        try {
            live_thread = "Live-threads:"+Integer.toString(threads.getThreadCount());
            set.setVariableString(".1.3.6.1.3.1.1.7.0.0", live_thread);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean odlDaemonThreads() {
        ThreadMXBean threads = ManagementFactory.getThreadMXBean();
        try {
            daemon_Thread = "Daemon-threads"+Integer.toString(threads.getDaemonThreadCount());
            set.setVariableString(".1.3.6.1.3.1.1.7.1.0", daemon_Thread);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean odlPeakThreads() {
        ThreadMXBean threads = ManagementFactory.getThreadMXBean();
        try {
            peak = "Peak-threads:"+Integer.toString(threads.getPeakThreadCount());
            set.setVariableString(".1.3.6.1.3.1.1.7.2.0", peak);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * public boolean odltotalStartedThreads() { try { total_threads =
     * Long.toString(threads.getTotalStartedThreadCount());
     * set.setVariableString(".1.3.6.1.3.1.1.1.12.0", total_threads); return
     * true; } catch (Exception e) { return false; } }
     */

    public boolean odlKarafCurrentHeapSize() {
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        try {
            current_heap_size = "Current heap-size:"+Long.toString(mem.getHeapMemoryUsage().getCommitted()/1024);
            set.setVariableString(".1.3.6.1.3.1.1.7.3.0", current_heap_size);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean odlKarafMaxHeapSize() {
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        try {
            maximum_heap_size = "Max Heap-size:"+Long.toString(mem.getHeapMemoryUsage().getMax()/1024);
            set.setVariableString(".1.3.6.1.3.1.1.7.4.0", maximum_heap_size);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean odlKarafBundleListActive() {
        BundleContext bundleContext = FrameworkUtil.getBundle(OdlCardinalKarafManager.class).getBundleContext();
        try {
            Bundle[] list = bundleContext.getBundles();
            ArrayList<String> activeBundles = new ArrayList<String>();
            for (int i = 0; i < list.length; i++) {
                if (list[i].getState() == active) {
                    activeBundles.add(list[i].toString());
                }
            }

            for (int i = 1; i <= 10; i++) {
                set.setVariableString(".1.3.6.1.3.1.1.4." + i + ".0", list[i].toString());
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean odlKarafBundleListInActive() {
        BundleContext bundleContext = FrameworkUtil.getBundle(OdlCardinalKarafManager.class).getBundleContext();
        try {
            Bundle[] list = bundleContext.getBundles();
            ArrayList<String> inactiveBundles = new ArrayList<String>();
            for (int i = 0; i < list.length; i++) {
                if ((list[i].getState() != active) && (list[i].getState() != resolved)) {
                    inactiveBundles.add(list[i].toString());
                }
            }
            for (int i = 1; i <= 5; i++) {
                set.setVariableString(".1.3.6.1.3.1.1.5." + i + ".0", list[i].toString());
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean odlKarafBundleListResolved() {
        BundleContext bundleContext = FrameworkUtil.getBundle(OdlCardinalKarafManager.class).getBundleContext();
        try {
            Bundle[] list = bundleContext.getBundles();
            ArrayList<String> resolvedBundles = new ArrayList<String>();
            for (int i = 0; i < list.length; i++) {
                if (list[i].getState() == resolved) {
                    resolvedBundles.add(list[i].toString());
                }
            }
            for (int i = 1; i <= 5; i++) {
                set.setVariableString(".1.3.6.1.3.1.1.6." + i + ".0", list[i].toString());
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean odlKarafFeatureInstalled() {
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
                List<String> installFeatures = new ArrayList<String>();
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals("x[m[m")) {
                        installFeatures.add(items.get(i - 4));
                    }
                }
                for (int i = 1; i <= 10; i++) {
                  if(i<installFeatures.size()){
                    set.setVariableString(".1.3.6.1.3.1.1.2." + i + ".0", installFeatures.get(i));
                    }
                }

                LOG.info("Value set for installed features");
                return true;
            }
            channel.disconnect();
            session.disconnect();
            LOG.info("DONE");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean odlKarafFeatureUnInstalled() {
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
                List<String> uninstallFeatures = new ArrayList<String>();
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals("[43;30m|")) {
                        uninstallFeatures.add(items.get(i - 3));
                    }
                }
                for (int i = 1; i <= 10; i++) {
                    set.setVariableString(".1.3.6.1.3.1.1.3." + i + ".0", uninstallFeatures.get(i));
                }

                LOG.info("Value set for installed features");
                return true;
            }
            channel.disconnect();
            session.disconnect();
            LOG.info("DONE");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private String printLong(long mem) {
        return fmtI.format(mem);
    }

    private String printSizeInKb(double size) {
        return fmtI.format((long) (size / 1024)) + " kbytes";
    }

}
