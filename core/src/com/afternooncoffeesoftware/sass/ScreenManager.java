package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.utils.IntMap;

/**
 * Created by cole on 2014-10-18.
 */
public final class ScreenManager {
    private static ScreenManager instance;
    private SASS game;

    //creates the table of screens
    private IntMap<com.badlogic.gdx.Screen> screens;


    private ScreenManager() {
        screens = new IntMap<com.badlogic.gdx.Screen>();
    }

    //create a screen manager if it doesn't already exist
    public static ScreenManager getInstance() {
        if (null == instance) {
            instance = new ScreenManager();
        }
        return instance;
    }

    //point to the game thread
    public void initialize(SASS sass) {
        this.game = sass;
    }

    //specialized show method for dialog windows
    public void showDialog(int set, NPC npc) {
        Screen.DIALOG.setDialog(set, npc);
        show(Screen.DIALOG);
    }

    //returns the main level class variable
    //used for referring to variables in the level that are needed in another screen.
    public Level getLevel(Screen screen) {
        return screen.getLevel();
    }

    //the main screen switcher class
    public void show(Screen screen) {
        if (null == game) return;
        if (!screens.containsKey(screen.ordinal()) || screens.containsKey(Screen.DIALOG.ordinal())) {
            screens.put(screen.ordinal(), screen.getScreenInstance());
        }
        game.setScreen(screens.get(screen.ordinal()));
    }

    //useless right now
    public static Class getClass(Screen screen) {
        return screen.getClass();
    }

    //trash maintenence
    public void dispose(Screen screen) {
        if (!screens.containsKey(screen.ordinal())) return;
        screens.remove(screen.ordinal()).dispose();
    }

    public void dispose() {
        for (com.badlogic.gdx.Screen screen : screens.values()) {
            screen.dispose();
        }
        screens.clear();
        instance = null;
    }
}
