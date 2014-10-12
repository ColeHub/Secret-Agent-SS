package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.*;

public class SASS extends Game {

    PauseMenu pauseMenu;
    @Override
    public void create() {
        this.setScreen(new Menu(this));
        Art.load();
        Sound.load();

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }
}
