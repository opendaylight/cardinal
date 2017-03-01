/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jcraft.jsch.JSchException;

public class CallTimer {

    private static final Logger LOG = LoggerFactory.getLogger(CallTimer.class);

    public static void main(String args[]) {
        CallTimer ct = new CallTimer();
        // Displaying current time
        LOG.info("Time now is -> {}", new Date());
        ct.CallTimerMain();

    }

    public void CallTimerMain() {
        // Creating timer which executes once after ten seconds
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TaskExampleRepeating(), 10000, 10000);
    }
}

class TaskExampleRepeating extends TimerTask {
    private static final Logger LOG = LoggerFactory.getLogger(TaskExampleRepeating.class);
    Map<String, String> odlKarafFeatureOid = new HashMap<String, String>();
    Map<String, String> insfeatureprevious = new HashMap<String, String>();
    Map<String, String> odlKarafFeatureList = new HashMap<String, String>();
    FeatureList featureList = new FeatureList();
    TrapSender trapSender = new TrapSender();
    SnmpSet set = new SnmpSet();
    public static int c = 0;

    // This task will repeat every five seconds
    public void run() {
        odlKarafFeatureList.clear();
        odlKarafFeatureList = featureList.odlKarafFeatureList();
        String val = "";

        if (c == 0) {
            odlKarafFeatureOid = featureList.odlKarafFeatureOid();
            c = odlKarafFeatureOid.size();
        }

        for (String k : insfeatureprevious.keySet()) {
            if (odlKarafFeatureList.get(k) != insfeatureprevious.get(k)) {
                val = odlKarafFeatureOid.get(k);
                trapSender.main(val, odlKarafFeatureList.get(k));
                try {
                    set.setVariableString(val, k + " :" + odlKarafFeatureList.get(k));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // cardinalKarafApi.setValues();
            }
        }
        insfeatureprevious.clear();
        insfeatureprevious.putAll(odlKarafFeatureList);

    }
}
