package org.example;

import Tower10.INFOR;
import Tower10.INFORMATICA;
import Tower10.MARKETPLACE;
import Tower10.PLAYAREA;
import Tower20.GAMING;
import Tower20.QUALCOM;
import Tower20.SWIMMINGPOOL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1-INFOR 2-INFORMATICA 3-GAMING 4-SWIMMINGPOOL 5-MARKETPLACE 6-PLAYAREA 7-QUALCOM 8-EXIT");
            int n = sc.nextInt();
            sc.nextLine(); // consume leftover newline after nextInt()
            if (n == 8) {
                System.out.println("Exiting...");
                sc.close();
                System.exit(0);
            }
            System.out.println("Enter your message");
            String message = sc.nextLine();
            switch (n) {
                case 1:
                    new INFOR().log(message);
                    break;
                case 2:
                    new INFORMATICA().log(message);
                    break;
                case 3:
                    new GAMING().log(message);
                    break;
                case 4:
                    new SWIMMINGPOOL().log(message);
                    break;
                case 5:
                    new MARKETPLACE().log(message);
                    break;
                case 6:
                    new PLAYAREA().log(message);
                    break;
                case 7:
                    new QUALCOM().log(message);
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }
}
