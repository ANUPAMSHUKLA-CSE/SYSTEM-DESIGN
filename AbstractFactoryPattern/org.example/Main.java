package org.example;

import org.example.factory.CloudServiceFactory;
import org.example.factory.CloudServiceFactoryProvider;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cloud provider name (AWS, Azure, GCP): ");
        String provider = scanner.nextLine();

        CloudServiceFactory factory = CloudServiceFactoryProvider.getFactory(provider);

        factory.createAuthentication().authenticate();
        factory.createCompute().startCompute();
        factory.createStorage().chooseStorage();
        factory.createNetworking().chooseNetwork();
        factory.createDeployment().doDeployment();
        factory.createMonitoring().startMonitoring();
    }
}
