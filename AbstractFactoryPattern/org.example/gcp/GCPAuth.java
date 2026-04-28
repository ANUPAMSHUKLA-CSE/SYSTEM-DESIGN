package org.example.gcp;

import org.example.product.Authentication;

public class GCPAuth implements Authentication {
    @Override
    public void authenticate() {
        System.out.println("Authenticating on GCP for that choose Google Cloud IAM");
    }
}
