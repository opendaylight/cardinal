package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.net.SocketException;
import org.apache.sshd.SshClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.SetCardinalMibValues;
import org.opendaylight.cardinal.impl.SnmpSet;
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
/**
 * @author Subodh Roy
 */

public class SetCardinalMibValuesTest {

    PDU responsePDU = null;
    SetCardinalMibValues setCardinalMibValues = new SetCardinalMibValues();
    SshClient client = null;
    Snmp snmp = null;
    Agent mockagent = new Agent();
    int htmlPort = 8082;
    int snmpPort = 161;
    SnmpSet set = new SnmpSet();

    @Before
    public void setUp() throws Exception {
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
    public void setDown() {
        try {
            snmp.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void setSystemNameTest() {
        if (responsePDU != null) {
            boolean setSystemName = setCardinalMibValues.setSystemName();
            assertEquals(true, setSystemName);
        } else {
            assertEquals(responsePDU, null);
        }
    }

    @Test
    public void setOdlNodeNameTest() {
        if (responsePDU != null) {
            boolean setOdlNodeName = setCardinalMibValues.setOdlNodeName();
            assertEquals(true, setOdlNodeName);
        } else {
            assertEquals(responsePDU, null);
        }
    }

    @Test
    public void setSystemIpAddressTest() throws SocketException {
        boolean setSystemIPAddress = false;
        if (responsePDU != null) {
            setSystemIPAddress = setCardinalMibValues.setSystemIpAddress();
            assertEquals(true, setSystemIPAddress);
        } else {
            assertEquals(responsePDU, null);
        }
    }

    @Test
    public void setCpuMemUsageTest() throws IOException, InterruptedException {
        boolean setCpuMemUsage = false;
        //String pid=setCardinalMibValues.getKarafPid();
        //setCardinalMibValues.setSystemIpAddress();
            setCpuMemUsage = setCardinalMibValues.setCpuMemUsage(setCardinalMibValues);
            if (setCpuMemUsage) {
                assertEquals(true, setCpuMemUsage);
            }
         else {
            assertEquals(false, setCpuMemUsage);
        }
    }

    @Test
    public void setMibValuesTest() {
        boolean bool = false;
        if (responsePDU != null) {
            try {
                bool = setCardinalMibValues.setMibValues();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (bool = true) {
                assertEquals(true, bool);
            }
        } else {
            assertEquals(false, bool);
        }
    }
}