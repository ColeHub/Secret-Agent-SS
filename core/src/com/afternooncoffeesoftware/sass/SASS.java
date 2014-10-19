package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;

public class SASS extends Game {
    Global global;
    Dialog dialog;
    @Override
    public void create() {
        global = new Global(this);
        ScreenManager.getInstance().initialize(this);
        //load files
        Art.load();
        Sound.load();

        //change screen to menu screen on startup
        //this.setScreen(new Splash(this));
        ScreenManager.getInstance().show(Screen.SPLASH);
        //this.setScreen(new Level(this));

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }
}
