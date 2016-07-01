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
 * The class is used for implementing the "OdlCardinalFeatureInstallModule"
 * group. The group is defined with the following oid: 1.3.6.1.3.1.1.2.
 */
public class OdlCardinalFeatureInstallModule implements OdlCardinalFeatureInstallModuleMBean, Serializable {

    /**
     * Variable for storing the value of "FeatureInstalled9". The variable is
     * identified by: "1.3.6.1.3.1.1.2.9".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled9 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "FeatureInstalled8". The variable is
     * identified by: "1.3.6.1.3.1.1.2.8".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled8 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "FeatureInstalled7". The variable is
     * identified by: "1.3.6.1.3.1.1.2.7".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled7 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "FeatureInstalled6". The variable is
     * identified by: "1.3.6.1.3.1.1.2.6".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled6 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "FeatureInstalled5". The variable is
     * identified by: "1.3.6.1.3.1.1.2.5".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled5 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "FeatureInstalled4". The variable is
     * identified by: "1.3.6.1.3.1.1.2.4".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled4 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "FeatureInstalled3". The variable is
     * identified by: "1.3.6.1.3.1.1.2.3".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled3 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "FeatureInstalled2". The variable is
     * identified by: "1.3.6.1.3.1.1.2.2".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled2 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "FeatureInstalled1". The variable is
     * identified by: "1.3.6.1.3.1.1.2.1".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled1 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "FeatureInstalled10". The variable is
     * identified by: "1.3.6.1.3.1.1.2.10".
     *
     * "To be done"
     *
     */
    protected String FeatureInstalled10 = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlKarafFeatureListInstalled". The
     * variable is identified by: "1.3.6.1.3.1.1.2.0".
     *
     * "To be done"
     *
     */
    protected String OdlKarafFeatureListInstalled = new String("Opendaylight Node Information");

    /**
     * Constructor for the "OdlCardinalFeatureInstallModule" group. If the group
     * contains a table, the entries created through an SNMP SET will not be
     * registered in Java DMK.
     */
    public OdlCardinalFeatureInstallModule(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlCardinalFeatureInstallModule" group. If the group
     * contains a table, the entries created through an SNMP SET will be
     * AUTOMATICALLY REGISTERED in Java DMK.
     */
    public OdlCardinalFeatureInstallModule(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "FeatureInstalled9" variable.
     */
    public String getFeatureInstalled9() throws SnmpStatusException {
        return FeatureInstalled9;
    }

    /**
     * Setter for the "FeatureInstalled9" variable.
     */
    public void setFeatureInstalled9(String x) throws SnmpStatusException {
        FeatureInstalled9 = x;
    }

    /**
     * Checker for the "FeatureInstalled9" variable.
     */
    public void checkFeatureInstalled9(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "FeatureInstalled8" variable.
     */
    public String getFeatureInstalled8() throws SnmpStatusException {
        return FeatureInstalled8;
    }

    /**
     * Setter for the "FeatureInstalled8" variable.
     */
    public void setFeatureInstalled8(String x) throws SnmpStatusException {
        FeatureInstalled8 = x;
    }

    /**
     * Checker for the "FeatureInstalled8" variable.
     */
    public void checkFeatureInstalled8(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "FeatureInstalled7" variable.
     */
    public String getFeatureInstalled7() throws SnmpStatusException {
        return FeatureInstalled7;
    }

    /**
     * Setter for the "FeatureInstalled7" variable.
     */
    public void setFeatureInstalled7(String x) throws SnmpStatusException {
        FeatureInstalled7 = x;
    }

    /**
     * Checker for the "FeatureInstalled7" variable.
     */
    public void checkFeatureInstalled7(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "FeatureInstalled6" variable.
     */
    public String getFeatureInstalled6() throws SnmpStatusException {
        return FeatureInstalled6;
    }

    /**
     * Setter for the "FeatureInstalled6" variable.
     */
    public void setFeatureInstalled6(String x) throws SnmpStatusException {
        FeatureInstalled6 = x;
    }

    /**
     * Checker for the "FeatureInstalled6" variable.
     */
    public void checkFeatureInstalled6(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "FeatureInstalled5" variable.
     */
    public String getFeatureInstalled5() throws SnmpStatusException {
        return FeatureInstalled5;
    }

    /**
     * Setter for the "FeatureInstalled5" variable.
     */
    public void setFeatureInstalled5(String x) throws SnmpStatusException {
        FeatureInstalled5 = x;
    }

    /**
     * Checker for the "FeatureInstalled5" variable.
     */
    public void checkFeatureInstalled5(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "FeatureInstalled4" variable.
     */
    public String getFeatureInstalled4() throws SnmpStatusException {
        return FeatureInstalled4;
    }

    /**
     * Setter for the "FeatureInstalled4" variable.
     */
    public void setFeatureInstalled4(String x) throws SnmpStatusException {
        FeatureInstalled4 = x;
    }

    /**
     * Checker for the "FeatureInstalled4" variable.
     */
    public void checkFeatureInstalled4(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "FeatureInstalled3" variable.
     */
    public String getFeatureInstalled3() throws SnmpStatusException {
        return FeatureInstalled3;
    }

    /**
     * Setter for the "FeatureInstalled3" variable.
     */
    public void setFeatureInstalled3(String x) throws SnmpStatusException {
        FeatureInstalled3 = x;
    }

    /**
     * Checker for the "FeatureInstalled3" variable.
     */
    public void checkFeatureInstalled3(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "FeatureInstalled2" variable.
     */
    public String getFeatureInstalled2() throws SnmpStatusException {
        return FeatureInstalled2;
    }

    /**
     * Setter for the "FeatureInstalled2" variable.
     */
    public void setFeatureInstalled2(String x) throws SnmpStatusException {
        FeatureInstalled2 = x;
    }

    /**
     * Checker for the "FeatureInstalled2" variable.
     */
    public void checkFeatureInstalled2(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "FeatureInstalled1" variable.
     */
    public String getFeatureInstalled1() throws SnmpStatusException {
        return FeatureInstalled1;
    }

    /**
     * Setter for the "FeatureInstalled1" variable.
     */
    public void setFeatureInstalled1(String x) throws SnmpStatusException {
        FeatureInstalled1 = x;
    }

    /**
     * Checker for the "FeatureInstalled1" variable.
     */
    public void checkFeatureInstalled1(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "FeatureInstalled10" variable.
     */
    public String getFeatureInstalled10() throws SnmpStatusException {
        return FeatureInstalled10;
    }

    /**
     * Setter for the "FeatureInstalled10" variable.
     */
    public void setFeatureInstalled10(String x) throws SnmpStatusException {
        FeatureInstalled10 = x;
    }

    /**
     * Checker for the "FeatureInstalled10" variable.
     */
    public void checkFeatureInstalled10(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlKarafFeatureListInstalled" variable.
     */
    public String getOdlKarafFeatureListInstalled() throws SnmpStatusException {
        return OdlKarafFeatureListInstalled;
    }

    /**
     * Setter for the "OdlKarafFeatureListInstalled" variable.
     */
    public void setOdlKarafFeatureListInstalled(String x) throws SnmpStatusException {
        OdlKarafFeatureListInstalled = x;
    }

    /**
     * Checker for the "OdlKarafFeatureListInstalled" variable.
     */
    public void checkOdlKarafFeatureListInstalled(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
