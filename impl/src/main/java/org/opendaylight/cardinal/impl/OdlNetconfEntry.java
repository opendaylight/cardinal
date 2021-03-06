/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;
//

// Generated by mibgen version 5.1 (03/08/07) when compiling ODL-CARDINAL-MIB.
//

// java imports
//
import java.io.Serializable;

// jmx imports
//
import com.sun.management.snmp.SnmpStatusException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;

/**
 * The class is used for implementing the "OdlNetconfEntry" group. The group is
 * defined with the following oid: 1.3.6.1.3.1.1.16.1.1.
 */
public class OdlNetconfEntry implements OdlNetconfEntryMBean, Serializable {

    /**
     * Variable for storing the value of "OdlNetconfStatus". The variable is
     * identified by: "1.3.6.1.3.1.1.16.1.1.4".
     */
    protected String OdlNetconfStatus = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlNetconfPort". The variable is
     * identified by: "1.3.6.1.3.1.1.16.1.1.3".
     */
    protected String OdlNetconfPort = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlNetconfHost". The variable is
     * identified by: "1.3.6.1.3.1.1.16.1.1.2".
     */
    protected String OdlNetconfHost = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlNetconfNodeId". The variable is
     * identified by: "1.3.6.1.3.1.1.16.1.1.1".
     */
    protected Byte[] OdlNetconfNodeId = { new Byte("74"), new Byte("68"), new Byte("77"), new Byte("75") };

    /**
     * Constructor for the "OdlNetconfEntry" group.
     */
    public OdlNetconfEntry(SnmpMib myMib) {
    }

    /**
     * Getter for the "OdlNetconfStatus" variable.
     */
    public String getOdlNetconfStatus() throws SnmpStatusException {
        return OdlNetconfStatus;
    }

    /**
     * Setter for the "OdlNetconfStatus" variable.
     */
    public void setOdlNetconfStatus(String x) throws SnmpStatusException {
        OdlNetconfStatus = x;
    }

    /**
     * Checker for the "OdlNetconfStatus" variable.
     */
    public void checkOdlNetconfStatus(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlNetconfPort" variable.
     */
    public String getOdlNetconfPort() throws SnmpStatusException {
        return OdlNetconfPort;
    }

    /**
     * Setter for the "OdlNetconfPort" variable.
     */
    public void setOdlNetconfPort(String x) throws SnmpStatusException {
        OdlNetconfPort = x;
    }

    /**
     * Checker for the "OdlNetconfPort" variable.
     */
    public void checkOdlNetconfPort(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlNetconfHost" variable.
     */
    public String getOdlNetconfHost() throws SnmpStatusException {
        return OdlNetconfHost;
    }

    /**
     * Setter for the "OdlNetconfHost" variable.
     */
    public void setOdlNetconfHost(String x) throws SnmpStatusException {
        OdlNetconfHost = x;
    }

    /**
     * Checker for the "OdlNetconfHost" variable.
     */
    public void checkOdlNetconfHost(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlNetconfNodeId" variable.
     */
    public Byte[] getOdlNetconfNodeId() throws SnmpStatusException {
        return OdlNetconfNodeId;
    }

    /**
     * Setter for the "OdlNetconfNodeId" variable.
     */
    public void setOdlNetconfNodeId(Byte[] x) throws SnmpStatusException {
        OdlNetconfNodeId = x;
    }

    /**
     * Checker for the "OdlNetconfNodeId" variable.
     */
    public void checkOdlNetconfNodeId(Byte[] x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
