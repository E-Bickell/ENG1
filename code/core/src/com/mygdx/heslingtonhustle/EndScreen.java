package com.mygdx.heslingtonhustle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class EndScreen implements Screen {
    final HeslingtonHustle game;
    OrthographicCamera camera;
    int finalScore = 100;
    public EndScreen(final HeslingtonHustle game, int score) {
        this.game = game;
        if(score < 100) {
            finalScore = score;
        }
        camera = new OrthographicCamera();

        camera.setToOrtho(false, 800, 400);
    }

    @Override
    public void show() {

    }

    public void render(float delta) {
        ScreenUtils.clear(0,0,0.2f,1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Game Complete", 100, 150);
        game.font.draw(game.batch, "Exam results: " + finalScore, 100, 100);
        game.batch.end();

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
