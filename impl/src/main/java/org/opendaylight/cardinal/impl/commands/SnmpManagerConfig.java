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

import java.io.IOException;
import java.lang.String;
import java.lang.IllegalArgumentException;
import java.lang.Exception;

@Command(scope = "odl", name = "snmp-manager",description = "Configure Snmp Address ")
public class SnmpManagerConfig extends OsgiCommandSupport {
    private static final String IP = "--ipaddress";
    private static final String TC = "--community";
    @Argument(index = 0, name = "add|del", description = "The desired operation",
            required = true, multiValued = false)
    String action = null;
    @Option(name = IP, aliases ={"-i"} ,description = "SNMP Manager IP",
            required = false, multiValued = false)
    String snmpManagerIp = null;
    @Option(name = TC, aliases = {"-c"}, description = "SNMP Trap Community",
            required = false, multiValued = false)

    String trapCommunity = null;
    private static final Logger logger = LoggerFactory.getLogger(SnmpManagerConfig.class);

    private SnmpManagerDatabaseOnSal snmpDBonSAL = null;
    public SnmpManagerConfig(SnmpManagerDatabaseOnSal databaseOnSal) {
        snmpDBonSAL = databaseOnSal;
    }

    private Object usage() {
        System.out.println("Insufficient Arguments");
        System.out.println("Correct Usage : ");
        System.out.println("snmp-manager -i <ip-address> -c <trap Community> add");
        System.out.println("snmp-manager del");
        return null;
    }
    @Override
    protected Object doExecute() {
        try {
            switch(action) {
                case "add":
                    logger.debug("executing snmp-manager-add command");
                    if (snmpManagerIp == null) {
                        System.out.println("Insufficient Arguments");
                        System.out.println("Correct Usage : snmp-manager -i <ip-address> -c <trap Community> add");
                        return null;
                    }
                    if (trapCommunity == null)
                        trapCommunity = "public";
                    snmpDBonSAL.setSnmpManagerConfiguration(snmpManagerIp, trapCommunity);
                    break;
                case "del":
                    logger.debug("executing snmp-manager command");
                    snmpDBonSAL.resetSnmpManagerAddress();
                    break;
                default:
                    return usage();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Exception occurred during execution of command \"snmp-manager\": ", e);
        }
        return null;
    }
}


