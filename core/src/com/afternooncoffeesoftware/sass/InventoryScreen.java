package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import java.util.ArrayList;


/**
 * Created by cole on 2014-10-21.
 */
public class InventoryScreen implements com.badlogic.gdx.Screen {

    Input input;
    Level level;
    OrthographicCamera camera;
    public static SpriteBatch batch;
    public static Object[] obj = new Object[6];
    int[] posX = {124, 220, 400};
    int[] posY = {224, 200};
    ArrayList<Object> inventory;

    BitmapFont font;

    public static int state;

    int x = 0, y = 0;
    Rectangle mouseBox;
    boolean isDragged, overlapping = false;

    public InventoryScreen() {
        level = ScreenManager.getInstance().getLevel(com.afternooncoffeesoftware.sass.Screen.LEVEL);
        inventory = level.player.inventory;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        state = 0;
        input = new Input(level);

        font = new BitmapFont();
        mouseBox = new Rectangle(0, 0, 2, 2);


    }

    @Override
    public void render(float delta) {

        //add items in list to inventoryscreen object array
        for (int i = 0; i <= inventory.size() - 1; i++) {
            obj[i] = new Object(inventory.get(i));
        }

        //set mouse x and y
        x = Gdx.input.getX();
        y = Gdx.input.getY();
        mouseBox.setPosition(x - (mouseBox.getWidth() / 2), 480 - y - (mouseBox.getHeight() / 2));

        //debugging string
        CharSequence str = "X: " + x + " Y: " + y;

        //set input mode
        input.inventory();

        //init
        Gdx.gl.glClearColor(1, 1, 1, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        //draw
        batch.begin();
        Art.inventorySprite.draw(batch);

        //debugging
        font.draw(batch, str, 10, 400);

        //draw objects in proper position
        for (int j = 0; j < 6; j++) {
            if (obj[j] != null) {
                if (j <= 3) obj[j].setPosition(posX[j], posY[0]);
                if (j < 6 && j > 3) obj[j].setPosition(posX[j], posY[1]);
                obj[j].setScale(4);
                obj[j].draw(batch);
            }
        }

//        //handle dragging
//        for (Object anObj : obj) {
//            if (anObj != null) {
//                if (Gdx.input.isButtonPressed(0)) {
//                    isDragged = true;
//                    if (Intersector.overlaps(anObj.box, mouseBox)) {
//                        isDragged = true;
//                        overlapping = true;
//                    }
//                    if (isDragged && overlapping) {
//                        anObj.setPosition(x - (anObj.sprite.getWidth() / 2), 480 - y - (anObj.sprite.getHeight() / 2));
//                        anObj.sprite.draw(batch);
//                    }
//                } else {
//                    isDragged = false;
//                    overlapping = false;
//                }
//            }
//        }

        //handle dragging
        Object temp;
        if (Intersector.overlaps(inventory.get(0).box, mouseBox)) {
            isDragged = true;
            temp = inventory.get(0);
        }
        if (Intersector.overlaps(inventory.get(1).box, mouseBox)) {
            isDragged = true;
            temp = inventory.get(1);
        } else
            temp = inventory.get(0);

        if (Gdx.input.isButtonPressed(0)) {
            isDragged = true;
            if (isDragged && temp.getName().equals(inventory.get(0).getName())) {
                inventory.get(0).box.setPosition(x - (inventory.get(0).sprite.getWidth() / 2), 480 - y - (inventory.get(0).sprite.getHeight() / 2));
            }
            if (isDragged && temp.getName().equals(inventory.get(1).getName())) {
                inventory.get(1).box.setPosition(x - (inventory.get(1).sprite.getWidth() / 2), 480 - y - (inventory.get(1).sprite.getHeight() / 2));
            }
        } else {
            isDragged = false;
        }


        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
