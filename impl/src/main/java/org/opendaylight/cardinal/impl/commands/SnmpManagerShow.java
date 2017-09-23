/*
 * Copyright (c) 2017 Ericsson India Global Services Pvt Ltd. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl.commands;
/**
 * Created by Kushagra Rastogi on 8/11/2017.
 */
import org.apache.karaf.shell.commands.*;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.String;
import java.io.IOException;
import java.lang.Exception;

@Command(scope = "odl", name = "snmp-manager-show",description = "Show Snmp Address and Trap Community")
public class SnmpManagerShow extends OsgiCommandSupport {
    private static final Logger logger = LoggerFactory.getLogger(SnmpManagerShow.class);

    private SnmpManagerDatabaseOnSal snmpDBonSAL = null;
    public SnmpManagerShow(SnmpManagerDatabaseOnSal databaseOnSal) {
        snmpDBonSAL = databaseOnSal;
    }

    protected Object doExecute(){
        try {
            logger.debug("executing snmp-manager-show command");
            String snmpManagerIp = snmpDBonSAL.getSnmpManagerAddress();
            String trapCommunity = snmpDBonSAL.getTrapAclCommunity();
            if(trapCommunity == null || snmpManagerIp == null) {
                System.out.println("Snmp Manager Ip or Trap community is not defined");
                return null;
            }
            System.out.println("Snmp Community : " + trapCommunity);
            System.out.println("Snmp Manager IP Address : " + snmpManagerIp);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Exception occurred during execution of command \"snmp-manager-show\": ", e);
        }
        return null;
    }
}
