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
import com.sun.management.snmp.SnmpStatusException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;

/**
 * The class is used for implementing the "OdlCardinalProjectModule" group. The
 * group is defined with the following oid: 1.3.6.1.3.1.1.8.
 */
public class OdlCardinalProjectModule implements OdlCardinalProjectModuleMBean, Serializable {

    /**
     * Variable for storing the value of "OdlMDSALBGPBMPinfo". The variable is
     * identified by: "1.3.6.1.3.1.1.8.18".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALBGPBMPinfo = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALBGPRIBInfo". The variable is
     * identified by: "1.3.6.1.3.1.1.8.17".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALBGPRIBInfo = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALBGPPeerInfo". The variable is
     * identified by: "1.3.6.1.3.1.1.8.16".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALBGPPeerInfo = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALOpenFlowOVSconnectedDevices".
     * The variable is identified by: "1.3.6.1.3.1.1.8.15".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALOpenFlowOVSconnectedDevices = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALIotDMlistofNodes". The
     * variable is identified by: "1.3.6.1.3.1.1.8.14".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALIotDMlistofNodes = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALIotDMlistofAEs". The variable
     * is identified by: "1.3.6.1.3.1.1.8.13".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALIotDMlistofAEs = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALIotDMListofcse". The variable
     * is identified by: "1.3.6.1.3.1.1.8.12".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALIotDMListofcse = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALGBPPolicytenants". The
     * variable is identified by: "1.3.6.1.3.1.1.8.10".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALGBPPolicytenants = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALGBPFaaslogicalnetwork". The
     * variable is identified by: "1.3.6.1.3.1.1.8.9".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALGBPFaaslogicalnetwork = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALService". The variable is
     * identified by: "1.3.6.1.3.1.1.8.8".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALService = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALServicefunctiontype". The
     * variable is identified by: "1.3.6.1.3.1.1.8.7".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALServicefunctiontype = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALSfcfunctionAlgorithms". The
     * variable is identified by: "1.3.6.1.3.1.1.8.6".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALSfcfunctionAlgorithms = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALSfcfunctiongroups". The
     * variable is identified by: "1.3.6.1.3.1.1.8.5".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALSfcfunctiongroups = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALSfcfunctionchain". The
     * variable is identified by: "1.3.6.1.3.1.1.8.4".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALSfcfunctionchain = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALSfcfunction". The variable is
     * identified by: "1.3.6.1.3.1.1.8.3".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALSfcfunction = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALNetconfConnectedDevices". The
     * variable is identified by: "1.3.6.1.3.1.1.8.2".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALNetconfConnectedDevices = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALClustershardsshared". The
     * variable is identified by: "1.3.6.1.3.1.1.8.1".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALClustershardsshared = new String("Opendaylight Node Information");

    /**
     * Variable for storing the value of "OdlMDSALClusterControllerRole". The
     * variable is identified by: "1.3.6.1.3.1.1.8.0".
     *
     * "To be done"
     *
     */
    protected String OdlMDSALClusterControllerRole = new String("Opendaylight Node Information");

    /**
     * Constructor for the "OdlCardinalProjectModule" group. If the group
     * contains a table, the entries created through an SNMP SET will not be
     * registered in Java DMK.
     */
    public OdlCardinalProjectModule(SnmpMib myMib) {
    }

    /**
     * Constructor for the "OdlCardinalProjectModule" group. If the group
     * contains a table, the entries created through an SNMP SET will be
     * AUTOMATICALLY REGISTERED in Java DMK.
     */
    public OdlCardinalProjectModule(SnmpMib myMib, MBeanServer server) {
    }

    /**
     * Getter for the "OdlMDSALBGPBMPinfo" variable.
     */
    public String getOdlMDSALBGPBMPinfo() throws SnmpStatusException {
        return OdlMDSALBGPBMPinfo;
    }

    /**
     * Setter for the "OdlMDSALBGPBMPinfo" variable.
     */
    public void setOdlMDSALBGPBMPinfo(String x) throws SnmpStatusException {
        OdlMDSALBGPBMPinfo = x;
    }

