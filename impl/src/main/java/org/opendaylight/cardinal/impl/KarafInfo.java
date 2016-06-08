/*
 * Copyright © 2016 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210.CardinalModule;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/*
 * Copyright © 2016 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
public class KarafInfo {
private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(KarafInfo.class);
/**
 * @param args
 */
public static void main(String[] args) {
  StringBuffer result = new StringBuffer();
  String host = "localhost";
  String user = "karaf";
  String password = "karaf";
  String command1 = "shell:info";
  String Live_thread;
  String Daemon_Thread;
  String Peak;
  String Total_threads;
  String Current_heap_size;
  String Maximum_heap_size;
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

  InputStream in = channel.getInputStream();
  channel.connect();
  Reader reader = new InputStreamReader(channel.getInputStream());
  char[] buf = new char[2048];

  int numRead;
  while ((numRead = reader.read(buf)) != -1) {
  String readData = String.valueOf(buf, 0, numRead);
  result.append(readData);
  buf = new char[2048];
  List<String> items = Arrays.asList(readData.split("\\s+"));
  Live_thread = items.get(61);
  Daemon_Thread = items.get(65);
  Peak = items.get(68);
  Total_threads = items.get(72);
  Current_heap_size = items.get(78);
  Maximum_heap_size = items.get(84);
  LOG.info("Value retrieved for Threads and Memory");
}
  channel.disconnect();
  session.disconnect();
  LOG.info("DONE");
} catch (Exception e) {
  e.printStackTrace();
}

}

}
