package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Created by cole on 2014-10-10.
 */
public class Input {

    public static void render() {
        if (Gdx.input.isKeyPressed(Keys.LEFT)) Art.player.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) Art.player.x += 200 * Gdx.graphics.getDeltaTime();
    }
}
