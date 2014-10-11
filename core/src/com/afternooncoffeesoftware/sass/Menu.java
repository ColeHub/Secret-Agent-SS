package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by cole on 2014-10-10.
 */
public class Menu {
    public static Texture titleImg;
    public static Sprite titleSprite;
    public static SpriteBatch batch;

    public static void load() {
        batch = new SpriteBatch();
        titleImg = new Texture("title.png");
        titleSprite = new Sprite(titleImg);
        titleSprite.scale(4);
        titleSprite.setPosition(200, 200);


    }

    public static void render() {
        batch.begin();
        titleSprite.draw(batch);


        batch.end();
        Input.menu();
    }
}
