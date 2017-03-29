package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.mappings.Xbox;
import com.badlogic.gdx.Input;

public class DoofyReturnsGame extends ApplicationAdapter {
  final String TAG = "DoofyReturnsGame";
  float elapsedTime = 0.0f;
  SpriteBatch batch;
  // Texture img;
  AnimatedSprite sprite;
  Player player;
  Controller playerOne;
  Sprite s;

  @Override
  public void create () {
    batch = new SpriteBatch();

    TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("pack/dguy.atlas"));
    player = new Player(atlas);

    Gdx.app.log(TAG, "Controllers:");
    for (Controller controller : Controllers.getControllers()) {
      Gdx.app.log(TAG, controller.getName());
      if (Xbox.isXboxController(controller)) {
        playerOne = controller;
        Gdx.app.log(TAG, "Ready Player One.");
      }
    }
  }

  public void update () {
    elapsedTime += Gdx.graphics.getDeltaTime();
    player.update(elapsedTime);
  }

  @Override
  public void render () {
    update();
    // Off white bc I was trying to match the bg color of anime spritesheet
    // you know bc converting the png to transparent bg was too hard :(
    Gdx.gl.glClearColor(0.86f, 0.88f,0.86f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.begin();
    player.draw(batch);
    batch.end();
  }

  @Override
  public void dispose () {
    batch.dispose();
    // img.dispose();
  }
}
