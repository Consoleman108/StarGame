package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;

public class Spaceship extends Sprite {
    private static final float MARGIN = 0.05f;

    public Spaceship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship").split(atlas.findRegion("main_ship").originalWidth/2,
                atlas.findRegion("main_ship").originalHeight)[0][0]);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }
    

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        this.pos.set(worldBounds.pos);
    }
}
