package com.afternooncoffeesoftware.sass;

/**
 * Created by cole on 2014-10-18.
 */
public enum Screen {

    SPLASH {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new Splash();
        }
    },

    MENU {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new Menu();
        }
    },

    PAUSEMENU {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new PauseMenu();
        }
    },

    LEVEL {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            if (level == null) return level = new Level();
            return level;
        }
    },

    DIALOG {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return ds = new DialogScreen(set, npc);
        }
    };

    Level level;
    DialogScreen ds;
    int set = 0;
    NPC npc;

    protected void setDialog(int set, NPC npc) {
        this.set = set;
        this.npc = npc;
    }

    Screen() {
    }

    protected Level getLevel() {
        return level;
    }

    protected abstract com.badlogic.gdx.Screen getScreenInstance();

}
