/*
 * Copyright © 2017 Ericsson and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import com.sun.management.snmp.SnmpOid;
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.SnmpVarBind;
import com.sun.management.snmp.SnmpVarBindList;
import com.sun.management.snmp.agent.SnmpMibAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.opendaylight.cardinal.api.SnmpMibService;

import java.util.Enumeration;

/**
 * Created by anirban on 25/12/16.
 */
public class SnmpMibServiceImpl implements SnmpMibService {
    private final Logger LOG = LoggerFactory.getLogger(SnmpMibServiceImpl.class);

    private Agent agent = null;
    public SnmpMibServiceImpl(Agent agent) {
        this.agent = agent;
    }

    public void loadMib(SnmpMibAgent mib){
        LOG.info("Loading Mib " + mib.getMibName());
        agent.registerMib(mib);
    }

    public void unloadMib(SnmpMibAgent mib){
        LOG.info("Unloading Mib " + mib.getMibName());
        agent.unregisterMib(mib);
    }

    public void setTrapAddress(String trapCommunity, String trapReceiver) {
        LOG.info("setTrapAddress called " + trapReceiver);
        agent.setTrapAddress(trapCommunity, trapReceiver);
    }

    public void sendSnmpTrap(SnmpOid ntOid, Enumeration<SnmpOid> payloadOid, Enumeration<SnmpValue> payloadData) {
        try {
            SnmpVarBindList varBindList = new SnmpVarBindList();
            while(payloadOid.hasMoreElements())
            {
                SnmpOid tempOid = payloadOid.nextElement();
                SnmpVarBind payloadOidBindData = new SnmpVarBind(tempOid, payloadData.nextElement());
                varBindList.addVarBind(payloadOidBindData);
            }
            agent.getSnmpAdaptor().snmpV2Trap(ntOid, varBindList);
            LOG.info("SnmpV2Trap Alarm sent " + ntOid);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

