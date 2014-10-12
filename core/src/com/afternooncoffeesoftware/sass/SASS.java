package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;

public class SASS extends Game {

    @Override
    public void create() {
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
