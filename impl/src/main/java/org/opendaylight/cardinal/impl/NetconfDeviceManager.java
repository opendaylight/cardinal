/*
 * Copyright © 2016 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.NetconfNode;
import java.util.concurrent.TimeUnit;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.network.topology.topology.topology.types.TopologyNetconf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.netconf.rev161227.DevicesBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.netconf.rev161227.cardinalnetconfinfogrouping.Netconf;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.netconf.rev161227.cardinalnetconfinfogrouping.NetconfBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NodeId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Node;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.NodeKey;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataBroker;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.common.api.data.ReadFailedException;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.CommunityTarget;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.SMIConstants;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TableEvent;
import org.snmp4j.util.TableUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@SuppressWarnings({ "deprecation", "unused" })
public class NetconfDeviceManager implements AutoCloseable, DataChangeListener {

    private static final Logger LOG = LoggerFactory.getLogger(NetconfDeviceManager.class);
    private static final InstanceIdentifier<Topology> NODE_IID = InstanceIdentifier.builder(NetworkTopology.class)
            .child(Topology.class, new TopologyKey(new TopologyId(TopologyNetconf.QNAME.getLocalName()))).build();
    private static final InstanceIdentifier<Node> NODE = InstanceIdentifier.builder(NODE_IID).child(Node.class).build();
    private static final ScheduledExecutorService executorService = MoreExecutors
            .listeningDecorator(Executors.newScheduledThreadPool(1));
    private final DataBroker dataBroker;
    private final RpcProviderRegistry rpcProviderRegistry;
    private ListenerRegistration<DataChangeListener> dataChangeListenerRegistration;
    final OID interfacesTable = new OID(".1.3.6.1.3.1.1.16.1");
    SnmpSet set = new SnmpSet();
    DevicesBuilder builder = new DevicesBuilder();
    OdlCardinalNetconfInfoApi odlNetconfApi = new OdlCardinalNetconfInfoApi();
    String netconfNode = null;
    List<String> featureList = new ArrayList<String>();
    Integer nodeSize = 0;
    Integer updatedSize = 0;
    Integer removedPathssize = 0;
    Map<String, List<String>> featureListOid = new HashMap<String, List<String>>();
    Map<String, List<String>> featureListUpdated = new HashMap<String, List<String>>();
    SnmpAgent agent;
    String nodeprevious = "netconf";

    public NetconfDeviceManager(DataBroker dataBroker, RpcProviderRegistry rpcProviderRegistry) {
        this.dataBroker = Preconditions.checkNotNull(dataBroker);
        odlNetconfApi.setDataProvider(dataBroker);
        try {
            agent = new SnmpAgent("0.0.0.0/2001");
            agent.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            LOG.info("Exception instarting snmp Daemon for Netconf");
        }
        this.rpcProviderRegistry = Preconditions.checkNotNull(rpcProviderRegistry);
        dataChangeListenerRegistration = dataBroker.registerDataChangeListener(LogicalDatastoreType.OPERATIONAL, NODE,
                this, AsyncDataBroker.DataChangeScope.BASE);
        if (dataChangeListenerRegistration != null) {
            LOG.info("Listener registered");
        } else {
            LOG.error("Failed to register onDataChanged Listener");
        }
    }

    @Override
    public void close() throws Exception {
        if (dataChangeListenerRegistration != null) {
            LOG.info("Closing onDataChanged listener registration");
            dataChangeListenerRegistration.close();
            dataChangeListenerRegistration = null;
        }
    }

    @Override
    public void onDataChanged(AsyncDataChangeEvent<InstanceIdentifier<?>, DataObject> change) {
        LOG.info("Data change event");
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
        for (String netcNode : featureListUpdated.keySet()) {
            if (netcNode.contains(node)) {
                node = netcNode;
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
            String node = getNode(removedPaths);
            if (removedPathssize == featureList.size()) {
                final OID sysDescr = new OID(".1.3.6.1.2.1.1.1.0");
                final OID interfacesTable = new OID(".1.3.6.1.3.1.1.16.1");
                agent.stop();
                try {
                    agent = new SnmpAgent("0.0.0.0/2001");
                    agent.start();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                }
                agent.unregisterManagedObject(agent.getSnmpv2MIB());
                agent.registerManagedObject(MOScalarFactory.createReadOnly(sysDescr, "MySystemDescr"));
                MOTableBuilder builder = new MOTableBuilder(interfacesTable);
                builder.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                        .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY);
                for (String netConfNode : featureList) {
                    featureListOid.remove(netConfNode);
                }
                if (featureListOid.size() > 2) {
                    for (String netConfNode : featureListOid.keySet()) {
                        List<String> value = featureListOid.get(netConfNode);
                        builder.addRowValue(new OctetString(netConfNode)).addRowValue(new OctetString(value.get(0)))
                                .addRowValue(new OctetString(value.get(1))).addRowValue(new OctetString(value.get(2)))
                                .addRowValue(new OctetString(value.get(3))).addRowValue(new OctetString(value.get(4)));
                    }
                    agent.registerManagedObject(builder.build());
                    featureListUpdated = featureListOid;
                    nodeSize = featureListOid.size();
                    updatedSize = featureListOid.size();
                    gettingTableOid();
                    LOG.info("{} Node(s) removed", removedPaths.size());
                } else {
                    int j = 14;
                    for (String netConfNode : featureListOid.keySet()) {
                        List<String> value = featureListOid.get(netConfNode);
                        try {
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".1.0", netConfNode);
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".2.0", value.get(0));
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".3.0", value.get(1));
                            set.setVariableString(".1.3.6.1.3.1.1." + j + ".4.0", value.get(2));
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            LOG.info("Exception due to removed path");
                            // e.printStackTrace();
                        }
                        j++;
                    }
                    odlNetconfApi.setValues(featureListOid);
                    featureListUpdated = featureListOid;
                    nodeSize = featureListOid.size();
                    updatedSize = featureListOid.size();
                }
            }
        }
    }

    private void handleDataUpdated(Map<InstanceIdentifier<?>, DataObject> updatedData) {
        Preconditions.checkNotNull(updatedData);
        if (!updatedData.isEmpty()) {
            LOG.info("{} Node(s) updated", updatedData.size());
        }
    }

    private void handleDataCreated(Map<InstanceIdentifier<?>, DataObject> createdData) {
        Preconditions.checkNotNull(createdData);
        if (!createdData.isEmpty()) {
            for (Map.Entry<InstanceIdentifier<?>, DataObject> dataObjectEntry : createdData.entrySet()) {
                nodeSize = nodeSize + 1;
                @SuppressWarnings("unchecked")
                final InstanceIdentifier<Node> path = (InstanceIdentifier<Node>) dataObjectEntry.getKey();
                LOG.info("Created node {}", path.toString());
                Future<Void> submit = executorService.schedule(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
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
                    }
                }, 25, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void identifyDevice(final InstanceIdentifier<Node> path, Node node) {
        LOG.info("  Attempting to identify '{}'", node.getKey().getNodeId().getValue().toString());
        String nodeName = null;
        String host = null;
        String port = null;
        String status = null;
        LOG.info("Read updated node");
        List<String> nodeValues = new ArrayList<String>();

        nodeName = node.getKey().getNodeId().getValue().toString();
        host = node.getAugmentation(NetconfNode.class).getHost().getIpAddress().getIpv4Address().getValue().toString();
        port = node.getAugmentation(NetconfNode.class).getPort().getValue().toString();
        status = node.getAugmentation(NetconfNode.class).getConnectionStatus().getName().toString();
        try {
            nodeValues.add(host);
            nodeValues.add(port);
            nodeValues.add(status);
            nodeValues.add(" ");
            nodeValues.add(" ");
            if (nodeName != nodeprevious) {
                featureListOid.put(nodeName, nodeValues);
                LOG.info("  featureListOid  {}", featureListOid);
                updatedSize = updatedSize + 1;
                nodeprevious = nodeName;
            }
            if (featureListOid.size() > 2) {
                removedPathssize = 0;
                featureList.clear();
                featureListUpdated = featureListOid;
                LOG.info("  featureListOid size {}", featureListOid.size());
                setNetconfOid(featureListOid);
                int j = 14;
                for (int i = 0; i < 2; i++) {
                    List<String> value = featureListOid.get(netconfNode);
                    set.setVariableString(".1.3.6.1.3.1.1." + j + ".1.0", "");
                    set.setVariableString(".1.3.6.1.3.1.1." + j + ".2.0", "");
                    set.setVariableString(".1.3.6.1.3.1.1." + j + ".3.0", "");
                    set.setVariableString(".1.3.6.1.3.1.1." + j + ".4.0", "");
                    j++;
                }
            } else {
                int j = 14;
                for (String netconfNode : featureListOid.keySet()) {
                    List<String> value = featureListOid.get(netconfNode);
                    set.setVariableString(".1.3.6.1.3.1.1." + j + ".1.0", netconfNode);
                    set.setVariableString(".1.3.6.1.3.1.1." + j + ".2.0", value.get(0));
                    set.setVariableString(".1.3.6.1.3.1.1." + j + ".3.0", value.get(1));
                    set.setVariableString(".1.3.6.1.3.1.1." + j + ".4.0", value.get(2));
                    j++;
                }
                odlNetconfApi.setValues(featureListOid);
                removedPathssize = 0;
                featureList.clear();
                featureListUpdated = featureListOid;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOG.info("............ Exception in Netconf {}", e);
        }
    }

    private boolean setNetconfOid(Map<String, List<String>> netconfList) throws IOException {
        agent.stop();
        agent = new SnmpAgent("0.0.0.0/2001");
        agent.start();
        agent.unregisterManagedObject(agent.getSnmpv2MIB());
        MOTableBuilder builder = new MOTableBuilder(interfacesTable);
        builder.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY)
                .addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY);
        for (String netconfNode : netconfList.keySet()) {
            List<String> value = netconfList.get(netconfNode);
            builder.addRowValue(new OctetString(netconfNode)).addRowValue(new OctetString(value.get(0)))
                    .addRowValue(new OctetString(value.get(1))).addRowValue(new OctetString(value.get(2)))
                    .addRowValue(new OctetString(value.get(3))).addRowValue(new OctetString(value.get(4)));
        }
        agent.registerManagedObject(builder.build());
        gettingTableOid();
        return true;

    }

    public void gettingTableOid() {
        NetconfBuilder flow = new NetconfBuilder();
        List<Netconf> netconflist = new ArrayList<Netconf>();
        List<List<String>> list = new ArrayList<List<String>>();

        try {
            TransportMapping transport = new DefaultUdpTransportMapping();
            Snmp snmp = new Snmp(transport);
            transport.listen();
            TableUtils tUtils = new TableUtils(snmp, new DefaultPDUFactory());
            Address targetAddress = GenericAddress.parse("udp:127.0.0.1/2001");
            CommunityTarget target = new CommunityTarget();
            target.setCommunity(new OctetString("public"));
            target.setAddress(targetAddress);
            target.setRetries(2);
            target.setTimeout(1500);
            target.setVersion(SnmpConstants.version2c);
            OID[] oid = new OID[] { new OID(interfacesTable.toString() + ".1"),
                    new OID(interfacesTable.toString() + ".2"), new OID(interfacesTable.toString() + ".3"),
                    new OID(interfacesTable.toString() + ".4") };
            List<TableEvent> events = tUtils.getTable(target, oid, null, null);

            for (TableEvent event : events) {
                List<String> strList = new ArrayList<String>();
                list.add(strList);
                for (VariableBinding vb : event.getColumns()) {
                    strList.add(vb.getVariable().toString());
                }
            }
        } catch (IOException e) {
            // e.printStackTrace();
            LOG.info("IOException :{}", e);
        }

        LOG.info("NetConf Table :{}", list);
        SimpleSnmpClient client = new SimpleSnmpClient("udp:127.0.0.1/2001");
        List<List<String>> tableContents = client.getTableAsStrings(
                new OID[] { new OID(interfacesTable.toString() + ".1"), new OID(interfacesTable.toString() + ".2"),
                        new OID(interfacesTable.toString() + ".3"), new OID(interfacesTable.toString() + ".4") });
        LOG.info("NetConf Table :{}", tableContents);
        for (int i = 0; i < list.size(); i++) {
            String nodeName = tableContents.get(i).get(0);
            String host = tableContents.get(i).get(1);
            String port = tableContents.get(i).get(2);
            String status = tableContents.get(i).get(3);
            flow.setNodeId(nodeName).setHost(host).setPort(port).setStatus(status).build();
            netconflist.add(flow.build());
        }
        builder.setNetconf(netconflist);
        builder.build();
        odlNetconfApi.setNetConfValues(builder.build());
    }
}
