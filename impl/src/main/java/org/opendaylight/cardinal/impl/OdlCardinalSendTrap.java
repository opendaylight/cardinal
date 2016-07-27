/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.IOException;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class OdlCardinalSendTrap {
    public boolean sendTrap() throws IOException{
       
        //create PDU
        PDU trap = new PDU();
        trap.setType(PDU.TRAP);
        OID oid = new OID(".1.3.6.1.3.1.1.1.36.0");          
        trap.add(new VariableBinding(SnmpConstants.snmpTrapOID, oid));
        Variable var = new OctetString("My system is in trouble");       
        trap.add(new VariableBinding(oid, var));  
        
        //create target 
        Address targetaddress = new UdpAddress("localhost/162");
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setVersion(SnmpConstants.version2c);
        target.setAddress(targetaddress);
        
        //send trap
        
        Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
          snmp.send(trap, target, null, null);
          return true;
      
        
    }
}
