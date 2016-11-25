package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.OdlCardinalSendTrap;
import org.opendaylight.cardinal.impl.SnmpSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import com.sun.management.snmp.SnmpStatusException;

/**
 * @author Subodh Roy
 * 
 */
public class OdlCardinalSendTrapTest {
    OdlCardinalSendTrap odlCardinalSendTrap = new OdlCardinalSendTrap();
    PDU responsePDU = null;
    Snmp snmp = null;
    Agent mockagent = new Agent();
    SnmpSet set = new SnmpSet();
    private static Logger log = LoggerFactory.getLogger(OdlCardinalSendTrapTest.class);

    @Before
    public void setUp() {
        try {
            mockagent.startSnmpDaemon();
        } catch (SnmpStatusException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        // final
        String ipAddress = "127.0.0.1";
        String port = "161";
        int snmpVersion = SnmpConstants.version2c;
        String community = "public";
        TransportMapping<?> transport = null;
        try {
            transport = new DefaultUdpTransportMapping();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            transport.listen();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        CommunityTarget comtarget = new CommunityTarget();
        comtarget.setCommunity(new OctetString(community));
        comtarget.setVersion(snmpVersion);
        comtarget.setAddress(new UdpAddress(ipAddress + "/" + port));
        comtarget.setRetries(2);
        comtarget.setTimeout(1000);
        PDU pdu = new PDU();
        // Setting the Oid and Value for odl-cardinal-mib variable
        OID oid = new OID(".1.3.6.1.3.1.1.1.11.0");
        Variable var = new OctetString("hostname");
        VariableBinding varBind = new VariableBinding(oid, var);
        pdu.add(varBind);
        pdu.setType(PDU.SET);
        pdu.setRequestID(new Integer32(1));
        // Create Snmp object for sending data to Agent
        snmp = new Snmp(transport);
        ResponseEvent response = null;
        try {
            response = snmp.set(pdu, comtarget);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Process Agent Response
        if (response != null) {
            responsePDU = response.getResponse();
        }
    }

    @After
    public void setDown() {

    }

    @Test
    public void sendTrapTest() throws IOException {
        if (responsePDU != null) {
            boolean bool = odlCardinalSendTrap.sendTrap();
            assertEquals(bool, true);
        } else {
            assertEquals(responsePDU, null);
            log.info("Response PDU is null");
        }
    }
}