package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by cole on 2014-10-12.
 */
public class NPC {
    public int x;
    public int y;
    public Rectangle box;
    public Sprite sprite;
    public static boolean active;

    public NPC(Texture texture) {

        active = true;
        box = new Rectangle();
        box.setHeight(64);
        box.setWidth(64);


        sprite = new Sprite(texture);
        sprite.scale(4);
    }

    public NPC(Player box) {
        this.x = box.x;
        this.y = box.y;
    }

    @Override
    public String toString() {
        String result = "";
        result += "NPC X: " + box.x + " Y: " + box.y;
        return result;
    }
}
