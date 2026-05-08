package org.example;

public class MP4 {
    private String file;

    public MP4(String file) {
        this.file = file;
    }

    public void playingMp4() {
        System.out.println("Playing MP4: " + file);
    }
}
