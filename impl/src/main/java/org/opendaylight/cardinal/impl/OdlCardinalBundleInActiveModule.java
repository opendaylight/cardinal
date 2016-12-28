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
 * The class is used for implementing the "OdlCardinalBundleInActiveModule"
 * group. The group is defined with the following oid: 1.3.6.1.3.1.1.5.
 */
public class OdlCardinalBundleInActiveModule implements OdlCardinalBundleInActiveModuleMBean, Serializable {

    /**
     * Variable for storing the value of "InstalledBundle5". The variable is
     * identified by: "1.3.6.1.3.1.1.5.5".
     */
    protected String InstalledBundle5 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "InstalledBundle4". The variable is
     * identified by: "1.3.6.1.3.1.1.5.4".
     */
    protected String InstalledBundle4 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "InstalledBundle3". The variable is
     * identified by: "1.3.6.1.3.1.1.5.3".
     */
    protected String InstalledBundle3 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "InstalledBundle2". The variable is
     * identified by: "1.3.6.1.3.1.1.5.2".
     */
    protected String InstalledBundle2 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "InstalledBundle1". The variable is
     * identified by: "1.3.6.1.3.1.1.5.1".
     */
    protected String InstalledBundle1 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlKarafBundleListInstalled". The
     * variable is identified by: "1.3.6.1.3.1.1.5.0".
     */
    protected String OdlKarafBundleListInstalled = new String("JDMK 5.1");

    /**
     * Constructor for the "OdlCardinalBundleInActiveModule" group. If the group
     * contains a table, the entries created through an SNMP SET will not be
     * registered in Java DMK.
     */
    public OdlCardinalBundleInActiveModule(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlCardinalBundleInActiveModule" group. If the group
     * contains a table, the entries created through an SNMP SET will be
     * AUTOMATICALLY REGISTERED in Java DMK.
     */
    public OdlCardinalBundleInActiveModule(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "InstalledBundle5" variable.
     */
    public String getInstalledBundle5() throws SnmpStatusException {
        return InstalledBundle5;
    }

    /**
     * Setter for the "InstalledBundle5" variable.
     */
    public void setInstalledBundle5(String x) throws SnmpStatusException {
        InstalledBundle5 = x;
    }

    /**
     * Checker for the "InstalledBundle5" variable.
     */
    public void checkInstalledBundle5(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "InstalledBundle4" variable.
     */
    public String getInstalledBundle4() throws SnmpStatusException {
        return InstalledBundle4;
    }

    /**
     * Setter for the "InstalledBundle4" variable.
     */
    public void setInstalledBundle4(String x) throws SnmpStatusException {
        InstalledBundle4 = x;
    }

    /**
     * Checker for the "InstalledBundle4" variable.
     */
    public void checkInstalledBundle4(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "InstalledBundle3" variable.
     */
    public String getInstalledBundle3() throws SnmpStatusException {
        return InstalledBundle3;
    }

    /**
     * Setter for the "InstalledBundle3" variable.
     */
    public void setInstalledBundle3(String x) throws SnmpStatusException {
        InstalledBundle3 = x;
    }

    /**
     * Checker for the "InstalledBundle3" variable.
     */
    public void checkInstalledBundle3(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "InstalledBundle2" variable.
     */
    public String getInstalledBundle2() throws SnmpStatusException {
        return InstalledBundle2;
    }

    /**
     * Setter for the "InstalledBundle2" variable.
     */
    public void setInstalledBundle2(String x) throws SnmpStatusException {
        InstalledBundle2 = x;
    }

    /**
     * Checker for the "InstalledBundle2" variable.
     */
    public void checkInstalledBundle2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "InstalledBundle1" variable.
     */
    public String getInstalledBundle1() throws SnmpStatusException {
        return InstalledBundle1;
    }

    /**
     * Setter for the "InstalledBundle1" variable.
     */
    public void setInstalledBundle1(String x) throws SnmpStatusException {
        InstalledBundle1 = x;
    }

    /**
     * Checker for the "InstalledBundle1" variable.
     */
    public void checkInstalledBundle1(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlKarafBundleListInstalled" variable.
     */
    public String getOdlKarafBundleListInstalled() throws SnmpStatusException {
        return OdlKarafBundleListInstalled;
    }

    /**
     * Setter for the "OdlKarafBundleListInstalled" variable.
     */
    public void setOdlKarafBundleListInstalled(String x) throws SnmpStatusException {
        OdlKarafBundleListInstalled = x;
    }

    /**
     * Checker for the "OdlKarafBundleListInstalled" variable.
     */
    public void checkOdlKarafBundleListInstalled(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
