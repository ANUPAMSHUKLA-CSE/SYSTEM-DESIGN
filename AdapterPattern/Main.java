package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("UNIFIED MEDIA PLAYER SYSTEM");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the fileName:");
        String file = sc.nextLine();

        System.out.println("Enter the type (mp3/mp4/vlc):");
        String type = sc.nextLine().toLowerCase();

        PlayButton player;

        switch (type) {
            case "mp3":
                System.out.println("Enter the audio type:");
                String audioType = sc.nextLine();
                player = new MP3Adapter(new MP3(file, audioType));
                break;
            case "mp4":
                player = new MP4Adapter(new MP4(file));
                break;
            case "vlc":
                System.out.println("Enter the quality:");
                String quality = sc.nextLine();
                player = new VLCAdapter(new VLC(file, quality));
                break;
            default:
                System.out.println("Unsupported media type: " + type);
                return;
        }

        player.play();
    }
}
