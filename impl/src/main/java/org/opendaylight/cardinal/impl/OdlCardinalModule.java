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
 * The class is used for implementing the "OdlCardinalModule" group. The group
 * is defined with the following oid: 1.3.6.1.3.1.1.1.
 */
public class OdlCardinalModule implements OdlCardinalModuleMBean, Serializable {

    /**
     * Variable for storing the value of "OdlSystemOdlNodeInfo". The variable is
     * identified by: "1.3.6.1.3.1.1.1.6".
     *
     * "To be done"
     *
     */
    protected Byte[] OdlSystemOdlNodeInfo = { new Byte("79"), new Byte("112"), new Byte("101"), new Byte("110"),
            new Byte("100"), new Byte("97"), new Byte("121"), new Byte("108"), new Byte("105"), new Byte("103"),
            new Byte("104"), new Byte("116"), new Byte("32"), new Byte("78"), new Byte("111"), new Byte("100"),
            new Byte("101"), new Byte("32"), new Byte("73"), new Byte("110"), new Byte("102"), new Byte("111"),
            new Byte("114"), new Byte("109"), new Byte("97"), new Byte("116"), new Byte("105"), new Byte("111"),
            new Byte("110") };

    /**
     * Variable for storing the value of "OdlSystemOdlUptime". The variable is
     * identified by: "1.3.6.1.3.1.1.1.5".
     *
     * "Uptime of the Odl"
     *
     */
    protected Byte[] OdlSystemOdlUptime = { new Byte("85"), new Byte("112"), new Byte("116"), new Byte("105"),
            new Byte("109"), new Byte("101"), new Byte("32"), new Byte("111"), new Byte("102"), new Byte("32"),
            new Byte("116"), new Byte("104"), new Byte("101"), new Byte("32"), new Byte("111"), new Byte("100"),
            new Byte("108") };

    /**
     * Variable for storing the value of "OdlSystemSysInfo". The variable is
     * identified by: "1.3.6.1.3.1.1.1.4".
     *
     * "System Information"
     *
     */
    protected Byte[] OdlSystemSysInfo = { new Byte("83"), new Byte("121"), new Byte("115"), new Byte("116"),
            new Byte("101"), new Byte("109"), new Byte("32"), new Byte("73"), new Byte("110"), new Byte("102"),
            new Byte("111"), new Byte("114"), new Byte("109"), new Byte("97"), new Byte("116"), new Byte("105"),
            new Byte("111"), new Byte("110") };

    /**
     * Variable for storing the value of "OdlSystemHostAddress". The variable is
     * identified by: "1.3.6.1.3.1.1.1.3".
     *
     * "System Host Address"
     *
     */
    protected Byte[] OdlSystemHostAddress = { new Byte("65"), new Byte("100"), new Byte("100"), new Byte("114"),
            new Byte("101"), new Byte("115"), new Byte("115"), new Byte("32"), new Byte("111"), new Byte("102"),
            new Byte("32"), new Byte("116"), new Byte("104"), new Byte("101"), new Byte("32"), new Byte("72"),
            new Byte("111"), new Byte("115"), new Byte("116"), new Byte("32"), new Byte("115"), new Byte("104"),
            new Byte("111"), new Byte("117"), new Byte("108"), new Byte("100"), new Byte("32"), new Byte("99"),
            new Byte("111"), new Byte("109"), new Byte("101"), new Byte("32"), new Byte("117"), new Byte("112") };

    /**
     * Variable for storing the value of "OdlSystemMemUsage". The variable is
     * identified by: "1.3.6.1.3.1.1.1.2".
     *
     * "The address of then given host."
     *
     */
    protected Integer OdlSystemMemUsage = new Integer(2);

    /**
     * Variable for storing the value of "OdlSystemCpuUsage". The variable is
     * identified by: "1.3.6.1.3.1.1.1.1".
     *
     * "Description regarding cpu usage"
     *
     */
    protected Integer OdlSystemCpuUsage = new Integer(1);

    /**
     * Constructor for the "OdlCardinalModule" group. If the group contains a
     * table, the entries created through an SNMP SET will not be registered in
     * Java DMK.
     */
    public OdlCardinalModule(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlCardinalModule" group. If the group contains a
     * table, the entries created through an SNMP SET will be AUTOMATICALLY
     * REGISTERED in Java DMK.
     */
    public OdlCardinalModule(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "OdlSystemOdlNodeInfo" variable.
     */
    public Byte[] getOdlSystemOdlNodeInfo() throws SnmpStatusException {
        return OdlSystemOdlNodeInfo;
    }

    /**
     * Setter for the "OdlSystemOdlNodeInfo" variable.
     */
    public void setOdlSystemOdlNodeInfo(Byte[] x) throws SnmpStatusException {
        OdlSystemOdlNodeInfo = x;
    }

    /**
     * Checker for the "OdlSystemOdlNodeInfo" variable.
     */
    public void checkOdlSystemOdlNodeInfo(Byte[] x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlSystemOdlUptime" variable.
     */
    public Byte[] getOdlSystemOdlUptime() throws SnmpStatusException {
        return OdlSystemOdlUptime;
    }

    /**
     * Setter for the "OdlSystemOdlUptime" variable.
     */
    public void setOdlSystemOdlUptime(Byte[] x) throws SnmpStatusException {
        OdlSystemOdlUptime = x;
    }

    /**
     * Checker for the "OdlSystemOdlUptime" variable.
     */
    public void checkOdlSystemOdlUptime(Byte[] x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlSystemSysInfo" variable.
     */
    public Byte[] getOdlSystemSysInfo() throws SnmpStatusException {
        return OdlSystemSysInfo;
    }

    /**
     * Setter for the "OdlSystemSysInfo" variable.
     */
    public void setOdlSystemSysInfo(Byte[] x) throws SnmpStatusException {
        OdlSystemSysInfo = x;
    }

    /**
     * Checker for the "OdlSystemSysInfo" variable.
     */
    public void checkOdlSystemSysInfo(Byte[] x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlSystemHostAddress" variable.
     */
    public Byte[] getOdlSystemHostAddress() throws SnmpStatusException {
        return OdlSystemHostAddress;
    }

    /**
     * Setter for the "OdlSystemHostAddress" variable.
     */
    public void setOdlSystemHostAddress(Byte[] x) throws SnmpStatusException {
        OdlSystemHostAddress = x;
    }

    /**
     * Checker for the "OdlSystemHostAddress" variable.
     */
    public void checkOdlSystemHostAddress(Byte[] x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
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
