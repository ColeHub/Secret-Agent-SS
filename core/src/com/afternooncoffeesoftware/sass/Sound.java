package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by cole on 2014-10-10.
 */
public class Sound {
    public static com.badlogic.gdx.audio.Sound select;
    public static Music walk;
    public static Music splashTune;
    public static Music menuMusic;


    public static void load() {
        select = Gdx.audio.newSound(Gdx.files.internal("Blip_Select.wav"));
        walk = Gdx.audio.newMusic(Gdx.files.internal("walk2.wav"));
        splashTune = Gdx.audio.newMusic(Gdx.files.internal("splashtune.mp3"));
        splashTune.setVolume(0.5f);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("testmeoyeah.wav"));
    }

    public void dispose() {
        select.dispose();
    }
}
