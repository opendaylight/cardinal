/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.Serializable;

// jmx imports
//
import javax.management.MBeanServer;
import com.sun.management.snmp.SnmpString;
import com.sun.management.snmp.SnmpStatusException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;

/**
 * The class is used for implementing the "OdlOpenFlowStats" group. The group is
 * defined with the following oid: 1.3.6.1.3.1.1.11.
 */
public class OdlOpenFlowStats implements OdlOpenFlowStatsMBean, Serializable {

    /**
     * Variable for storing the value of "OdlOpenflowFlowstats". The variable is
     * identified by: "1.3.6.1.3.1.1.11.6".
     */
    protected String OdlOpenflowFlowstats = new String("OpenflowFlowstats");

    /**
     * Variable for storing the value of "OdlOpenflowStatus". The variable is
     * identified by: "1.3.6.1.3.1.1.11.5".
     */
    protected String OdlOpenflowStatus = new String("Not Connected");

    /**
     * Variable for storing the value of "OdlOpenflowManufacturer". The variable
     * is identified by: "1.3.6.1.3.1.1.11.4".
     */
    protected String OdlOpenflowManufacturer = new String("OpenflowManufacturer");

    /**
     * Variable for storing the value of "OdlOpenflowMacAddress". The variable
     * is identified by: "1.3.6.1.3.1.1.11.3".
     */
    protected String OdlOpenflowMacAddress = new String("OpenflowMacAddress");

    /**
     * Variable for storing the value of "OdlOpenflowInterface". The variable is
     * identified by: "1.3.6.1.3.1.1.11.2".
     */
    protected String OdlOpenflowInterface = new String("OpenflowInterface");

    /**
     * Variable for storing the value of "OdlOpenflowNode". The variable is
     * identified by: "1.3.6.1.3.1.1.11.1".
     */
    protected String OdlOpenflowNode = new String("openFlowNode");

    /**
     * Variable for storing the value of "OdlOpenflowMeterstats". The variable
     * is identified by: "1.3.6.1.3.1.1.11.7".
     */
    protected String OdlOpenflowMeterstats = new String("OpenflowMeterstats");

    /**
     * Constructor for the "OdlOpenFlowStats" group. If the group contains a
     * table, the entries created through an SNMP SET will not be registered in
     * Java DMK.
     */
    public OdlOpenFlowStats(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlOpenFlowStats" group. If the group contains a
     * table, the entries created through an SNMP SET will be AUTOMATICALLY
     * REGISTERED in Java DMK.
     */
    public OdlOpenFlowStats(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "OdlOpenflowFlowstats" variable.
     */
    public String getOdlOpenflowFlowstats() throws SnmpStatusException {
        return OdlOpenflowFlowstats;
    }

    /**
     * Setter for the "OdlOpenflowFlowstats" variable.
     */
    public void setOdlOpenflowFlowstats(String x) throws SnmpStatusException {
        OdlOpenflowFlowstats = x;
    }

    /**
     * Checker for the "OdlOpenflowFlowstats" variable.
     */
    public void checkOdlOpenflowFlowstats(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowStatus" variable.
     */
    public String getOdlOpenflowStatus() throws SnmpStatusException {
        return OdlOpenflowStatus;
    }

    /**
     * Setter for the "OdlOpenflowStatus" variable.
     */
    public void setOdlOpenflowStatus(String x) throws SnmpStatusException {
        OdlOpenflowStatus = x;
    }

    /**
     * Checker for the "OdlOpenflowStatus" variable.
     */
    public void checkOdlOpenflowStatus(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowManufacturer" variable.
     */
    public String getOdlOpenflowManufacturer() throws SnmpStatusException {
        return OdlOpenflowManufacturer;
    }

    /**
     * Setter for the "OdlOpenflowManufacturer" variable.
     */
    public void setOdlOpenflowManufacturer(String x) throws SnmpStatusException {
        OdlOpenflowManufacturer = x;
    }

    /**
     * Checker for the "OdlOpenflowManufacturer" variable.
     */
    public void checkOdlOpenflowManufacturer(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowMacAddress" variable.
     */
    public String getOdlOpenflowMacAddress() throws SnmpStatusException {
        return OdlOpenflowMacAddress;
    }

    /**
     * Setter for the "OdlOpenflowMacAddress" variable.
     */
    public void setOdlOpenflowMacAddress(String x) throws SnmpStatusException {
        OdlOpenflowMacAddress = x;
    }

    /**
     * Checker for the "OdlOpenflowMacAddress" variable.
     */
    public void checkOdlOpenflowMacAddress(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowInterface" variable.
     */
    public String getOdlOpenflowInterface() throws SnmpStatusException {
        return OdlOpenflowInterface;
    }

    /**
     * Setter for the "OdlOpenflowInterface" variable.
     */
    public void setOdlOpenflowInterface(String x) throws SnmpStatusException {
        OdlOpenflowInterface = x;
    }

    /**
     * Checker for the "OdlOpenflowInterface" variable.
     */
    public void checkOdlOpenflowInterface(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowNode" variable.
     */
    public String getOdlOpenflowNode() throws SnmpStatusException {
        return OdlOpenflowNode;
    }

    /**
     * Setter for the "OdlOpenflowNode" variable.
     */
    public void setOdlOpenflowNode(String x) throws SnmpStatusException {
        OdlOpenflowNode = x;
    }

    /**
     * Checker for the "OdlOpenflowNode" variable.
     */
    public void checkOdlOpenflowNode(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowMeterstats" variable.
     */
    public String getOdlOpenflowMeterstats() throws SnmpStatusException {
        return OdlOpenflowMeterstats;
    }

    /**
     * Setter for the "OdlOpenflowMeterstats" variable.
     */
    public void setOdlOpenflowMeterstats(String x) throws SnmpStatusException {
        OdlOpenflowMeterstats = x;
    }

    /**
     * Checker for the "OdlOpenflowMeterstats" variable.
     */
    public void checkOdlOpenflowMeterstats(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
