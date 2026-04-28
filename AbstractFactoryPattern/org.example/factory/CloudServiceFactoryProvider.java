package org.example.factory;

import org.example.factory.aws.AWSFactory;
import org.example.factory.azure.AzureFactory;
import org.example.factory.gcp.GCPFactory;

public class CloudServiceFactoryProvider {
    public static CloudServiceFactory getFactory(String provider) {
        switch (provider.toUpperCase()) {
            case "AZURE": return new AzureFactory();
            case "GCP":   return new GCPFactory();
            default:      return new AWSFactory();
        }
    }
}
