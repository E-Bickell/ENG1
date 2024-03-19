package com.mygdx.heslingtonhustle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;

public class Map implements Screen {

    int size;
    Buildings[] buildings;
    final Game game;
    OrthographicCamera camera;
    Texture tiles;
    TextureRegion grassTile;
    TextureRegion pathTile;
    TextureRegion[] playerImg;
    Player player;


    public Map(final HeslingtonHustle gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        buildings = new Buildings[5];
        buildings[0] = new Buildings("test", "library", new Point(3,5), "read");
        buildings[0].addAct();
        grassTile = new TextureRegion();
        pathTile = new TextureRegion();
        playerImg = new TextureRegion[8];
        player = new Player();


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        updatePlayer();
    }

    public void updatePlayer() {
        if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)){
            player.move(-1,-1);
        } else if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)){
            player.move(1,-1);
        } else if(Gdx.input.isKeyPressed(Input.Keys.A) && Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(-1,1);
        } else if(Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(1,1);
        } else if(Gdx.input.isKeyPressed(Input.Keys.W)){
            player.move(0,-1);
        } else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            player.move(-1,0);
        } else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(0,1);
        } else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            player.move(1,0);
        } else {

        }
    }

    @Override
    public void resize(int i, int i1) {

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