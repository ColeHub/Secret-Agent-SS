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
    NPC guard;

    public static TextureRegion currentFrame;
    boolean last = false;

    public int globalOffset = 0;

    static float stateTime;

    public Level(final SASS sass) {

        this.game = sass;
        batch = new SpriteBatch();


        Art.load();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        Art.load();
        Sound.load();


        player = new Player((800 / 3) * 2, (480 / 4));
        guard = new NPC(800 / 3, 480 / 4, Art.nekkidImg);

        input = new Input(this);

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

        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = Art.walkAnimation.getKeyFrame(stateTime, true);

        Art.levelBgBox.x = globalOffset - 200;

        //render scene
        batch.begin();
        Art.levelBgSprite.draw(batch);
        Art.levelBgSprite.setPosition(Art.levelBgBox.x, Art.levelBgBox.y);
        font.draw(batch, str, 10, 460);

        guard.sprite.draw(batch);
        player.sprite.draw(batch);
        guard.sprite.setPosition(globalOffset + guard.box.x, guard.box.y);
        player.sprite.setPosition(player.box.x, player.box.y);

        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.ESCAPE)) {
            Sound.select.play(0.5f);
            game.setScreen(new Menu(game));
        }

        if (input.walkRight) {
            if (currentFrame.isFlipX()) currentFrame.flip(true, false);
            player.sprite.setRegion(currentFrame);
            Sound.walk.play();
            last = false;

        }
        if (input.walkLeft) {
            if (!currentFrame.isFlipX()) currentFrame.flip(true, false);
            player.sprite.setRegion(currentFrame);
            Sound.walk.play();
            last = true;
        }
        if (!input.walkLeft && !input.walkRight) {
            if (!last) {
                if (Art.playerRegIdle.isFlipX()) Art.playerRegIdle.flip(true, false);
                player.sprite.setRegion(Art.playerRegIdle);
            }
            if (last) {
                if (!Art.playerRegIdle.isFlipX()) Art.playerRegIdle.flip(true, false);
                player.sprite.setRegion(Art.playerRegIdle);
            }
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
