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
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataBroker;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.common.api.data.ReadFailedException;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpAddress;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev130715.MacAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//TODO: maintain closed state
@SuppressWarnings({ "deprecation", "unused" })
public class OpenflowDeviceManager implements DataChangeListener, AutoCloseable {
	private static final Logger LOG = LoggerFactory.getLogger(OpenflowDeviceManager.class);
	private static final InstanceIdentifier<Node> NODE_IID = InstanceIdentifier.builder(Nodes.class).child(Node.class)
			.build();
	private static final ScheduledExecutorService executorService = MoreExecutors
			.listeningDecorator(Executors.newScheduledThreadPool(1));
	private final DataBroker dataBroker;
	private final RpcProviderRegistry rpcProviderRegistry;
	private ListenerRegistration<DataChangeListener> dataChangeListenerRegistration;
	SnmpSet set = new SnmpSet();
	// OdlCardinalOpenflowInfoApi odlOpenflowApi = new
	// OdlCardinalOpenflowInfoApi();
	String status = "NotConnected";
	String openFlowNode = null;

	public OpenflowDeviceManager(DataBroker dataBroker, RpcProviderRegistry rpcProviderRegistry) {
		this.dataBroker = Preconditions.checkNotNull(dataBroker);
		// odlOpenflowApi.setDataProvider(dataBroker);
		this.rpcProviderRegistry = Preconditions.checkNotNull(rpcProviderRegistry);
		dataChangeListenerRegistration = dataBroker.registerDataChangeListener(LogicalDatastoreType.OPERATIONAL,
				NODE_IID, this, AsyncDataBroker.DataChangeScope.BASE);
		if (dataChangeListenerRegistration != null) {
			LOG.info("Listener registered");
		} else {
			LOG.error("Failed to register onDataChanged Listener");
		}
	}

	@Override
	public void close() throws Exception {
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

	private void handleDataRemoved(Set<InstanceIdentifier<?>> removedPaths) {
		// TODO Auto-generated method stub
		Preconditions.checkNotNull(removedPaths);
		if (!removedPaths.isEmpty()) {
			try {
				set.setVariableString(".1.3.6.1.3.1.1.11.1.0", openFlowNode);
				set.setVariableString(".1.3.6.1.3.1.1.11.2.0", " ");
				set.setVariableString(".1.3.6.1.3.1.1.11.3.0", " ");
				set.setVariableString(".1.3.6.1.3.1.1.11.4.0", " ");
				set.setVariableString(".1.3.6.1.3.1.1.11.5.0", "Not Connected");
				set.setVariableString(".1.3.6.1.3.1.1.11.6.0", " ");
				set.setVariableString(".1.3.6.1.3.1.1.11.7.0", " ");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

			// odlOpenflowApi.setValues();
			LOG.info("{} Node(s) removed", removedPaths.size());
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
				@SuppressWarnings("unchecked")
				final InstanceIdentifier<Node> path = (InstanceIdentifier<Node>) dataObjectEntry.getKey();
				LOG.info("Created node {}", path.toString());
				// sleep 25ms and then re-read the Node information to give OF
				// a change to update with FlowCapable
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
		LOG.debug("Attempting to identify '{}'", node.getId().toString());
		String hardware = null;
		String macaddress = null;
		String interfaceName = null;
		String manufacturer = null;
		String openFlowStats = null;
		String openFlowMeterstats = null;
		LOG.info("Read updated node");
		FlowCapableNode flowCapableNode = node.getAugmentation(FlowCapableNode.class);
		// TODO: this needs to register for data change on hardware or something
		// because it's really still empty at this point
		List<NodeConnector> conn = node.getNodeConnector();
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
				set.setVariableString(".1.3.6.1.3.1.1.11.1.0", openFlowNode);
				set.setVariableString(".1.3.6.1.3.1.1.11.2.0", interfaceName);
				set.setVariableString(".1.3.6.1.3.1.1.11.3.0", macaddress);
				set.setVariableString(".1.3.6.1.3.1.1.11.4.0", manufacturer);
				set.setVariableString(".1.3.6.1.3.1.1.11.5.0", status);
				set.setVariableString(".1.3.6.1.3.1.1.11.6.0", " ");
				set.setVariableString(".1.3.6.1.3.1.1.11.7.0", " ");
				// odlOpenflowApi.setValues();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LOG.info("Start snmp daemon from root");
			}
			if (flowCapableNode.getIpAddress() != null) {
				IpAddress ip;
				ip = flowCapableNode.getIpAddress();
				String ipStr = ip.getIpv4Address().getValue();
			}
		} else {
			// else of flowCapableNodeconn
		}
	}
}