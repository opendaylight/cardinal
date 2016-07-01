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
 * the "OdlCardinalBundleResolvedModule" MBean.
 */
public interface OdlCardinalBundleResolvedModuleMBean {

    /**
     * Getter for the "ResolvedBundle5" variable.
     */
    public String getResolvedBundle5() throws SnmpStatusException;

    /**
     * Setter for the "ResolvedBundle5" variable.
     */
    public void setResolvedBundle5(String x) throws SnmpStatusException;

    /**
     * Checker for the "ResolvedBundle5" variable.
     */
    public void checkResolvedBundle5(String x) throws SnmpStatusException;

    /**
     * Getter for the "ResolvedBundle4" variable.
     */
    public String getResolvedBundle4() throws SnmpStatusException;

    /**
     * Setter for the "ResolvedBundle4" variable.
     */
    public void setResolvedBundle4(String x) throws SnmpStatusException;

    /**
     * Checker for the "ResolvedBundle4" variable.
     */
    public void checkResolvedBundle4(String x) throws SnmpStatusException;

    /**
     * Getter for the "ResolvedBundle3" variable.
     */
    public String getResolvedBundle3() throws SnmpStatusException;

    /**
     * Setter for the "ResolvedBundle3" variable.
     */
    public void setResolvedBundle3(String x) throws SnmpStatusException;

    /**
     * Checker for the "ResolvedBundle3" variable.
     */
    public void checkResolvedBundle3(String x) throws SnmpStatusException;

    /**
     * Getter for the "ResolvedBundle2" variable.
     */
    public String getResolvedBundle2() throws SnmpStatusException;

    /**
     * Setter for the "ResolvedBundle2" variable.
     */
    public void setResolvedBundle2(String x) throws SnmpStatusException;

    /**
     * Checker for the "ResolvedBundle2" variable.
     */
    public void checkResolvedBundle2(String x) throws SnmpStatusException;

    /**
     * Getter for the "ResolvedBundle1" variable.
     */
    public String getResolvedBundle1() throws SnmpStatusException;

    /**
     * Setter for the "ResolvedBundle1" variable.
     */
    public void setResolvedBundle1(String x) throws SnmpStatusException;

    /**
     * Checker for the "ResolvedBundle1" variable.
     */
    public void checkResolvedBundle1(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlKarafBundleListResolved" variable.
     */
    public String getOdlKarafBundleListResolved() throws SnmpStatusException;

    /**
     * Setter for the "OdlKarafBundleListResolved" variable.
     */
    public void setOdlKarafBundleListResolved(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlKarafBundleListResolved" variable.
     */
    public void checkOdlKarafBundleListResolved(String x) throws SnmpStatusException;

}
