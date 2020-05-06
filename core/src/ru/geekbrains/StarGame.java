package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion region;

	float x, y;
	float width, height;
	int scrX, scrY, scrWidth,scrHeight;
	boolean flipX, flipY;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("VH.jpg");
		region = new TextureRegion(img, 50, 50, 100, 100);
		x = 0;
		y = 0;
		width = img.getWidth();
		height = img.getHeight();
		flipX = false;
		flipY = false;

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.3f, 0.2f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
