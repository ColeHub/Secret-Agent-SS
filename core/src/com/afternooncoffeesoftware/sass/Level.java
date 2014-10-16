package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;

/**
 * Created by cole on 2014-10-10.
 */
public class Level implements Screen {
    final SASS game;
    BitmapFont font;
    Player player;
    OrthographicCamera camera;
    Input input;
    Dialog guardDialog;
    DialogScreen ds;
    SpriteBatch batch;
    NPC guard;
    NPC guard2;

    public static TextureRegion currentFrame;
    boolean last = false;

    public int globalOffset = 0;

    static float stateTime;

    public Level(final SASS sass) {
        this.game = sass;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        Art.load();
        Sound.load();

        player = new Player((800 / 3) * 2, (480 / 4));

        guard = new NPC(Art.nekkidImg);
        guard2 = new NPC(Art.nekkidImg);

        input = new Input(this);
        font = new BitmapFont();

        stateTime = 0f;
    }

    public void render(float delta) {


        //debugging
        CharSequence str = player.toString();
        CharSequence str2 = guard.toString();
        CharSequence str3 = guard2.toString();

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
        font.draw(batch, str2, 10, 440);
        font.draw(batch, str3, 10, 480);

        if (guard.active) {
            if (Intersector.overlaps(player.box, guard.box)) {
                game.setScreen(new DialogScreen(game, 1, guard));
            }
        }
        //restarts conversation with not active guard with SPACE BAR
        else {
            if (Intersector.overlaps(player.box, guard.box) && Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.SPACE))
                game.setScreen(new DialogScreen(game, 3, guard));
        }
        if (guard2.active) {
            if (Intersector.overlaps(player.box, guard2.box)) game.setScreen(new DialogScreen(game, 3, guard2));
        }

        guard.sprite.draw(batch);
        guard2.sprite.draw(batch);
        player.sprite.draw(batch);
        guard.box.setPosition(globalOffset + 400, 480 / 4);
        guard2.box.setPosition(globalOffset + 600, 480 / 4);
        guard.sprite.setPosition(guard.box.x, guard.box.y);
        guard2.sprite.setPosition(guard2.box.x, guard2.box.y);
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
        input.level(player);
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
        Sound.menuMusic.dispose();
    }
}
