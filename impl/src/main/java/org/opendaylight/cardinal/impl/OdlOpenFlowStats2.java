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
import javax.management.MBeanServer;
import com.sun.management.snmp.SnmpString;
import com.sun.management.snmp.SnmpStatusException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;

/**
 * The class is used for implementing the "OdlOpenFlowStats2" group. The group
 * is defined with the following oid: 1.3.6.1.3.1.1.12.
 */
public class OdlOpenFlowStats2 implements OdlOpenFlowStats2MBean, Serializable {

    /**
     * Variable for storing the value of "OdlOpenflowFlowstats2". The variable
     * is identified by: "1.3.6.1.3.1.1.12.6".
     */
    protected String OdlOpenflowFlowstats2 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlOpenflowStatus2". The variable is
     * identified by: "1.3.6.1.3.1.1.12.5".
     */
    protected String OdlOpenflowStatus2 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlOpenflowManufacturer2". The
     * variable is identified by: "1.3.6.1.3.1.1.12.4".
     */
    protected String OdlOpenflowManufacturer2 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlOpenflowMacAddress2". The variable
     * is identified by: "1.3.6.1.3.1.1.12.3".
     */
    protected String OdlOpenflowMacAddress2 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlOpenflowInterface2". The variable
     * is identified by: "1.3.6.1.3.1.1.12.2".
     */
    protected String OdlOpenflowInterface2 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlOpenflowNode2". The variable is
     * identified by: "1.3.6.1.3.1.1.12.1".
     */
    protected String OdlOpenflowNode2 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlOpenflowMeterstats2". The variable
     * is identified by: "1.3.6.1.3.1.1.12.7".
     */
    protected String OdlOpenflowMeterstats2 = new String("JDMK 5.1");

    /**
     * Constructor for the "OdlOpenFlowStats2" group. If the group contains a
     * table, the entries created through an SNMP SET will not be registered in
     * Java DMK.
     */
    public OdlOpenFlowStats2(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlOpenFlowStats2" group. If the group contains a
     * table, the entries created through an SNMP SET will be AUTOMATICALLY
     * REGISTERED in Java DMK.
     */
    public OdlOpenFlowStats2(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "OdlOpenflowFlowstats2" variable.
     */
    public String getOdlOpenflowFlowstats2() throws SnmpStatusException {
        return OdlOpenflowFlowstats2;
    }

    /**
     * Setter for the "OdlOpenflowFlowstats2" variable.
     */
    public void setOdlOpenflowFlowstats2(String x) throws SnmpStatusException {
        OdlOpenflowFlowstats2 = x;
    }

    /**
     * Checker for the "OdlOpenflowFlowstats2" variable.
     */
    public void checkOdlOpenflowFlowstats2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowStatus2" variable.
     */
    public String getOdlOpenflowStatus2() throws SnmpStatusException {
        return OdlOpenflowStatus2;
    }

    /**
     * Setter for the "OdlOpenflowStatus2" variable.
     */
    public void setOdlOpenflowStatus2(String x) throws SnmpStatusException {
        OdlOpenflowStatus2 = x;
    }

    /**
     * Checker for the "OdlOpenflowStatus2" variable.
     */
    public void checkOdlOpenflowStatus2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowManufacturer2" variable.
     */
    public String getOdlOpenflowManufacturer2() throws SnmpStatusException {
        return OdlOpenflowManufacturer2;
    }

    /**
     * Setter for the "OdlOpenflowManufacturer2" variable.
     */
    public void setOdlOpenflowManufacturer2(String x) throws SnmpStatusException {
        OdlOpenflowManufacturer2 = x;
    }

    /**
     * Checker for the "OdlOpenflowManufacturer2" variable.
     */
    public void checkOdlOpenflowManufacturer2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowMacAddress2" variable.
     */
    public String getOdlOpenflowMacAddress2() throws SnmpStatusException {
        return OdlOpenflowMacAddress2;
    }

    /**
     * Setter for the "OdlOpenflowMacAddress2" variable.
     */
    public void setOdlOpenflowMacAddress2(String x) throws SnmpStatusException {
        OdlOpenflowMacAddress2 = x;
    }

    /**
     * Checker for the "OdlOpenflowMacAddress2" variable.
     */
    public void checkOdlOpenflowMacAddress2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowInterface2" variable.
     */
    public String getOdlOpenflowInterface2() throws SnmpStatusException {
        return OdlOpenflowInterface2;
    }

    /**
     * Setter for the "OdlOpenflowInterface2" variable.
     */
    public void setOdlOpenflowInterface2(String x) throws SnmpStatusException {
        OdlOpenflowInterface2 = x;
    }

    /**
     * Checker for the "OdlOpenflowInterface2" variable.
     */
    public void checkOdlOpenflowInterface2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowNode2" variable.
     */
    public String getOdlOpenflowNode2() throws SnmpStatusException {
        return OdlOpenflowNode2;
    }

    /**
     * Setter for the "OdlOpenflowNode2" variable.
     */
    public void setOdlOpenflowNode2(String x) throws SnmpStatusException {
        OdlOpenflowNode2 = x;
    }

    /**
     * Checker for the "OdlOpenflowNode2" variable.
     */
    public void checkOdlOpenflowNode2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlOpenflowMeterstats2" variable.
     */
    public String getOdlOpenflowMeterstats2() throws SnmpStatusException {
        return OdlOpenflowMeterstats2;
    }

    /**
     * Setter for the "OdlOpenflowMeterstats2" variable.
     */
    public void setOdlOpenflowMeterstats2(String x) throws SnmpStatusException {
        OdlOpenflowMeterstats2 = x;
    }

    /**
     * Checker for the "OdlOpenflowMeterstats2" variable.
     */
    public void checkOdlOpenflowMeterstats2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
