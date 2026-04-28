package org.example.aws;

import org.example.product.Deployment;

public class AWSDeployment implements Deployment {
    @Override
    public void doDeployment() {
        System.out.println("Deploying on AWS- for that choose Use scripts / CI-CD / containers (ECS/EKS optional)");
    }
}
