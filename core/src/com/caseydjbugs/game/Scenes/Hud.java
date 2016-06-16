package com.caseydjbugs.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.caseydjbugs.game.BugsGame;

/**
 * Created by David on 5/12/2016.
 */
public class Hud {

    public Stage stage;
    private Viewport viewport;

    private Integer leftArmorLevel;
    private Integer leftHealthLevel;
    private Integer leftAttackLevel;
    private Integer rightArmorLevel;
    private Integer rightHealthLevel;
    private Integer rightAttackLevel;
    public float leftMoneyCount;
    private float rightMoneyCount;
    private float moneyCap;

    public Label leftMoneyLabel;
    Label rightMoneyLabel;
    Label leftArmorLabel;
    Label rightArmorLabel;
    Label leftAttackLabel;
    Label rightAttackLabel;
    Label leftHealthLabel;
    Label rightHealthLabel;
    Label leftMoneyLabel2;
    Label rightMoneyLabel2;
    Label leftArmorLabel2;
    Label rightArmorLabel2;
    Label leftAttackLabel2;
    Label rightAttackLabel2;
    Label leftHealthLabel2;
    Label rightHealthLabel2;

    public Hud(SpriteBatch spriteBatch){


        leftMoneyCount = 0;
        leftArmorLevel = 0;
        leftAttackLevel = 0;
        leftHealthLevel = 0;
        moneyCap = 300;


        rightMoneyCount = 0;
        rightArmorLevel = 0;
        rightAttackLevel = 0;
        rightHealthLevel = 0;

        viewport = new FitViewport(BugsGame.width,BugsGame.height,new OrthographicCamera());
        stage = new Stage(viewport, spriteBatch);

        Table table = new Table();
        table.top();

        //table is size of the stage.
        table.setFillParent(true);

        leftMoneyLabel = new Label(String.format("%.2f",leftMoneyCount),new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        leftArmorLabel = new Label(String.format("%d",leftArmorLevel),new Label.LabelStyle(new BitmapFont(),Color.BLUE));
        leftAttackLabel = new Label(String.format("%d",leftAttackLevel),new Label.LabelStyle(new BitmapFont(),Color.BLUE));
        leftHealthLabel = new Label(String.format("%d",leftHealthLevel),new Label.LabelStyle(new BitmapFont(),Color.BLUE));

        rightMoneyLabel = new Label(String.format("%.2f",rightMoneyCount),new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        rightArmorLabel = new Label(String.format("%d",rightArmorLevel),new Label.LabelStyle(new BitmapFont(),Color.RED));
        rightAttackLabel = new Label(String.format("%d",rightAttackLevel),new Label.LabelStyle(new BitmapFont(),Color.RED));
        rightHealthLabel = new Label(String.format("%d",rightHealthLevel),new Label.LabelStyle(new BitmapFont(),Color.RED));

        leftMoneyLabel2 = new Label("Money",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        leftArmorLabel2 = new Label("Armor",new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        leftAttackLabel2 = new Label("Attack",new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        leftHealthLabel2 = new Label("Health",new Label.LabelStyle(new BitmapFont(),Color.WHITE));

        rightMoneyLabel2 = new Label("Money",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        rightArmorLabel2 = new Label("Armor",new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        rightAttackLabel2 = new Label("Attack",new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        rightHealthLabel2 = new Label("Health",new Label.LabelStyle(new BitmapFont(),Color.WHITE));


        table.row();
        table.add(leftMoneyLabel2).expandX().padTop(10);
        table.add(leftArmorLabel2).expandX().padTop(10);
        table.add(leftAttackLabel2).expandX().padTop(10);
        table.add(leftHealthLabel2).expandX().padTop(10);
        table.add(rightHealthLabel2).expandX().padTop(10);
        table.add(rightAttackLabel2).expandX().padTop(10);
        table.add(rightArmorLabel2).expandX().padTop(10);
        table.add(rightMoneyLabel2).expandX().padTop(10);
        table.row();
        table.add(leftMoneyLabel).expandX().padTop(10);
        table.add(leftArmorLabel).expandX().padTop(10);
        table.add(leftAttackLabel).expandX().padTop(10);
        table.add(leftHealthLabel).expandX().padTop(10);
        table.add(rightHealthLabel).expandX().padTop(10);
        table.add(rightAttackLabel).expandX().padTop(10);
        table.add(rightArmorLabel).expandX().padTop(10);
        table.add(rightMoneyLabel).expandX().padTop(10);
        stage.addActor(table);

    }
}
