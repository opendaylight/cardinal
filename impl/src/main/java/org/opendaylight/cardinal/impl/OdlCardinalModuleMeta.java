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
import com.sun.management.snmp.SnmpCounter;
import com.sun.management.snmp.SnmpCounter64;
import com.sun.management.snmp.SnmpGauge;
import com.sun.management.snmp.SnmpInt;
import com.sun.management.snmp.SnmpUnsignedInt;
import com.sun.management.snmp.SnmpIpAddress;
import com.sun.management.snmp.SnmpTimeticks;
import com.sun.management.snmp.SnmpOpaque;
import com.sun.management.snmp.SnmpString;
import com.sun.management.snmp.SnmpStringFixed;
import com.sun.management.snmp.SnmpOid;
import com.sun.management.snmp.SnmpNull;
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.SnmpVarBind;
import com.sun.management.snmp.SnmpStatusException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibGroup;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;
import com.sun.management.snmp.agent.SnmpStandardMetaServer;
import com.sun.management.snmp.agent.SnmpMibSubRequest;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.EnumRowStatus;
import com.sun.management.snmp.SnmpDefinitions;

/**
 * The class is used for representing SNMP metadata for the "OdlCardinalModule"
 * group. The group is defined with the following oid: 1.3.6.1.3.1.1.1.
 */
@SuppressWarnings("all")
public class OdlCardinalModuleMeta extends SnmpMibGroup implements Serializable, SnmpStandardMetaServer {

