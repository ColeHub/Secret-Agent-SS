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
        this.x = x;
        this.y = y;

        box = new Rectangle();
        box.x = (800 / 3) * 2;
        box.y = (480 / 3);
        box.setHeight(64);
        box.setWidth(64);

        sprite = new Sprite(Art.playerImg);
        sprite.scale(4);
        sprite.setPosition(box.x, box.y);

    }

    public Player(Player box) {
        this.x = box.x;
        this.y = box.y;
    }

    public String toString() {
        String result = "";
        result += box.x + ", " + box.y;
        return result;
    }

}
