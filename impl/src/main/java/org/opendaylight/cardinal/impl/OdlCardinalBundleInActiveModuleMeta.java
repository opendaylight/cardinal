/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

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
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibGroup;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;
import com.sun.management.snmp.agent.SnmpStandardMetaServer;
import com.sun.management.snmp.agent.SnmpMibSubRequest;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.EnumRowStatus;
import com.sun.management.snmp.SnmpDefinitions;

/**
 * The class is used for representing SNMP metadata for the
 * "OdlCardinalBundleInActiveModule" group. The group is defined with the
 * following oid: 1.3.6.1.3.1.1.5.
 */
public class OdlCardinalBundleInActiveModuleMeta extends SnmpMibGroup implements Serializable, SnmpStandardMetaServer {

    /**
     * Constructor for the metadata associated to
     * "OdlCardinalBundleInActiveModule".
     */
    public OdlCardinalBundleInActiveModuleMeta(SnmpMib myMib, SnmpStandardObjectServer objserv) {
        objectserver = objserv;
        try {
            registerObject(5);
            registerObject(4);
            registerObject(3);
            registerObject(2);
            registerObject(1);
            registerObject(0);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the value of a scalar variable.
     */
    public SnmpValue get(long var, Object data) throws SnmpStatusException {
        switch ((int) var) {
        case 5:
            return new SnmpString(node.getInstalledBundle5());

        case 4:
            return new SnmpString(node.getInstalledBundle4());

        case 3:
            return new SnmpString(node.getInstalledBundle3());

        case 2:
            return new SnmpString(node.getInstalledBundle2());

        case 1:
            return new SnmpString(node.getInstalledBundle1());

        case 0:
            return new SnmpString(node.getOdlKarafBundleListInstalled());

        default:
            break;
        }
        throw new SnmpStatusException(SnmpStatusException.noSuchObject);
    }

    /**
     * Set the value of a scalar variable.
     */
    public SnmpValue set(SnmpValue x, long var, Object data) throws SnmpStatusException {
        switch ((int) var) {
        case 5:
            if (x instanceof SnmpString) {
                node.setInstalledBundle5(((SnmpString) x).toString());
                return new SnmpString(node.getInstalledBundle5());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 4:
            if (x instanceof SnmpString) {
                node.setInstalledBundle4(((SnmpString) x).toString());
                return new SnmpString(node.getInstalledBundle4());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 3:
            if (x instanceof SnmpString) {
                node.setInstalledBundle3(((SnmpString) x).toString());
                return new SnmpString(node.getInstalledBundle3());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 2:
            if (x instanceof SnmpString) {
                node.setInstalledBundle2(((SnmpString) x).toString());
                return new SnmpString(node.getInstalledBundle2());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 1:
            if (x instanceof SnmpString) {
                node.setInstalledBundle1(((SnmpString) x).toString());
                return new SnmpString(node.getInstalledBundle1());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 0:
            if (x instanceof SnmpString) {
                node.setOdlKarafBundleListInstalled(((SnmpString) x).toString());
                return new SnmpString(node.getOdlKarafBundleListInstalled());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        default:
            break;
        }
        throw new SnmpStatusException(SnmpStatusException.snmpRspNotWritable);
    }

    /**
     * Check the value of a scalar variable.
     */
    public void check(SnmpValue x, long var, Object data) throws SnmpStatusException {
        switch ((int) var) {
        case 5:
            if (x instanceof SnmpString) {
                node.checkInstalledBundle5(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 4:
            if (x instanceof SnmpString) {
                node.checkInstalledBundle4(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 3:
            if (x instanceof SnmpString) {
                node.checkInstalledBundle3(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 2:
            if (x instanceof SnmpString) {
                node.checkInstalledBundle2(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 1:
            if (x instanceof SnmpString) {
                node.checkInstalledBundle1(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 0:
            if (x instanceof SnmpString) {
                node.checkOdlKarafBundleListInstalled(((SnmpString) x).toString());
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
    protected void setInstance(OdlCardinalBundleInActiveModuleMBean var) {
        node = var;
    }

    // ------------------------------------------------------------
    //
    // Implements the "get" method defined in "SnmpMibGroup".
    // See the "SnmpMibGroup" Javadoc API for more details.
    //
    // ------------------------------------------------------------

    public void get(SnmpMibSubRequest req, int depth) throws SnmpStatusException {
        objectserver.get(this, req, depth);
    }

    // ------------------------------------------------------------
    //
    // Implements the "set" method defined in "SnmpMibGroup".
    // See the "SnmpMibGroup" Javadoc API for more details.
    //
    // ------------------------------------------------------------

    public void set(SnmpMibSubRequest req, int depth) throws SnmpStatusException {
        objectserver.set(this, req, depth);
    }

    // ------------------------------------------------------------
    //
    // Implements the "check" method defined in "SnmpMibGroup".
    // See the "SnmpMibGroup" Javadoc API for more details.
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
        case 5:
        case 4:
        case 3:
        case 2:
        case 1:
        case 0:
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
        case 5:
        case 4:
        case 3:
        case 2:
        case 1:
        case 0:
            return true;
        default:
            break;
        }
        return false;
    }

    // ------------------------------------------------------------
    //
    // Implements the "skipVariable" method defined in "SnmpMibGroup".
    // See the "SnmpMibGroup" Javadoc API for more details.
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
        case 5:
            return "InstalledBundle5";

        case 4:
            return "InstalledBundle4";

        case 3:
            return "InstalledBundle3";

        case 2:
            return "InstalledBundle2";

        case 1:
            return "InstalledBundle1";

        case 0:
            return "OdlKarafBundleListInstalled";

        default:
            break;
        }
        throw new SnmpStatusException(SnmpStatusException.noSuchObject);
    }

    /**
     * Returns true if "arc" identifies a table object.
     */
    public boolean isTable(long arc) {

        switch ((int) arc) {
        default:
            break;
        }
        return false;
    }

    /**
     * Returns the table object identified by "arc".
     */
    public SnmpMibTable getTable(long arc) {
        return null;
    }

    /**
     * Register the group's SnmpMibTable objects with the meta-data.
     */
    public void registerTableNodes(SnmpMib mib, MBeanServer server) {
    }

    protected OdlCardinalBundleInActiveModuleMBean node;
    protected SnmpStandardObjectServer objectserver = null;
}
