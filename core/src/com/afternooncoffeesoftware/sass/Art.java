package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by cole on 2014-10-10.
 */
public class Art {
    public static SpriteBatch batch;
    public static OrthographicCamera camera;
    public static Texture img;
    public static Sprite sprite;
    public static Rectangle player;


    public static void load() {

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        player = new Rectangle();
        player.x = (800 / 3) * 2;
        player.y = (480 / 3);
        player.setHeight(64);
        player.setWidth(64);

        img = new Texture("nekkid.png");
        sprite = new Sprite(img);
        sprite.scale(4);
        sprite.setPosition(player.x, player.y);
    }
}
