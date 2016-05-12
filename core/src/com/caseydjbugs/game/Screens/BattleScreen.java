package com.caseydjbugs.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.caseydjbugs.game.BugsGame;




/**
 * Created by David on 5/12/2016.
 */
public class BattleScreen implements Screen {
  private BugsGame game;
    public Texture texture;
    public SpriteBatch batch;
    private OrthographicCamera gameCamera;
    private Viewport viewport;


    public BattleScreen(BugsGame game) {
        this.game = game;
        texture = new Texture("badlogic.jpg");
        gameCamera = new OrthographicCamera();
        //different types of viewports change how you look at game
        viewport = new FitViewport(BugsGame.width,BugsGame.height,gameCamera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //opens the box
        game.batch.setProjectionMatrix(gameCamera.combined);
        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        //close box
        game.batch.end();




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
}
