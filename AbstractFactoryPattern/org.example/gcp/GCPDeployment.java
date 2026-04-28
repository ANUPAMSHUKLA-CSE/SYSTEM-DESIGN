package org.example.gcp;

import org.example.product.Deployment;

public class GCPDeployment implements Deployment {
    @Override
    public void doDeployment() {
        System.out.println("Deploying on GCP for that choose Google Cloud Run,Cloud Build / container-based deployment");
    }
}
