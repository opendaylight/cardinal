package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.OdlCardinalNetconfInfoApi;
import org.opendaylight.cardinal.impl.SetCardinalMibValues;
import org.opendaylight.cardinal.impl.SnmpSet;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.netconf.rev161227.Devices;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.netconf.rev161227.DevicesBuilder;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
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
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Preeti Pandey
 */

public class OdlCardinalNetconfInfoApiTest {
    PDU responsePDU = null;
    Snmp snmp = null;
    Agent mockagent = new Agent();
    SnmpSet set = new SnmpSet();
    SetCardinalMibValues setSnmpValues = new SetCardinalMibValues();
    OdlCardinalNetconfInfoApi odlCardinalNetconfInfoApi = new OdlCardinalNetconfInfoApi();
    DevicesBuilder builder = new DevicesBuilder();
    private static Logger log = LoggerFactory.getLogger(OdlCardinalNetconfInfoApiTest.class);
    Map<String, List<String>> featureListOid = new HashMap<String, List<String>>();

    @Mock
    private DataBroker mockDataBroker;
    private MockOdlCardinalNetconfInfoApi myMock = new MockOdlCardinalNetconfInfoApi();
    public static final InstanceIdentifier<Devices> Cardinal_IID_NETCONF = InstanceIdentifier.builder(Devices.class)
            .build();

    private class MockOdlCardinalNetconfInfoApi extends OdlCardinalNetconfInfoApi {
    }

    @Before
    public void setUp() throws SnmpStatusException {
        MockitoAnnotations.initMocks(this);
        myMock.setDataProvider(mockDataBroker);
        mockagent.startSnmpDaemon();
        try {
            setSnmpValues.setMibValues();
        } catch (Exception e2) {
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
        OID oid = new OID(".1.3.6.1.3.1.1.1.14.0");
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
            String nodeName = "nodeName";
            responsePDU = response.getResponse();
            List<String> nodeValues = new ArrayList<String>();
            nodeValues.add("host");
            nodeValues.add("port");
            nodeValues.add("status");
            featureListOid.put(nodeName, nodeValues);
        }
    }

    @After
    public void setDown() {
        try {
            snmp.close();
            try {
                myMock.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void setValuesTest() {
        if (responsePDU != null) {
            Devices devicesInfo = odlCardinalNetconfInfoApi.getValues(featureListOid);
            ReadWriteTransaction txn = mock(ReadWriteTransaction.class);
            doReturn(txn).when(mockDataBroker).newReadWriteTransaction();
            txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_NETCONF, devicesInfo);
            txn.submit();
            assertNotNull(txn);
        } else {
            assertNull(responsePDU);
            log.info("PDU Response is null");
        }
    }

    @Test
    public void getValuesTest() throws Exception {
        if (responsePDU != null) {
            set.setVariableString(".1.3.6.1.3.1.1.14.1.0", "controller-config");
            Devices devicesInfo = odlCardinalNetconfInfoApi.getValues(featureListOid);
            if (devicesInfo != null) {
                assertTrue(devicesInfo.getNetconf().get(0).getNodeId().toString().contains("controller-config"));
            }
        } else {
            assertNull(responsePDU);
            log.info("PDU Response is null");
        }
    }
}

