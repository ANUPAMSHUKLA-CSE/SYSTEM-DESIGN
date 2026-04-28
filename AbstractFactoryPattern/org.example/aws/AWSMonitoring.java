package org.example.aws;

import org.example.product.Monitoring;

public class AWSMonitoring implements Monitoring {
    @Override
    public void startMonitoring() {
        System.out.println("Monitoring on AWS through Amazon CloudWatch");
    }
}
