package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Intersector;

/**
 * Created by cole on 2014-10-10.
 */
public class Level implements com.badlogic.gdx.Screen {
    BitmapFont debugFont;
    Player player;
    OrthographicCamera camera;
    Input input;
    SpriteBatch batch;
    NPC guard;
    NPC guard2;

    Object paper;

    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Minecraftia-Regular.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    //in-game font

    BitmapFont font = new BitmapFont();

    public static TextureRegion currentFrame;
    boolean last = false;

    public int globalOffset = 0;

    //test revert successfull

    static float stateTime;

    public Level() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        Art.load();
        Sound.load();
        debugFont = new BitmapFont();
        debugFont.setColor(1.0f, 0.0f, 0.0f, 1.0f);

        // x was 800/3*2 = 533.333
        player = new Player(500, (480 / 4));

        guard = new NPC(Art.nekkidImg);
        guard2 = new NPC(Art.nekkidImg);

        input = new Input(this);
        stateTime = 0f;

        parameter.size = 32;
        font = generator.generateFont(parameter);

        paper = new Object("Paper", Art.paperImg);
    }

    public void render(float delta) {
        input.level(player);



        //debugging string
        CharSequence str = player.toString();

        //set up a white canvas
        Gdx.gl.glClearColor(0.8f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Art.batch.setProjectionMatrix(camera.combined);
        Art.levelBgBox.x = globalOffset + 200;

        //render scene
        batch.begin();
        Art.levelBgSprite.draw(batch);
        if(globalOffset > -800)
            Art.levelBgSprite.setPosition(Art.levelBgBox.x, Art.levelBgBox.y);
        if(globalOffset < -800)
            Art.levelBgSprite.setPosition(Art.levelBgBox.x+1600, Art.levelBgBox.y);
        //debugging
        debugFont.draw(batch, str, 10, 400);

        font.draw(batch, "GET TO THE MEETING", 200, 440);
        font.draw(batch, "globalOffset: " + globalOffset, 200, 400);

        //initialize objects and positions
        guard.sprite.draw(batch);
        guard2.sprite.draw(batch);

        //this is temporary, will be:
        //if(!inventory.contains(paper))
        if(paper.inScene)
            paper.sprite.draw(batch);

        player.sprite.draw(batch);

        guard.box.setPosition(globalOffset + 400, 480 / 4);
        guard2.box.setPosition(globalOffset + 700, 480 / 4);
        paper.box.setPosition(globalOffset + 780, 150);
        guard.sprite.setPosition(guard.box.x, guard.box.y);
        guard2.sprite.setPosition(guard2.box.x, guard2.box.y);
        player.sprite.setPosition(player.box.x, player.box.y);
        paper.sprite.setPosition(paper.box.x, paper.box.y);

        playerAnimate();
        npcEvents();
        objectEvents();

        batch.end();
    }

    public void playerAnimate(){
        //animation variables
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = Art.walkAnimation.getKeyFrame(stateTime, true);

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
    }

    public void npcEvents(){
        if (guard.talkative) {
            if (Intersector.overlaps(player.box, guard.box)) {
                //game.setScreen(new DialogScreen(game, 1, guard));
                ScreenManager.getInstance().showDialog(1, guard);
            }
        }
        //restarts conversation with not active guard with SPACE BAR
        else {
            if (Intersector.overlaps(player.box, guard.box) && Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.SPACE))
                //game.setScreen(new DialogScreen(game, 3, guard));
                ScreenManager.getInstance().showDialog(3, guard);
        }
        if (guard2.talkative) {
            if (Intersector.overlaps(player.box, guard2.box)) {
                //game.setScreen(new DialogScreen(game, 3, guard2));
                ScreenManager.getInstance().showDialog(3, guard2);
            }
        }
    }

    public void objectEvents(){
        if(Intersector.overlaps(player.box, paper.box)){
            //will be:
            //(add paper to inventory arraylist)
            //(play sound)
            //(put text on screen: "PAPER GET")
            paper.inScene = false;
        }

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
        debugFont.dispose();
        Sound.select.dispose();
        Sound.menuMusic.dispose();
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
    }
}
