package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by cole on 2014-10-12.
 */
public class NPC {
    public float x;
    public float y;
    public Rectangle box;
    public Sprite sprite;
    public boolean talkative;

    public NPC(Texture texture) {

        talkative = true;

        box = new Rectangle();
        sprite = new Sprite(texture);
        sprite.scale(4);
        box.setHeight(sprite.getHeight() * sprite.getScaleY());
        box.setWidth(sprite.getHeight() * sprite.getScaleX());
        sprite.setOrigin(box.x, box.y);
        sprite.setCenter(box.getWidth() / 2, box.getHeight() / 2);
    }

    public NPC(final NPC npc) {
        talkative = true;
        box = new Rectangle();
        sprite = new Sprite(npc.sprite.getTexture());
        sprite.scale(4);
        box.setHeight(sprite.getHeight() * sprite.getScaleY());
        box.setWidth(sprite.getHeight() * sprite.getScaleX());
        sprite.setOrigin(box.x, box.y);
        sprite.setCenter(box.getWidth() / 2, box.getHeight() / 2);
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

    @Override
    public String toString() {
        String result = "";
        result += "NPC X: " + box.x + " Y: " + box.y;
        return result;
    }
}
