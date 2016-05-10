/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import org.slf4j.LoggerFactory;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.AbstractVariable;
import org.snmp4j.smi.AssignableFromString;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SnmpSet {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(SnmpSet.class);
    private static String ipAddress = "127.0.0.1";

    private static String port = "161";

    private static int snmpVersion = SnmpConstants.version2c;

    private static String community = "public";

    public void setVariableString(String mibOid, String hostName) throws Exception {

        // Create TransportMapping and Listen
        @SuppressWarnings("rawtypes")
        TransportMapping transport = new DefaultUdpTransportMapping();
        transport.listen();

        // Create Target Address object
        CommunityTarget comtarget = new CommunityTarget();
        comtarget.setCommunity(new OctetString(community));
        comtarget.setVersion(snmpVersion);
        comtarget.setAddress(new UdpAddress(ipAddress + "/" + port));
        comtarget.setRetries(2);
        comtarget.setTimeout(1000);

        // Create the PDU object
        PDU pdu = new PDU();
        // Setting the Oid and Value for odl-cardinal-mib variable
        OID oid = new OID(mibOid);
        Variable var = new OctetString(hostName);
        VariableBinding varBind = new VariableBinding(oid, var);
        pdu.add(varBind);
        pdu.setType(PDU.SET);
        pdu.setRequestID(new Integer32(1));

        // Create Snmp object for sending data to Agent
        Snmp snmp = new Snmp(transport);

        ResponseEvent response = snmp.set(pdu, comtarget);

        // Process Agent Response
        if (response != null) {

            PDU responsePDU = response.getResponse();

            if (responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
                int errorIndex = responsePDU.getErrorIndex();
                String errorStatusText = responsePDU.getErrorStatusText();

                if (errorStatus == PDU.noError) {
                    LOG.info("Snmp Set Response = " + responsePDU.getVariableBindings());
                } else {
                    LOG.info("Error: Request Failed");
                    LOG.info("Error Status = " + errorStatus);
                    LOG.info("Error Index = " + errorIndex);
                    LOG.info("Error Status Text = " + errorStatusText);
                }
            } else {
                LOG.info("Error: Response PDU is null");
            }
        } else {
            LOG.info("Error: Agent Timeout... ");
        }
        snmp.close();
    }

    public static Variable stringToVariable(String value, int smiSyntax) {
        Variable var = AbstractVariable.createFromSyntax(smiSyntax);
        if (var instanceof AssignableFromString)
            ((AssignableFromString) var).setValue(value);
        else
            throw new IllegalArgumentException("Unsupported conversion from String to " + var.getSyntaxString());
        return var;
    }

    public void setVariableInt(String mibOid, int hostName) throws Exception {

        // Create TransportMapping and Listen
        @SuppressWarnings("rawtypes")
        TransportMapping transport = new DefaultUdpTransportMapping();
        transport.listen();

        // Create Target Address object
        CommunityTarget comtarget = new CommunityTarget();
        comtarget.setCommunity(new OctetString(community));
        comtarget.setVersion(snmpVersion);
        comtarget.setAddress(new UdpAddress(ipAddress + "/" + port));
        comtarget.setRetries(2);
        comtarget.setTimeout(1000);

        // Create the PDU object
        PDU pdu = new PDU();
        // Setting the Oid and Value for sysContact variable
        OID oid = new OID(mibOid);
        Variable var = new Integer32(hostName);
        VariableBinding varBind = new VariableBinding(oid, var);
        pdu.add(varBind);
        pdu.setType(PDU.SET);
        pdu.setRequestID(new Integer32(1));

        // Create Snmp object for sending data to Agent
        Snmp snmp = new Snmp(transport);

        ResponseEvent response = snmp.set(pdu, comtarget);

        // Process Agent Response
        if (response != null) {

            PDU responsePDU = response.getResponse();

            if (responsePDU != null) {
                int errorStatus = responsePDU.getErrorStatus();
                int errorIndex = responsePDU.getErrorIndex();
                String errorStatusText = responsePDU.getErrorStatusText();

                if (errorStatus == PDU.noError) {
                    LOG.info("Snmp Set Response = " + responsePDU.getVariableBindings());
                } else {
                    LOG.info("Error: Request Failed");
                    LOG.info("Error Status = " + errorStatus);
                    LOG.info("Error Index = " + errorIndex);
                    LOG.info("Error Status Text = " + errorStatusText);
                }
            } else {
                LOG.info("Error: Response PDU is null");
            }
        } else {
            LOG.info("Error: Agent Timeout... ");
        }
        snmp.close();
    }

}

