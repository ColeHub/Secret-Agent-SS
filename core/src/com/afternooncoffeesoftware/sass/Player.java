package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by cole on 2014-10-10.
 */
public class Player {
    public int x = 0;
    public int y = 0;
    public static Rectangle box;
    public static Sprite sprite;

    public Player(int x, int y) {

        box = new Rectangle();
        box.x = x;
        box.y = y;
        box.setHeight(64);
        box.setWidth(64);

        sprite = new Sprite(Art.playerRegIdle);
        sprite.scale(4);
        sprite.setPosition(box.x, box.y);

    }

    public Player(Player box) {
        this.x = box.x;
        this.y = box.y;
    }

    public String toString() {
        String result = "";
        result += "Player X: " + box.x + " Y: " + box.y;
        return result;
    }

}
