package org.example.azure;

import org.example.product.Compute;

public class AzureCompute implements Compute {
    @Override
    public void startCompute() {
        System.out.println("Starting compute on Azure for that choose Azure Virtual Machines or Azure Functions");
    }
}
