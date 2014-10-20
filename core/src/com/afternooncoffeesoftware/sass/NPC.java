package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.Texture;
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
        box.setHeight(64);
        box.setWidth(64);

        x = box.x;
        y = box.y;

        sprite = new Sprite(texture);
        sprite.scale(4);
    }

    @Override
    public String toString() {
        String result = "";
        result += "NPC X: " + box.x + " Y: " + box.y;
        return result;
    }
}
