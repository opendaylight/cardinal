package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.cardinal.impl.ODL_CARDINAL_MIBOidTable;

public class ODL_CARDINAL_MIBOidTableTest {
    ODL_CARDINAL_MIBOidTable odlTable = new ODL_CARDINAL_MIBOidTable();

    @Before
    public void setUp() {
    }

    @After
    public void setDown() {
    }

    @Test
    public void isTest() throws Exception {
        odlTable.getAllEntries();
    }
}