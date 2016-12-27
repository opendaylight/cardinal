/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import com.sun.management.snmp.SnmpStatusException;

/**
 * This interface is used for representing the remote management interface for
 * the "OdlCardinalBundleInActiveModule" MBean.
 */
public interface OdlCardinalBundleInActiveModuleMBean {

    /**
     * Getter for the "InstalledBundle5" variable.
     */
    public String getInstalledBundle5() throws SnmpStatusException;

    /**
     * Setter for the "InstalledBundle5" variable.
     */
    public void setInstalledBundle5(String x) throws SnmpStatusException;

    /**
     * Checker for the "InstalledBundle5" variable.
     */
    public void checkInstalledBundle5(String x) throws SnmpStatusException;

    /**
     * Getter for the "InstalledBundle4" variable.
     */
    public String getInstalledBundle4() throws SnmpStatusException;

    /**
     * Setter for the "InstalledBundle4" variable.
     */
    public void setInstalledBundle4(String x) throws SnmpStatusException;

    /**
     * Checker for the "InstalledBundle4" variable.
     */
    public void checkInstalledBundle4(String x) throws SnmpStatusException;

    /**
     * Getter for the "InstalledBundle3" variable.
     */
    public String getInstalledBundle3() throws SnmpStatusException;

    /**
     * Setter for the "InstalledBundle3" variable.
     */
    public void setInstalledBundle3(String x) throws SnmpStatusException;

    /**
     * Checker for the "InstalledBundle3" variable.
     */
    public void checkInstalledBundle3(String x) throws SnmpStatusException;

    /**
     * Getter for the "InstalledBundle2" variable.
     */
    public String getInstalledBundle2() throws SnmpStatusException;

    /**
     * Setter for the "InstalledBundle2" variable.
     */
    public void setInstalledBundle2(String x) throws SnmpStatusException;

    /**
     * Checker for the "InstalledBundle2" variable.
     */
    public void checkInstalledBundle2(String x) throws SnmpStatusException;

    /**
     * Getter for the "InstalledBundle1" variable.
     */
    public String getInstalledBundle1() throws SnmpStatusException;

    /**
     * Setter for the "InstalledBundle1" variable.
     */
    public void setInstalledBundle1(String x) throws SnmpStatusException;

    /**
     * Checker for the "InstalledBundle1" variable.
     */
    public void checkInstalledBundle1(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlKarafBundleListInstalled" variable.
     */
    public String getOdlKarafBundleListInstalled() throws SnmpStatusException;

    /**
     * Setter for the "OdlKarafBundleListInstalled" variable.
     */
    public void setOdlKarafBundleListInstalled(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlKarafBundleListInstalled" variable.
     */
    public void checkOdlKarafBundleListInstalled(String x) throws SnmpStatusException;

}
