/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class SetCardinalMibValues implements AutoCloseable {
  private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(SetCardinalMibValues.class);

  public void setMibValues() throws Exception {
    String temp = null;
    String pid = null;
    String uptime = null;

    // getting the system name

    InetAddress ipAddress = InetAddress.getLocalHost();
    String hostName = ipAddress.getHostName();
    SnmpSet set = new SnmpSet();

    // setting system name to mib variable

    set.setVariableString(".1.3.6.1.3.1.1.1.4.0", hostName);

    // setting odl-node name.

    set.setVariableString(".1.3.6.1.3.1.1.1.6.0", "Opendaylight Node Information");

    // getting system ip address

    try {
      Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
      while (interfaces.hasMoreElements()) {
        NetworkInterface iface = interfaces.nextElement();
        if (iface.isLoopback() || !iface.isUp() || iface.isVirtual() || iface.isPointToPoint())
          continue;

        Enumeration<InetAddress> addresses = iface.getInetAddresses();
        while (addresses.hasMoreElements()) {
          InetAddress addr = addresses.nextElement();

          final String ip = addr.getHostAddress();
          if (Inet4Address.class == addr.getClass()) {

            // setting system ip address to mib varible

            set.setVariableString(".1.3.6.1.3.1.1.1.3.0", ip);
          }

        }
      }
    } catch (SocketException e) {
      throw new RuntimeException(e);
    }

    // fetching the process id of karaf

    try {
      Process p = Runtime.getRuntime().exec("sudo netstat -lpn ");
      BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
      BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
      String[] words;
      ArrayList<String> arr = new ArrayList<String>();
      // read the output from the command
      String[] s2 = null;
      while ((temp = stdInput.readLine()) != null) {
        if (temp.contains(":8101")) {
          words = temp.split(" ");
          // System.out.println(s);
          for (String each : words) {
            if (!"".equals(each)) {
              arr.add(each);
            }
          }
          s2 = arr.get(6).split("/");
          // getting cpu and memory usage of karaf

          try {
            Process systemProcess = Runtime.getRuntime().exec(" ps -p " + s2[0] + " -o %cpu,%mem");
            systemProcess.waitFor();
            BufferedReader StdInput = new BufferedReader(
                new InputStreamReader(systemProcess.getInputStream()));
            String topS = "";
            int a = 0;
            int b = 0;
            StdInput.readLine();
            while ((topS = StdInput.readLine()) != null) {
              topS = topS.replaceAll("  ", " ");
              topS = topS.replaceAll("  ", " ");
              topS = topS.replaceAll("  ", " ");
              String[] tokens1 = topS.split(" ");
              float temp1 = Float.parseFloat(tokens1[1]);
              float temp2 = Float.parseFloat(tokens1[2]);
              a = Math.round(temp1);
              b = Math.round(temp2);
              // setting the cpu value to mib variable

              set.setVariableInt(".1.3.6.1.3.1.1.1.1.0", a);

              // setting the mem usage value to mib variable

              set.setVariableInt(".1.3.6.1.3.1.1.1.2.0", b);
            }

          } catch (Exception e) {
            throw new RuntimeException(e);

          }

          // getting karaf Uptime

          try {
            Process systemProcess = Runtime.getRuntime().exec("ps -eo pid,etime");
            systemProcess.waitFor();
            BufferedReader StdInput = new BufferedReader(
                new InputStreamReader(systemProcess.getInputStream()));
            String topS = "";

            while ((topS = StdInput.readLine()) != null) {
              if (topS.contains(s2[0])) {
                topS = topS.replaceAll("  ", " ");
                topS = topS.replaceAll("  ", " ");
                topS = topS.replaceAll("  ", " ");
                String[] tokens1 = topS.split(" ");
                pid = tokens1[0];
                uptime = tokens1[1];

                // setting the karaf uptime value to mib
                // variable

                set.setVariableString(".1.3.6.1.3.1.1.1.5.0", uptime);

              }
            }
          } catch (Exception e) {
            throw new RuntimeException(e);

          }

        }
      }

      // read any errors from the attempted command
      LOG.info("error of the command (if any):");
      String s1;
      while ((s1 = stdError.readLine()) != null) {
        LOG.info(s1);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);

    }
  }

  @Override
  public void close() throws Exception {
    // TODO Auto-generated method stub

  }
}
