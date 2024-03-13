package com.mygdx.heslingtonhustle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen implements Screen {
    final HeslingtonHustle game;
    Texture playerSprite;
    Texture mapSprite;
    Player player;
    Map map;
    OrthographicCamera camera;

    public GameScreen(final HeslingtonHustle game) {
        this.game = game;

        playerSprite = new Texture(Gdx.files.internal("Char.png"));
        mapSprite = new Texture(Gdx.files.internal("Map.png"));
        player = new Player();
        map = new Map();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
        playerSprite.dispose();
        mapSprite.dispose();
    }
}
