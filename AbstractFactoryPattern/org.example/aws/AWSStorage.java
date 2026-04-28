package org.example.aws;

import org.example.product.Storage;

public class AWSStorage implements Storage {
    @Override
    public void chooseStorage() {
        System.out.println("Choosing storage on AWS for that choose Amazon S3 ");
    }
}
