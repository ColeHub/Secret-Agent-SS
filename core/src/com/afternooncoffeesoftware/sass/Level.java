package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by cole on 2014-10-10.
 */
public class Level {
    BitmapFont font;

    public void create() {
        Art.load();
        Sound.load();
    }

    public void render() {
        //debugging
        CharSequence str = Art.player.toString();
        font = new BitmapFont();

        //set up a white canvas
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Art.batch.setProjectionMatrix(Art.camera.combined);

        //render scene
        Art.batch.begin();
        font.draw(Art.batch, str, 200, 300);
        Art.sprite.draw(Art.batch);
        Art.sprite.setPosition(Art.player.x, Art.player.y);
        Art.batch.end();
        Input.level();
    }
}
