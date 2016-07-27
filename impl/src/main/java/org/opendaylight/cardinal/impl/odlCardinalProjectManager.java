/*
 * Copyright © 2015 TCS and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.cardinal.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class odlCardinalProjectManager {
    final String name = "admin";
    final String password = "admin";
    final String authString = name + ":" + password;
    SnmpSet set = new SnmpSet();

    public void odlMDSALIotDMListofcse() throws MalformedURLException {
        URL url = new URL("http://localhost:8181/restconf/operational/onem2m:onem2m-cse-list/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        try {
            set.setVariableString(".1.3.6.1.3.1.1.8.12.0",apis.odlRestGetApis(url));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void odlMDSALIotDMlistofAEs() throws MalformedURLException {
        URL url = new URL("http://localhost:8181/restconf/operational/onem2m:onem2m-cse-list/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);
    }

    public void odlMDSALIotDMlistofNodes() throws MalformedURLException {
        URL url = new URL("http://localhost:8181/restconf/operational/onem2m:onem2m-cse-list/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);

    }

    public void odlMDSALOpenFlowOVSconnectedDevices() throws MalformedURLException {
        URL url = new URL("http://localhost:8181/restconf/operational/network-topology:network-topology/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);

    }

    public void odlMDSALSfcfunction() throws MalformedURLException {
        URL url = new URL("http://localhost:8181/restconf/operational/service-function:service-functions/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);

    }

    public void odlMDSALSfcfunctionchain() throws MalformedURLException {
        URL url = new URL("http://localhost:8181/restconf/operational/service-function-chain:service-function-chains/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);

    }

    public void odlMDSALSfcfunctiongroups() throws MalformedURLException {
        URL url = new URL("http://localhost:8181/restconf/operational/service-function-group:service-function-groups/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);

    }

    public void odlMDSALSfcfunctionAlgorithms() throws MalformedURLException {
        URL url = new URL(
                "http://localhost:8181/restconf/operational/service-function-group-algorithm:service-function-group-algorithms/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);

    }

    public void odlMDSALGBPFaaslogicalnetwork() throws MalformedURLException {
        URL url = new URL("http://localhost:8181/restconf/operational/faas:logical-networks/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);

    }

    public void odlMDSALGBPPolicytenants() throws MalformedURLException {
        URL url = new URL("http://localhost:8181/restconf/operational/policy:tenants/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);

    }

    public void odlMDSALGBPResolvedpolicies() throws MalformedURLException {
        URL url = new URL(
                "http://localhost:8181/restconf/operational/service-function-group-algorithm:service-function-group-algorithms/");
        odlCardinalProjectManager apis = new odlCardinalProjectManager();
        apis.odlRestGetApis(url);

    }

    public String odlRestGetApis(URL url) throws MalformedURLException {
        String encodedAuthStr = Base64.getEncoder().encodeToString(authString.getBytes());
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Basic " + encodedAuthStr);
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                return output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            throw new RuntimeException(e);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
        return "project-information";
    }

}
