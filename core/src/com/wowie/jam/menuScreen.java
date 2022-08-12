package com.wowie.jam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class menuScreen extends InputAdapter implements Screen {
    Stage stage;
    SpriteBatch batch;
    Texture player;
    Texture ground;
    float speed = 100.0f;
    float playerX = 150;
    float playerY = 150;

    Rectangle playerRectangle;
    Rectangle groundRectangle;

    float previousX, previousY;

    @Override
    public void show() {
        player = new Texture("Tiles/tile_0109.png");
        ground = new Texture("Tiles/tile_0014.png");

        stage = new Stage();

        playerRectangle = new Rectangle((int) playerX, (int) playerY, player.getWidth(), player.getHeight());
        groundRectangle = new Rectangle(100, 100, ground.getWidth(), ground.getHeight());

        previousX = 0;
        previousY = 0;

        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 0);
        ScreenUtils.clear(1, 1, 1, 0);

        batch.begin();
        stage.draw();
        batch.draw(player, playerX, playerY);
        batch.draw(ground, 100, 100);

        if (groundRectangle.intersects(playerRectangle)) {
            playerY = previousY;
            playerX = previousX;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            previousY = playerY;
            playerY += Gdx.graphics.getDeltaTime() * speed;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            previousY = playerY;
            playerY -= Gdx.graphics.getDeltaTime() * speed;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            previousX = playerX;
            playerX -= Gdx.graphics.getDeltaTime() * speed;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            previousX = playerX;
            playerX += Gdx.graphics.getDeltaTime() * speed;
        }

        if(playerX < 0) playerX = 0;
        if(playerX > 945) playerX = 945;

        playerRectangle = new Rectangle((int) playerX, (int) playerY, player.getWidth(), player.getHeight());
        groundRectangle = new Rectangle(100, 100, ground.getWidth(), ground.getHeight());

        batch.end();
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
