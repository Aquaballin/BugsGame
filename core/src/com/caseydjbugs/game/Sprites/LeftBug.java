package com.caseydjbugs.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.caseydjbugs.game.Screens.BattleScreen;

import javax.xml.soap.Text;

/**
 * Created by David on 5/16/2016.
 */
public class LeftBug  extends Sprite {
    public World world;
    public Body body;
    Texture texture;
    public LeftBug(World world){
        this.world = world;
        defineLeftBug();
    }
    private void defineLeftBug() {
        //texture = new Texture(Gdx.files.internal("assets/LeftBugOne2.png"));
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(10,10);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5);
        fixtureDef.shape = shape;
        body.createFixture(fixtureDef);
    }
}
