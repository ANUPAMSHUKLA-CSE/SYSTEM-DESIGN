package org.example.factory.gcp;

import org.example.factory.CloudServiceFactory;
import org.example.gcp.*;
import org.example.product.*;

public class GCPFactory implements CloudServiceFactory {
    @Override
    public Authentication createAuthentication() { return new GCPAuth(); }
    @Override
    public Compute createCompute() { return new GCPCompute(); }
    @Override
    public Storage createStorage() { return new GCPStorage(); }
    @Override
    public Networking createNetworking() { return new GCPNetworking(); }
    @Override
    public Deployment createDeployment() { return new GCPDeployment(); }
    @Override
    public Monitoring createMonitoring() { return new GCPMonitoring(); }
}
