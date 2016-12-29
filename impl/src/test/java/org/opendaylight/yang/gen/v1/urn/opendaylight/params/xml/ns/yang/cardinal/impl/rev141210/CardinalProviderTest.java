package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import org.junit.Test;
import org.opendaylight.cardinal.impl.CardinalProvider;
import org.junit.After;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.Devices;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.DevicesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.Openflow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.OpenflowBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opendaylight.cardinal.impl.Agent;
import org.opendaylight.cardinal.impl.OdlCardinalOpenflowInfoApi;

public class CardinalProviderTest {
    CardinalProvider provider = new CardinalProvider();
    Agent mockagent = new Agent();
    private static final Logger LOG = LoggerFactory.getLogger(CardinalProvider.class);
    private ProviderContext providerContext;
    public ProviderContext session = mock(ProviderContext.class);
    public static DataBroker dataService;
    final OdlCardinalOpenflowInfoApi odlOpenflowApi = new OdlCardinalOpenflowInfoApi();

    @Before
    public void setUp() {
    }

    @After
    public void setDown() throws Exception {
        provider.close();
    }

    @Test
    public void OnSessionInitiatedTest() throws Exception {
        this.providerContext = session;
        this.dataService = session.getSALService(DataBroker.class);
        initDevicesOperationalTest();
    }

    @Test
    public void initDevicesOperationalTest() {
        // TODO Auto-generated method stub
        DevicesBuilder builder = new DevicesBuilder();
        OpenflowBuilder flow = new OpenflowBuilder();
        flow.setNodeName(null).setInterface(null).setMacAddress(null).setManufacturer(null).setStatus(null)
                .setFlowStats(null).setMeterStats(null).build();
        List<Openflow> openflowlist = new ArrayList<Openflow>();
        openflowlist.add(flow.build());
        builder.setOpenflow(openflowlist);
        Devices devices = builder.build();
        WriteTransaction tx = mock(WriteTransaction.class);
        tx.put(LogicalDatastoreType.OPERATIONAL, OdlCardinalOpenflowInfoApi.Cardinal_IID_OPENFLOW, devices);
        tx.submit();
    }

    @Test
    public void testClose() throws Exception {
        CardinalProvider provider = new CardinalProvider();
        provider.close();
    }

}
