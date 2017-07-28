/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import org.slf4j.LoggerFactory;

/**
 * @author Gaurav Pande.
 *
 */
/**
 * @author gaurav pande.
 *
 */
public class SetCardinalMibValues {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SetCardinalMibValues.class);
    SnmpSet set = new SnmpSet();
    String temp = null;
    String pid = null;
    String uptime = null;
    String[] s2 = null;
    static boolean flag = true;
    static boolean flagKaraf = true;

    /**
     * @return
     * @throws Exception
     *             when the methods fail. constructor for the class.
     */
    public boolean setMibValues() throws Exception {
        SetCardinalMibValues setter = new SetCardinalMibValues();
        boolean firstPDUTESTPassed = setter.setSystemName();
        if (firstPDUTESTPassed) {
            setter.setSystemIpAddress();
            setter.setCpuMemUsage(setter);
            setter.setOdlNodeName();
            return true;
        } else {
            return false;
        }

    }

    /**
     * @return false or true on the basis of whether the mib values are set.
     */
    public boolean setSystemName() {
        // getting the system name

        InetAddress ipAddress = null;
        try {
            ipAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e1) {
            throw new RuntimeException(e1);
        }
        String hostName = "Machine Name:" + ipAddress.getHostName();

        // setting system name to mib variable

        try {
            boolean hostNameSet = set.setVariableString(".1.3.6.1.3.1.1.1.4.0", hostName);
            return hostNameSet;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return false or true on the basis of whether the mib values are set.
     */
    public boolean setOdlNodeName() {
        // setting odl-node name.
        try {
            set.setVariableString(".1.3.6.1.3.1.1.1.6.0", "Opendaylight Node A");
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return false or true on the basis of whether the mib values are set.
     * @throws SocketException
     *             when fail to get the socket. method to set the system ip
     *             address.
     */
    public boolean setSystemIpAddress() throws SocketException {
        // getting system ip address
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            if (iface.isLoopback() || !iface.isUp() || iface.isVirtual() || iface.isPointToPoint()) {
                continue;
            }
            // boolean bool=iface.getName().toString().contains("eth0");
            while (iface.getName().toString().contains("eth0") | iface.getName().toString().contains("wlan")) {
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    final String ip = addr.getHostAddress();
                    if (Inet4Address.class == addr.getClass()) {

                        // setting system ip address to mib varible

                        try {
                            set.setVariableString(".1.3.6.1.3.1.1.1.3.0", ip);
                            return true;
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        }
        return true;
    }

    /**
     * @return false or true on the basis of mib values set properly or not.
     * @throws IOException
     *             when an i/o error occur.
     * @throws InterruptedException
     *             when Interrupt occur. method to set the cpu and memory usage.
     */
    public boolean setCpuMemUsage(SetCardinalMibValues setter) throws IOException, InterruptedException {
        // fetching the process id of karaf
        StringBuffer output = new StringBuffer();
        boolean flag = true;
        int flag1 = 0;
        int flag2 = 0;
        String temp = null;
        String[] s2 = null;
        Process process = Runtime.getRuntime().exec("sudo netstat -lpn ");
        process.waitFor();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String[] words;
        ArrayList<String> arr = new ArrayList<>();
        // read the output from the command

        while ((temp = stdInput.readLine()) != null && flag) {
            if (temp.contains(":8101")) {
                words = temp.split(" ");
                for (String each : words) {
                    if (!"".equals(each)) {
                        arr.add(each);
                    }
                }
                s2 = arr.get(6).split("/");

                // getting cpu and memory usage of karaf

                Process systemProcess = Runtime.getRuntime().exec(" ps -p " + s2[0] + " -o %cpu,%mem");
                systemProcess.waitFor();
                BufferedReader stdInput1 = new BufferedReader(new InputStreamReader(systemProcess.getInputStream()));
                String topS = "";
                int cpu = 0;
                int mem = 0;
                ArrayList<String> list = new ArrayList<>();
                String s = stdInput1.readLine();
                while ((topS = stdInput1.readLine()) != null) {
                    topS = topS.replaceAll("  ", " ");
                    topS = topS.replaceAll("  ", " ");
                    topS = topS.replaceAll("  ", " ");
                    String[] tokens1 = topS.split(" ");
                    for (String data : tokens1) {
                        if (!data.equals("")) {
                            list.add(data);
                        }
                    }
                    float temp1 = Float.parseFloat(list.get(0));
                    float temp2 = Float.parseFloat(list.get(1));
                    // float temp1 = Float.parseFloat(tokens1[1]);
                    // float temp2 = Float.parseFloat(tokens1[2]);
                    cpu = Math.round(temp1);
                    flag1 = cpu;
                    mem = Math.round(temp2);
                    flag2 = mem;
                    // setting the cpu value to mib variable

                    try {
                        set.setVariableInt(".1.3.6.1.3.1.1.1.1.0", cpu);

                        // setting the mem usage value to mib variable

                        set.setVariableInt(".1.3.6.1.3.1.1.1.2.0", mem);
                        // return true;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }

        // try close}
        /*
         * catch(ArrayIndexOutOfBoundsException e){ e.printStackTrace(); }
         * catch(Exception e){ e.printStackTrace(); }
         */

        // read any errors from the attempted command
        LOG.info("error of the command (if any):");
        String s1;
        while ((s1 = stdError.readLine()) != null) {
            LOG.info(s1);
        }
        if (flag1 != 0 && flag2 != 0) {
            setter.setKarafUptime(s2[0]);
            return true;
        } else {
            return false;
        }

    }

    /**
     * @return false or true on the basis of mib values set properly or not.
     * @throws IOException
     *             when an i/o error occur.
     * @throws InterruptedException
     *             when Interrupt occur. method to set the uptime of the karaf
     *             process.
     */
    public boolean setKarafUptime(String processid) throws IOException, InterruptedException {

        // getting karaf uptime

        Process systemProcess = Runtime.getRuntime().exec("ps -eo pid,etime");
        systemProcess.waitFor();
        BufferedReader stdInput1 = new BufferedReader(new InputStreamReader(systemProcess.getInputStream()));
        String topS = "";
        ArrayList<String> list = new ArrayList<>();

        while ((topS = stdInput1.readLine()) != null) {
            if (!topS.equals("")) {
                if (topS.contains(processid)) {
                    topS = topS.replaceAll("  ", " ");
                    topS = topS.replaceAll("  ", " ");
                    topS = topS.replaceAll("  ", " ");
                    String[] tokens1 = topS.split(" ");
                    for (String data : tokens1) {
                        if (!data.equals("")) {
                            list.add(data);
                        }
                    }
                    pid = list.get(0);
                    uptime = list.get(1);

                    // setting the karaf uptime value to mib
                    // variable

                    try {
                        set.setVariableString(".1.3.6.1.3.1.1.1.5.0", uptime);
                        return true;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }
            } else {
                LOG.info("Issue in getting uptime...");
            }
        }
        if (uptime != null) {
            return true;
        } else {
            return false;
        }

    }
}
