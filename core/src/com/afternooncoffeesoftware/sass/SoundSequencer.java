package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by cole on 2014-10-13.
 */
public class SoundSequencer {

    public com.badlogic.gdx.audio.Sound sound;

    /**
     * A list of tracks to play in a sequence
     */
    Array<com.badlogic.gdx.audio.Sound> sounds = new Array<com.badlogic.gdx.audio.Sound>();

    /**
     * The index to play
     */
    int index = 0;

    /**
     * The delay between tracks
     */
    double delay;

    /**
     * The last time a track was played
     */
    double lastPlayed;

    /**
     * Add a sound to the sequencer
     */
    public void addSound(String path) {
        sound = Gdx.audio.newSound(Gdx.files.internal(path));
        if (sounds.contains(sound, true))
            return;
        sounds.add(sound);
    }


    /**
     * Play the sound sequence with a given delay
     *
     * @param volume 0 - 1
     * @param delay  in seconds
     */
    public void play(float volume, double delay) {
        if (TimeUtils.nanoTime() - lastPlayed > delay / 1000000000) {
            play(volume);
        }
    }

    /**
     * Play the sound track
     *
     * @param volume 0 - 1
     */
    public void play(float volume) {
        if (sounds.get(index) != null) {
            sounds.get(index).play(volume);
            lastPlayed = TimeUtils.nanoTime();
        }
        nextTrack();
    }

    /**
     * Move to the next track on the play list
     */
    private void nextTrack() {
        if (index + 1 > sounds.size - 1) {
            index = 0;
        } else {
            index += 1;
        }
    }
}