  /**
   * Constructor for the metadata associated to "OdlCardinalModule".
   */
  public OdlCardinalModuleMeta(SnmpMib myMib, SnmpStandardObjectServer objserv) {
    objectserver = objserv;
    try {
      registerObject(6);
      registerObject(5);
      registerObject(4);
      registerObject(3);
      registerObject(2);
      registerObject(1);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Get the value of a scalar variable
   */
  public SnmpValue get(long var, Object data) throws SnmpStatusException {
    switch ((int) var) {
    case 6:
      return new SnmpString(node.getOdlSystemOdlNodeInfo());

    case 5:
      return new SnmpString(node.getOdlSystemOdlUptime());

    case 4:
      return new SnmpString(node.getOdlSystemSysInfo());

    case 3:
      return new SnmpString(node.getOdlSystemHostAddress());

    case 2:
      return new SnmpInt(node.getOdlSystemMemUsage());

    case 1:
      return new SnmpInt(node.getOdlSystemCpuUsage());

    default:
      break;
    }
    throw new SnmpStatusException(SnmpStatusException.noSuchObject);
  }

  /**
   * Set the value of a scalar variable
   */
  public SnmpValue set(SnmpValue x, long var, Object data) throws SnmpStatusException {
    switch ((int) var) {
    case 6:
      if (x instanceof SnmpString) {
        node.setOdlSystemOdlNodeInfo(((SnmpString) x).toByte());
        return new SnmpString(node.getOdlSystemOdlNodeInfo());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }

    case 5:
      if (x instanceof SnmpString) {
        node.setOdlSystemOdlUptime(((SnmpString) x).toByte());
        return new SnmpString(node.getOdlSystemOdlUptime());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }

    case 4:
      if (x instanceof SnmpString) {
        node.setOdlSystemSysInfo(((SnmpString) x).toByte());
        return new SnmpString(node.getOdlSystemSysInfo());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }

    case 3:
      if (x instanceof SnmpString) {
        node.setOdlSystemHostAddress(((SnmpString) x).toByte());
        return new SnmpString(node.getOdlSystemHostAddress());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }

    case 2:
      if (x instanceof SnmpInt) {
        node.setOdlSystemMemUsage(((SnmpInt) x).toInteger());
        return new SnmpInt(node.getOdlSystemMemUsage());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }

    case 1:
      if (x instanceof SnmpInt) {
        node.setOdlSystemCpuUsage(((SnmpInt) x).toInteger());
        return new SnmpInt(node.getOdlSystemCpuUsage());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }

    default:
      break;
    }
    throw new SnmpStatusException(SnmpStatusException.snmpRspNotWritable);
  }

  /**
   * Check the value of a scalar variable
   */
  public void check(SnmpValue x, long var, Object data) throws SnmpStatusException {
    switch ((int) var) {
    case 6:
      if (x instanceof SnmpString) {
        node.checkOdlSystemOdlNodeInfo(((SnmpString) x).toByte());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }
      break;

    case 5:
      if (x instanceof SnmpString) {
        node.checkOdlSystemOdlUptime(((SnmpString) x).toByte());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }
      break;

    case 4:
      if (x instanceof SnmpString) {
        node.checkOdlSystemSysInfo(((SnmpString) x).toByte());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }
      break;

    case 3:
      if (x instanceof SnmpString) {
        node.checkOdlSystemHostAddress(((SnmpString) x).toByte());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }
      break;

    case 2:
      if (x instanceof SnmpInt) {
        node.checkOdlSystemMemUsage(((SnmpInt) x).toInteger());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }
      break;

    case 1:
      if (x instanceof SnmpInt) {
        node.checkOdlSystemCpuUsage(((SnmpInt) x).toInteger());
      } else {
        throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
      }
      break;

    default:
      throw new SnmpStatusException(SnmpStatusException.snmpRspNotWritable);
    }
  }

  /**
   * Allow to bind the metadata description to a specific object.
   */
  protected void setInstance(OdlCardinalModuleMBean var) {
    node = var;
  }

  // ------------------------------------------------------------
  //
  // Implements the "get" method defined in "SnmpMibGroup".
  // See the "SnmpMibGroup" Javadoc API for more details.
  //
  // ------------------------------------------------------------

  public void get(SnmpMibSubRequest req, int depth) throws SnmpStatusException {
    objectserver.get(this, req, depth);
  }

  // ------------------------------------------------------------
  //
  // Implements the "set" method defined in "SnmpMibGroup".
  // See the "SnmpMibGroup" Javadoc API for more details.
  //
  // ------------------------------------------------------------

  public void set(SnmpMibSubRequest req, int depth) throws SnmpStatusException {
    objectserver.set(this, req, depth);
  }

  // ------------------------------------------------------------
  //
  // Implements the "check" method defined in "SnmpMibGroup".
  // See the "SnmpMibGroup" Javadoc API for more details.
  //
  // ------------------------------------------------------------

  public void check(SnmpMibSubRequest req, int depth) throws SnmpStatusException {
    objectserver.check(this, req, depth);
  }

  /**
   * Returns true if "arc" identifies a scalar object.
   */
  public boolean isVariable(long arc) {

    switch ((int) arc) {
    case 6:
    case 5:
    case 4:
    case 3:
    case 2:
    case 1:
      return true;
    default:
      break;
    }
    return false;
  }

  /**
   * Returns true if "arc" identifies a readable scalar object.
   */
  public boolean isReadable(long arc) {

    switch ((int) arc) {
    case 6:
    case 5:
    case 4:
    case 3:
    case 2:
    case 1:
      return true;
    default:
      break;
    }
    return false;
  }

  // ------------------------------------------------------------
  //
  // Implements the "skipVariable" method defined in "SnmpMibGroup".
  // See the "SnmpMibGroup" Javadoc API for more details.
  //
  // ------------------------------------------------------------

  public boolean skipVariable(long var, Object data, int pduVersion) {
    return false;
  }

  /**
   * Return the name of the attribute corresponding to the SNMP variable
   * identified by "id".
   */
  public String getAttributeName(long id) throws SnmpStatusException {
    switch ((int) id) {
    case 6:
      return "OdlSystemOdlNodeInfo";

    case 5:
      return "OdlSystemOdlUptime";

    case 4:
      return "OdlSystemSysInfo";

    case 3:
      return "OdlSystemHostAddress";

    case 2:
      return "OdlSystemMemUsage";

    case 1:
      return "OdlSystemCpuUsage";

    default:
      break;
    }
    throw new SnmpStatusException(SnmpStatusException.noSuchObject);
  }

  /**
   * Returns true if "arc" identifies a table object.
   */
  public boolean isTable(long arc) {

    switch ((int) arc) {
    default:
      break;
    }
    return false;
  }

  /**
   * Returns the table object identified by "arc".
   */
  public SnmpMibTable getTable(long arc) {
    return null;
  }

  /**
   * Register the group's SnmpMibTable objects with the meta-data.
   */

  public void registerTableNodes(SnmpMib mib, MBeanServer server) {
  }

  protected OdlCardinalModuleMBean node;
  protected SnmpStandardObjectServer objectserver = null;
}
