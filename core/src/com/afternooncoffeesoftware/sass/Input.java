package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Created by cole on 2014-10-10.
 */
public class Input {
    final Level level;
    DialogScreen dialog;
    static Player player;
    public static boolean walkRight = false;
    public static boolean walkLeft = false;

    public Input(final Level level) {
        this.level = level;
    }

    public Input(final Level level, final DialogScreen dialogScreen) {
        this.level = level;
        dialog = dialogScreen;
    }

    public void menu() {

        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) Gdx.app.exit();
    }

    public void level() {

        if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A)) {
            player.box.x -= 200 * Gdx.graphics.getDeltaTime();
            walkLeft = true;
            if (player.box.x <= 100) {
                player.box.x = 100;
                //move global offset
                if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A))
                    level.globalOffset += 200 * Gdx.graphics.getDeltaTime();
            }

        } else {
            walkLeft = false;
        }


        if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) {
            player.box.x += 200 * Gdx.graphics.getDeltaTime();
            walkRight = true;
            if (player.box.x >= 700) {
                player.box.x = 700;
                //move global offset
                if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D))
                    level.globalOffset -= 200 * Gdx.graphics.getDeltaTime();
            }
        } else {
            walkRight = false;
        }


    }

    public void dialog() {
        if (Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.W)) {
            //move dialog option up
            if (dialog.counter >= 0)
                dialog.counter--;
            else {
                dialog.counter = 0;
            }
        }
        if (Gdx.input.isKeyJustPressed(Keys.DOWN) || Gdx.input.isKeyJustPressed(Keys.S)) {
            //move dialog option down
            if (dialog.counter <= 2)
                dialog.counter++;
            else {
                dialog.counter = 2;
            }
        }
        if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
            //activate dialog option
            dialog.counted = dialog.counter;
        }
    }
}
