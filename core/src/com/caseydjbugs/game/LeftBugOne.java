package com.caseydjbugs.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by David on 1/18/2016.
 */
public class LeftBugOne extends Bug {

    TextureAtlas atlas_LeftBugOne_run, atlas_LeftBugOne_fight, atlas_healthBar;

    Animation run,fight,healthFull,healthDecreasingByOnePerSecond;

    LeftBugOne() {
        this.setX(50);
        this.setY(50);
        atlas_LeftBugOne_run = new TextureAtlas(Gdx.files.internal("LeftBugOne.atlas"));
        atlas_LeftBugOne_fight = new TextureAtlas(Gdx.files.internal("LeftBugOne-Fight.atlas"));
        //added health bars 5/9/2016
        atlas_healthBar = new TextureAtlas(Gdx.files.internal("fullHealthTryTwo.atlas"));
        fight = new Animation(1 / 10f, atlas_LeftBugOne_fight.getRegions());
        run = new Animation(1 / 15f, atlas_LeftBugOne_run.getRegions());
        healthFull = new Animation(0f,atlas_healthBar.getRegions());
        healthDecreasingByOnePerSecond = new Animation(1/70f);
    }


}
