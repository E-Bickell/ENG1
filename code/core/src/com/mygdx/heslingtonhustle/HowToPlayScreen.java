package com.mygdx.heslingtonhustle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class HowToPlayScreen implements Screen {
    final HeslingtonHustle game;
    OrthographicCamera camera;

    /**
     * Creates an instance of the MainMenuScreen
     * @param game HeslingtonHustle game
     */
    public HowToPlayScreen(final HeslingtonHustle game) {
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
        game.font.draw(game.batch, "How To Play:", 100, 380);
        game.font.draw(game.batch, "The aim is to study as much as possible over the course of a week, to prepare for your exams.", 100, 350);
        game.font.draw(game.batch, "You can study for these exams in the Ron Cooke Hub (building at the bottom right)", 100, 320);
        game.font.draw(game.batch, "and this will take 4 hours and drain 3 energy.", 100, 300);
        game.font.draw(game.batch, "You can eat at the Piazza building (building at the top right), this will take 1 hour", 100, 270);
        game.font.draw(game.batch, "and drain 1 energy, but will also restore 5 hunger.", 100, 250);
        game.font.draw(game.batch, "You can relax at Glasshouse in Langwith (building at the top left), this will take 3 hours", 100, 220);
        game.font.draw(game.batch, "and drain 2 energy.", 100, 200);
        game.font.draw(game.batch, "Finally, you can sleep in your halls at Goodricke College (building at the bottom left),", 100, 170);
        game.font.draw(game.batch, "this will skip to the next day.", 100, 150);
        game.font.draw(game.batch, "To move, use the WASD keys, and to perform an activity, click on the desired building.", 100, 120);
        game.font.draw(game.batch, "Press Space To Begin", 100, 50);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            game.setScreen(new Map(game));
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
