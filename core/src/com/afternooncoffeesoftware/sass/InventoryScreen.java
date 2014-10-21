package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * Created by cole on 2014-10-21.
 */
public class InventoryScreen implements com.badlogic.gdx.Screen {

    Input input;
    Level level;
    OrthographicCamera camera;
    public static SpriteBatch batch;

    public static int state;

    public InventoryScreen() {
        level = ScreenManager.getInstance().getLevel(com.afternooncoffeesoftware.sass.Screen.LEVEL);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        state = 0;

        input = new Input(level);

    }

    @Override
    public void render(float delta) {
        input.inventory();

        Gdx.gl.glClearColor(1, 1, 1, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);


        batch.begin();
        Art.inventorySprite.draw(batch);

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
