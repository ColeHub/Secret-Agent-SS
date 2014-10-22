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
    int[] posX = {148, 244, 400};
    int[] posY = {248, 200};
    ArrayList<Object> inventory;

    BitmapFont font;

    public static int state;

    int x = 0, y = 0;
    Rectangle mouseBox;

    public InventoryScreen() {
        level = ScreenManager.getInstance().getLevel(com.afternooncoffeesoftware.sass.Screen.LEVEL);
        inventory = level.player.inventory;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        state = 0;
        input = new Input(level);

        font = new BitmapFont();
        mouseBox = new Rectangle(0, 0, 8, 8);


    }

    @Override
    public void render(float delta) {

        for (int i = 0; i <= inventory.size() - 1; i++) {
            obj[i] = new Object(inventory.get(i));
        }

        x = Gdx.input.getX();
        y = Gdx.input.getY();
        mouseBox.setPosition(x, 480 - y);

        //debugging string
        CharSequence str = "X: " + x + " Y: " + y;

        input.inventory();

        Gdx.gl.glClearColor(1, 1, 1, 0.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        Art.inventorySprite.draw(batch);

        //debugging
        font.draw(batch, str, 10, 400);

        for (int j = 0; j < 6; j++) {
            if (obj[j] != null && !obj[j].isDragged) {
                if (j <= 3) obj[j].box.setPosition(posX[j], posY[0]);
                if (j < 6 && j > 3) obj[j].box.setPosition(posX[j], posY[1]);
                obj[j].sprite.setPosition(obj[j].box.x, obj[j].box.y);
                obj[j].sprite.scale(2);
                obj[j].sprite.draw(batch);
            }
        }

        //BELOW IS POORLY OPTOMIZED
        //WILL BE REVISTED
        //BUT YOU GET THE IDEA

        if (Gdx.input.isButtonPressed(0) && Intersector.overlaps(obj[0].box, mouseBox)) {
            obj[0].isDragged = true;
        } else if (Gdx.input.isButtonPressed(0) && !Intersector.overlaps(obj[0].box, mouseBox)) {
            obj[0].isDragged = true;
        }

        if (obj[0].isDragged) {
            obj[0].box.setPosition(x, 480 - y);
            obj[0].sprite.setPosition(obj[0].box.x, obj[0].box.y);
            obj[0].sprite.draw(batch);
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
