package org.example.gcp;

import org.example.product.Compute;

public class GCPCompute implements Compute {
    @Override
    public void startCompute() {
        System.out.println("Starting compute on GCP for that choose Google Cloud Compute Engine or Google Cloud Functions");
    }
}
