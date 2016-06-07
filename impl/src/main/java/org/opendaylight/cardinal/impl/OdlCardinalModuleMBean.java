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
 * the "OdlCardinalModule" MBean.
 */
@SuppressWarnings("all")
public interface OdlCardinalModuleMBean {

	/**
	 * Getter for the "OdlSystemOdlNodeInfo" variable.
	 */
	public Byte[] getOdlSystemOdlNodeInfo() throws SnmpStatusException;

	/**
	 * Setter for the "OdlSystemOdlNodeInfo" variable.
	 */
	public void setOdlSystemOdlNodeInfo(Byte[] x) throws SnmpStatusException;

	/**
	 * Checker for the "OdlSystemOdlNodeInfo" variable.
	 */
	public void checkOdlSystemOdlNodeInfo(Byte[] x) throws SnmpStatusException;

	/**
	 * Getter for the "OdlSystemOdlUptime" variable.
	 */
	public Byte[] getOdlSystemOdlUptime() throws SnmpStatusException;

	/**
	 * Setter for the "OdlSystemOdlUptime" variable.
	 */
	public void setOdlSystemOdlUptime(Byte[] x) throws SnmpStatusException;

	/**
	 * Checker for the "OdlSystemOdlUptime" variable.
	 */
	public void checkOdlSystemOdlUptime(Byte[] x) throws SnmpStatusException;

	/**
	 * Getter for the "OdlSystemSysInfo" variable.
	 */
	public Byte[] getOdlSystemSysInfo() throws SnmpStatusException;

	/**
	 * Setter for the "OdlSystemSysInfo" variable.
	 */
	public void setOdlSystemSysInfo(Byte[] x) throws SnmpStatusException;

	/**
	 * Checker for the "OdlSystemSysInfo" variable.
	 */
	public void checkOdlSystemSysInfo(Byte[] x) throws SnmpStatusException;

	/**
	 * Getter for the "OdlSystemHostAddress" variable.
	 */
	public Byte[] getOdlSystemHostAddress() throws SnmpStatusException;

	/**
	 * Setter for the "OdlSystemHostAddress" variable.
	 */
	public void setOdlSystemHostAddress(Byte[] x) throws SnmpStatusException;

	/**
	 * Checker for the "OdlSystemHostAddress" variable.
	 */
	public void checkOdlSystemHostAddress(Byte[] x) throws SnmpStatusException;

	/**
	 * Getter for the "OdlSystemMemUsage" variable.
	 */
	public Integer getOdlSystemMemUsage() throws SnmpStatusException;

	/**
	 * Setter for the "OdlSystemMemUsage" variable.
	 */
	public void setOdlSystemMemUsage(Integer x) throws SnmpStatusException;

	/**
	 * Checker for the "OdlSystemMemUsage" variable.
	 */
	public void checkOdlSystemMemUsage(Integer x) throws SnmpStatusException;

	/**
	 * Getter for the "OdlSystemCpuUsage" variable.
	 */
	public Integer getOdlSystemCpuUsage() throws SnmpStatusException;

	/**
	 * Setter for the "OdlSystemCpuUsage" variable.
	 */
	public void setOdlSystemCpuUsage(Integer x) throws SnmpStatusException;

	/**
	 * Checker for the "OdlSystemCpuUsage" variable.
	 */
	public void checkOdlSystemCpuUsage(Integer x) throws SnmpStatusException;

}
