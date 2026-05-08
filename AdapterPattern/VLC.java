package org.example;

public class VLC {
    private String file;
    private String quality;

    public VLC(String file, String quality) {
        this.file = file;
        this.quality = quality;
    }

    public void playVLC() {
        System.out.println("Playing VLC video: " + file + " [quality=" + quality + "]");
    }
}
