package org.example.aws;

import org.example.product.Networking;

public class AWSNetworking implements Networking {
    @Override
    public void chooseNetwork() {
        System.out.println("Choosing networking on AWS for that choose Amazon VPC and do configurations and security groups, load balancing /ElasticLoadBalancing");
    }
}
