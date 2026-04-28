package org.example.azure;

import org.example.product.Authentication;

public class AzureAuth implements Authentication {
    @Override
    public void authenticate() {
        System.out.println("Authenticating on Azure for that choose Azure Active Directory");
    }
}
