/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataBroker;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.common.api.data.ReadFailedException;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.DevicesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.Openflow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.openflow.rev161128.cardinalopenflowinfogrouping.OpenflowBuilder;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.SMIConstants;

/**
 *
 * @author Subodh Roy
 *
 */
// TODO: maintain closed state
@SuppressWarnings({ "deprecation", "unused" })
public class OpenflowDeviceManager implements DataChangeListener, AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(OpenflowDeviceManager.class);
    private static final InstanceIdentifier<Node> NODE_IID = InstanceIdentifier.builder(Nodes.class).child(Node.class)
            .build();
    private static final ScheduledExecutorService executorService = MoreExecutors
            .listeningDecorator(Executors.newScheduledThreadPool(1));
    private final DataBroker dataBroker;
    SnmpAgent agent;
    private ListenerRegistration<DataChangeListener> dataChangeListenerRegistration;
    SnmpSet set = new SnmpSet();
    DevicesBuilder builder = new DevicesBuilder();
    OdlCardinalOpenflowInfoApi odlOpenflowApi = new OdlCardinalOpenflowInfoApi();
    String status = "NotConnected";
    String openFlowNode = null;
    String nodeprevious = "ovs";
    Integer nodeSize = 0;
    Integer updatedSize = 0;
    Integer removedPathssize = 0;
    final OID sysDescr = new OID(".1.3.6.1.2.1.1.1.0");
    final OID interfacesTable = new OID(".1.3.6.1.3.1.1.11.1");
    Map<String, List<String>> featureListOid = new HashMap<>();
    Map<String, List<String>> featureListUpdated = new HashMap<>();
    List<String> featureList = new ArrayList<>();

    public OpenflowDeviceManager(DataBroker dataBroker, SnmpAgent sagent) {
        this.dataBroker = Preconditions.checkNotNull(dataBroker);
        odlOpenflowApi.setDataProvider(dataBroker);
        agent = sagent;
        dataChangeListenerRegistration = dataBroker.registerDataChangeListener(LogicalDatastoreType.OPERATIONAL,
                NODE_IID, this, AsyncDataBroker.DataChangeScope.BASE);
        if (dataChangeListenerRegistration != null) {
            LOG.info("Listener registered");
        } else {
            LOG.error("Failed to register onDataChanged Listener");
        }
    }

    @Override
    public void close() {
        if (dataChangeListenerRegistration != null) {
            LOG.info("closing onDataChanged listener registration");
            dataChangeListenerRegistration.close();
            dataChangeListenerRegistration = null;
        }
    }

    @Override
    public void onDataChanged(AsyncDataChangeEvent<InstanceIdentifier<?>, DataObject> change) {
        LOG.info("data change event");
        handleDataCreated(change.getCreatedData());
        handleDataUpdated(change.getUpdatedData());
        handleDataRemoved(change.getRemovedPaths());
    }

    public String getNode(Set<InstanceIdentifier<?>> Paths) {
        int index1 = Paths.toString().lastIndexOf("value=");
        int index2 = Paths.toString().lastIndexOf("]]]]}");
        String node1 = Paths.toString().substring(index1, index2);
        String[] nodevalues = node1.split("value=");
        String node = nodevalues[1];
        //for (String ovsNode : featureListUpdated.keySet()) {featureListOid
        for (String ovsNode : featureListOid.keySet()) {
            if (ovsNode.contains(node)) {
                node = ovsNode;
                featureList.add(node);
            }
        }
        return node;
    }

    private void handleDataRemoved(Set<InstanceIdentifier<?>> removedPaths) {
        // TODO Auto-generated method stub
        Preconditions.checkNotNull(removedPaths);
        if (!removedPaths.isEmpty()) {
            removedPathssize++;
            LOG.info("Removed path is {}", removedPathssize);
            LOG.info("featureList size is {}", featureList.size());
            String node = getNode(removedPaths);
           // if (removedPathssize == featureList.size()) {
                final OID sysDescr = new OID(".1.3.6.1.2.1.1.1.0");
                final OID interfacesTable = new OID(".1.3.6.1.3.1.1.13.1");
                agent.stop();
                try {
                    agent = new SnmpAgent("0.0.0.0/2003");
                    agent.start();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                agent.unregisterManagedObject(agent.getSnmpv2MIB());
                agent.registerManagedObject(MOScalarFactory.createReadOnly(sysDescr, "MySystemDescr"));
                MOTableBuilder builder = new MOTableBuilder(interfacesTable)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY);
                for (String ovsNode : featureList) {
                    if(featureList.contains(ovsNode)) {
                        featureListOid.remove(ovsNode);
                        LOG.info("featureListOid size is {}", featureListOid.size());
                    }
                }
                if (featureListOid.size() > 2) {
                    for (String ovsNode : featureListOid.keySet()) {
                        List<String> value = featureListOid.get(ovsNode);
                        builder.addRowValue(new OctetString(ovsNode)).addRowValue(new OctetString(value.get(0)))
                                .addRowValue(new OctetString(value.get(1))).addRowValue(new OctetString(value.get(2)))
                                .addRowValue(new OctetString(value.get(3))).addRowValue(new OctetString(value.get(4)))
                                .addRowValue(new OctetString(value.get(5)));
                    }
                    agent.registerManagedObject(builder.build());
                    featureListUpdated = featureListOid;
                    //nodeSize = featureListOid.size();
                    updatedSize = featureListOid.size();
                    nodeSize=0;
                    gettingTableOid();
                    LOG.info("{} Node(s) removed", removedPaths.size());
                } else if (featureListOid.size() == 0) {
                    int j = 11;
                    for (int i = 0; i < 2; i++) {
                        try {
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".1.0", "");
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".2.0", "");
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".3.0", "");
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".4.0", "");
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".5.0", "");
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".6.0", "");
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".7.0", "");
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        j++;
                    }
                    odlOpenflowApi.setValues(featureListOid);
                    featureListUpdated = featureListOid;
                    //nodeSize = featureListOid.size();
                    updatedSize = featureListOid.size();
                    nodeSize=0;
                } else {
                    int j = 11;
                    for (String ovsNode : featureListOid.keySet()) {
                        List<String> value = featureListOid.get(ovsNode);
                        try {
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".1.0", ovsNode);
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".2.0", value.get(0));
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".3.0", value.get(1));
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".4.0", value.get(2));
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".5.0", value.get(3));
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".6.0", " ");
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".7.0", " ");
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        j++;
                    }
                    odlOpenflowApi.setValues(featureListOid);
                    featureListUpdated = featureListOid;
                    //nodeSize = featureListOid.size();
                    updatedSize = featureListOid.size();
                    nodeSize=0;
                }
            //}
        }
    }

    private void handleDataUpdated(Map<InstanceIdentifier<?>, DataObject> updatedData) {
        Preconditions.checkNotNull(updatedData);
        LOG.info("handle Node(s) updated {}", updatedData);
        if (!updatedData.isEmpty()) {
            LOG.info("{} Node(s) updated", updatedData.size());
        }
    }

    private void handleDataCreated(Map<InstanceIdentifier<?>, DataObject> createdData) {
        Preconditions.checkNotNull(createdData);
        if (!createdData.isEmpty()) {
            for (Map.Entry<InstanceIdentifier<?>, DataObject> dataObjectEntry : createdData.entrySet()) {
                nodeSize = nodeSize + 1;
                LOG.info("Created nodeSize {}", nodeSize);
                @SuppressWarnings("unchecked")
                final InstanceIdentifier<Node> path = (InstanceIdentifier<Node>) dataObjectEntry.getKey();
                LOG.info("Created node {}", path.toString());
                // sleep 25ms and then re-read the Node information to give OF
                // a change to update with FlowCapable
                Future<Void> submit = executorService.schedule(() -> {
                    ReadOnlyTransaction readOnlyTransaction = dataBroker.newReadOnlyTransaction();
                    final CheckedFuture<Optional<Node>, ReadFailedException> readFuture = readOnlyTransaction
                            .read(LogicalDatastoreType.OPERATIONAL, path);
                    Futures.addCallback(readFuture, new FutureCallback<Optional<Node>>() {
                        @Override
                        public void onSuccess(Optional<Node> result) {
                            if (result.isPresent()) {
                                identifyDevice(path, result.get());
                            } else {
                                LOG.error("Read succeeded, node doesn't exist: {}", path);
                            }
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            LOG.error("Failed to read Node: {}", path, t);
                        }
                    });
                    return null;
                }, 5000, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void identifyDevice(final InstanceIdentifier<Node> path, Node node) {
        LOG.debug("Attempting to identify ", node.getId().toString());
        String hardware = null;
        String macaddress = null;
        String interfaceName = null;
        String manufacturer = null;
        String openFlowStats = " ";
        String openFlowMeterstats = " ";
        List<String> nodeValues = new ArrayList<>();
        LOG.info("Read created node");
        FlowCapableNode flowCapableNode = node.getAugmentation(FlowCapableNode.class);
        // TODO: this needs to register for data change on hardware or something
        // because it's really still empty at this point
        List<NodeConnector> conn = node.getNodeConnector();
        openFlowNode = node.getId().getValue();
        NodeConnector nodeconn = conn.get(0);
        FlowCapableNodeConnector flowCapableNodeconn = nodeconn.getAugmentation(FlowCapableNodeConnector.class);
        if (flowCapableNodeconn != null) {
            NodeConnectorKey nodekey = nodeconn.getKey();
            NodeConnectorId nodekey1 = nodekey.getId();
            openFlowNode = nodekey1.getValue();
            interfaceName = flowCapableNodeconn.getName();
            macaddress = flowCapableNodeconn.getHardwareAddress().getValue();
            hardware = flowCapableNode.getHardware();
            manufacturer = flowCapableNode.getManufacturer();
            status = "Connected";
            try {
                nodeValues.add(interfaceName);
                nodeValues.add(macaddress);
                nodeValues.add(manufacturer);
                nodeValues.add(status);
                nodeValues.add(openFlowStats);
                nodeValues.add(openFlowMeterstats);
                /* to create map for the ovsnode and its values */
                if (openFlowNode != nodeprevious) {
                    featureListOid.put(openFlowNode, nodeValues);
                    updatedSize = updatedSize + 1;
                    nodeprevious = openFlowNode;
                }
                if (featureListOid.size() > 2) {
                    removedPathssize = 0;
                    featureList.clear();
                    featureListUpdated = featureListOid;
                    setOvsSwitchOid(featureListOid);
                    LOG.info("featureListOid size {}", featureListOid.size());
                    int j = 11;
                    for (int i = 0; i < 2; i++) {
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".1.0", "");
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".2.0", "");
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".3.0", "");
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".4.0", "");
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".5.0", "");
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".6.0", "");
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".7.0", "");
                        j++;
                    }

                } else {
                    int j = 11;
                    for (String ovsNode : featureListOid.keySet()) {
                        List<String> value = featureListOid.get(ovsNode);
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".1.0", ovsNode);
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".2.0", value.get(0));
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".3.0", value.get(1));
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".4.0", value.get(2));
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".5.0", value.get(3));
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".6.0", " ");
                        set.setVariableString(".1.3.6.1.3.1.1." + j + ".7.0", " ");
                        j++;
                    }
                    odlOpenflowApi.setValues(featureListOid);
                    removedPathssize = 0;
                    featureList.clear();
                    featureListUpdated = featureListOid;

                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                LOG.info("Exception  {}", e);
            }
        }
    }

    public boolean setOvsSwitchOid(Map<String, List<String>> ovsList) throws IOException {
        ovsList.entrySet().size();
        final OID sysDescr = new OID(".1.3.6.1.2.1.1.1.0");
        final OID interfacesTable = new OID(".1.3.6.1.3.1.1.11.1");
        agent.stop();
        agent = new SnmpAgent("0.0.0.0/2003");
        agent.start();
        agent.unregisterManagedObject(agent.getSnmpv2MIB());
        // Register a system description, use one from you product environment
        // to test with
        agent.registerManagedObject(MOScalarFactory.createReadOnly(sysDescr, "MySystemDescr"));
        MOTableBuilder builder = new MOTableBuilder(interfacesTable)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY);
        for (String ovsNode : ovsList.keySet()) {
            List<String> value = ovsList.get(ovsNode);
            builder.addRowValue(new OctetString(ovsNode)).addRowValue(new OctetString(value.get(0)))
                    .addRowValue(new OctetString(value.get(1))).addRowValue(new OctetString(value.get(2)))
                    .addRowValue(new OctetString(value.get(3))).addRowValue(new OctetString(value.get(4)))
                    .addRowValue(new OctetString(value.get(5)));
        }
        agent.registerManagedObject(builder.build());
        gettingTableOid();
        return true;
    }

    public void gettingTableOid() {
        OpenflowBuilder flow = new OpenflowBuilder();
        List<Openflow> openflowlist = new ArrayList<>();
        final OID interfacesTable = new OID(".1.3.6.1.3.1.1.11.1");
        SimpleSnmpClient client = new SimpleSnmpClient("udp:127.0.0.1/2003");
        List<List<String>> tableContents = client
                .getTableAsStrings(new OID[] { new OID(interfacesTable.toString() + ".1"),
                        new OID(interfacesTable.toString() + ".2"), new OID(interfacesTable.toString() + ".3"),
                        new OID(interfacesTable.toString() + ".4"), new OID(interfacesTable.toString() + ".5") });
        LOG.info("openFlowNode Table :{}", tableContents);
        for (int i = 0; i < tableContents.size(); i++) {
            String openFlowNode = tableContents.get(i).get(0);
            String interfaceName = tableContents.get(i).get(1);
            String macaddress = tableContents.get(i).get(2);
            String manufacturer = tableContents.get(i).get(3);
            String status = tableContents.get(i).get(4);
            String openFlowStats = " ";
            String openFlowMeterstats = " ";
            flow.setNodeName(openFlowNode).setInterface(interfaceName).setMacAddress(macaddress)
                    .setManufacturer(manufacturer).setStatus(status).setFlowStats(openFlowStats)
                    .setMeterStats(openFlowMeterstats);
            openflowlist.add(flow.build());
        }
        builder.setOpenflow(openflowlist);
        builder.build();
        odlOpenflowApi.setOvsValues(builder.build());
    }
}
