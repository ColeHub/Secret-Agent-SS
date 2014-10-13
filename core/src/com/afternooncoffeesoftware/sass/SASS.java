package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;

public class SASS extends Game {
    Global global;
    @Override
    public void create() {
        global = new Global(this);
        //load files
        Art.load();
        Sound.load();

        //change screen to menu screen on startup
        this.setScreen(new Menu(this));

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }
}
