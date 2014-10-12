package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by cole on 2014-10-10.
 */
public class Level implements Screen {
    final SASS game;
    BitmapFont font;
    Player player;
    OrthographicCamera camera;
    Input input;
    PauseMenu pauseMenu;

    public Level(final SASS sass) {
        this.game = sass;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        Art.load();
        Sound.load();
        player = new Player((800 / 3) * 2, (480 / 3));



    }

    public void render(float delta) {


        //debugging
        CharSequence str = player.toString();
        font = new BitmapFont();

        //set up a white canvas
        Gdx.gl.glClearColor(0.8f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Art.batch.setProjectionMatrix(camera.combined);

        //render scene
        Art.batch.begin();
        font.draw(Art.batch, str, 200, 300);
        Player.sprite.draw(Art.batch);
        Player.sprite.setPosition(player.box.x, player.box.y);

        Art.batch.end();

        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.ESCAPE)) {
            Sound.select.play(0.5f);
            //this.hide();
            game.setScreen(new PauseMenu(game));
        }

        input.level();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
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
        font.dispose();
        Sound.select.dispose();
    }
}
