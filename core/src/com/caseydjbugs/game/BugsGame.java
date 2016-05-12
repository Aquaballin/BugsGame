package com.caseydjbugs.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


import java.awt.Polygon;
import java.util.List;

public class BugsGame extends ApplicationAdapter implements InputProcessor {

    //the sprite values need to represent the batch drawing


    Box2DDebugRenderer debugRenderer = new Box2DDebugRenderer();

    PolygonShape shape = new PolygonShape();
    FixtureDef fixtureDef = new FixtureDef();
    MapObject mapObject = new MapObject();
    AssetManager assetManager;
    Body body;

    TextureAtlas textureAtlas;
    Sprite sprite;


    SpriteBatch batch;
    private float timePassed1 = 0;

    RightBugOne startingRightBug;
    LeftBugOne startingLeftBug;
    Coin coin;


    @Override
    public void create() {
        Gdx.input.setInputProcessor(this);
        startingLeftBug = new LeftBugOne();
        startingRightBug = new RightBugOne();
        coin = new Coin();


        textureAtlas = new TextureAtlas(Gdx.files.internal("LeftBugOne.atlas"));
        sprite  = new Sprite(textureAtlas.createSprite("leftBugAutoRun"));

        batch = new SpriteBatch();
        sprite.setPosition(Gdx.graphics.getWidth()-Gdx.graphics.getWidth(),Gdx.graphics.getHeight()-Gdx.graphics.getHeight());
        World world = new World(new Vector2(0,0),true);// (0,0) is grav weight
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(sprite.getX(),sprite.getY());
        body = world.createBody(bodyDef);
        PolygonShape shape;
        shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth()/2,sprite.getHeight()/2);







    }


    @Override
    public void dispose() {
        startingLeftBug.atlas_LeftBugOne_run.dispose();
        startingRightBug.atlas_RightBugOne_run.dispose();
        batch.dispose();
    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        timePassed1 += Gdx.graphics.getDeltaTime();
        batch.draw(coin.coinAnimation.getKeyFrame(timePassed1,true),50,1100);
        batch.draw(coin.coinAnimation.getKeyFrame(timePassed1,true),Gdx.graphics.getHeight()+600,1100);
        startingLeftBug.bounds = new Rectangle(startingLeftBug.x + 1, 0, 500, 500);
        startingRightBug.bounds = new Rectangle(startingRightBug.x + 1, 0, 500, 500);

        if (startingLeftBug.bounds.overlaps(startingRightBug.bounds)) {
            //stop and fight animation
            batch.draw(startingRightBug.fight.getKeyFrame(timePassed1,true),startingRightBug.x,0);
            batch.draw(startingLeftBug.fight.getKeyFrame(timePassed1,true),startingLeftBug.x,0);
            batch.draw(startingRightBug.healthDecreasingByOnePerSecond.getKeyFrame(timePassed1,false),startingRightBug.x,700);
            batch.draw(startingRightBug.healthDecreasingByOnePerSecond.getKeyFrame(timePassed1,false),startingLeftBug.x,700);
            //fight()
        } else {
            batch.draw(startingLeftBug.run.getKeyFrame(timePassed1, true), startingLeftBug.x += 1, 0);
            batch.draw(startingRightBug.run.getKeyFrame(timePassed1, true), startingRightBug.x -= 1, 0);
            batch.draw(startingLeftBug.healthFull.getKeyFrame(0,true),startingLeftBug.x +=1, 700);
            batch.draw(startingRightBug.healthFull.getKeyFrame(0,true),startingRightBug.x -=1, 700);
            //

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
