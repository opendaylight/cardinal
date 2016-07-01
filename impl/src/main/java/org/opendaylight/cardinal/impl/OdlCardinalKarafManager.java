/*
 * Copyright © 2016 Tata Consultancy Services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
public class OdlCardinalKarafManager {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalKarafManager.class);

    /**
     * @param args.
     */
    public static void main(String[] args) {
        StringBuffer result = new StringBuffer();
        String host = "localhost";
        String user = "karaf";
        String password = "karaf";
        String command1 = "feature:list | grep \" x\"";
        String command2 = "feature:list | grep \"\\|           \\|\"";
        String live_thread;
        String daemon_Thread;
        String peak;
        String total_threads;
        String current_heap_size;
        String maximum_heap_size;
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

            InputStream in = channel.getInputStream();
            channel.connect();
            Reader reader = new InputStreamReader(channel.getInputStream());
            char[] buf = new char[20000];
            int numRead;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                result.append(readData);
                buf = new char[20000];
                ArrayList<String> list = new ArrayList<String>();
                // list.add();
                List<String> items = Arrays.asList(readData.split("\\s+"));
                for (int i = 0; i < items.size(); i++) {
                     if (items.get(i).equals("x[m[m")) {
                        System.out.println(items.get(i - 4));
                    }
                }
                List<String> strlist = new ArrayList<String>();
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals("[43;30m|")) {
                       strlist.add(items.get(i - 3));
                   }
                }
                System.out.println(strlist);
                //System.out.println(items);
                LOG.info("Value retrieved for Threads and Memory");
            }
            channel.disconnect();
            session.disconnect();
            LOG.info("DONE");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
