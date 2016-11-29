package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.CardinalProvider;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;
import static org.mockito.Mockito.mock;

public class CardinalProviderTest {

    CardinalProvider provider = new CardinalProvider();

    @Before
    public void setUp() {
    }

    @After
    public void setDown() throws Exception {
        provider.close();
    }

    @Test
    public void testOnSessionInitiated() throws Exception {
        // ensure no exceptions
        // currently this method is empty
        provider.onSessionInitiated(mock(BindingAwareBroker.ProviderContext.class));
    }

    @Test
    public void testClose() throws Exception {
        CardinalProvider provider = new CardinalProvider();
        // ensure no exceptions
        // currently this method is empty
        provider.close();
    }
}