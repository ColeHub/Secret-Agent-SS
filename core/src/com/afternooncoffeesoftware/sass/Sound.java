package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input;
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
        walk.setVolume(0.3f);
        splashTune = Gdx.audio.newMusic(Gdx.files.internal("splashtune.mp3"));
        splashTune.setVolume(0.5f);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("SpaceTheme2.wav"));
        menuMusic.setLooping(true);

    }

    public static void pauseMusic() {
        if (menuMusic.isPlaying() && Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.M)) {
            menuMusic.pause();
        }
        if (!(menuMusic.isPlaying()) && Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.M)) {
            menuMusic.play();
        }
    }



    public void dispose() {
        walk.dispose();
        splashTune.dispose();
        menuMusic.dispose();
        select.dispose();
    }
}
