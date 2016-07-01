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
 * The class is used for implementing the "OdlCardinalKarafShellModule" group.
 * The group is defined with the following oid: 1.3.6.1.3.1.1.7.
 */
public class OdlCardinalKarafShellModule implements OdlCardinalKarafShellModuleMBean, Serializable {

    /**
     * Variable for storing the value of "OdlKarafMaxHeapSize". The variable is
     * identified by: "1.3.6.1.3.1.1.7.4".
     *
     * "To be done"
     *
     */
    protected String OdlKarafMaxHeapSize = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlKarafCurrentHeapSize". The variable
     * is identified by: "1.3.6.1.3.1.1.7.3".
     *
     * "To be done"
     *
     */
    protected String OdlKarafCurrentHeapSize = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlKarafPeakThreads". The variable is
     * identified by: "1.3.6.1.3.1.1.7.2".
     *
     * "To be done"
     *
     */
    protected String OdlKarafPeakThreads = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlKarafDaemonThreads". The variable
     * is identified by: "1.3.6.1.3.1.1.7.1".
     *
     * "To be done"
     *
     */
    protected String OdlKarafDaemonThreads = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlKarafLiveThreads". The variable is
     * identified by: "1.3.6.1.3.1.1.7.0".
     *
     * "To be done"
     *
     */
    protected String OdlKarafLiveThreads = new String("Opendaylight Node Information");

    /**
     * Constructor for the "OdlCardinalKarafShellModule" group. If the group
     * contains a table, the entries created through an SNMP SET will not be
     * registered in Java DMK.
     */
    public OdlCardinalKarafShellModule(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlCardinalKarafShellModule" group. If the group
     * contains a table, the entries created through an SNMP SET will be
     * AUTOMATICALLY REGISTERED in Java DMK.
     */
    public OdlCardinalKarafShellModule(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "OdlKarafMaxHeapSize" variable.
     */
    public String getOdlKarafMaxHeapSize() throws SnmpStatusException {
        return OdlKarafMaxHeapSize;
    }

    /**
     * Setter for the "OdlKarafMaxHeapSize" variable.
     */
    public void setOdlKarafMaxHeapSize(String x) throws SnmpStatusException {
        OdlKarafMaxHeapSize = x;
    }

    /**
     * Checker for the "OdlKarafMaxHeapSize" variable.
     */
    public void checkOdlKarafMaxHeapSize(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlKarafCurrentHeapSize" variable.
     */
    public String getOdlKarafCurrentHeapSize() throws SnmpStatusException {
        return OdlKarafCurrentHeapSize;
    }

    /**
     * Setter for the "OdlKarafCurrentHeapSize" variable.
     */
    public void setOdlKarafCurrentHeapSize(String x) throws SnmpStatusException {
        OdlKarafCurrentHeapSize = x;
    }

    /**
     * Checker for the "OdlKarafCurrentHeapSize" variable.
     */
    public void checkOdlKarafCurrentHeapSize(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlKarafPeakThreads" variable.
     */
    public String getOdlKarafPeakThreads() throws SnmpStatusException {
        return OdlKarafPeakThreads;
    }

    /**
     * Setter for the "OdlKarafPeakThreads" variable.
     */
    public void setOdlKarafPeakThreads(String x) throws SnmpStatusException {
        OdlKarafPeakThreads = x;
    }

    /**
     * Checker for the "OdlKarafPeakThreads" variable.
     */
    public void checkOdlKarafPeakThreads(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlKarafDaemonThreads" variable.
     */
    public String getOdlKarafDaemonThreads() throws SnmpStatusException {
        return OdlKarafDaemonThreads;
    }

    /**
     * Setter for the "OdlKarafDaemonThreads" variable.
     */
    public void setOdlKarafDaemonThreads(String x) throws SnmpStatusException {
        OdlKarafDaemonThreads = x;
    }

    /**
     * Checker for the "OdlKarafDaemonThreads" variable.
     */
    public void checkOdlKarafDaemonThreads(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlKarafLiveThreads" variable.
     */
    public String getOdlKarafLiveThreads() throws SnmpStatusException {
        return OdlKarafLiveThreads;
    }

    /**
     * Setter for the "OdlKarafLiveThreads" variable.
     */
    public void setOdlKarafLiveThreads(String x) throws SnmpStatusException {
        OdlKarafLiveThreads = x;
    }

    /**
     * Checker for the "OdlKarafLiveThreads" variable.
     */
    public void checkOdlKarafLiveThreads(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
