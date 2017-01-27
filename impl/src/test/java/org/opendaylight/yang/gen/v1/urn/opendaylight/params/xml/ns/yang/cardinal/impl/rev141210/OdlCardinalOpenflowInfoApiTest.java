package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.OdlCardinalOpenflowInfoApi;
import org.opendaylight.cardinal.impl.SetCardinalMibValues;
import org.opendaylight.cardinal.impl.SnmpSet;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.Devices;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.DevicesBuilder;
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
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Preeti Pandey
 */

public class OdlCardinalOpenflowInfoApiTest {
    PDU responsePDU = null;
    Snmp snmp = null;
    Agent mockagent = new Agent();
    SnmpSet set = new SnmpSet();
    SetCardinalMibValues setSnmpValues = new SetCardinalMibValues();
    OdlCardinalOpenflowInfoApi odlCardinalOpenflowInfoApi = new OdlCardinalOpenflowInfoApi();
    DevicesBuilder builder = new DevicesBuilder();
    private static Logger log = LoggerFactory.getLogger(OdlCardinalOpenflowInfoApiTest.class);

    @Mock
    private DataBroker mockDataBroker;
    private MockOdlCardinalOpenflowInfoApi myMock = new MockOdlCardinalOpenflowInfoApi();
    public static final InstanceIdentifier<Devices> Cardinal_IID_OPENFLOW = InstanceIdentifier.builder(Devices.class)
            .build();

    private class MockOdlCardinalOpenflowInfoApi extends OdlCardinalOpenflowInfoApi {
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
        OID oid = new OID(".1.3.6.1.3.1.1.1.11.0");
        Variable var = new OctetString("hostname");
        VariableBinding varBind = new VariableBinding(oid, var);
        pdu.add(varBind);
        pdu.setType(PDU.SET);
        pdu.setRequestID(new Integer32(1));
        snmp = new Snmp(transport);
        ResponseEvent response = null;
        try {
            response = snmp.set(pdu, comtarget);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (response != null) {
            responsePDU = response.getResponse();
            try {
                set.setVariableString(".1.3.6.1.3.1.1.11.1.0", "openFlowNode");
                set.setVariableString(".1.3.6.1.3.1.1.11.2.0", "interfaceName");
                set.setVariableString(".1.3.6.1.3.1.1.11.3.0", "macaddress");
                set.setVariableString(".1.3.6.1.3.1.1.11.4.0", "manufacturer");
                set.setVariableString(".1.3.6.1.3.1.1.11.5.0", "status");
                set.setVariableString(".1.3.6.1.3.1.1.11.6.0", " ");
                set.setVariableString(".1.3.6.1.3.1.1.11.7.0", " ");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
            Devices devicesInfo = odlCardinalOpenflowInfoApi.getValues();
            ReadWriteTransaction txn = mock(ReadWriteTransaction.class);
            doReturn(txn).when(mockDataBroker).newReadWriteTransaction();
            txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_OPENFLOW, devicesInfo);
            txn.submit();
            assertNotNull(txn);
        } else {
            assertNull(responsePDU);
            log.info("PDU Response is null");
        }
    }

    @Test
    public void getValuesTest() {
        if (responsePDU != null) {
            Devices devicesInfo = odlCardinalOpenflowInfoApi.getValues();
            if (devicesInfo != null) {
                assertTrue(devicesInfo.getOpenflow().get(0).toString().contains("openFlowNode"));
            }
        } else {
            assertNull(responsePDU);
            log.info("PDU Response is null");
        }
    }
}

