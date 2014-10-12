package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by cole on 2014-10-10.
 */
public class Level implements Screen {
    final SASS game;
    BitmapFont font;
    Player player;
    OrthographicCamera camera;
    Input input;
    SpriteBatch batch;

    public static TextureRegion currentFrame, currentFrameFlip;


    static float stateTime;

    public Level(final SASS sass) {
        Art.load();
        this.game = sass;
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        Art.load();
        Sound.load();
        player = new Player((800 / 3) * 2, (480 / 3));

        stateTime = 0f;
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
        batch.begin();
        Art.levelBgSprite.draw(batch);
        Art.levelBgSprite.setPosition(Art.levelBgBox.x, Art.levelBgBox.y);
        font.draw(batch, str, 10, 460);
        Player.sprite.draw(batch);
        Player.sprite.setPosition(player.box.x, player.box.y);

        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = Art.walkAnimation.getKeyFrame(stateTime, true);

        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.ESCAPE)) {
            Sound.select.play(0.5f);
            //this.hide();
            game.setScreen(new Menu(game));
        }

        if (input.walkRight) {
            player.sprite.setRegion(currentFrame);
        }
        if (input.walkLeft) {
            player.sprite.setRegion(currentFrame);
        }

        batch.end();

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
