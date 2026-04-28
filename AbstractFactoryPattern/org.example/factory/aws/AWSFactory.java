package org.example.factory.aws;

import org.example.aws.*;
import org.example.factory.CloudServiceFactory;
import org.example.product.*;

public class AWSFactory implements CloudServiceFactory {
    @Override
    public Authentication createAuthentication() { return new AWSAuth(); }
    @Override
    public Compute createCompute() { return new AWSCompute(); }
    @Override
    public Storage createStorage() { return new AWSStorage(); }
    @Override
    public Networking createNetworking() { return new AWSNetworking(); }
    @Override
    public Deployment createDeployment() { return new AWSDeployment(); }
    @Override
    public Monitoring createMonitoring() { return new AWSMonitoring(); }
}
