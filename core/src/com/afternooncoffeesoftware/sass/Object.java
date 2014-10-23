package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
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
    private String name;

    public Object(final String name, Texture texture){
        this.name = name;

        box = new Rectangle();
        sprite = new Sprite(texture);
        sprite.scale(1);
        box.setHeight(sprite.getHeight() * sprite.getScaleY());
        box.setWidth(sprite.getHeight() * sprite.getScaleX());
        sprite.setOrigin(box.x, box.y);
        sprite.setCenter(box.getWidth() / 2, box.getHeight() / 2);
    }

    public Object(final Object o) {
        this.box = new Rectangle();
        this.box.setHeight(64);
        this.box.setWidth(64);
        this.name = o.name;
        this.sprite = new Sprite(o.sprite.getTexture());
        sprite.setOrigin(box.x, box.y);
        sprite.setCenter(box.getWidth() / 2, box.getHeight() / 2);
        this.sprite.scale(1);
    }

    public void draw(Batch batch) {
        sprite.draw(batch);
    }

    public void setPosition(float x, float y) {
        box.setPosition(x, y);
        sprite.setPosition(box.x, box.y);
    }

    public void setScale(int scale) {
        sprite.setScale(scale);
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
