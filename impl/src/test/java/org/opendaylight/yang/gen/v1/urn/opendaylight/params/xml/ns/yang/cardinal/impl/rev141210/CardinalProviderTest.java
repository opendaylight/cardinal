package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;
import org.junit.Test;
import org.opendaylight.cardinal.impl.CardinalProvider;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;

import static org.mockito.Mockito.mock;

/**
 * @author Gaurav Pande This class provides the test case handling
 *         for different scenarios
 */

public class CardinalProviderTest {
    @Test
    public void testOnSessionInitiated() {
        CardinalProvider provider = new CardinalProvider();
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