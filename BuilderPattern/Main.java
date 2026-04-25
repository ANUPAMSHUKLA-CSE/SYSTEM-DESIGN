package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE BEST TRAVEL PACKAGE");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your age");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your destination");
        String destination = sc.nextLine();
        System.out.println("Enter your duration");
        int duration = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the base price");
        int basePrice = Integer.parseInt(sc.nextLine());

        TravelPackage.TravelPackageBuilder builder =
                new TravelPackage.TravelPackageBuilder(destination, duration, basePrice);

        Set<Integer> selected = new HashSet<>();
        System.out.println("Add optional fields if you want \n 1. Travel Mode \n 2. Meal Plan \n 3. Adventure Activities \n 4. Travel Insurance \n 0. Done");
        while (true) {
            System.out.print("Enter your choice=");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 0) break;
            if (choice >= 1 && choice <= 4 && !selected.add(choice)) {
                System.out.println("Option " + choice + " is already set! Choose a different one.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter Travel Mode (bus/train/plane)=");
                    builder.travelMode(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter Meal Plan (breakfast/lunch/dinner/all)=");
                    builder.mealPlan(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter Adventure Activities comma-separated (Scuba Diving,Camping,Swimming)=");
                    builder.adventureActivities(Arrays.asList(sc.nextLine().split(",")));
                    break;
                case 4:
                    System.out.print("Enter Travel Insurance (true/false)=");
                    builder.isTravelInsuranceIncluded(Boolean.parseBoolean(sc.nextLine()));
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        TravelPackage travelPackage = builder.build();
        System.out.println(travelPackage);
        System.out.println("Your Travel Package is ready ::: costing=" + new CalculatePrice(travelPackage).calculate());
        System.out.println("Thank you for choosing us");
    }
}
