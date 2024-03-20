package com.mygdx.heslingtonhustle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class Map implements Screen {

    public static final float SPEED = 40;
    int face;
    Buildings[] buildings;
    final Game game;
    TextureAtlas[] textures;
    Texture[] staticTextures;
    Sprite[] sprites;
    Sprite[] staticSpr;
    Sprite playerSpr;
    SpriteBatch batch;
    OrthographicCamera camera;
    TextureRegion[] playerImg;
    Player player;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;


    public Map(final HeslingtonHustle gam) {
        game = gam;
        face = 0;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        buildings = new Buildings[5];
        buildings[0] = new Buildings("test", "library", new Point(3,5), "read");
        buildings[0].addAct();
        player = new Player();
        batch = new SpriteBatch();

        textures = new TextureAtlas[8];
        sprites = new Sprite[8];
        staticTextures = new Texture[8];
        staticSpr = new Sprite[8];

        textures[0] = new TextureAtlas("char_animate/char_n.txt");
        sprites[0] = textures[0].createSprite("char_n");
        staticTextures[0] = new Texture("char_animate/static_n.png");
        staticSpr[0] = new Sprite(staticTextures[0]);

        textures[1] = new TextureAtlas("char_animate/char_ne.txt");
        sprites[1] = textures[1].createSprite("char_ne");
        staticTextures[1] = new Texture("char_animate/static_ne.png");
        staticSpr[1] = new Sprite(staticTextures[1]);

        textures[2] = new TextureAtlas("char_animate/char_e.txt");
        sprites[2] = textures[2].createSprite("char_e");
        staticTextures[2] = new Texture("char_animate/static_e.png");
        staticSpr[2] = new Sprite(staticTextures[2]);

        textures[3] = new TextureAtlas("char_animate/char_se.txt");
        sprites[3] = textures[3].createSprite("char_se");
        staticTextures[3] = new Texture("char_animate/static_se.png");
        staticSpr[3] = new Sprite(staticTextures[3]);

        textures[4] = new TextureAtlas("char_animate/char_s.txt");
        sprites[4] = textures[4].createSprite("char_s");
        staticTextures[4] = new Texture("char_animate/static_s.png");
        staticSpr[4] = new Sprite(staticTextures[4]);

        textures[5] = new TextureAtlas("char_animate/char_sw.txt");
        sprites[5] = textures[5].createSprite("char_sw");
        staticTextures[5] = new Texture("char_animate/static_sw.png");
        staticSpr[5] = new Sprite(staticTextures[5]);

        textures[6] = new TextureAtlas("char_animate/char_w.txt");
        sprites[6] = textures[6].createSprite("char_w");
        staticTextures[6] = new Texture("char_animate/static_w.png");
        staticSpr[6] = new Sprite(staticTextures[6]);

        textures[7] = new TextureAtlas("char_animate/char_nw.txt");
        sprites[7] = textures[7].createSprite("char_nw");
        staticTextures[7] = new Texture("char_animate/static_nw.png");
        staticSpr[7] = new Sprite(staticTextures[7]);

        playerSpr = staticSpr[0];

        System.out.println("open map screen");
        map = new TmxMapLoader().load("map/map.tmx");
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
        float unitScale = 1 / 16;
        renderer = new OrthogonalTiledMapRenderer(map, unitScale);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,0);
        handleInput(v);

        camera.update();
        renderer.setView(camera);
        renderer.render();

        batch.begin();
        playerSpr.setPosition(player.getX(), player.getY());
        playerSpr.draw(batch);
        batch.end();
    }

    public void handleInput(float v) {
        float change = SPEED * v;
        if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)){
            player.move(-change,-change);
            playerSpr = sprites[7];
            face = 7;
        } else if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)){
            player.move(change,-change);
            playerSpr = sprites[1];
            face = 1;
        } else if(Gdx.input.isKeyPressed(Input.Keys.A) && Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(-change,change);
            playerSpr = sprites[5];
            face = 5;
        } else if(Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(change,change);
            playerSpr = sprites[3];
            face = 3;
        } else if(Gdx.input.isKeyPressed(Input.Keys.W)){
            player.move(0,-change);
            playerSpr = sprites[0];
            face = 0;
        } else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            player.move(-change,0);
            playerSpr = sprites[2];
            face = 2;
        } else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(0,change);
            playerSpr = sprites[4];
            face = 4;
        } else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            player.move(change,0);
            playerSpr = sprites[6];
            face = 6;
        } else {
            playerSpr = staticSpr[face];
        }
        //camera.position.x += (float) ((player.getX() - camera.position.x) * 0.5 * v);
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
        map.dispose();
        for (int i = 0; i < textures.length; i++){
            textures[i].dispose();
            staticTextures[i].dispose();
        }
    }
}