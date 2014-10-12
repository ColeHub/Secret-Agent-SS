package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;

/**
 * Created by cole on 2014-10-10.
 */
public class Sound {
    public static com.badlogic.gdx.audio.Sound select;


    public static void load() {
        select = Gdx.audio.newSound(Gdx.files.internal("Blip_Select.wav"));
    }

    public void dispose() {
        select.dispose();
    }
}
