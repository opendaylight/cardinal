package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.OdlCardinalKarafInfoApi;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.karaf.rev160620.CardinalKarafInfo;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OdlCardinalKarafInfoApiTest {
	PDU responsePDU = null;
	Snmp snmp = null;
	OdlCardinalKarafInfoApi infoapi = new OdlCardinalKarafInfoApi();
	Agent mockagent = new Agent();
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OdlCardinalKarafInfoApi.class);

	@Mock
	private DataBroker mockDataBroker;
	private MockOdlCardinalKarafInfoApi myMock = new MockOdlCardinalKarafInfoApi();
	public static final InstanceIdentifier<CardinalKarafInfo> Cardinal_IID_KARAF = InstanceIdentifier
			.builder(CardinalKarafInfo.class).build();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		myMock.setDataProvider(mockDataBroker);
		try {
			mockagent.startSnmpDaemon();
		} catch (SnmpStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		try {
			myMock.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setValuesTest() {
		if (responsePDU != null) {
			CardinalKarafInfo cardinalKarafInfo = infoapi.getOidValues();
			if (cardinalKarafInfo != null) {
				ReadWriteTransaction txn = mock(ReadWriteTransaction.class);
				doReturn(txn).when(mockDataBroker).newReadWriteTransaction();
				txn.put(LogicalDatastoreType.OPERATIONAL, Cardinal_IID_KARAF, cardinalKarafInfo);
				txn.submit();
				LOG.info("ReadWriteTransaction is not null {}", txn);
			}
		} else {
			assertNull(responsePDU);
			LOG.info("PDU Response is null");
		}
	}

	@Test
	public void getValuesTest() {
		if (responsePDU != null) {
			CardinalKarafInfo cardinalKarafInfo = infoapi.getOidValues();
			if (cardinalKarafInfo != null) {

				assertEquals(" JDMK 5.1", cardinalKarafInfo.getOdlKarafFeatureListInstalled1());
			}
		} else {
			assertNull(responsePDU);
			LOG.info("PDU Response is null");
		}
	}

	private class MockOdlCardinalKarafInfoApi extends OdlCardinalKarafInfoApi {
	}
}