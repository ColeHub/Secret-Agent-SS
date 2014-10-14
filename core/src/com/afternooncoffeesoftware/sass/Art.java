package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
//import sun.jvm.hotspot.asm.sparc.SPARCRegister;

/**
 * Created by cole on 2014-10-10.
 */
public class Art {
    public static SpriteBatch batch;
    public static OrthographicCamera camera;
    public static Texture nekkidImg;
    public static TextureRegion playerRegIdle, playerRegIdleFlip;
    public static Rectangle levelBgBox;
    public static Texture levelBgTexture;
    public static Sprite levelBgSprite;
    public static Texture titleImg;
    public static Texture lampImg;
    public static Sprite titleSprite;
    public static Sprite lampSprite;

    public static Texture dialogSelectImg;
    public static Sprite dialogSelectSprite;

    public static Texture splashImg;
    public static Sprite splashSprite;

    public static Texture startImg, exitImg, optionsImg;
    public static Sprite menuCurrentSprite;

    //spritesheet animating test crap
    static Animation walkAnimation;
    static Texture sheet;
    static TextureRegion[] walkFrames;

    public static void load() {

        sheet = new Texture("king.png");
        playerRegIdle = new TextureRegion(sheet, 32, 32);
        playerRegIdleFlip = playerRegIdle;
        playerRegIdleFlip.flip(true, false);
        TextureRegion[][] tmp = TextureRegion.split(sheet, 32, 32);
        walkFrames = new TextureRegion[2];
        int index = 0;
        for (int i = 0; i <= 1; i++) {
            walkFrames[index++] = tmp[0][i];

        }
        walkAnimation = new Animation(0.3f, walkFrames);

        batch = new SpriteBatch();

        nekkidImg = new Texture("nekkid.png");

        titleImg = new Texture("title.png");
        startImg = new Texture("start.png");
        exitImg = new Texture("exit.png");
        optionsImg = new Texture("options.png");
        menuCurrentSprite = new Sprite(startImg);
        menuCurrentSprite.scale(3);
        menuCurrentSprite.setOrigin(0, 0);
        menuCurrentSprite.setPosition(0, 0);

        splashImg = new Texture("splash.png");
        splashSprite = new Sprite(splashImg);
        splashSprite.scale(3);
        splashSprite.setOrigin(0, 0);
        splashSprite.setPosition(0, 0);

        dialogSelectImg = new Texture("dialogselect.png");
        dialogSelectSprite = new Sprite(dialogSelectImg);
        dialogSelectSprite.scale(3);
        dialogSelectSprite.setOrigin(0, 10);

        titleSprite = new Sprite(titleImg);
        titleSprite.scale(3);
        titleSprite.setOrigin(0, 0);
        titleSprite.setPosition(0, 0);

        lampImg = new Texture("lamp.png");
        lampSprite = new Sprite(lampImg);
        lampSprite.scale(4);
        lampSprite.setPosition(200, 200);

        levelBgBox = new Rectangle();
        levelBgBox.x = 0;
        levelBgBox.y = 0;
        levelBgBox.setWidth(1800);
        levelBgBox.setHeight(600);
        levelBgTexture = new Texture("level.png");
        levelBgSprite = new Sprite(levelBgTexture);
        levelBgSprite.scale(3);
        levelBgSprite.setOrigin(levelBgTexture.getWidth() / 2, 0);


    }
}
