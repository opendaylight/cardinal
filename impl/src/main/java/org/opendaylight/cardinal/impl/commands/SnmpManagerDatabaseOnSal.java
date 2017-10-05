/*
 * Copyright (c) 2017 Ericsson India Global Services Pvt Ltd. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl.commands;
/**
 * Created by Kushagra Rastogi on 8/11/2017.
 */
import org.opendaylight.controller.md.sal.binding.api.ReadTransaction;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.TransactionCommitFailedException;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.setsnmptrapaddr.rev170509.TrapAcl;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.setsnmptrapaddr.rev170509.TrapAclBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.cardinal.setsnmptrapaddr.rev170509.Ipv4Address;

import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.FutureCallback;

import javax.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

public class SnmpManagerDatabaseOnSal {
    private static final Logger LOG = LoggerFactory.getLogger(SnmpManagerDatabaseOnSal.class);
    private DataBroker db = null;
    private TrapAcl trapAcl = null;

    public SnmpManagerDatabaseOnSal(DataBroker db) {
        LOG.info("Instanciating SnmpManagerDatabaseOnSal");
        this.db = db;
    }

    public String getSnmpManagerAddress()throws InterruptedException,ExecutionException {
        try {
            LOG.debug("reading Snmp Manager Address");
            ReadTransaction rtx = null;
            String temp = null;
            rtx = db.newReadOnlyTransaction();
            temp = rtx.read(LogicalDatastoreType.CONFIGURATION, InstanceIdentifier.builder(TrapAcl.class).build()).get().get().getTrapAddress().toString();
            LOG.info("SNMP Manager Address = {}", temp);
            return temp;
        }
        catch(NullPointerException e){
            LOG.error("Snmp Manager Address not in dataStore");
            return null;
        }
        catch(IllegalStateException e){
            LOG.error("Snmp Manager Address not in dataStore");
            return null;
        }
    }

    public String getTrapAclCommunity()throws InterruptedException,ExecutionException {
        try {
            LOG.debug("reading Trap Acl Community");
            ReadTransaction rtx = null;
            String temp = null;
            rtx = db.newReadOnlyTransaction();
            temp = rtx.read(LogicalDatastoreType.CONFIGURATION, InstanceIdentifier.builder(TrapAcl.class).build()).get().get().getTrapCommunity();
            LOG.info("Trap Acl Community = {}", temp);
            return temp;
        }
        catch(NullPointerException e){
            LOG.error("Trap Acl Community not in dataStore");
            return null;
        }
        catch(IllegalStateException e){
            LOG.error("Trap Acl Community not in dataStore");
            return null;
        }
    }

    public void setSnmpManagerConfiguration(@Nonnull String snmpManagerAddress, @Nonnull String trapAclCommunity){
        LOG.debug("SNMP Manager Address and TrapAclCommunity write on datastore");
        WriteTransaction wtx = db.newWriteOnlyTransaction();
        Ipv4Address iPv4Address = new Ipv4Address(snmpManagerAddress);
        trapAcl = new TrapAclBuilder()
                .setTrapAddress(iPv4Address)
                .setTrapCommunity(trapAclCommunity)
                .build();
        wtx.put(LogicalDatastoreType.CONFIGURATION, InstanceIdentifier.builder(TrapAcl.class).build(),trapAcl);
        CheckedFuture<Void,TransactionCommitFailedException> future = wtx.submit();
        Futures.addCallback(future,new LoggingFuturesCallBack<Void>("Registration of Snmp Manager Address or Trap Acl Community is not successfull",LOG));

    }

    public void resetSnmpManagerAddress() {
        LOG.debug("Delete Snmp Manager Address and Trap Acl Community");
        WriteTransaction wtx = db.newWriteOnlyTransaction();
        wtx.delete(LogicalDatastoreType.CONFIGURATION, InstanceIdentifier.builder(TrapAcl.class).build());
        CheckedFuture<Void,TransactionCommitFailedException> future = wtx.submit();
        Futures.addCallback(future,new LoggingFuturesCallBack<Void>("Delete is not successfull",LOG));
    }

    public class LoggingFuturesCallBack<V> implements FutureCallback<V> {

        private Logger LOG;
        private String message;
        public LoggingFuturesCallBack(String message,Logger LOG) {
            this.message = message;
            this.LOG = LOG;
        }
        @Override
        public void onFailure(Throwable e) {
            LOG.warn(message,e);

        }

        @Override
        public void onSuccess(V arg0) {
            LOG.info("Success Transaction");

        }
    }
}
