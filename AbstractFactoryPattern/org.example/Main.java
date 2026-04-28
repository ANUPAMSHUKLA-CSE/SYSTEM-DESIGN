package org.example;

import org.example.factory.CloudServiceFactory;
import org.example.factory.CloudServiceFactoryProvider;

public class Main {
    public static void main(String[] args) {
        String provider = args.length > 0 ? args[0] : "AWS";

        CloudServiceFactory factory = CloudServiceFactoryProvider.getFactory(provider);

        factory.createAuthentication().authenticate();
        factory.createCompute().startCompute();
        factory.createStorage().chooseStorage();
        factory.createNetworking().chooseNetwork();
        factory.createDeployment().doDeployment();
        factory.createMonitoring().startMonitoring();
    }
}
