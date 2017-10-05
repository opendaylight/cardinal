/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.api;

import java.net.InetAddress;
import java.util.Enumeration;

import com.sun.management.snmp.SnmpOid;
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.agent.SnmpMibAgent;

public interface SnmpMibService {
    /*
     * Load your custom MIB
     */
    void loadMib(final SnmpMibAgent mib);

    /*
     * Unload your custom MIB
     */
    void unloadMib(final SnmpMibAgent mib);

    /**
     * Set a trap address
     */
    void setTrapAddress(final String trapCommunity, final String trapReceiver);

    /*
     * Send a TRAP
     */
    void sendSnmpTrap(SnmpOid ntOid, Enumeration<SnmpOid> payloadOid, Enumeration<SnmpValue> payloadData);
}
