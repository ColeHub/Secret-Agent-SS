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
    public boolean inScene;
    public Rectangle box;
    public Sprite sprite;
    private String name;
    public boolean isDragged;

    public Object(final String name, Texture texture){
        inScene = true;
        isDragged = false;
        box = new Rectangle();
        box.setHeight(64);
        box.setWidth(64);

        this.name = name;

        sprite = new Sprite(texture);

        sprite.scale(1);
    }

    public Object(final Object o) {
        this.box = new Rectangle();
        this.inScene = o.inScene;
        this.box.setHeight(64);
        this.box.setWidth(64);
        this.name = o.name;
        this.sprite = new Sprite(o.sprite.getTexture());
        this.sprite.scale(1);
    }

    public String getName(){
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    public void dispose(){
        this.dispose();
    }
}
