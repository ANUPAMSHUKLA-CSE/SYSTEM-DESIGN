package org.example.gcp;

import org.example.product.Storage;

public class GCPStorage implements Storage {
    @Override
    public void chooseStorage() {
        System.out.println("Choosing storage on GCP for that choose Google Cloud Storage");
    }
}
