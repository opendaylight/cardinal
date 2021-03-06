/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;
//

// Generated by mibgen version 5.1 (03/08/07) when compiling ODL-CARDINAL-MIB in standard metadata mode.
//

// java imports
//
import java.io.Serializable;

// jmx imports
//
import javax.management.MBeanServer;
import com.sun.management.snmp.SnmpCounter;
import com.sun.management.snmp.SnmpCounter64;
import com.sun.management.snmp.SnmpGauge;
import com.sun.management.snmp.SnmpInt;
import com.sun.management.snmp.SnmpUnsignedInt;
import com.sun.management.snmp.SnmpIpAddress;
import com.sun.management.snmp.SnmpTimeticks;
import com.sun.management.snmp.SnmpOpaque;
import com.sun.management.snmp.SnmpString;
import com.sun.management.snmp.SnmpStringFixed;
import com.sun.management.snmp.SnmpOid;
import com.sun.management.snmp.SnmpNull;
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.SnmpVarBind;
import com.sun.management.snmp.SnmpStatusException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMibNode;
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibEntry;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;
import com.sun.management.snmp.agent.SnmpStandardMetaServer;
import com.sun.management.snmp.agent.SnmpMibSubRequest;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.EnumRowStatus;
import com.sun.management.snmp.SnmpDefinitions;

/**
 * The class is used for representing SNMP metadata for the "OdlNetconfEntry"
 * group. The group is defined with the following oid: 1.3.6.1.3.1.1.16.1.1.
 */
public class OdlNetconfEntryMeta extends SnmpMibEntry implements Serializable, SnmpStandardMetaServer {

    /**
     * Constructor for the metadata associated to "OdlNetconfEntry".
     */
    public OdlNetconfEntryMeta(SnmpMib myMib, SnmpStandardObjectServer objserv) {
        objectserver = objserv;
        varList = new int[4];
        varList[0] = 4;
        varList[1] = 3;
        varList[2] = 2;
        varList[3] = 1;
        SnmpMibNode.sort(varList);
    }

    /**
     * Get the value of a scalar variable
     */
    public SnmpValue get(long var, Object data) throws SnmpStatusException {
        switch ((int) var) {
        case 4:
            return new SnmpString(node.getOdlNetconfStatus());

        case 3:
            return new SnmpString(node.getOdlNetconfPort());

        case 2:
            return new SnmpString(node.getOdlNetconfHost());

        case 1:
            return new SnmpString(node.getOdlNetconfNodeId());

        default:
            break;
        }
        throw new SnmpStatusException(SnmpStatusException.noSuchObject);
    }

    /**
     * Set the value of a scalar variable
     */
    public SnmpValue set(SnmpValue x, long var, Object data) throws SnmpStatusException {
        switch ((int) var) {
        case 4:
            if (x instanceof SnmpString) {
                node.setOdlNetconfStatus(((SnmpString) x).toString());
                return new SnmpString(node.getOdlNetconfStatus());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 3:
            if (x instanceof SnmpString) {
                node.setOdlNetconfPort(((SnmpString) x).toString());
                return new SnmpString(node.getOdlNetconfPort());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 2:
            if (x instanceof SnmpString) {
                node.setOdlNetconfHost(((SnmpString) x).toString());
                return new SnmpString(node.getOdlNetconfHost());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 1:
            if (x instanceof SnmpString) {
                node.setOdlNetconfNodeId(((SnmpString) x).toByte());
                return new SnmpString(node.getOdlNetconfNodeId());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        default:
            break;
        }
        throw new SnmpStatusException(SnmpStatusException.snmpRspNotWritable);
    }

    /**
     * Check the value of a scalar variable
     */
    public void check(SnmpValue x, long var, Object data) throws SnmpStatusException {
        switch ((int) var) {
        case 4:
            if (x instanceof SnmpString) {
                node.checkOdlNetconfStatus(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 3:
            if (x instanceof SnmpString) {
                node.checkOdlNetconfPort(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 2:
            if (x instanceof SnmpString) {
                node.checkOdlNetconfHost(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 1:
            if (x instanceof SnmpString) {
                node.checkOdlNetconfNodeId(((SnmpString) x).toByte());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        default:
            throw new SnmpStatusException(SnmpStatusException.snmpRspNotWritable);
        }
    }

    /**
     * Allow to bind the metadata description to a specific object.
     */
    protected void setInstance(OdlNetconfEntryMBean var) {
        node = var;
    }

    // ------------------------------------------------------------
    //
    // Implements the "get" method defined in "SnmpMibEntry".
    // See the "SnmpMibEntry" Javadoc API for more details.
    //
    // ------------------------------------------------------------

    public void get(SnmpMibSubRequest req, int depth) throws SnmpStatusException {
        objectserver.get(this, req, depth);
    }

    // ------------------------------------------------------------
    //
    // Implements the "set" method defined in "SnmpMibEntry".
    // See the "SnmpMibEntry" Javadoc API for more details.
    //
    // ------------------------------------------------------------

    public void set(SnmpMibSubRequest req, int depth) throws SnmpStatusException {
        objectserver.set(this, req, depth);
    }

    // ------------------------------------------------------------
    //
    // Implements the "check" method defined in "SnmpMibEntry".
    // See the "SnmpMibEntry" Javadoc API for more details.
    //
    // ------------------------------------------------------------

    public void check(SnmpMibSubRequest req, int depth) throws SnmpStatusException {
        objectserver.check(this, req, depth);
    }

    /**
     * Returns true if "arc" identifies a scalar object.
     */
    public boolean isVariable(long arc) {

        switch ((int) arc) {
        case 4:
        case 3:
        case 2:
        case 1:
            return true;
        default:
            break;
        }
        return false;
    }

    /**
     * Returns true if "arc" identifies a readable scalar object.
     */
    public boolean isReadable(long arc) {

        switch ((int) arc) {
        case 4:
        case 3:
        case 2:
        case 1:
            return true;
        default:
            break;
        }
        return false;
    }

    // ------------------------------------------------------------
    //
    // Implements the "skipVariable" method defined in "SnmpMibEntry".
    // See the "SnmpMibEntry" Javadoc API for more details.
    //
    // ------------------------------------------------------------

    public boolean skipVariable(long var, Object data, int pduVersion) {
        return false;
    }

    /**
     * Return the name of the attribute corresponding to the SNMP variable
     * identified by "id".
     */
    public String getAttributeName(long id) throws SnmpStatusException {
        switch ((int) id) {
        case 4:
            return "OdlNetconfStatus";

        case 3:
            return "OdlNetconfPort";

        case 2:
            return "OdlNetconfHost";

        case 1:
            return "OdlNetconfNodeId";

        default:
            break;
        }
        throw new SnmpStatusException(SnmpStatusException.noSuchObject);
    }

    protected OdlNetconfEntryMBean node;
    protected SnmpStandardObjectServer objectserver = null;
}
