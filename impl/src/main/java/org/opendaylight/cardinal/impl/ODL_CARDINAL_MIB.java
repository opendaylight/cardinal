/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;


import java.io.Serializable;
import java.util.Hashtable;

import javax.management.InstanceAlreadyExistsException;
// jmx imports
//
import javax.management.MBeanServer;
import javax.management.ObjectName;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

/**
 * The class is used for representing "ODL-CARDINAL-MIB". You can edit the file
 * if you want to modify the behavior of the MIB.
 */
public class ODL_CARDINAL_MIB extends SnmpMib implements Serializable {

    /**
     * Default constructor. Initialize the Mib tree.
     */
    public ODL_CARDINAL_MIB() {
        mibName = "ODL_CARDINAL_MIB";
    }

    /**
     * Initialization of the MIB with no registration in Java DMK.
     */
    public void init() throws IllegalAccessException {
        // Allow only one initialization of the MIB.
        //
        if (isInitialized == true) {
            return;
        }

        try {
            populate(null, null);
        } catch (IllegalAccessException x) {
            throw x;
        } catch (RuntimeException x) {
            throw x;
        } catch (Exception x) {
            throw new Error(x.getMessage());
        }

        isInitialized = true;
    }

    /**
     * Initialization of the MIB with AUTOMATIC REGISTRATION in Java DMK.
     */
    public ObjectName preRegister(MBeanServer server, ObjectName name) throws Exception {
        // Allow only one initialization of the MIB.
        //
        if (isInitialized == true) {
            throw new InstanceAlreadyExistsException();
        }

        // Initialize MBeanServer information.
        //
        this.server = server;

        populate(server, name);

        isInitialized = true;
        return name;
    }

    /**
     * Initialization of the MIB with no registration in Java DMK.
     */
    public void populate(MBeanServer server, ObjectName name) throws Exception {
        // Allow only one initialization of the MIB.
        //
        if (isInitialized == true) {
            return;
        }

        if (objectserver == null)
            objectserver = new SnmpStandardObjectServer();

        // Initialization of the "OdlCardinalModule" group.
        // To disable support of this group, redefine the
        // "createOdlCardinalModuleMetaNode()" factory method, and make it
        // return "null"
        //
        initOdlCardinalModule(server);

        isInitialized = true;
    }

    // ------------------------------------------------------------
    //
    // Initialization of the "OdlCardinalModule" group.
    //
    // ------------------------------------------------------------

    /**
     * Initialization of the "OdlCardinalModule" group.
     * 
     * To disable support of this group, redefine the
     * "createOdlCardinalModuleMetaNode()" factory method, and make it return
     * "null"
     * 
     * @param server
     *            MBeanServer for this group (may be null)
     * 
     **/
    protected void initOdlCardinalModule(MBeanServer server) throws Exception {
        final String oid = getGroupOid("OdlCardinalModule", "1.3.6.1.3.1.1.1");
        ObjectName objname = null;
        if (server != null) {
            objname = getGroupObjectName("OdlCardinalModule", oid, mibName + ":name=OdlCardinalModule");
        }
        final OdlCardinalModuleMeta meta = createOdlCardinalModuleMetaNode("OdlCardinalModule", oid, objname, server);
        if (meta != null) {
            meta.registerTableNodes(this, server);

            // Note that when using standard metadata,
            // the returned object must implement the "OdlCardinalModuleMBean"
            // interface.
            //
            final OdlCardinalModuleMBean group = (OdlCardinalModuleMBean) createOdlCardinalModuleMBean(
                    "OdlCardinalModule", oid, objname, server);
            meta.setInstance(group);
            registerGroupNode("OdlCardinalModule", oid, objname, meta, group, server);
        }
    }

    /**
     * Factory method for "OdlCardinalModule" group metadata class.
     * 
     * You can redefine this method if you need to replace the default generated
     * metadata class with your own customized class.
     * 
     * @param groupName
     *            Name of the group ("OdlCardinalModule")
     * @param groupOid
     *            OID of this group
     * @param groupObjname
     *            ObjectName for this group (may be null)
     * @param server
     *            MBeanServer for this group (may be null)
     * 
     * @return An instance of the metadata class generated for the
     *         "OdlCardinalModule" group (OdlCardinalModuleMeta)
     * 
     **/
    protected OdlCardinalModuleMeta createOdlCardinalModuleMetaNode(String groupName, String groupOid,
            ObjectName groupObjname, MBeanServer server) {
        return new OdlCardinalModuleMeta(this, objectserver);
    }

    /**
     * Factory method for "OdlCardinalModule" group MBean.
     * 
     * You can redefine this method if you need to replace the default generated
     * MBean class with your own customized class.
     * 
     * @param groupName
     *            Name of the group ("OdlCardinalModule")
     * @param groupOid
     *            OID of this group
     * @param groupObjname
     *            ObjectName for this group (may be null)
     * @param server
     *            MBeanServer for this group (may be null)
     * 
     * @return An instance of the MBean class generated for the
     *         "OdlCardinalModule" group (OdlCardinalModule)
     * 
     *         Note that when using standard metadata, the returned object must
     *         implement the "OdlCardinalModuleMBean" interface.
     **/
    protected Object createOdlCardinalModuleMBean(String groupName, String groupOid, ObjectName groupObjname,
            MBeanServer server) {

        // Note that when using standard metadata,
        // the returned object must implement the "OdlCardinalModuleMBean"
        // interface.
        //
        if (server != null)
            return new OdlCardinalModule(this, server);
        else
            return new OdlCardinalModule(this);
    }

    // ------------------------------------------------------------
    //
    // Implements the "registerTableMeta" method defined in "SnmpMib".
    // See the "SnmpMib" Javadoc API for more details.
    //
    // ------------------------------------------------------------

    public void registerTableMeta(String name, SnmpMibTable meta) {
        if (metadatas == null)
            return;
        if (name == null)
            return;
        metadatas.put(name, meta);
    }

    // ------------------------------------------------------------
    //
    // Implements the "getRegisteredTableMeta" method defined in "SnmpMib".
    // See the "SnmpMib" Javadoc API for more details.
    //
    // ------------------------------------------------------------

    public SnmpMibTable getRegisteredTableMeta(String name) {
        if (metadatas == null)
            return null;
        if (name == null)
            return null;
        return (SnmpMibTable) metadatas.get(name);
    }

    public SnmpStandardObjectServer getStandardObjectServer() {
        if (objectserver == null)
            objectserver = new SnmpStandardObjectServer();
        return objectserver;
    }

    private boolean isInitialized = false;

    protected SnmpStandardObjectServer objectserver;

    protected final Hashtable metadatas = new Hashtable();
}
