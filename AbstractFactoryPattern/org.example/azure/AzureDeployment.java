package org.example.azure;

import org.example.product.Deployment;

public class AzureDeployment implements Deployment {
    @Override
    public void doDeployment() {
        System.out.println("Deploying on Azure DevOps / pipelines / containers");
    }
}
