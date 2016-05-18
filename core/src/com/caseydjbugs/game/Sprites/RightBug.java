package com.caseydjbugs.game.Sprites;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by David on 5/16/2016.
 */
public class RightBug extends Sprite {
    public int health, armor, attack, speed;
    public World world;
    public Body body;

    public RightBug(World world){
        this.world = world;
        defineRightBug();


    }
    private void defineRightBug() {
        setOriginCenter();
        rotate(180);
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(400 - 32, 32);
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        body = world.createBody(bodyDef);
        body.applyForce(new Vector2(-.0f,0),body.getWorldCenter(),true);
        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5);
        fixtureDef.shape = shape;
        body.createFixture(fixtureDef);
    }
}
