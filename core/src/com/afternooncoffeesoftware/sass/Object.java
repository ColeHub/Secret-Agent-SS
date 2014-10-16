package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by cole on 2014-10-16.
 */
public class Object {
    public int x;
    public int y;
    public Rectangle box;
    public Sprite sprite;
    public boolean active;
    private String name;

    public Object(final String name, Texture texture){
        active = true;
        box = new Rectangle();
        box.setHeight(64);
        box.setWidth(64);

        this.name = name;

        sprite = new Sprite(texture);
        sprite.scale(4);
    }

    public String getName(){
        return name;
    }
}
