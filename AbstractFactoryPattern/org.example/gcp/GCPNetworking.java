package org.example.gcp;

import org.example.product.Networking;

public class GCPNetworking implements Networking {
    @Override
    public void chooseNetwork() {
        System.out.println("Choosing network on GCP for that choose Google Cloud Networking VPC setup ,Google Cloud Load Balancing");
    }
}
