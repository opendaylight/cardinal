package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.apache.sshd.SshClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.SnmpSet;
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
 */
public class SnmpSetTest {
    SnmpSet snmpSet = new SnmpSet();
    PDU responsePDU = null;
    SshClient client = null;
    Snmp snmp = null;
    Agent mockagent = new Agent();
    int htmlPort = 8082;
    int snmpPort = 161;
    SnmpSet set = new SnmpSet();
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SnmpSetTest.class);

    // OID oid = new OID(str);
    @Before
    public void setUp() throws SnmpStatusException {
        // SnmpSet set = new SnmpSet();
        mockagent.startSnmpDaemon();
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
        OID oid = new OID(".1.3.6.1.3.1.1.1.4.0");
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
    @Test
    public void setVariableStringTest() throws Exception {
        String oid = ".1.3.6.1.3.1.1.1.6.0";
        String str = "localhost";
        if (responsePDU != null) {
            boolean req = snmpSet.setVariableString(oid, str);
            assertEquals(true, req);
        } else {
            assertEquals(null, responsePDU);
            LOG.info("response PDU is Null");
        }
    }

    @Test
    public void setVariableIntTest() throws Exception {
        String oid = ".1.3.6.1.3.1.1.1.2.0";
        int hname = 12;
        if (responsePDU != null) {
            boolean req = snmpSet.setVariableInt(oid, hname);
            assertEquals(true, req);
        } else {
            assertEquals(null, responsePDU);
            LOG.info("response PDU is Null");
        }
    }
}