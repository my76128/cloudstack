// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.agent;

import com.cloud.agent.resource.DummyResource;
import com.cloud.utils.backoff.BackoffAlgorithm;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

import javax.naming.ConfigurationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DummyAgentShell implements IAgentShell, Daemon {

    @Override
    public void init(DaemonContext daemonContext) throws DaemonInitException, Exception {

    }

    @Override
    public void start() throws Exception {
        Agent agent = new Agent(this, 1, DummyResource.class.newInstance());
        agent.start();
        try {
            while (true)
                Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public void destroy() {

    }

    @Override
    public Map<String, Object> getCmdLineProperties() {
        return new HashMap<String, Object>();
    }

    @Override
    public Properties getProperties() {
        return new Properties();
    }

    @Override
    public String getPersistentProperty(String prefix, String name) {
        return "1234";
    }

    @Override
    public void setPersistentProperty(String prefix, String name, String value) {

    }

    @Override
    public String getHost() {
        return "127.0.0.1";
    }

    @Override
    public String getPrivateIp() {
        return "127.0.0.1";
    }

    @Override
    public int getPort() {
        return 8250;
    }

    @Override
    public int getWorkers() {
        return 1;
    }

    @Override
    public int getProxyPort() {
        return 0;
    }

    @Override
    public String getGuid() {
        return "123123123123";
    }

    @Override
    public String getZone() {
        return "zone";
    }

    @Override
    public String getPod() {
        return "pod";
    }

    @Override
    public BackoffAlgorithm getBackoffAlgorithm() {
        return null;
    }

    @Override
    public int getPingRetries() {
        return 3;
    }

    @Override
    public String getVersion() {
        return "4.3.1";
    }

    public static void main(String[] args) throws Exception {
        try {
            DummyAgentShell shell = new DummyAgentShell();
            shell.start();
        } catch (ConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }

}
