package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by cole on 2014-10-10.
 */
public class Art {
    public static SpriteBatch batch;
    public static OrthographicCamera camera;
    public static Texture playerImg;
    public static TextureRegion playerReg;
    public static Texture titleImg;
    public static Texture lampImg;
    public static Sprite titleSprite;
    public static Sprite lampSprite;


    public static void load() {
        batch = new SpriteBatch();

        playerImg = new Texture("nekkid.png");

        titleImg = new Texture("title.png");
        titleSprite = new Sprite(titleImg);
        titleSprite.scale(3);
        titleSprite.setOrigin(0, 0);
        titleSprite.setPosition(0, 0);

        lampImg = new Texture("lamp.png");
        lampSprite = new Sprite(lampImg);
        lampSprite.scale(4);
        lampSprite.setPosition(200, 200);

    }
}
