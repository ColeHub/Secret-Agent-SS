package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by cole on 2014-10-11.
 * This is so broken at the moment.
 * Use at your own risk.
 */

public class PauseMenu implements com.badlogic.gdx.Screen {
    Level level;
    OrthographicCamera camera;
    public static SpriteBatch batch;

    public static int state;

    public PauseMenu() {
        level = ScreenManager.getInstance().getLevel(com.afternooncoffeesoftware.sass.Screen.LEVEL);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();

        state = 0;
        //Sound.menuMusic.play();

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) || Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            Sound.select.play(0.5f);
            if (state < 2) {
                state++;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) || Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            Sound.select.play(0.5f);
            if (state > 0) {
                state--;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        batch.begin();
        Art.pausedSprite.draw(batch);

        if (state == 0) {
            Art.menuCurrentSprite.setTexture(Art.resumeImg);
            Art.menuCurrentSprite.draw(batch);
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) || Gdx.input.isButtonPressed(Input.Keys.ANY_KEY)) {
                Sound.select.play(0.5f);
                //change screen to the level
                dispose();
                ScreenManager.getInstance().show(Screen.LEVEL);

            }
        } else if (state == 1) {
            Art.menuCurrentSprite.setTexture(Art.optionsImg);
            Art.menuCurrentSprite.draw(batch);
        } else if (state == 2) {
            Art.menuCurrentSprite.setTexture(Art.exitImg);
            Art.menuCurrentSprite.draw(batch);
            if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
                Gdx.app.exit();
            }
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
        Sound.menuMusic.dispose();
    }
}

