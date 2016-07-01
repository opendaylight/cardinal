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
import com.sun.management.snmp.SnmpString;
import com.sun.management.snmp.SnmpValue;
import com.sun.management.snmp.SnmpStatusException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibGroup;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;
import com.sun.management.snmp.agent.SnmpStandardMetaServer;
import com.sun.management.snmp.agent.SnmpMibSubRequest;
import com.sun.management.snmp.agent.SnmpMibTable;


/**
 * The class is used for representing SNMP metadata for the
 * "OdlCardinalFeatureInstallModule" group. The group is defined with the
 * following oid: 1.3.6.1.3.1.1.2.
 */
public class OdlCardinalFeatureInstallModuleMeta extends SnmpMibGroup implements Serializable, SnmpStandardMetaServer {

    /**
     * Constructor for the metadata associated to
     * "OdlCardinalFeatureInstallModule".
     */
    public OdlCardinalFeatureInstallModuleMeta(SnmpMib myMib, SnmpStandardObjectServer objserv) {
        objectserver = objserv;
        try {
            registerObject(9);
            registerObject(8);
            registerObject(7);
            registerObject(6);
            registerObject(5);
            registerObject(4);
            registerObject(3);
            registerObject(2);
            registerObject(1);
            registerObject(10);
            registerObject(0);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the value of a scalar variable
     */
    public SnmpValue get(long var, Object data) throws SnmpStatusException {
        switch ((int) var) {
        case 9:
            return new SnmpString(node.getFeatureInstalled9());

        case 8:
            return new SnmpString(node.getFeatureInstalled8());

        case 7:
            return new SnmpString(node.getFeatureInstalled7());

        case 6:
            return new SnmpString(node.getFeatureInstalled6());

        case 5:
            return new SnmpString(node.getFeatureInstalled5());

        case 4:
            return new SnmpString(node.getFeatureInstalled4());

        case 3:
            return new SnmpString(node.getFeatureInstalled3());

        case 2:
            return new SnmpString(node.getFeatureInstalled2());

        case 1:
            return new SnmpString(node.getFeatureInstalled1());

        case 10:
            return new SnmpString(node.getFeatureInstalled10());

        case 0:
            return new SnmpString(node.getOdlKarafFeatureListInstalled());

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
        case 9:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled9(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled9());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 8:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled8(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled8());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 7:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled7(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled7());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 6:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled6(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled6());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 5:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled5(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled5());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 4:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled4(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled4());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 3:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled3(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled3());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 2:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled2(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled2());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 1:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled1(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled1());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 10:
            if (x instanceof SnmpString) {
                node.setFeatureInstalled10(((SnmpString) x).toString());
                return new SnmpString(node.getFeatureInstalled10());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 0:
            if (x instanceof SnmpString) {
                node.setOdlKarafFeatureListInstalled(((SnmpString) x).toString());
                return new SnmpString(node.getOdlKarafFeatureListInstalled());
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
        case 9:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled9(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 8:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled8(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 7:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled7(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 6:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled6(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 5:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled5(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 4:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled4(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 3:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled3(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 2:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled2(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 1:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled1(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 10:
            if (x instanceof SnmpString) {
                node.checkFeatureInstalled10(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 0:
            if (x instanceof SnmpString) {
                node.checkOdlKarafFeatureListInstalled(((SnmpString) x).toString());
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
    protected void setInstance(OdlCardinalFeatureInstallModuleMBean var) {
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
        case 9:
        case 8:
        case 7:
        case 6:
        case 5:
        case 4:
        case 3:
        case 2:
        case 1:
        case 10:
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
        case 9:
        case 8:
        case 7:
        case 6:
        case 5:
        case 4:
        case 3:
        case 2:
        case 1:
        case 10:
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
        case 9:
            return "FeatureInstalled9";

        case 8:
            return "FeatureInstalled8";

        case 7:
            return "FeatureInstalled7";

        case 6:
            return "FeatureInstalled6";

        case 5:
            return "FeatureInstalled5";

        case 4:
            return "FeatureInstalled4";

        case 3:
            return "FeatureInstalled3";

        case 2:
            return "FeatureInstalled2";

        case 1:
            return "FeatureInstalled1";

        case 10:
            return "FeatureInstalled10";

        case 0:
            return "OdlKarafFeatureListInstalled";

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

    protected OdlCardinalFeatureInstallModuleMBean node;
    protected SnmpStandardObjectServer objectserver = null;
}
