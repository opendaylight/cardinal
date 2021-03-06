/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;
//

// Generated by mibgen version 5.1 (03/08/07) when compiling ODL-CARDINAL-MIB in standard metadata mode.
//

// jmx imports
//
import com.sun.management.snmp.SnmpStatusException;

/**
 * This interface is used for representing the remote management interface for
 * the "NetOpenflowEntry" MBean.
 */
public interface NetOpenflowEntryMBean {

    /**
     * Getter for the "OdlNetOpenflowFlowstats" variable.
     */
    public String getOdlNetOpenflowFlowstats() throws SnmpStatusException;

    /**
     * Setter for the "OdlNetOpenflowFlowstats" variable.
     */
    public void setOdlNetOpenflowFlowstats(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlNetOpenflowFlowstats" variable.
     */
    public void checkOdlNetOpenflowFlowstats(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlNetOpenflowManufacturer" variable.
     */
    public String getOdlNetOpenflowManufacturer() throws SnmpStatusException;

    /**
     * Setter for the "OdlNetOpenflowManufacturer" variable.
     */
    public void setOdlNetOpenflowManufacturer(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlNetOpenflowManufacturer" variable.
     */
    public void checkOdlNetOpenflowManufacturer(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlNetOpenflowMacAddress" variable.
     */
    public String getOdlNetOpenflowMacAddress() throws SnmpStatusException;

    /**
     * Setter for the "OdlNetOpenflowMacAddress" variable.
     */
    public void setOdlNetOpenflowMacAddress(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlNetOpenflowMacAddress" variable.
     */
    public void checkOdlNetOpenflowMacAddress(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlNetOpenflowInterface" variable.
     */
    public String getOdlNetOpenflowInterface() throws SnmpStatusException;

    /**
     * Setter for the "OdlNetOpenflowInterface" variable.
     */
    public void setOdlNetOpenflowInterface(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlNetOpenflowInterface" variable.
     */
    public void checkOdlNetOpenflowInterface(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlNetOpenflowRowStatus" variable.
     */
    public String getOdlNetOpenflowRowStatus() throws SnmpStatusException;

    /**
     * Setter for the "OdlNetOpenflowRowStatus" variable.
     */
    public void setOdlNetOpenflowRowStatus(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlNetOpenflowRowStatus" variable.
     */
    public void checkOdlNetOpenflowRowStatus(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlNetOpenflowNode" variable.
     */
    public Byte[] getOdlNetOpenflowNode() throws SnmpStatusException;

    /**
     * Setter for the "OdlNetOpenflowNode" variable.
     */
    public void setOdlNetOpenflowNode(Byte[] x) throws SnmpStatusException;

    /**
     * Checker for the "OdlNetOpenflowNode" variable.
     */
    public void checkOdlNetOpenflowNode(Byte[] x) throws SnmpStatusException;

    /**
     * Getter for the "OdlNetOpenflowMeterstats" variable.
     */
    public String getOdlNetOpenflowMeterstats() throws SnmpStatusException;

    /**
     * Setter for the "OdlNetOpenflowMeterstats" variable.
     */
    public void setOdlNetOpenflowMeterstats(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlNetOpenflowMeterstats" variable.
     */
    public void checkOdlNetOpenflowMeterstats(String x) throws SnmpStatusException;

}
