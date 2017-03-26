package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

public class DoofyReturnsGame extends ApplicationAdapter {
  int FRAME_COLS = 6, FRAME_ROWS = 5;
  float t = 0.0f;
  SpriteBatch batch;
  Texture img;
  AnimatedSprite sprite;
  // Animation<TextureRegion> walkAnimation;
  
  @Override
  public void create () {
    batch = new SpriteBatch();
    img = new Texture("sprite1.png");
    sprite = new AnimatedSprite(img, 2, 2, 0.14f);
  }

  @Override
  public void render () {
    Gdx.gl.glClearColor(0.86f, 0.88f,0.86f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    t += Gdx.graphics.getDeltaTime();
    batch.begin();
    sprite.draw(batch, t);
    batch.end();
  }
  
  @Override
  public void dispose () {
    batch.dispose();
    img.dispose();
  }
}
