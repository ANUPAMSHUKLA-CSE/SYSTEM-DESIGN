package org.example;

public class VLCAdapter implements PlayButton {
    private VLC vlc;

    public VLCAdapter(VLC vlc) {
        this.vlc = vlc;
    }

    @Override
    public void play() {
        vlc.playVLC();
    }
}
