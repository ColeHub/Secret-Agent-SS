package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by cole on 2014-10-10.
 */
public class Art {
    public static SpriteBatch batch;
    public static Texture img;


    public static void load(){
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

    }
}
