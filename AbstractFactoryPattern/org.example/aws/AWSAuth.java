package org.example.aws;

import org.example.product.Authentication;

public class AWSAuth implements Authentication {
    @Override
    public void authenticate() {
        System.out.println("Authenticating on AWS for that choose IAM roles / access keys");
    }
}
