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

    Animation run,fight;

    LeftBugOne() {
        this.setX(50);
        this.setY(50);
        atlas_LeftBugOne_run = new TextureAtlas(Gdx.files.internal("LeftBugOne.atlas"));
        atlas_LeftBugOne_fight = new TextureAtlas(Gdx.files.internal("LeftBugOne-Fight.atlas"));
        //added health bars 5/9/2016
        atlas_healthBar = new TextureAtlas(Gdx.files.internal("healthBar12.atlas"));
        fight = new Animation(1 / 10f, atlas_LeftBugOne_fight.getRegions());
        run = new Animation(1 / 15f, atlas_LeftBugOne_run.getRegions());
    }

    public TextureAtlas getAtlas_LeftBugOne() {
        return atlas_LeftBugOne_run;
    }

    public void setAtlas_LeftBugOne(TextureAtlas atlas_LeftBugOne) {
        this.atlas_LeftBugOne_run = atlas_LeftBugOne;
    }

    public Animation getAnimation_LeftBugOne() {
        return run;
    }

    public void setAnimation_LeftBugOne(Animation animation_LeftBugOne) {
        this.run = animation_LeftBugOne;
    }

}
