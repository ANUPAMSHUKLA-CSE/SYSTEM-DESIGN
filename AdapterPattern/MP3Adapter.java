package org.example;

public class MP3Adapter implements PlayButton {
    private MP3 mp3;

    public MP3Adapter(MP3 mp3) {
        this.mp3 = mp3;
    }

    @Override
    public void play() {
        mp3.playMp3();
    }
}
