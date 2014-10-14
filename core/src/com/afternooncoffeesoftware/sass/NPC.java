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
    Dialog dialog;
    public static Rectangle box;
    public static Sprite sprite;

    public NPC(int x, int y, Texture texture) {

        box = new Rectangle();
        box.x = x;
        box.y = y;
        box.setHeight(64);
        box.setWidth(64);


        sprite = new Sprite(texture);
        sprite.scale(4);
        sprite.setPosition(box.x, box.y);




    }

    public NPC(Player box) {
        this.x = box.x;
        this.y = box.y;
    }

    public String toString() {
        String result = "";
        result += "Player x,y\n";
        result += box.x + ", " + box.y;
        return result;
    }
}
