package com.caseydjbugs.game;


import com.badlogic.gdx.Game;

import com.badlogic.gdx.InputProcessor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.caseydjbugs.game.Screens.BattleScreen;




public class BugsGame extends Game implements InputProcessor {

    public static final int width = 400;
    public static final int height = 208;


    //make only one spritebatch because its memory intensive
    public SpriteBatch batch;
    private float timePassed1 = 0;




    @Override
    public void create() {
        batch = new SpriteBatch();
        //made package for Screens, can set different screens in BugsGame class
        setScreen(new BattleScreen(this));
    }


    @Override
    public void dispose() {
        batch.dispose();
    }


    @Override
    public void render() {
        super.render();
    }


    /* When the finger touches down on the keyboard
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    /* When the finger comes up off the screen

     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }


    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
