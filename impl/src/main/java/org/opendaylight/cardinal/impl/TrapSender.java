/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class TrapSender {
    private static final Logger LOG = LoggerFactory.getLogger(TrapSender.class);
    public static final String community = "public";

    // Sending Trap for sysLocation of RFC1213
    public static String Oid = ".1.3.6.1.3.1.2.1.3";

    // IP of Local Host
     public static final String ipAddress = "127.0.0.1";
    //public static final String ipAddress = "172.21.88.135";

    public static String featurestatus = "";

    // Ideally Port 162 should be used to send receive Trap, any other available
    // Port can be used
    public static final int port = 162;
    public static String sysinfo = null;
    PDU response = null;
    private static final String REGEX = "\\bUP\\b";
    static File tempFile = null;

    public void main(String args, String status) {
        Pattern pattern = Pattern.compile(REGEX);
        Oid = args;
        featurestatus = status;

        String s = "";
        Process p;
        try {
            p = Runtime.getRuntime().exec("ifconfig eth0");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
                s = s.concat(br.readLine());
                Matcher m = pattern.matcher(s);
                if (m.find()) {
                    sysinfo = "Link Up";
                    LOG.info("eth0: {}", sysinfo);
                }
            }
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
        }

        TrapSender trapV2 = new TrapSender();
        trapV2.sendTrap_Version2();
    }

    /**
     * This methods sends the V1 trap to the Localhost in port 162
     */
    public void sendTrap_Version2() {
        try {
            // Create Transport Mapping
            TransportMapping transport = new DefaultUdpTransportMapping();
            transport.listen();

            // Create Target
            CommunityTarget cTarget = new CommunityTarget();
            cTarget.setCommunity(new OctetString(community));
            cTarget.setVersion(SnmpConstants.version2c);
            cTarget.setAddress(new UdpAddress(ipAddress + "/" + port));
            cTarget.setRetries(2);
            cTarget.setTimeout(5000);

            // Create PDU for V2
            PDU pdu = new PDU();

            // need to specify the system up time
            pdu.add(new VariableBinding(SnmpConstants.sysUpTime, new OctetString(new Date().toString())));
            pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID, new OID(Oid)));
            pdu.add(new VariableBinding(SnmpConstants.snmpTrapAddress, new IpAddress(ipAddress)));

            pdu.add(new VariableBinding(new OID(Oid), new OctetString(featurestatus)));
            pdu.setType(PDU.TRAP);
            // pdu.setType(PDU.INFORM);

            // Send the PDU
            Snmp snmp = new Snmp(transport);
            LOG.info("Sending V2 Trap... Check Wheather NMS is Listening or not? ");
            if (sysinfo == "Link Up") {
                snmp.send(pdu, cTarget);
            }
            snmp.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
