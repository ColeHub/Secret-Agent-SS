package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by cole on 2014-10-12.
 */
public class DialogScreen implements Screen {
    final SASS game;
    final Level level;
    Dialog dialog;
    public static int counter;
    public static int counted;
    SpriteBatch batch;
    BitmapFont font;
    Rectangle selectBox;
    OrthographicCamera camera;
    Input input;

    int pos1, pos2, pos3, posNPCText;
    int margin;

    public DialogScreen(final SASS sass, int set) {
        this.game = sass;
        level = new Level(game);
        switch (set) {
            case 1:
                dialog.set1();
                break;
            case 2:
                dialog.set2();
                break;
            case 3:
                dialog.set3();
                break;
            default:
                break;
        }
        //this.dialog = dialog;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        Art.load();
        font = new BitmapFont();

        pos1 = 120;
        pos2 = 80;
        pos3 = 40;
        posNPCText = 440;
        margin = 20;

        counter = 0;

        selectBox = new Rectangle(0, 120, 800, 40);

        input = new Input(level, this);
    }

    public void render(float delta) {

        CharSequence strNPC = dialog.textNPC;
        CharSequence str1 = dialog.option1;
        CharSequence str2 = dialog.option2;
        CharSequence str3 = dialog.option3;

        Gdx.gl.glClearColor(0, 0, 0, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (counter == 0) selectBox.y = 120;
        if (counter == 1) selectBox.y = 80;
        if (counter == 2) selectBox.y = 40;

        batch.begin();
        Art.dialogSelectSprite.setPosition(selectBox.x, selectBox.y);
        Art.dialogSelectSprite.draw(batch);
        font.draw(batch, strNPC, margin, posNPCText);
        font.draw(batch, str1, margin, pos1);
        font.draw(batch, str2, margin, pos2);
        font.draw(batch, str3, margin, pos3);
        batch.end();

        input.dialog();

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
    }


}
