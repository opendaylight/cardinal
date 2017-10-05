/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import com.google.common.base.Preconditions;
import org.opendaylight.controller.md.sal.binding.api.*;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.setsnmptrapaddr.rev170509.TrapAcl;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Created by anirban on 14/5/17.
 */
public class TrapAddressChangeHandler implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(TrapAddressChangeHandler.class);
    private final Agent snmpAgent;
    private final DataBroker dataProvider;
    private ClusteredDataTreeChangeListener<TrapAcl> configDataTreeTrapAddrChangeListener;
    private ListenerRegistration<? extends ClusteredDataTreeChangeListener<TrapAcl>> listener;

    public TrapAddressChangeHandler(@Nonnull final Agent snmpAgent, @Nonnull final DataBroker db) {
        dataProvider = db;
        this.snmpAgent = snmpAgent;
        registerForAddressChange();
    }

    private void setTrapAddressAtAgent(@Nonnull DataObjectModification<TrapAcl> trapAddressChange) {
        try {
            switch (trapAddressChange.getModificationType()) {
                case SUBTREE_MODIFIED:
                    LOG.info("Trap Address SUBTREE_MODIFIED??");
                    break;
                case DELETE:
                    LOG.info("Trap Address DELETED");
                    break;
                case WRITE:
                    final TrapAcl trapAddr = trapAddressChange.getDataAfter();
                    LOG.info("Trap Address : " + trapAddr.getTrapCommunity() + " " + trapAddr.getTrapAddress().getValue());
                    snmpAgent.setTrapAddress(trapAddr.getTrapCommunity(), trapAddr.getTrapAddress().getValue());
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleTrapAddressChange(@Nonnull Collection<DataTreeModification<TrapAcl>> changes) {
        for (DataTreeModification<TrapAcl> trapAddressChangeData : changes) {
            final DataTreeIdentifier<TrapAcl> iid = trapAddressChangeData.getRootPath();
            final LogicalDatastoreType dataStoreType = iid.getDatastoreType();
            if (dataStoreType == LogicalDatastoreType.CONFIGURATION) {
                setTrapAddressAtAgent(trapAddressChangeData.getRootNode());
            }
        }
    }

    private void registerForAddressChange() {
        try {
            InstanceIdentifier<TrapAcl> trapAclIID =
                    Preconditions.checkNotNull(InstanceIdentifier.create(TrapAcl.class),
                            "TrapAcl IID should not be null");

            DataTreeIdentifier<TrapAcl> configDataTreeTrapAclId =
                    new DataTreeIdentifier<>(LogicalDatastoreType.CONFIGURATION, trapAclIID);
            configDataTreeTrapAddrChangeListener = new ClusteredDataTreeChangeListener<TrapAcl>() {
                @Override
                public void onDataTreeChanged(Collection<DataTreeModification<TrapAcl>> changes) {
                    handleTrapAddressChange(changes);
                }
            };
            listener = dataProvider.registerDataTreeChangeListener(configDataTreeTrapAclId,
                    configDataTreeTrapAddrChangeListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            listener.close();
            listener = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

