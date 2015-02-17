package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;



/**
 * Created by cole on 2014-10-12.
 */
public class DialogScreen implements com.badlogic.gdx.Screen {
    Level level;
    NPC npc;
    Dialog dialog;
    public int counter;
    public int counted;
    SpriteBatch batch;
    Rectangle selectBox;
    OrthographicCamera camera;
    Input input;

    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Minecraftia-Regular.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    BitmapFont font;

    int pos1, pos2, pos3, posNPCText, currentSet;
    int margin;
    int FONT_WRAP_WIDTH = Gdx.graphics.getWidth() - 30;

    public DialogScreen(int set, NPC npc) {
        this.npc = npc;
        level = ScreenManager.getInstance().getLevel(com.afternooncoffeesoftware.sass.Screen.LEVEL);
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
            case 4:
                dialog.entranceGuard1Set1();
                break;
            case 5:
                dialog.entranceGuard1Set2();
                break;
            case 6:
                dialog.entranceGuard1Set3();
                break;
            default:
                break;
        }
        currentSet = set;
        //this.dialog = dialog;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        Art.load();
        font = new BitmapFont();

        pos1 = 100;
        pos2 = 60;
        pos3 = 20;
        posNPCText = 440;
        margin = 20;

        counter = 0;

        selectBox = new Rectangle(0, 120, 800, 40);

        input = new Input(level, this);

        //font params
        parameter.size = 24;
        font = generator.generateFont(parameter);
    }

    public void setSet(int set) {
        ScreenManager.getInstance().showDialog(set, npc);
    }


    public void render(float delta) {
        input.dialog();

        Gdx.gl.glClearColor(0, 0, 0, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        level.entranceGuard1.talkative = false;


        //controls the flow of the guard conversations
        if (currentSet == 1) {
            if (counter == 0 && Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER))
                setSet(2);
            if (counter == 1 && Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER))
                dialog.textNPC = "Sorry?";
            if (counter == 2 && Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER)) {
                dialog.textNPC = "...?";
            }
        }
        if (currentSet == 2) {
            if (counter == 0 && Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER)) {
                ScreenManager.getInstance().show(com.afternooncoffeesoftware.sass.Screen.LEVEL);
                level.guard.talkative = false;
            }
            if (counter == 1 && Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER)) {
                ScreenManager.getInstance().show(com.afternooncoffeesoftware.sass.Screen.LEVEL);
                level.guard.talkative = false;
            }
            if (counter == 2 && Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER) )
                setSet(3);
        }

        if (currentSet == 3) {
            Art.dialogSelectSprite.setColor(0,0,0,0.2f);
            if (counter < 3 && Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ENTER) ||
                    Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.SPACE)) {

                ScreenManager.getInstance().show(com.afternooncoffeesoftware.sass.Screen.LEVEL);
                level.guard.talkative = false;
                level.guard2.talkative = false;
            }
        }
        //controls the flow of the entranceGuard1 conversation
        if (currentSet == 4) {
            if ((counter == 0 || counter == 1) && input.enterButtonIsPressed())
                setSet(5);

            if (counter == 2 && input.enterButtonIsPressed())
                setSet(6);
            }
        if (currentSet == 5 || currentSet == 6) {
            if (input.enterButtonIsPressed()) {
                ScreenManager.getInstance().show(com.afternooncoffeesoftware.sass.Screen.LEVEL);
            }
        }


        CharSequence strNPC = dialog.textNPC;
        CharSequence str1 = dialog.option1;
        CharSequence str2 = dialog.option2;
        CharSequence str3 = dialog.option3;

        if (counter == 0) selectBox.y = 115;
        if (counter == 1) selectBox.y = 75;
        if (counter == 2) selectBox.y = 35;

        batch.begin();
        Art.dialogSelectSprite.setPosition(selectBox.x, selectBox.y);
        Art.dialogSelectSprite.draw(batch);
        npc.sprite.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        npc.sprite.draw(batch);
        //font.draw(batch, strNPC, margin, posNPCText);
        //wraps the npc text
        font.drawWrapped(batch, strNPC, margin, posNPCText, FONT_WRAP_WIDTH);

        font.draw(batch, str1, margin, pos1);
        font.draw(batch, str2, margin, pos2);
        font.draw(batch, str3, margin, pos3);
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
        generator.dispose();
    }


}
