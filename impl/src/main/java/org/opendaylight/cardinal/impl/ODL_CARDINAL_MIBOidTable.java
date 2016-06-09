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
import com.sun.management.snmp.SnmpOidRecord;

// jdmk imports
//
import com.sun.management.snmp.SnmpOidTableSupport;

/**
 * The class contains metadata definitions for "ODL-CARDINAL-MIB". Call
 * SnmpOid.setSnmpOidTable(new ODL_CARDINAL_MIBOidTable()) to load the metadata
 * in the SnmpOidTable.
 */
@SuppressWarnings("all")
public class ODL_CARDINAL_MIBOidTable extends SnmpOidTableSupport implements Serializable {

  /**
   * Default constructor. Initialize the Mib tree.
   */
  public ODL_CARDINAL_MIBOidTable() {
    super("ODL_CARDINAL_MIB");
    loadMib(varList);
  }

  static SnmpOidRecord varList[] = { new SnmpOidRecord("odlSystemOdlNodeInfo", "1.3.6.1.3.1.1.1.6", "S"),
      new SnmpOidRecord("odlSystemOdlUptime", "1.3.6.1.3.1.1.1.5", "S"),
      new SnmpOidRecord("odlSystemSysInfo", "1.3.6.1.3.1.1.1.4", "S"),
      new SnmpOidRecord("odlSystemHostAddress", "1.3.6.1.3.1.1.1.3", "S"),
      new SnmpOidRecord("odlSystemMemUsage", "1.3.6.1.3.1.1.1.2", "I"),
      new SnmpOidRecord("odlSystemCpuUsage", "1.3.6.1.3.1.1.1.1", "I"),
      new SnmpOidRecord("snmpGroup", "1.3.6.1.3.1.2", "OBG") };
}
