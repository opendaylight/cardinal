/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallTimer implements AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(CallTimer.class);

    private Timer timer;

    public static void main(String args[]) {
        CallTimer ct = new CallTimer();
        // Displaying current time
        LOG.info("Time now is -> {}", new Date());
        ct.CallTimerMain();

    }

    public void CallTimerMain() {
        // Creating timer which executes once after ten seconds
        timer = new Timer();
        timer.scheduleAtFixedRate(new TaskExampleRepeating(), 10000, 10000);
    }

    @Override
    public void close() {
        if (timer != null) {
            timer.cancel();
        }
    }
}

class TaskExampleRepeating extends TimerTask {
    private static final Logger LOG = LoggerFactory.getLogger(TaskExampleRepeating.class);
    Map<String, String> odlKarafFeatureOid = new HashMap<>();
    Map<String, String> insfeatureprevious = new HashMap<>();
    Map<String, String> odlKarafFeatureList = new HashMap<>();
    FeatureList featureList = new FeatureList();
    TrapSender trapSender = new TrapSender();
    SnmpSet set = new SnmpSet();
    public static int c = 0;

    // This task will repeat every five seconds
    @Override
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
