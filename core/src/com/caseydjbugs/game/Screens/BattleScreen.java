package com.caseydjbugs.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.caseydjbugs.game.BugsGame;
import com.caseydjbugs.game.Scenes.Hud;
import com.caseydjbugs.game.Sprites.LeftBug;
import com.caseydjbugs.game.Sprites.RightBug;


/**
 * Created by David on 5/12/2016.
 */
public class BattleScreen implements Screen {
    private BugsGame game;
    private OrthographicCamera gameCamera;
    private Viewport viewport;
    private Hud hud;
    SpriteBatch batch;
    //Box2d variables
    private World world;
    private Box2DDebugRenderer debugRenderer;
    LeftBug leftBug;
    RightBug rightBug;
    public Texture texture;

    Sprite sprite, sprite2;

    public BattleScreen(BugsGame game) {
        this.game = game;
        gameCamera = new OrthographicCamera();
        viewport = new FitViewport(BugsGame.width,BugsGame.height,gameCamera);
        gameCamera.position.set(viewport.getWorldWidth()/2,viewport.getWorldHeight()/2,0);
        hud = new Hud(game.batch);
        world = new World(new Vector2(0,0),true);
        leftBug = new LeftBug(world);
        rightBug = new RightBug(world);
        debugRenderer = new Box2DDebugRenderer();
        game.batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("LeftBugOne.png"));
        sprite = new Sprite(texture,0,0,57,58);
        sprite2 = new Sprite( new Texture(Gdx.files.internal("RightBugOne.png")),0,0,57,58);

    }

    @Override
    public void show() {

    }

     public void handleInput(float dt) {

         leftBug.body.setLinearVelocity(new Vector2(15f, 0));
         rightBug.body.setLinearVelocity(new Vector2(-15f,0));
         sprite.setPosition(leftBug.body.getPosition().x-16,leftBug.body.getPosition().y-16);
         sprite2.setPosition(rightBug.body.getPosition().x-16,rightBug.body.getPosition().y-16);
         //hud.leftMoneyCount += dt;


     }
    public void update(float dt) {

        handleInput(dt);
        hud.update(dt);
        world.step(1 / 60f, 6, 2);
        gameCamera.update();




    }
    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        debugRenderer.render(world,gameCamera.combined);
        game.batch.begin();
        sprite.draw(game.batch);
        sprite2.draw(game.batch);
        game.batch.end();


        /**
        game.batch.begin();
        game.batch.draw(texture,leftBug.body.getPosition().x,rightBug.body.getPosition().y);

        game.batch.end();
         **/
    }
    /*
    User this to auto adjust screen
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    public World getWorld(){
        return world;
    }
}
