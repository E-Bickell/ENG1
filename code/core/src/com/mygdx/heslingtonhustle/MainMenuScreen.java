package com.mygdx.heslingtonhustle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Represents the start menu screen of the game
 */
public class MainMenuScreen implements Screen {
    final HeslingtonHustle game;
    OrthographicCamera camera;

    /**
     * Creates an instance of the MainMenuScreen
     * @param game HeslingtonHustle game
     */
    public MainMenuScreen(final HeslingtonHustle game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.2f,1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Heslington Hustle", 100, 150);
        game.font.draw(game.batch, "Press Space To Begin", 100, 100);
        game.font.draw(game.batch, "Press Q to find out how to play", 100, 75);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            game.setScreen(new Map(game));
            dispose();
        } else if (Gdx.input.isKeyPressed(Input.Keys.Q)){
            game.setScreen(new HowToPlayScreen(game));
            dispose();
        }
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

    }
}
