package com.mygdx.heslingtonhustle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

import java.awt.*;

public class Map implements Screen {

    int size;
    Buildings[] buildings;
    final Game game;
    OrthographicCamera camera;

    public Map(final HeslingtonHustle gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        buildings = new Buildings[5];
        buildings[0] = new Buildings("test", "library", new Point(3,5), "read");
        buildings[0].addAct();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

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