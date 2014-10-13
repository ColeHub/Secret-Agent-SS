package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Created by cole on 2014-10-10.
 */
public class Input {
    final Level level;
    static Player player;
    public static boolean walkRight = false;
    public static boolean walkLeft = false;

    public Input(final Level level) {
        this.level = level;
    }

    public void menu() {
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) Gdx.app.exit();
    }

    public void level() {

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            player.box.x -= 200 * Gdx.graphics.getDeltaTime();
            walkLeft = true;
            if (player.box.x <= 100) {
                player.box.x = 100;
                //move global offset
                if (Gdx.input.isKeyPressed(Keys.LEFT)) level.globalOffset += 200 * Gdx.graphics.getDeltaTime();
            }

        } else {
            walkLeft = false;
        }


        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            player.box.x += 200 * Gdx.graphics.getDeltaTime();
            walkRight = true;
            if (player.box.x >= 700) {
                player.box.x = 700;
                //move global offset
                if (Gdx.input.isKeyPressed(Keys.RIGHT)) level.globalOffset -= 200 * Gdx.graphics.getDeltaTime();
            }
        } else {
            walkRight = false;
        }

    }
}