    /**
     * Checker for the "OdlMDSALBGPBMPinfo" variable.
     */
    public void checkOdlMDSALBGPBMPinfo(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALBGPRIBInfo" variable.
     */
    public String getOdlMDSALBGPRIBInfo() throws SnmpStatusException {
        return OdlMDSALBGPRIBInfo;
    }

    /**
     * Setter for the "OdlMDSALBGPRIBInfo" variable.
     */
    public void setOdlMDSALBGPRIBInfo(String x) throws SnmpStatusException {
        OdlMDSALBGPRIBInfo = x;
    }

    /**
     * Checker for the "OdlMDSALBGPRIBInfo" variable.
     */
    public void checkOdlMDSALBGPRIBInfo(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALBGPPeerInfo" variable.
     */
    public String getOdlMDSALBGPPeerInfo() throws SnmpStatusException {
        return OdlMDSALBGPPeerInfo;
    }

    /**
     * Setter for the "OdlMDSALBGPPeerInfo" variable.
     */
    public void setOdlMDSALBGPPeerInfo(String x) throws SnmpStatusException {
        OdlMDSALBGPPeerInfo = x;
    }

    /**
     * Checker for the "OdlMDSALBGPPeerInfo" variable.
     */
    public void checkOdlMDSALBGPPeerInfo(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALOpenFlowOVSconnectedDevices" variable.
     */
    public String getOdlMDSALOpenFlowOVSconnectedDevices() throws SnmpStatusException {
        return OdlMDSALOpenFlowOVSconnectedDevices;
    }

    /**
     * Setter for the "OdlMDSALOpenFlowOVSconnectedDevices" variable.
     */
    public void setOdlMDSALOpenFlowOVSconnectedDevices(String x) throws SnmpStatusException {
        OdlMDSALOpenFlowOVSconnectedDevices = x;
    }

    /**
     * Checker for the "OdlMDSALOpenFlowOVSconnectedDevices" variable.
     */
    public void checkOdlMDSALOpenFlowOVSconnectedDevices(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALIotDMlistofNodes" variable.
     */
    public String getOdlMDSALIotDMlistofNodes() throws SnmpStatusException {
        return OdlMDSALIotDMlistofNodes;
    }

    /**
     * Setter for the "OdlMDSALIotDMlistofNodes" variable.
     */
    public void setOdlMDSALIotDMlistofNodes(String x) throws SnmpStatusException {
        OdlMDSALIotDMlistofNodes = x;
    }

    /**
     * Checker for the "OdlMDSALIotDMlistofNodes" variable.
     */
    public void checkOdlMDSALIotDMlistofNodes(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALIotDMlistofAEs" variable.
     */
    public String getOdlMDSALIotDMlistofAEs() throws SnmpStatusException {
        return OdlMDSALIotDMlistofAEs;
    }

    /**
     * Setter for the "OdlMDSALIotDMlistofAEs" variable.
     */
    public void setOdlMDSALIotDMlistofAEs(String x) throws SnmpStatusException {
        OdlMDSALIotDMlistofAEs = x;
    }

    /**
     * Checker for the "OdlMDSALIotDMlistofAEs" variable.
     */
    public void checkOdlMDSALIotDMlistofAEs(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALIotDMListofcse" variable.
     */
    public String getOdlMDSALIotDMListofcse() throws SnmpStatusException {
        return OdlMDSALIotDMListofcse;
    }

    /**
     * Setter for the "OdlMDSALIotDMListofcse" variable.
     */
    public void setOdlMDSALIotDMListofcse(String x) throws SnmpStatusException {
        OdlMDSALIotDMListofcse = x;
    }

    /**
     * Checker for the "OdlMDSALIotDMListofcse" variable.
     */
    public void checkOdlMDSALIotDMListofcse(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALGBPPolicytenants" variable.
     */
    public String getOdlMDSALGBPPolicytenants() throws SnmpStatusException {
        return OdlMDSALGBPPolicytenants;
    }

    /**
     * Setter for the "OdlMDSALGBPPolicytenants" variable.
     */
    public void setOdlMDSALGBPPolicytenants(String x) throws SnmpStatusException {
        OdlMDSALGBPPolicytenants = x;
    }

    /**
     * Checker for the "OdlMDSALGBPPolicytenants" variable.
     */
    public void checkOdlMDSALGBPPolicytenants(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALGBPFaaslogicalnetwork" variable.
     */
    public String getOdlMDSALGBPFaaslogicalnetwork() throws SnmpStatusException {
        return OdlMDSALGBPFaaslogicalnetwork;
    }

    /**
     * Setter for the "OdlMDSALGBPFaaslogicalnetwork" variable.
     */
    public void setOdlMDSALGBPFaaslogicalnetwork(String x) throws SnmpStatusException {
        OdlMDSALGBPFaaslogicalnetwork = x;
    }

    /**
     * Checker for the "OdlMDSALGBPFaaslogicalnetwork" variable.
     */
    public void checkOdlMDSALGBPFaaslogicalnetwork(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALService" variable.
     */
    public String getOdlMDSALService() throws SnmpStatusException {
        return OdlMDSALService;
    }

    /**
     * Setter for the "OdlMDSALService" variable.
     */
    public void setOdlMDSALService(String x) throws SnmpStatusException {
        OdlMDSALService = x;
    }

    /**
     * Checker for the "OdlMDSALService" variable.
     */
    public void checkOdlMDSALService(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALServicefunctiontype" variable.
     */
    public String getOdlMDSALServicefunctiontype() throws SnmpStatusException {
        return OdlMDSALServicefunctiontype;
    }

    /**
     * Setter for the "OdlMDSALServicefunctiontype" variable.
     */
    public void setOdlMDSALServicefunctiontype(String x) throws SnmpStatusException {
        OdlMDSALServicefunctiontype = x;
    }

    /**
     * Checker for the "OdlMDSALServicefunctiontype" variable.
     */
    public void checkOdlMDSALServicefunctiontype(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALSfcfunctionAlgorithms" variable.
     */
    public String getOdlMDSALSfcfunctionAlgorithms() throws SnmpStatusException {
        return OdlMDSALSfcfunctionAlgorithms;
    }

    /**
     * Setter for the "OdlMDSALSfcfunctionAlgorithms" variable.
     */
    public void setOdlMDSALSfcfunctionAlgorithms(String x) throws SnmpStatusException {
        OdlMDSALSfcfunctionAlgorithms = x;
    }

    /**
     * Checker for the "OdlMDSALSfcfunctionAlgorithms" variable.
     */
    public void checkOdlMDSALSfcfunctionAlgorithms(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALSfcfunctiongroups" variable.
     */
    public String getOdlMDSALSfcfunctiongroups() throws SnmpStatusException {
        return OdlMDSALSfcfunctiongroups;
    }

    /**
     * Setter for the "OdlMDSALSfcfunctiongroups" variable.
     */
    public void setOdlMDSALSfcfunctiongroups(String x) throws SnmpStatusException {
        OdlMDSALSfcfunctiongroups = x;
    }

    /**
     * Checker for the "OdlMDSALSfcfunctiongroups" variable.
     */
    public void checkOdlMDSALSfcfunctiongroups(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALSfcfunctionchain" variable.
     */
    public String getOdlMDSALSfcfunctionchain() throws SnmpStatusException {
        return OdlMDSALSfcfunctionchain;
    }

    /**
     * Setter for the "OdlMDSALSfcfunctionchain" variable.
     */
    public void setOdlMDSALSfcfunctionchain(String x) throws SnmpStatusException {
        OdlMDSALSfcfunctionchain = x;
    }

    /**
     * Checker for the "OdlMDSALSfcfunctionchain" variable.
     */
    public void checkOdlMDSALSfcfunctionchain(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALSfcfunction" variable.
     */
    public String getOdlMDSALSfcfunction() throws SnmpStatusException {
        return OdlMDSALSfcfunction;
    }

    /**
     * Setter for the "OdlMDSALSfcfunction" variable.
     */
    public void setOdlMDSALSfcfunction(String x) throws SnmpStatusException {
        OdlMDSALSfcfunction = x;
    }

    /**
     * Checker for the "OdlMDSALSfcfunction" variable.
     */
    public void checkOdlMDSALSfcfunction(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALNetconfConnectedDevices" variable.
     */
    public String getOdlMDSALNetconfConnectedDevices() throws SnmpStatusException {
        return OdlMDSALNetconfConnectedDevices;
    }

    /**
     * Setter for the "OdlMDSALNetconfConnectedDevices" variable.
     */
    public void setOdlMDSALNetconfConnectedDevices(String x) throws SnmpStatusException {
        OdlMDSALNetconfConnectedDevices = x;
    }

    /**
     * Checker for the "OdlMDSALNetconfConnectedDevices" variable.
     */
    public void checkOdlMDSALNetconfConnectedDevices(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALClustershardsshared" variable.
     */
    public String getOdlMDSALClustershardsshared() throws SnmpStatusException {
        return OdlMDSALClustershardsshared;
    }

    /**
     * Setter for the "OdlMDSALClustershardsshared" variable.
     */
    public void setOdlMDSALClustershardsshared(String x) throws SnmpStatusException {
        OdlMDSALClustershardsshared = x;
    }

    /**
     * Checker for the "OdlMDSALClustershardsshared" variable.
     */
    public void checkOdlMDSALClustershardsshared(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

    /**
     * Getter for the "OdlMDSALClusterControllerRole" variable.
     */
    public String getOdlMDSALClusterControllerRole() throws SnmpStatusException {
        return OdlMDSALClusterControllerRole;
    }

    /**
     * Setter for the "OdlMDSALClusterControllerRole" variable.
     */
    public void setOdlMDSALClusterControllerRole(String x) throws SnmpStatusException {
        OdlMDSALClusterControllerRole = x;
    }

    /**
     * Checker for the "OdlMDSALClusterControllerRole" variable.
     */
    public void checkOdlMDSALClusterControllerRole(String x) throws SnmpStatusException {
        //
        // Add your own checking policy.
        //
    }

}
