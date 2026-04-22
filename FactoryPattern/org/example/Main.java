package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Document Processing System");
        System.out.println("1. Process\n2. Exit");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter choice: ");
            String input = scanner.nextLine().trim();
            if ("2".equals(input)) { System.out.println("Exiting."); break; }
            if ("1".equals(input)) {
                System.out.print("Enter document name: ");
                String docName = scanner.nextLine().trim();
                try {
                    DocumentFactory.createDocument(docName).process();
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
