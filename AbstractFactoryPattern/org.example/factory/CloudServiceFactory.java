package org.example.factory;

import org.example.product.*;

public interface CloudServiceFactory {
    Authentication createAuthentication();
    Compute createCompute();
    Storage createStorage();
    Networking createNetworking();
    Deployment createDeployment();
    Monitoring createMonitoring();
}
