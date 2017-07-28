/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import org.slf4j.LoggerFactory;

public class OdlCardinalPolling implements Runnable {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalPolling.class);
    final SetCardinalMibValues setSnmpValues = new SetCardinalMibValues();
    final Agent snmpDaemonStart = new Agent();
    final OdlCardinalSysInfoApis cardinalApi = new OdlCardinalSysInfoApis();
    final OdlCardinalKarafInfoApi cardinalKarafApi = new OdlCardinalKarafInfoApi();
    final KarafInfo manager = new KarafInfo();
    final odlCardinalProjectManager pmanager = new odlCardinalProjectManager();


    @Override

    public void run() {
        // TODO Auto-generated method stub
        boolean flag = true;
        long threadSleepTime  = 60000;
        while(flag){
            System.out.println("running thread");
            LOG.info("Fetching system information");
            // Fetching the system values and setting those values to our mib
            try {
                boolean settingFirstTimePassed = setSnmpValues.setMibValues();
                if(settingFirstTimePassed){
                manager.odlDaemonThreads();
                manager.odlKarafBundleListActive();
                manager.odlKarafBundleListInActive();
                manager.odlKarafBundleListResolved();
                manager.odlKarafCurrentHeapSize();
                manager.odlKarafFeatureInstalled();
                manager.odlKarafFeatureUnInstalled();
                manager.odlKarafMaxHeapSize();
                manager.odlLiveThreads();
                manager.odlPeakThreads();
                pmanager.odlMDSALIotDMListofcse();
                }
                else{
                    break;
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();


            }

            try {
                if(flag){
                Thread.sleep(threadSleepTime);
                }
                else {
                    Thread.currentThread().destroy();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void startThread() throws InterruptedException{

        OdlCardinalPolling cardinalObj = new OdlCardinalPolling();
        Thread cardinalThread = new Thread(cardinalObj);
            cardinalThread.start();
    }

}
