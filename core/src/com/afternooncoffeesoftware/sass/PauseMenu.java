package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by cole on 2014-10-11.
 * This is so broken at the moment.
 * Use at your own risk.
 */

public class PauseMenu implements Screen {
    final SASS game;
    final Level level;

    OrthographicCamera camera;
    public static SpriteBatch batch;

    public PauseMenu(final SASS sass, final Level level) {
        game = sass;
        this.level = level;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        Art.titleSprite.draw(batch);

        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.X)) {
            Sound.select.play(0.5f);

            //change screen to the level
            game.getScreen();
            this.hide();
        }

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

