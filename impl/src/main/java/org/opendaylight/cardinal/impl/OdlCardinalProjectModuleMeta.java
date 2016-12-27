/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

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
 * "OdlCardinalProjectModule" group. The group is defined with the following
 * oid: 1.3.6.1.3.1.1.8.
 */
public class OdlCardinalProjectModuleMeta extends SnmpMibGroup implements Serializable, SnmpStandardMetaServer {

    /**
     * Constructor for the metadata associated to "OdlCardinalProjectModule".
     */
    public OdlCardinalProjectModuleMeta(SnmpMib myMib, SnmpStandardObjectServer objserv) {
        objectserver = objserv;
        try {
            registerObject(17);
            registerObject(16);
            registerObject(15);
            registerObject(14);
            registerObject(13);
            registerObject(12);
            registerObject(11);
            registerObject(10);
            registerObject(9);
            registerObject(8);
            registerObject(7);
            registerObject(6);
            registerObject(5);
            registerObject(4);
            registerObject(3);
            registerObject(2);
            registerObject(1);
            registerObject(0);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Get the value of a scalar variable
     */
    public SnmpValue get(long var, Object data) throws SnmpStatusException {
        switch ((int) var) {
        case 17:
            return new SnmpString(node.getOdlMDSALBGPBMPinfo());

        case 16:
            return new SnmpString(node.getOdlMDSALBGPRIBInfo());

        case 15:
            return new SnmpString(node.getOdlMDSALBGPPeerInfo());

        case 14:
            return new SnmpString(node.getOdlMDSALOpenFlowOVSconnectedDevices());

        case 13:
            return new SnmpString(node.getOdlMDSALIotDMlistofNodes());

        case 12:
            return new SnmpString(node.getOdlMDSALIotDMlistofAEs());

        case 11:
            return new SnmpString(node.getOdlMDSALIotDMListofcse());

        case 10:
            return new SnmpString(node.getOdlMDSALGBPPolicytenants());

        case 9:
            return new SnmpString(node.getOdlMDSALGBPFaaslogicalnetwork());

        case 8:
            return new SnmpString(node.getOdlMDSALService());

        case 7:
            return new SnmpString(node.getOdlMDSALServicefunctiontype());

        case 6:
            return new SnmpString(node.getOdlMDSALSfcfunctionAlgorithms());

        case 5:
            return new SnmpString(node.getOdlMDSALSfcfunctiongroups());

        case 4:
            return new SnmpString(node.getOdlMDSALSfcfunctionchain());

        case 3:
            return new SnmpString(node.getOdlMDSALSfcfunction());

        case 2:
            return new SnmpString(node.getOdlMDSALNetconfConnectedDevices());

        case 1:
            return new SnmpString(node.getOdlMDSALClustershardsshared());

        case 0:
            return new SnmpString(node.getOdlMDSALClusterControllerRole());

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
        case 17:
            if (x instanceof SnmpString) {
                node.setOdlMDSALBGPBMPinfo(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALBGPBMPinfo());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 16:
            if (x instanceof SnmpString) {
                node.setOdlMDSALBGPRIBInfo(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALBGPRIBInfo());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 15:
            if (x instanceof SnmpString) {
                node.setOdlMDSALBGPPeerInfo(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALBGPPeerInfo());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 14:
            if (x instanceof SnmpString) {
                node.setOdlMDSALOpenFlowOVSconnectedDevices(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALOpenFlowOVSconnectedDevices());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 13:
            if (x instanceof SnmpString) {
                node.setOdlMDSALIotDMlistofNodes(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALIotDMlistofNodes());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 12:
            if (x instanceof SnmpString) {
                node.setOdlMDSALIotDMlistofAEs(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALIotDMlistofAEs());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 11:
            if (x instanceof SnmpString) {
                node.setOdlMDSALIotDMListofcse(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALIotDMListofcse());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 10:
            if (x instanceof SnmpString) {
                node.setOdlMDSALGBPPolicytenants(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALGBPPolicytenants());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 9:
            if (x instanceof SnmpString) {
                node.setOdlMDSALGBPFaaslogicalnetwork(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALGBPFaaslogicalnetwork());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 8:
            if (x instanceof SnmpString) {
                node.setOdlMDSALService(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALService());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 7:
            if (x instanceof SnmpString) {
                node.setOdlMDSALServicefunctiontype(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALServicefunctiontype());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 6:
            if (x instanceof SnmpString) {
                node.setOdlMDSALSfcfunctionAlgorithms(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALSfcfunctionAlgorithms());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 5:
            if (x instanceof SnmpString) {
                node.setOdlMDSALSfcfunctiongroups(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALSfcfunctiongroups());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 4:
            if (x instanceof SnmpString) {
                node.setOdlMDSALSfcfunctionchain(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALSfcfunctionchain());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 3:
            if (x instanceof SnmpString) {
                node.setOdlMDSALSfcfunction(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALSfcfunction());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 2:
            if (x instanceof SnmpString) {
                node.setOdlMDSALNetconfConnectedDevices(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALNetconfConnectedDevices());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 1:
            if (x instanceof SnmpString) {
                node.setOdlMDSALClustershardsshared(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALClustershardsshared());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }

        case 0:
            if (x instanceof SnmpString) {
                node.setOdlMDSALClusterControllerRole(((SnmpString) x).toString());
                return new SnmpString(node.getOdlMDSALClusterControllerRole());
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
        case 17:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALBGPBMPinfo(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 16:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALBGPRIBInfo(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 15:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALBGPPeerInfo(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 14:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALOpenFlowOVSconnectedDevices(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 13:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALIotDMlistofNodes(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 12:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALIotDMlistofAEs(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 11:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALIotDMListofcse(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 10:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALGBPPolicytenants(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 9:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALGBPFaaslogicalnetwork(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 8:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALService(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 7:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALServicefunctiontype(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 6:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALSfcfunctionAlgorithms(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 5:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALSfcfunctiongroups(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 4:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALSfcfunctionchain(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 3:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALSfcfunction(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 2:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALNetconfConnectedDevices(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 1:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALClustershardsshared(((SnmpString) x).toString());
            } else {
                throw new SnmpStatusException(SnmpStatusException.snmpRspWrongType);
            }
            break;

        case 0:
            if (x instanceof SnmpString) {
                node.checkOdlMDSALClusterControllerRole(((SnmpString) x).toString());
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
    protected void setInstance(OdlCardinalProjectModuleMBean var) {
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
        case 17:
        case 16:
        case 15:
        case 14:
        case 13:
        case 12:
        case 11:
        case 10:
        case 9:
        case 8:
        case 7:
        case 6:
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
        case 17:
        case 16:
        case 15:
        case 14:
        case 13:
        case 12:
        case 11:
        case 10:
        case 9:
        case 8:
        case 7:
        case 6:
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
        case 17:
            return "OdlMDSALBGPBMPinfo";

        case 16:
            return "OdlMDSALBGPRIBInfo";

        case 15:
            return "OdlMDSALBGPPeerInfo";

        case 14:
            return "OdlMDSALOpenFlowOVSconnectedDevices";

        case 13:
            return "OdlMDSALIotDMlistofNodes";

        case 12:
            return "OdlMDSALIotDMlistofAEs";

        case 11:
            return "OdlMDSALIotDMListofcse";

        case 10:
            return "OdlMDSALGBPPolicytenants";

        case 9:
            return "OdlMDSALGBPFaaslogicalnetwork";

        case 8:
            return "OdlMDSALService";

        case 7:
            return "OdlMDSALServicefunctiontype";

        case 6:
            return "OdlMDSALSfcfunctionAlgorithms";

        case 5:
            return "OdlMDSALSfcfunctiongroups";

        case 4:
            return "OdlMDSALSfcfunctionchain";

        case 3:
            return "OdlMDSALSfcfunction";

        case 2:
            return "OdlMDSALNetconfConnectedDevices";

        case 1:
            return "OdlMDSALClustershardsshared";

        case 0:
            return "OdlMDSALClusterControllerRole";

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

    protected OdlCardinalProjectModuleMBean node;
    protected SnmpStandardObjectServer objectserver = null;
}
