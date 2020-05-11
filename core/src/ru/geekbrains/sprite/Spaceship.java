package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Spaceship extends Sprite {

    final static private int SPEED = 200;

    private Vector2 currentPos = new Vector2(0,0);         // - текущая позиция
    private Vector2 destinationPos = new Vector2();               // - позиция назначения
    private Vector2 direction = new Vector2();                    // - нормализованный вектор направления
    private Vector2 velocity = new Vector2();                     // - скорость
    private Vector2 move = new Vector2();                         // - прищение к текущей позиции
    private float delta = 1/60;

    public Spaceship(Texture texture) {
        super(new TextureRegion(texture, 916,95,195,287));
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (currentPos.dst2(destinationPos) > move.len2()) {
            currentPos.add(move);
        } else {
            currentPos.set(destinationPos);
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
        direction.set(destinationPos);
        direction.sub(currentPos);
        direction.nor();

        velocity = new Vector2(direction);
        velocity.scl(SPEED);

        move.set(velocity);
        move.scl(delta);

        System.out.println("Touch Down Spaceship");

        return super.touchDown(touch, pointer, button);
    }


}
