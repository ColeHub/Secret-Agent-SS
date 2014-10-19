package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by cole on 2014-10-13.
 */
public class Splash implements com.badlogic.gdx.Screen {

    OrthographicCamera camera;
    public static SpriteBatch batch;

    public Splash() {

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();

        Sound.splashTune.play();

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        Art.splashSprite.draw(batch);
        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY) || Gdx.input.isButtonPressed(Input.Keys.ANY_KEY)) {
            Sound.select.play(0.5f);
            ScreenManager.getInstance().show(Screen.MENU);
            dispose();
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
        //batch.dispose();
        Sound.splashTune.dispose();

    }
}
