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
 * The class is used for implementing the "OdlCardinalBundleActiveModule" group.
 * The group is defined with the following oid: 1.3.6.1.3.1.1.4.
 */
public class OdlCardinalBundleActiveModule implements OdlCardinalBundleActiveModuleMBean, Serializable {

    /**
     * Variable for storing the value of "Activebundle9". The variable is
     * identified by: "1.3.6.1.3.1.1.4.9".
     */
    protected String Activebundle9 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "Activebundle8". The variable is
     * identified by: "1.3.6.1.3.1.1.4.8".
     */
    protected String Activebundle8 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "Activebundle7". The variable is
     * identified by: "1.3.6.1.3.1.1.4.7".
     */
    protected String Activebundle7 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "Activebundle6". The variable is
     * identified by: "1.3.6.1.3.1.1.4.6".
     */
    protected String Activebundle6 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "Activebundle5". The variable is
     * identified by: "1.3.6.1.3.1.1.4.5".
     */
    protected String Activebundle5 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "Activebundle4". The variable is
     * identified by: "1.3.6.1.3.1.1.4.4".
     */
    protected String Activebundle4 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "Activebundle3". The variable is
     * identified by: "1.3.6.1.3.1.1.4.3".
     */
    protected String Activebundle3 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "Activebundle2". The variable is
     * identified by: "1.3.6.1.3.1.1.4.2".
     */
    protected String Activebundle2 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "Activebundle10". The variable is
     * identified by: "1.3.6.1.3.1.1.4.10".
     */
    protected String Activebundle10 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "Activebundle1". The variable is
     * identified by: "1.3.6.1.3.1.1.4.1".
     */
    protected String Activebundle1 = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "OdKarafBundleListActive". The variable
     * is identified by: "1.3.6.1.3.1.1.4.0".
     */
    protected String OdKarafBundleListActive = new String("JDMK 5.1");

    /**
     * Constructor for the "OdlCardinalBundleActiveModule" group. If the group
     * contains a table, the entries created through an SNMP SET will not be
     * registered in Java DMK.
     */
    public OdlCardinalBundleActiveModule(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlCardinalBundleActiveModule" group. If the group
     * contains a table, the entries created through an SNMP SET will be
     * AUTOMATICALLY REGISTERED in Java DMK.
     */
    public OdlCardinalBundleActiveModule(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "Activebundle9" variable.
     */
    public String getActivebundle9() throws SnmpStatusException {
        return Activebundle9;
    }

    /**
     * Setter for the "Activebundle9" variable.
     */
    public void setActivebundle9(String x) throws SnmpStatusException {
        Activebundle9 = x;
    }

    /**
     * Checker for the "Activebundle9" variable.
     */
    public void checkActivebundle9(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "Activebundle8" variable.
     */
    public String getActivebundle8() throws SnmpStatusException {
        return Activebundle8;
    }

    /**
     * Setter for the "Activebundle8" variable.
     */
    public void setActivebundle8(String x) throws SnmpStatusException {
        Activebundle8 = x;
    }

    /**
     * Checker for the "Activebundle8" variable.
     */
    public void checkActivebundle8(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "Activebundle7" variable.
     */
    public String getActivebundle7() throws SnmpStatusException {
        return Activebundle7;
    }

    /**
     * Setter for the "Activebundle7" variable.
     */
    public void setActivebundle7(String x) throws SnmpStatusException {
        Activebundle7 = x;
    }

    /**
     * Checker for the "Activebundle7" variable.
     */
    public void checkActivebundle7(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "Activebundle6" variable.
     */
    public String getActivebundle6() throws SnmpStatusException {
        return Activebundle6;
    }

    /**
     * Setter for the "Activebundle6" variable.
     */
    public void setActivebundle6(String x) throws SnmpStatusException {
        Activebundle6 = x;
    }

    /**
     * Checker for the "Activebundle6" variable.
     */
    public void checkActivebundle6(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "Activebundle5" variable.
     */
    public String getActivebundle5() throws SnmpStatusException {
        return Activebundle5;
    }

    /**
     * Setter for the "Activebundle5" variable.
     */
    public void setActivebundle5(String x) throws SnmpStatusException {
        Activebundle5 = x;
    }

    /**
     * Checker for the "Activebundle5" variable.
     */
    public void checkActivebundle5(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "Activebundle4" variable.
     */
    public String getActivebundle4() throws SnmpStatusException {
        return Activebundle4;
    }

    /**
     * Setter for the "Activebundle4" variable.
     */
    public void setActivebundle4(String x) throws SnmpStatusException {
        Activebundle4 = x;
    }

    /**
     * Checker for the "Activebundle4" variable.
     */
    public void checkActivebundle4(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "Activebundle3" variable.
     */
    public String getActivebundle3() throws SnmpStatusException {
        return Activebundle3;
    }

    /**
     * Setter for the "Activebundle3" variable.
     */
    public void setActivebundle3(String x) throws SnmpStatusException {
        Activebundle3 = x;
    }

    /**
     * Checker for the "Activebundle3" variable.
     */
    public void checkActivebundle3(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "Activebundle2" variable.
     */
    public String getActivebundle2() throws SnmpStatusException {
        return Activebundle2;
    }

    /**
     * Setter for the "Activebundle2" variable.
     */
    public void setActivebundle2(String x) throws SnmpStatusException {
        Activebundle2 = x;
    }

    /**
     * Checker for the "Activebundle2" variable.
     */
    public void checkActivebundle2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "Activebundle10" variable.
     */
    public String getActivebundle10() throws SnmpStatusException {
        return Activebundle10;
    }

    /**
     * Setter for the "Activebundle10" variable.
     */
    public void setActivebundle10(String x) throws SnmpStatusException {
        Activebundle10 = x;
    }

    /**
     * Checker for the "Activebundle10" variable.
     */
    public void checkActivebundle10(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "Activebundle1" variable.
     */
    public String getActivebundle1() throws SnmpStatusException {
        return Activebundle1;
    }

    /**
     * Setter for the "Activebundle1" variable.
     */
    public void setActivebundle1(String x) throws SnmpStatusException {
        Activebundle1 = x;
    }

    /**
     * Checker for the "Activebundle1" variable.
     */
    public void checkActivebundle1(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdKarafBundleListActive" variable.
     */
    public String getOdKarafBundleListActive() throws SnmpStatusException {
        return OdKarafBundleListActive;
    }

    /**
     * Setter for the "OdKarafBundleListActive" variable.
     */
    public void setOdKarafBundleListActive(String x) throws SnmpStatusException {
        OdKarafBundleListActive = x;
    }

    /**
     * Checker for the "OdKarafBundleListActive" variable.
     */
    public void checkOdKarafBundleListActive(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
