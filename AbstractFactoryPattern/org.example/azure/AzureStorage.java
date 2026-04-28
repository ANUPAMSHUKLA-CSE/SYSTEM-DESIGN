package org.example.azure;

import org.example.product.Storage;

public class AzureStorage implements Storage {
    @Override
    public void chooseStorage() {
        System.out.println("Choosing storage on Azure for that choose Azure Blob Storage");
    }
}
