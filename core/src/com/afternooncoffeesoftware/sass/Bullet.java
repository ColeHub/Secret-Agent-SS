package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by cole on 2015-01-06.
 */
public class Bullet {
    public int x;
    public int y;
    public Rectangle box;
    public Sprite sprite;
    public boolean face;

    public Bullet(final boolean faceRight) {
        box = new Rectangle();
        sprite = new Sprite(Art.bulletSprite);
        face = faceRight;
        sprite.scale(0.2f);
        box.setHeight(sprite.getHeight() * sprite.getScaleY());
        box.setWidth(sprite.getHeight() * sprite.getScaleX());
        sprite.setOrigin(box.x, box.y);
        sprite.setCenter(box.getWidth() / 2, box.getHeight() / 2);
    }

    public Bullet(final Bullet b) {
        this.box = new Rectangle();
        this.box.setHeight(b.box.getHeight());
        this.box.setWidth(b.box.getWidth());
        this.sprite = new Sprite(b.sprite.getTexture());
        sprite.setOrigin(box.x, box.y);
        sprite.setCenter(box.getWidth() / 2, box.getHeight() / 2);
        this.sprite.scale(0.2f);
    }

    public void draw(Batch batch) {
        sprite.setPosition(box.x, box.y);
        sprite.draw(batch);
    }

    public void setPosition(float x, float y) {
        box.setPosition(x, y);
        sprite.setPosition(box.x, box.y);
    }

    public void setScale(int scale) {
        sprite.setScale(scale);
    }

    public boolean facingRight() {
        if (face) return true;
        else return false;
    }

    public boolean visible() {
        if (box.x > Gdx.graphics.getWidth() || box.x < 0) return false;
        else return true;
    }

    public void dispose() {
        this.dispose();
    }
}
