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
 * the "OdlOpenFlowStats" MBean.
 */
public interface OdlOpenFlowStatsMBean {

    /**
     * Getter for the "OdlOpenflowFlowstats" variable.
     */
    public String getOdlOpenflowFlowstats() throws SnmpStatusException;

    /**
     * Setter for the "OdlOpenflowFlowstats" variable.
     */
    public void setOdlOpenflowFlowstats(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlOpenflowFlowstats" variable.
     */
    public void checkOdlOpenflowFlowstats(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlOpenflowStatus" variable.
     */
    public String getOdlOpenflowStatus() throws SnmpStatusException;

    /**
     * Setter for the "OdlOpenflowStatus" variable.
     */
    public void setOdlOpenflowStatus(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlOpenflowStatus" variable.
     */
    public void checkOdlOpenflowStatus(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlOpenflowManufacturer" variable.
     */
    public String getOdlOpenflowManufacturer() throws SnmpStatusException;

    /**
     * Setter for the "OdlOpenflowManufacturer" variable.
     */
    public void setOdlOpenflowManufacturer(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlOpenflowManufacturer" variable.
     */
    public void checkOdlOpenflowManufacturer(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlOpenflowMacAddress" variable.
     */
    public String getOdlOpenflowMacAddress() throws SnmpStatusException;

    /**
     * Setter for the "OdlOpenflowMacAddress" variable.
     */
    public void setOdlOpenflowMacAddress(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlOpenflowMacAddress" variable.
     */
    public void checkOdlOpenflowMacAddress(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlOpenflowInterface" variable.
     */
    public String getOdlOpenflowInterface() throws SnmpStatusException;

    /**
     * Setter for the "OdlOpenflowInterface" variable.
     */
    public void setOdlOpenflowInterface(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlOpenflowInterface" variable.
     */
    public void checkOdlOpenflowInterface(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlOpenflowNode" variable.
     */
    public String getOdlOpenflowNode() throws SnmpStatusException;

    /**
     * Setter for the "OdlOpenflowNode" variable.
     */
    public void setOdlOpenflowNode(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlOpenflowNode" variable.
     */
    public void checkOdlOpenflowNode(String x) throws SnmpStatusException;

    /**
     * Getter for the "OdlOpenflowMeterstats" variable.
     */
    public String getOdlOpenflowMeterstats() throws SnmpStatusException;

    /**
     * Setter for the "OdlOpenflowMeterstats" variable.
     */
    public void setOdlOpenflowMeterstats(String x) throws SnmpStatusException;

    /**
     * Checker for the "OdlOpenflowMeterstats" variable.
     */
    public void checkOdlOpenflowMeterstats(String x) throws SnmpStatusException;

}
