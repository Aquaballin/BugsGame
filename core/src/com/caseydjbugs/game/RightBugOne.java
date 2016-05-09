package com.caseydjbugs.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by David on 1/18/2016.
 */
public class RightBugOne extends Bug {
    TextureAtlas atlas_RightBugOne_run, atlas_RightBugOne_fight,atlas_healthBar;
    Animation run,fight,healthFull,healthDecreasingByOnePerSecond;
    RightBugOne() {
        bounds = new Rectangle();
        this.setX(Gdx.graphics.getHeight()+450);
        this.setY(Gdx.graphics.getWidth() - 50);
        atlas_RightBugOne_run = new TextureAtlas(Gdx.files.internal("RightBugOne.atlas"));
        atlas_RightBugOne_fight = new TextureAtlas(Gdx.files.internal("RightBugOne-Fight.atlas"));
        atlas_healthBar = new TextureAtlas(Gdx.files.internal("fullHealthTryTwo.atlas"));
        run = new Animation(1 / 15f, atlas_RightBugOne_run.getRegions());
        fight = new Animation(1 / 10f, atlas_RightBugOne_fight.getRegions());
        healthFull = new Animation(0f,atlas_healthBar.getRegions());
        healthDecreasingByOnePerSecond = new Animation(1f,atlas_healthBar.getRegions());

    }
}
