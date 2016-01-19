package com.caseydjbugs.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class BugsGame extends ApplicationAdapter implements InputProcessor {
    //draws batched quad using indices
    SpriteBatch batch;
    //timePassed for how long it takes to draw frames
    private float timePassed1 = 0;
    //Right player starting bug, for now we will make this a computer player
    RightBugOne startingRightBug;
    //left player starting bug
    LeftBugOne startingLeftBug;

    //PHYSICS FOR COLLISION
    //create a world to start a physics engine, pass gravity as a parameter
    World bugBeach = new World(new Vector2(0, -98f), true);
    //now create a body definition, this defines the physics objects type and position in the simulation
    BodyDef bodyDef = new BodyDef(); // go to this link to continue figureing out how to use the body def.
    /**
     * http://www.gamefromscratch.com/post/2014/08/27/LibGDX-Tutorial-13-Physics-with-Box2D-Part-1-A-Basic-Physics-Simulations.aspx
     */


    /**
     * This method creates running memory elements
     */
    @Override
    public void create() {
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
        startingLeftBug = new LeftBugOne();
        startingRightBug = new RightBugOne();
    }

    /**
     * delete memory components made in create
     */
    @Override
    public void dispose() {
        startingLeftBug.atlas_LeftBugOne_run.dispose();
        startingRightBug.atlas_RightBugOne_run.dispose();
        batch.dispose();
    }

    //draws everything, infinite loop
    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        timePassed1 += Gdx.graphics.getDeltaTime();

        startingLeftBug.bounds = new Rectangle(startingLeftBug.x + 1, 0, 400, 400);
        startingRightBug.bounds = new Rectangle(startingRightBug.x + 1, 0, 400, 400);
        if (startingLeftBug.bounds.overlaps(startingRightBug.bounds)) {

            //stop and fight animation
            batch.draw(startingRightBug.fight.getKeyFrame(timePassed1,true),startingRightBug.x,0);
            batch.draw(startingLeftBug.fight.getKeyFrame(timePassed1,true),startingLeftBug.x,0);
            //fight()
        } else {
            batch.draw(startingLeftBug.run.getKeyFrame(timePassed1, true), startingLeftBug.x += 1, 0);
            batch.draw(startingRightBug.run.getKeyFrame(timePassed1, true), startingRightBug.x -= 1, 0);
        }

        batch.end();
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
