package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;

public class SASS extends Game {
    Global global;
    Dialog dialog;
    @Override
    public void create() {
        global = new Global(this);
        //load files
        Art.load();
        Sound.load();

        //change screen to menu screen on startup
        //this.setScreen(new Splash(this));
        this.setScreen(new Level(this));

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }
}
