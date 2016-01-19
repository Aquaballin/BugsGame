package com.caseydjbugs.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by David on 1/19/2016.
 */
public class Coin {
    TextureAtlas coinAtlas;
    Animation coinAnimation;
    Coin() {
        coinAtlas = new TextureAtlas(Gdx.files.internal("Coin-Atlas.atlas"));
        coinAnimation = new Animation(1/7f,coinAtlas.getRegions());
    }

}
