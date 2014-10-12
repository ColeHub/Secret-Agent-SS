package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Created by cole on 2014-10-10.
 */
public class Input {
    static Player player;


    public static void menu() {
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) Gdx.app.exit();
    }

    public static void level() {
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            player.box.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            player.box.x += 200 * Gdx.graphics.getDeltaTime();
        }
    }
}
