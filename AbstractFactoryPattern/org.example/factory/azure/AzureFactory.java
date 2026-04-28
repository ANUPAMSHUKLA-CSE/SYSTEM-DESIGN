package org.example.factory.azure;

import org.example.azure.*;
import org.example.factory.CloudServiceFactory;
import org.example.product.*;

public class AzureFactory implements CloudServiceFactory {
    @Override
    public Authentication createAuthentication() { return new AzureAuth(); }
    @Override
    public Compute createCompute() { return new AzureCompute(); }
    @Override
    public Storage createStorage() { return new AzureStorage(); }
    @Override
    public Networking createNetworking() { return new AzureNetworking(); }
    @Override
    public Deployment createDeployment() { return new AzureDeployment(); }
    @Override
    public Monitoring createMonitoring() { return new AzureMonitoring(); }
}
