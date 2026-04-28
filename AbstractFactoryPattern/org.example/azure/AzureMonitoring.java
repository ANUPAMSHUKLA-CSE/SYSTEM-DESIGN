package org.example.azure;

import org.example.product.Monitoring;

public class AzureMonitoring implements Monitoring {
    @Override
    public void startMonitoring() {
        System.out.println("Monitoring on Azure through Azure Monitor");
    }
}
