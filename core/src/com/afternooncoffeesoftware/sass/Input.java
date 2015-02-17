package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.InputProcessor.*;

/**
 * Created by cole on 2014-10-10.
 */
public class Input {
    final Level level;
    DialogScreen dialog;
    Player player;
    public boolean walkRight = false;
    public boolean walkLeft = false;
    private int maxLeft = 300;
    private int maxRight = 500;

    //sets the speed limit
    private static final float MAX_MOVEMENT_SPEED = 400 * Gdx.graphics.getDeltaTime();
    public static float oldVel = 0;

    public static float transition_speed = 4f;
    public static float newVel = 0f;
    public static float endVel = 350 * Gdx.graphics.getDeltaTime();


    public Input(final Level level) {
        this.level = level;
    }

    public Input(final Level level, final DialogScreen dialogScreen) {
        this.level = level;
        dialog = dialogScreen;
    }

    public void menu() {
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) Gdx.app.exit();

    }
    public boolean enterButtonIsPressed() {
        boolean isPressed = false;
        if (Gdx.input.isKeyJustPressed(Keys.SPACE)
                || Gdx.input.isKeyJustPressed(Keys.ENTER)) {
            isPressed = true;
        }
        return isPressed;
    }
    public boolean rightIsPressed() {
        boolean isPressed = false;
        if (Gdx.input.isKeyPressed(Keys.D)
                || Gdx.input.isKeyPressed(Keys.RIGHT))
            isPressed = true;
        return isPressed;
    }
    public boolean leftIsPressed() {
        boolean isPressed = false;
        if (Gdx.input.isKeyPressed(Keys.A)
                || Gdx.input.isKeyPressed(Keys.LEFT))
            isPressed = true;
        return isPressed;
    }

    public void level(Player player) {
            //scrubs acceleration if stopped
            if (!walkLeft && !walkRight) {
                newVel = 0f;
                oldVel = 0f;
            }

            if ((rightIsPressed() ^ leftIsPressed()) && leftIsPressed()) {
                walkLeft = true;
                //calculate acceleration
                newVel = oldVel * (1 - Gdx.graphics.getDeltaTime() * transition_speed)
                        + endVel * (Gdx.graphics.getDeltaTime() * transition_speed);
                //log velocity and walking states
                Gdx.app.log("Left Velocity", String.valueOf(newVel));
                Gdx.app.log("walkLeft = ", String.valueOf(walkLeft));
                Gdx.app.log("walkRight = ", String.valueOf(walkRight));
                //set velocity to max if calculated velocity is over max
                if (newVel < MAX_MOVEMENT_SPEED) {
                    player.box.x -= newVel;
                    oldVel = newVel;
                } else {
                    player.box.x -= MAX_MOVEMENT_SPEED;
                }


                if (player.box.x <= maxLeft) {
                    player.box.x = maxLeft;
                    //move global offset
                    if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A))
                        level.globalOffset += newVel;
                }

            } else {
                walkLeft = false;
            }


        if ((rightIsPressed() ^ leftIsPressed()) && rightIsPressed()) {
                walkRight = true;
                //calculate acceleration
                newVel = oldVel * (1 - Gdx.graphics.getDeltaTime() * transition_speed)
                        + endVel * (Gdx.graphics.getDeltaTime() * transition_speed);
                //log velocity and walking states
                Gdx.app.log("Right Velocity", String.valueOf(newVel));
                Gdx.app.log("walkLeft = ", String.valueOf(walkLeft));
                Gdx.app.log("walkRight = ", String.valueOf(walkRight));
                //set velocity to max if calculated velocity is over max
                if (newVel < MAX_MOVEMENT_SPEED) {
                    player.box.x += newVel;
                    oldVel = newVel;
                } else {
                    player.box.x += MAX_MOVEMENT_SPEED;
                }


                if (player.box.x >= maxRight) {
                    player.box.x = maxRight;
                    //move global offset
                    if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D))
                        level.globalOffset -= newVel;
                }
            } else {
                walkRight = false;
            }


        if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) ScreenManager.getInstance().show(Screen.PAUSEMENU);

        if (Gdx.input.isKeyJustPressed(Keys.I)) ScreenManager.getInstance().show(Screen.INVENTORY);

    }

    public void dialog() {
        if (Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.W)) {
            //move dialog option up
            if (dialog.counter > 0)
                dialog.counter--;
            else {
                dialog.counter = 0;
            }
        }
        if (Gdx.input.isKeyJustPressed(Keys.DOWN) || Gdx.input.isKeyJustPressed(Keys.S)) {
            //move dialog option down
            if (dialog.counter < 2)
                dialog.counter++;
            else {
                dialog.counter = 2;
            }
        }
        if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
            //activate dialog option

            dialog.counted = dialog.counter;
        }
    }

    public void inventory() {
        if (Gdx.input.isKeyJustPressed(Keys.I) || Gdx.input.isKeyJustPressed(Keys.ESCAPE) ) ScreenManager.getInstance().show(Screen.LEVEL);
    }
}
