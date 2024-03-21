package com.mygdx.heslingtonhustle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;


/**
 * Represents the map of the Game on which the game is rendered and played
 */
public class Map implements Screen {

    public static final float SPEED = 100f;
    private static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public BitmapFont font;
    Week week;
    int face;
    Buildings[] buildings;
    final HeslingtonHustle game;
    //TextureAtlas[] textures;
    Texture[] staticTextures;
    //Sprite[] sprites;
    //Animation<TextureAtlas>[] animations;
    Sprite[] staticSpr;
    Sprite playerSpr;
    //Animation<TextureAtlas> playerAni;
    SpriteBatch batch;
    SpriteBatch guiBatch;
    OrthographicCamera camera;
    Player player;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;
    Texture rchTexture;
    Texture piazzaTexture;
    Texture goodrickeTexture;
    Texture langwithTexture;
    Vector3 touchPos;

    /**
     * Creates an instance of the Map
     * @param gam HeslingtonHustle game
     */

    /** For the arrays, the direction each number represents is:
     * /0: North
     * 1: NE
     * 2: East
     * 3: SE
     * 4: South
     * 5: SW
     * 6: West
     * 7: NW
     * There are TextureAtlas files for animations in the assets folder, however, we could not
     * get them working for the first version of the game
     */
    //There are Texture Atlas files in
    public Map(final HeslingtonHustle gam) {
        font = new BitmapFont();
        font.setColor(Color.RED);
        week = new Week();
        game = gam;
        face = 0;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        player = new Player();
        batch = new SpriteBatch();
        guiBatch = new SpriteBatch();

        staticTextures = new Texture[8];
        staticSpr = new Sprite[8];

        staticTextures[0] = new Texture("char_animate/static_n.png");
        staticSpr[0] = new Sprite(staticTextures[0]);

        staticTextures[1] = new Texture("char_animate/static_ne.png");
        staticSpr[1] = new Sprite(staticTextures[1]);

        staticTextures[2] = new Texture("char_animate/static_e.png");
        staticSpr[2] = new Sprite(staticTextures[2]);

        staticTextures[3] = new Texture("char_animate/static_se.png");
        staticSpr[3] = new Sprite(staticTextures[3]);

        staticTextures[4] = new Texture("char_animate/static_s.png");
        staticSpr[4] = new Sprite(staticTextures[4]);

        staticTextures[5] = new Texture("char_animate/static_sw.png");
        staticSpr[5] = new Sprite(staticTextures[5]);

        staticTextures[6] = new Texture("char_animate/static_w.png");
        staticSpr[6] = new Sprite(staticTextures[6]);

        staticTextures[7] = new Texture("char_animate/static_nw.png");
        staticSpr[7] = new Sprite(staticTextures[7]);

        playerSpr = new Sprite(staticSpr[0]);

        System.out.println("open map screen");
        map = new TmxMapLoader().load("map/map.tmx");
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
        renderer = new OrthogonalTiledMapRenderer(map, 4*SCREEN_WIDTH/(map.getProperties().get("width",Integer.class)*32f));

        rchTexture = new Texture(Gdx.files.internal("map/ron-cooke-hub.jpeg"));
        piazzaTexture = new Texture(Gdx.files.internal("map/piazza-building.jpeg"));
        goodrickeTexture = new Texture(Gdx.files.internal("map/goodricke-college.jpeg"));
        langwithTexture = new Texture(Gdx.files.internal("map/the-glasshouse.jpg"));

        buildings = new Buildings[4];
        buildings[0] = new Buildings("Ron Cooke Hub", 800, 100, rchTexture.getWidth(), rchTexture.getHeight(), "study");
        buildings[0].addAct(new Activity("Study", "Study", 4, -3));
        buildings[1] = new Buildings("Piazza building", 900, 700, piazzaTexture.getWidth(), piazzaTexture.getHeight(), "eat");
        buildings[1].addAct(new Activity("Eat", "Eat", 1, -1));
        buildings[2] = new Buildings("Langwith college", 86, 692, langwithTexture.getWidth(), langwithTexture.getHeight(), "recreational");
        buildings[2].addAct(new Activity("Relax at Glasshouse", "Recreational", 3, -2));;
        buildings[3] = new Buildings("Goodricke college", 86, 70, goodrickeTexture.getWidth(), goodrickeTexture.getHeight(), "sleep");
        buildings[3].addAct(new Activity("Sleep", "Sleep", 0, 0));

        touchPos = new Vector3();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,0);
        handleInput(v);

