/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.IOException;
import java.net.InetAddress;

import javax.management.ObjectName;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class OdlCardinalSetTrapReceiver {
    int snmpPort = 161;
    final ObjectName snmpObjName=null;
  
  public boolean startReceiver(){
      OdlCardinalTrapReceiver snmp4jTrapReceiver = new OdlCardinalTrapReceiver();
      try {
              snmp4jTrapReceiver.listen(new UdpAddress("localhost/162"));
              return true;
      } catch (IOException e) {
              e.printStackTrace();
      }
      return true;
      
  }
  
  
       

}

    





