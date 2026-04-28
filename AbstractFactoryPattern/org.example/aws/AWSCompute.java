package org.example.aws;

import org.example.product.Compute;

public class AWSCompute implements Compute {
    @Override
    public void startCompute() {
        System.out.println("Starting compute on AWS for that choose Amazon EC2 or AWS Lambda");
    }
}
