/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

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
 * The class is used for implementing the "OdlCardinalMainModule" group. The
 * group is defined with the following oid: 1.3.6.1.3.1.1.1.
 */
public class OdlCardinalMainModule implements OdlCardinalMainModuleMBean, Serializable {

    /**
     * Variable for storing the value of "OdlSystemOdlNodeInfo". The variable is
     * identified by: "1.3.6.1.3.1.1.1.6".
     *
     * "To be done"
     *
     */
    protected String OdlSystemOdlNodeInfo = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlSystemOdlUptime". The variable is
     * identified by: "1.3.6.1.3.1.1.1.5".
     *
     * "Uptime of the Odl"
     *
     */
    protected String OdlSystemOdlUptime = new String("Uptime of the odl");

    /**
     * Variable for storing the value of "OdlSystemSysInfo". The variable is
     * identified by: "1.3.6.1.3.1.1.1.4".
     *
     * "System Information"
     *
     */
    protected String OdlSystemSysInfo = new String("System Information");

    /**
     * Variable for storing the value of "OdlSystemHostAddress". The variable is
     * identified by: "1.3.6.1.3.1.1.1.3".
     *
     * "System Host Address"
     *
     */
    protected String OdlSystemHostAddress = new String("Address of the Host should come up");

    /**
     * Variable for storing the value of "OdlSystemHostAddressTrap". The
     * variable is identified by: "1.3.6.1.3.1.1.1.36".
     *
     * "A simple string object, to act as an optional payload for the
     * netSnmpExampleHeartbeatNotification. This varbind is not part of the
     * notification definition, so is optional and need not be included in the
     * notification payload. The value has no real meaning, but the romantically
     * inclined may take it to be the object of the sender's affection, and
     * hence the cause of the heart beating faster."
     *
     */
    protected String OdlSystemHostAddressTrap = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlSystemMemUsage". The variable is
     * identified by: "1.3.6.1.3.1.1.1.2".
     *
     * "The address of then given host."
     *
     */
    protected Integer OdlSystemMemUsage = new Integer(2);

    /**
     * Variable for storing the value of "OdlMDSALGBPResolvedpolicies". The
     * variable is identified by: "1.3.6.1.3.1.1.1.11".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALGBPResolvedpolicies = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlSystemCpuUsage". The variable is
     * identified by: "1.3.6.1.3.1.1.1.1".
     *
     * "Description regarding cpu usage"
     *
     */
    protected Integer OdlSystemCpuUsage = new Integer(1);

    /**
     * Constructor for the "OdlCardinalMainModule" group. If the group contains
     * a table, the entries created through an SNMP SET will not be registered
     * in Java DMK.
     */
    public OdlCardinalMainModule(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlCardinalMainModule" group. If the group contains
     * a table, the entries created through an SNMP SET will be AUTOMATICALLY
     * REGISTERED in Java DMK.
     */
    public OdlCardinalMainModule(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "OdlSystemOdlNodeInfo" variable.
     */
    public String getOdlSystemOdlNodeInfo() throws SnmpStatusException {
        return OdlSystemOdlNodeInfo;
    }

    /**
     * Setter for the "OdlSystemOdlNodeInfo" variable.
     */
    public void setOdlSystemOdlNodeInfo(String x) throws SnmpStatusException {
        OdlSystemOdlNodeInfo = x;
    }

    /**
     * Checker for the "OdlSystemOdlNodeInfo" variable.
     */
    public void checkOdlSystemOdlNodeInfo(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlSystemOdlUptime" variable.
     */
    public String getOdlSystemOdlUptime() throws SnmpStatusException {
        return OdlSystemOdlUptime;
    }

    /**
     * Setter for the "OdlSystemOdlUptime" variable.
     */
    public void setOdlSystemOdlUptime(String x) throws SnmpStatusException {
        OdlSystemOdlUptime = x;
    }

    /**
     * Checker for the "OdlSystemOdlUptime" variable.
     */
    public void checkOdlSystemOdlUptime(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlSystemSysInfo" variable.
     */
    public String getOdlSystemSysInfo() throws SnmpStatusException {
        return OdlSystemSysInfo;
    }

    /**
     * Setter for the "OdlSystemSysInfo" variable.
     */
    public void setOdlSystemSysInfo(String x) throws SnmpStatusException {
        OdlSystemSysInfo = x;
    }

    /**
     * Checker for the "OdlSystemSysInfo" variable.
     */
    public void checkOdlSystemSysInfo(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlSystemHostAddress" variable.
     */
    public String getOdlSystemHostAddress() throws SnmpStatusException {
        return OdlSystemHostAddress;
    }

    /**
     * Setter for the "OdlSystemHostAddress" variable.
     */
    public void setOdlSystemHostAddress(String x) throws SnmpStatusException {
        OdlSystemHostAddress = x;
    }

    /**
     * Checker for the "OdlSystemHostAddress" variable.
     */
    public void checkOdlSystemHostAddress(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlSystemHostAddressTrap" variable.
     */
    public String getOdlSystemHostAddressTrap() throws SnmpStatusException {
        return OdlSystemHostAddressTrap;
    }

    /**
     * Getter for the "OdlSystemMemUsage" variable.
     */
    public Integer getOdlSystemMemUsage() throws SnmpStatusException {
        return OdlSystemMemUsage;
    }

    /**
     * Setter for the "OdlSystemMemUsage" variable.
     */
    public void setOdlSystemMemUsage(Integer x) throws SnmpStatusException {
        OdlSystemMemUsage = x;
    }

    /**
     * Checker for the "OdlSystemMemUsage" variable.
     */
    public void checkOdlSystemMemUsage(Integer x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALGBPResolvedpolicies" variable.
     */
    public String getOdlMDSALGBPResolvedpolicies() throws SnmpStatusException {
        return OdlMDSALGBPResolvedpolicies;
    }

    /**
     * Setter for the "OdlMDSALGBPResolvedpolicies" variable.
     */
    public void setOdlMDSALGBPResolvedpolicies(String x) throws SnmpStatusException {
        OdlMDSALGBPResolvedpolicies = x;
    }

    /**
     * Checker for the "OdlMDSALGBPResolvedpolicies" variable.
     */
    public void checkOdlMDSALGBPResolvedpolicies(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlSystemCpuUsage" variable.
     */
    public Integer getOdlSystemCpuUsage() throws SnmpStatusException {
        return OdlSystemCpuUsage;
    }

    /**
     * Setter for the "OdlSystemCpuUsage" variable.
     */
    public void setOdlSystemCpuUsage(Integer x) throws SnmpStatusException {
        OdlSystemCpuUsage = x;
    }

    /**
     * Checker for the "OdlSystemCpuUsage" variable.
     */
    public void checkOdlSystemCpuUsage(Integer x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
