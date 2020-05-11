package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Spaceship extends Sprite {

    private final float V_LEN = 0.01f;
    private Vector2 destinationPos = new Vector2();
    private Vector2 velocity = new Vector2();
    private Vector2 common = new Vector2();

    public Spaceship(Texture texture) {
        super(new TextureRegion(texture, 916,95,195,287));
    }

    @Override
    public void draw(SpriteBatch batch) {

        if (common.set(destinationPos).sub(pos).len2() > velocity.len2())
            pos.add(velocity);
        else{
            pos.set(destinationPos);
            velocity.setZero();
        }
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        this.pos.set(worldBounds.pos);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        destinationPos = touch;
        common = destinationPos.cpy().sub(pos);
        velocity.set(common).setLength(V_LEN);
        return super.touchDown(touch, pointer, button);
    }

}
