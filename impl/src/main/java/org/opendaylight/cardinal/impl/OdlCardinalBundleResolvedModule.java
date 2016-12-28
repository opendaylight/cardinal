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
 * The class is used for implementing the "OdlCardinalBundleResolvedModule"
 * group. The group is defined with the following oid: 1.3.6.1.3.1.1.6.
 */
public class OdlCardinalBundleResolvedModule implements OdlCardinalBundleResolvedModuleMBean, Serializable {

    /**
     * Variable for storing the value of "ResolvedBundle5". The variable is
     * identified by: "1.3.6.1.3.1.1.6.5".
     */
    protected String ResolvedBundle5 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "ResolvedBundle4". The variable is
     * identified by: "1.3.6.1.3.1.1.6.4".
     */
    protected String ResolvedBundle4 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "ResolvedBundle3". The variable is
     * identified by: "1.3.6.1.3.1.1.6.3".
     */
    protected String ResolvedBundle3 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "ResolvedBundle2". The variable is
     * identified by: "1.3.6.1.3.1.1.6.2".
     */
    protected String ResolvedBundle2 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "ResolvedBundle1". The variable is
     * identified by: "1.3.6.1.3.1.1.6.1".
     */
    protected String ResolvedBundle1 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdlKarafBundleListResolved". The
     * variable is identified by: "1.3.6.1.3.1.1.6.0".
     */
    protected String OdlKarafBundleListResolved = new String("JDMK 5.1");

    /**
     * Constructor for the "OdlCardinalBundleResolvedModule" group. If the group
     * contains a table, the entries created through an SNMP SET will not be
     * registered in Java DMK.
     */
    public OdlCardinalBundleResolvedModule(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlCardinalBundleResolvedModule" group. If the group
     * contains a table, the entries created through an SNMP SET will be
     * AUTOMATICALLY REGISTERED in Java DMK.
     */
    public OdlCardinalBundleResolvedModule(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "ResolvedBundle5" variable.
     */
    public String getResolvedBundle5() throws SnmpStatusException {
        return ResolvedBundle5;
    }

    /**
     * Setter for the "ResolvedBundle5" variable.
     */
    public void setResolvedBundle5(String x) throws SnmpStatusException {
        ResolvedBundle5 = x;
    }

    /**
     * Checker for the "ResolvedBundle5" variable.
     */
    public void checkResolvedBundle5(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "ResolvedBundle4" variable.
     */
    public String getResolvedBundle4() throws SnmpStatusException {
        return ResolvedBundle4;
    }

    /**
     * Setter for the "ResolvedBundle4" variable.
     */
    public void setResolvedBundle4(String x) throws SnmpStatusException {
        ResolvedBundle4 = x;
    }

    /**
     * Checker for the "ResolvedBundle4" variable.
     */
    public void checkResolvedBundle4(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "ResolvedBundle3" variable.
     */
    public String getResolvedBundle3() throws SnmpStatusException {
        return ResolvedBundle3;
    }

    /**
     * Setter for the "ResolvedBundle3" variable.
     */
    public void setResolvedBundle3(String x) throws SnmpStatusException {
        ResolvedBundle3 = x;
    }

    /**
     * Checker for the "ResolvedBundle3" variable.
     */
    public void checkResolvedBundle3(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "ResolvedBundle2" variable.
     */
    public String getResolvedBundle2() throws SnmpStatusException {
        return ResolvedBundle2;
    }

    /**
     * Setter for the "ResolvedBundle2" variable.
     */
    public void setResolvedBundle2(String x) throws SnmpStatusException {
        ResolvedBundle2 = x;
    }

    /**
     * Checker for the "ResolvedBundle2" variable.
     */
    public void checkResolvedBundle2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "ResolvedBundle1" variable.
     */
    public String getResolvedBundle1() throws SnmpStatusException {
        return ResolvedBundle1;
    }

    /**
     * Setter for the "ResolvedBundle1" variable.
     */
    public void setResolvedBundle1(String x) throws SnmpStatusException {
        ResolvedBundle1 = x;
    }

    /**
     * Checker for the "ResolvedBundle1" variable.
     */
    public void checkResolvedBundle1(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlKarafBundleListResolved" variable.
     */
    public String getOdlKarafBundleListResolved() throws SnmpStatusException {
        return OdlKarafBundleListResolved;
    }

    /**
     * Setter for the "OdlKarafBundleListResolved" variable.
     */
    public void setOdlKarafBundleListResolved(String x) throws SnmpStatusException {
        OdlKarafBundleListResolved = x;
    }

    /**
     * Checker for the "OdlKarafBundleListResolved" variable.
     */
    public void checkOdlKarafBundleListResolved(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
