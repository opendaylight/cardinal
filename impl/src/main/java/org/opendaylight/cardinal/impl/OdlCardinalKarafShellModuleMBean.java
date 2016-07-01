/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

// jmx imports
//
import com.sun.management.snmp.SnmpStatusException;

/**
 * This interface is used for representing the remote management interface for
 * the "OdlCardinalKarafShellModule" MBean.
 */
public interface OdlCardinalKarafShellModuleMBean {

    /**
     * Getter for the "OdlKarafMaxHeapSize" variable.
     */
    public String getOdlKarafMaxHeapSize() throws SnmpStatusException;

    /**
     * Setter for the "OdlKarafMaxHeapSize" variable.
     */
    public void setOdlKarafMaxHeapSize(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlKarafMaxHeapSize" variable.
     */
    public void checkOdlKarafMaxHeapSize(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlKarafCurrentHeapSize" variable.
     */
    public String getOdlKarafCurrentHeapSize() throws SnmpStatusException;

    /**
     * Setter for the "OdlKarafCurrentHeapSize" variable.
     */
    public void setOdlKarafCurrentHeapSize(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlKarafCurrentHeapSize" variable.
     */
    public void checkOdlKarafCurrentHeapSize(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlKarafPeakThreads" variable.
     */
    public String getOdlKarafPeakThreads() throws SnmpStatusException;

    /**
     * Setter for the "OdlKarafPeakThreads" variable.
     */
    public void setOdlKarafPeakThreads(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlKarafPeakThreads" variable.
     */
    public void checkOdlKarafPeakThreads(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlKarafDaemonThreads" variable.
     */
    public String getOdlKarafDaemonThreads() throws SnmpStatusException;

    /**
     * Setter for the "OdlKarafDaemonThreads" variable.
     */
    public void setOdlKarafDaemonThreads(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlKarafDaemonThreads" variable.
     */
    public void checkOdlKarafDaemonThreads(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlKarafLiveThreads" variable.
     */
    public String getOdlKarafLiveThreads() throws SnmpStatusException;

    /**
     * Setter for the "OdlKarafLiveThreads" variable.
     */
    public void setOdlKarafLiveThreads(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlKarafLiveThreads" variable.
     */
    public void checkOdlKarafLiveThreads(String x) throws SnmpStatusException;

}
