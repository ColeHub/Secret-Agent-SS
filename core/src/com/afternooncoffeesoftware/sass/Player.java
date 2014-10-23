package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cole on 2014-10-10.
 */
public class Player {
    public int x = 0;
    public int y = 0;
    public Rectangle box;
    public Sprite sprite;
    public ArrayList<Object> inventory;

    public Player(int x, int y) {
        inventory = new ArrayList<Object>();

        box = new Rectangle();
        sprite = new Sprite(Art.playerRegIdle);
        sprite.scale(4);
        box.setHeight(128);
        box.setWidth(64);
//        box.setHeight(sprite.getHeight() * sprite.getScaleY());
//        box.setWidth(sprite.getHeight() * sprite.getScaleX());
        sprite.setOrigin(box.x, box.y);
        sprite.setCenter(box.getWidth() / 2, box.getHeight() / 2);

        setPosition(x, y);
    }

    public void draw(Batch batch) {
        sprite.draw(batch);
    }

    public void setPosition(float x, float y) {
        box.setPosition(x, y);
        sprite.setPosition(box.x - 50, box.y);
    }

    public void setX(float x) {
        box.setPosition(x, box.y);
        sprite.setPosition(x, box.y);
    }

    public void setY(float y) {
        box.setPosition(box.x, y);
        sprite.setPosition(box.x, y);
    }

    public void setScale(int scale) {
        sprite.setScale(scale);
    }

    public float getCenterX() {
        return sprite.getWidth() / 2 + box.getX();
    }

    public float getCenterY() {
        return sprite.getHeight() / 2 + box.getY();
    }
    @Override
    public String toString() {
        String result = "";
        result += "Player X: " + box.x + " Y: " + box.y;
        return result;
    }

}
