package org.example;

public class MP4Adapter implements PlayButton {
    private MP4 mp4;

    public MP4Adapter(MP4 mp4) {
        this.mp4 = mp4;
    }

    @Override
    public void play() {
        mp4.playingMp4();
    }
}
