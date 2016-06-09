/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210.CardinalModule;
import org.slf4j.LoggerFactory;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class OdlCardinalGet {
  private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalGet.class);
  public String snmpGet(String host, String community, String strOID) {
    String strResponse = "";
    ResponseEvent response;
    Snmp snmp;
    try {
      OctetString community1 = new OctetString(community);
      host = host + "/" + "161";
      Address tHost = new UdpAddress(host);
      TransportMapping transport = new DefaultUdpTransportMapping();
      transport.listen();
      CommunityTarget comtarget = new CommunityTarget();
      comtarget.setCommunity(community1);
      comtarget.setVersion(SnmpConstants.version1);
      comtarget.setAddress(tHost);
      comtarget.setRetries(2);
      comtarget.setTimeout(5000);
      PDU pdu = new PDU();
      pdu.add(new VariableBinding(new OID(strOID)));
      pdu.setType(PDU.GET);
      snmp = new Snmp(transport);
      response = snmp.get(pdu, comtarget);
      if (response != null) {
        if (response.getResponse().getErrorStatusText().equalsIgnoreCase("Success")) {
          PDU pduresponse = response.getResponse();
          strResponse = pduresponse.getVariableBindings().firstElement().toString();
          if (strResponse.contains("=")) {
            int len = strResponse.indexOf("=");
            strResponse = strResponse.substring(len + 1, strResponse.length());
          }
        }
      } else {
        LOG.info("Looks like a TimeOut occured ");
      }
      snmp.close();
    } catch (Exception e) {
      throw new RuntimeException(e);    
    }
    // System.out.println("Response="+strResponse);
    return strResponse;
  }
}
