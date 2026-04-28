package org.example.gcp;

import org.example.product.Monitoring;

public class GCPMonitoring implements Monitoring {
    @Override
    public void startMonitoring() {
        System.out.println("Monitoring on GCP through Google Cloud Monitoring");
    }
}