        //for camera edges, doesn't work just yet
        boolean farHorz = player.getX() + camera.viewportWidth/2 + 16/2f <= 700 && player.getX() - camera.viewportWidth/2 >0;
        boolean farVert = player.getY() + camera.viewportHeight/2 + 16/2f <= 420 && player.getY() - camera.viewportHeight/2 >0;
        if(farHorz) {
            camera.position.set(player.getX() + 16/2f, camera.position.y, 0);

        }

        if(farVert) {
            camera.position.set(camera.position.x, player.getY() + 16/2f, 0);
        }

        camera.position.set(player.getX() + 16/2f, player.getY() + 16/2f, 0);
        camera.update();
        renderer.setView(camera);
        renderer.render();

        String dayString = "Current day: " + (week.currentWeekDay + 1);
        String hourString = "Current hour: ";
        if(!week.endWeek()) {
            hourString = "Current hour: " + week.weekDays[week.currentWeekDay].checkHour();
        }
        String energyString = "Current energy: " + player.energyCheck();
        String hungerString = "Current hunger: " + player.hungerCheck();
        String activitiesDone = "Eaten: " + player.tracker.getNumberOfType("Eat") + "\n" +
                "Relaxed: " + player.tracker.getNumberOfType("Recreational") + "\n" +
                "Studied :" + player.tracker.getNumberOfType("Study") + "\n" +
                "Slept :" + player.tracker.getNumberOfType("Sleep");

        batch.begin();
        //THIS WAS THE ONE LINE FOR THE CAMERA TO BE CENTERED T_T
        batch.setProjectionMatrix(camera.combined);
        batch.draw(rchTexture, buildings[0].xStart, buildings[0].yStart);
        batch.draw(piazzaTexture, buildings[1].xStart, buildings[1].yStart);
        batch.draw(langwithTexture, buildings[2].xStart, buildings[2].yStart);
        batch.draw(goodrickeTexture, buildings[3].xStart, buildings[3].yStart);

        playerSpr.setPosition(player.getX(), player.getY());
        playerSpr.draw(batch);

        batch.end();

        guiBatch.begin();
        font.draw(guiBatch, dayString, 0,390);
        font.draw(guiBatch, hourString, 0,365);
        font.draw(guiBatch, energyString, 0,340);
        font.draw(guiBatch, hungerString, 0,315);
        font.draw(guiBatch, activitiesDone, 715,390);
        guiBatch.end();
    }

    /**
     * Handles inputs from the user
     * @param v
     */
    public void handleInput(float v) {
        float change = Gdx.graphics.getDeltaTime()*SPEED;
        if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)){
            player.move(-change,change);
            face = 7;
        } else if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)){
            player.move(change,change);
            face = 1;
        } else if(Gdx.input.isKeyPressed(Input.Keys.A) && Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(-change,-change);
            face = 5;
        } else if(Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(change,-change);
            face = 3;
        } else if(Gdx.input.isKeyPressed(Input.Keys.W)){
            player.move(0,change);
            face = 0;
        } else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            player.move(-change,0);
            face = 6;
        } else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            player.move(0,-change);
            face = 4;
        } else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            player.move(change,0);
            face = 2;
        }

        if (Gdx.input.justTouched()){
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if (touchPos.x > buildings[0].xStart && touchPos.x < buildings[0].xStart + buildings[0].width){
                if (touchPos.y > buildings[0].yStart && touchPos.y < buildings[0].yStart + buildings[0].height){
                    player.interact(buildings[0], week);

                }
            }
            if (touchPos.x > buildings[1].xStart && touchPos.x < buildings[1].xStart + buildings[1].width){
                if (touchPos.y > buildings[1].yStart && touchPos.y < buildings[1].yStart + buildings[1].height){
                    player.interact(buildings[1], week);
                }
            }
            if (touchPos.x > buildings[2].xStart && touchPos.x < buildings[2].xStart + buildings[2].width){
                if (touchPos.y > buildings[2].yStart && touchPos.y < buildings[2].yStart + buildings[2].height){
                    player.interact(buildings[2], week);;
                }
            }
            if (touchPos.x > buildings[3].xStart && touchPos.x < buildings[3].xStart + buildings[3].width){
                if (touchPos.y > buildings[3].yStart && touchPos.y < buildings[3].yStart + buildings[3].height){
                    player.interact(buildings[3], week);
                    if(week.endWeek()) {
                        game.setScreen(new EndScreen(game, player.getScore()));
                        this.dispose();
                    }

                }
            }
        }
        playerSpr = new Sprite(staticSpr[face]);
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
        guiBatch.dispose();
        batch.dispose();
        font.dispose();
        map.dispose();
        for (int i = 0; i < staticTextures.length; i++){
            staticTextures[i].dispose();
        }
        rchTexture.dispose();
        piazzaTexture.dispose();
        langwithTexture.dispose();
        goodrickeTexture.dispose();
    }
}