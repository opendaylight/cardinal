package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.impl.rev141210;

import org.opendaylight.cardinal.impl.NetOpenflowEntry;
import java.io.Serializable;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//jmx imports
//import com.sun.jmx.snmp.SnmpStatusException;
import com.sun.management.snmp.SnmpStatusException;
//jdmk imports
import com.sun.management.snmp.agent.SnmpMib;

public class NetOpenflowEntryTest {

    // NetOpenflowEntry netOpen= new NetOpenflowEntry();
    SnmpMib mib;
    NetOpenflowEntry netOpen = new NetOpenflowEntry(mib);

    @After
    public void setDown() {

    }

    @Test
    public void getOdlNetOpenflowFlowstatsTest() throws SnmpStatusException,
            com.sun.management.snmp.SnmpStatusException {
        String x = new String("flow");
        try {
            assertEquals(x, netOpen.getOdlNetOpenflowFlowstats());
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        netOpen.setOdlNetOpenflowFlowstats("flow");
        assertEquals(x, netOpen.getOdlNetOpenflowFlowstats());

    }

    @Test
    public void getOdlNetOpenflowManufacturerTest() throws SnmpStatusException {

        String y = new String("manu");
        try {
            assertEquals(y, netOpen.getOdlNetOpenflowManufacturer());
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            netOpen.setOdlNetOpenflowManufacturer("manu");
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            assertEquals(y, netOpen.getOdlNetOpenflowManufacturer());
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void getOdlNetOpenflowMacAddressTest() throws SnmpStatusException {

        String z = new String("address");
        try {
            assertEquals(z, netOpen.getOdlNetOpenflowMacAddress());
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            netOpen.setOdlNetOpenflowMacAddress("address");
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            assertEquals(z, netOpen.getOdlNetOpenflowMacAddress());
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void getOdlNetOpenflowInterfaceTest() {
        String interfc = new String("JDMK 5.1");
        try {
            assertEquals(interfc, netOpen.getOdlNetOpenflowInterface());
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void getOdlNetOpenflowMeterstatsTest() throws SnmpStatusException {
        String meterStats = new String("meter");
        try {
            assertEquals(meterStats, netOpen.getOdlNetOpenflowMeterstats());
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            netOpen.setOdlNetOpenflowMeterstats(meterStats);
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            assertEquals(meterStats, netOpen.getOdlNetOpenflowMeterstats());
        } catch (com.sun.management.snmp.SnmpStatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
