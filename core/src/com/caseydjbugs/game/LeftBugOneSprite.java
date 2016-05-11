package com.caseydjbugs.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by David on 5/11/2016.
 */
public class LeftBugOneSprite extends Sprite {
    public World world;
    public Body body;
    public LeftBugOneSprite(World world) {
        this.world = world;
        defineLeftBugOne();
    }
    public void defineLeftBugOne(){
        BodyDef bodyDef =  new BodyDef();
        //fix starting position;
        bodyDef.position.set(1,1);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5);
        fixtureDef.shape = shape;
        body.createFixture(fixtureDef);
    }
}
