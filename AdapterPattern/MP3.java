package org.example;

public class MP3 {
    private String file;
    private String type;

    public MP3(String file, String type) {
        this.file = file;
        this.type = type;
    }

    public void playMp3() {
        System.out.println("Playing MP3 audio: " + file + " [type=" + type + "]");
    }
}
