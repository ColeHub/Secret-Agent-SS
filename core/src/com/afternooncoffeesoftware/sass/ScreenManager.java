package com.afternooncoffeesoftware.sass;

import com.badlogic.gdx.utils.IntMap;

/**
 * Created by cole on 2014-10-18.
 */
public final class ScreenManager {
    private static ScreenManager instance;
    private SASS game;

    private IntMap<com.badlogic.gdx.Screen> screens;


    private ScreenManager() {
        screens = new IntMap<com.badlogic.gdx.Screen>();
    }

    public static ScreenManager getInstance() {
        if (null == instance) {
            instance = new ScreenManager();
        }
        return instance;
    }

    public void initialize(SASS sass) {
        this.game = sass;
    }

    public void showDialog(int set, NPC npc) {
        Screen.DIALOG.setDialog(set, npc);
        show(Screen.DIALOG);
    }

    public Level getLevel(Screen screen) {
        return screen.getLevel();
    }

    public void show(Screen screen) {
        if (null == game) return;
        if (!screens.containsKey(screen.ordinal()) || screens.containsKey(Screen.DIALOG.ordinal())) {
            screens.put(screen.ordinal(), screen.getScreenInstance());
        }
        game.setScreen(screens.get(screen.ordinal()));
    }

    public static Class getClass(Screen screen) {
        return screen.getClass();
    }

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
