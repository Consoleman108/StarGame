package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.move.Movement;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 currentPosition;
    private Vector2 destinationPosition;
    Movement movement;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        currentPosition = new Vector2();
        destinationPosition = new Vector2();
        movement = new Movement();
        movement.setSrcPos(currentPosition);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        movement.getMove(currentPosition, delta);
        batch.begin();
        batch.draw(img, currentPosition.x, currentPosition.y);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        destinationPosition.set(screenX, Gdx.graphics.getHeight() - screenY);
        movement.setCurrenAndDestinationPos(currentPosition, destinationPosition);

        System.out.println("touchDown touch.x = " + destinationPosition.x + " touch.y = " + destinationPosition.y);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
