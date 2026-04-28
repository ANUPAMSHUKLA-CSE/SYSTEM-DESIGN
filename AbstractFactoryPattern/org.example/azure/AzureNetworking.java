package org.example.azure;

import org.example.product.Networking;

public class AzureNetworking implements Networking {
    @Override
    public void chooseNetwork() {
        System.out.println("Choosing network on Azure for that choose Azure Virtual Network..Azure Load Balancer");
    }
}
