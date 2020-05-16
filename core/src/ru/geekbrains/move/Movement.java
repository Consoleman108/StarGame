package ru.geekbrains.move;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Movement {
    final static private int SPEED = 200;

    private Vector2 currentPos = new Vector2();         // - текущая позиция
    private Vector2 destinationPos = new Vector2();     // - позиция назначения
    private Vector2 direction = new Vector2();          // - нормализованный вектор направления
    private Vector2 velocity = new Vector2();           // - скорость
    private Vector2 move = new Vector2();               // - прищение к текущей позиции

    public Movement() {

    }

    public void setDstPos(Vector2 destinationPos) {
        this.destinationPos = destinationPos;
        System.out.println("Позиция куда необходимо передвинуться: " + this.destinationPos);
    }

    public void setSrcPos(Vector2 currentPos) {
        this.currentPos = currentPos;
        System.out.println("Текущая позиция: " + this.currentPos);
    }

    public void setCurrenAndDestinationPos(Vector2 currentPos, Vector2 destinationPos) {
        setSrcPos(currentPos);
        setDstPos(destinationPos);
    }

    public void getMove(Vector2 soursePosition, float deltaTime) {
        direction.set(destinationPos);
        direction.sub(currentPos);
        direction.nor();

        velocity = new Vector2(direction);
        velocity.scl(SPEED);

        move.set(velocity);
        move.scl(deltaTime);

        if (soursePosition.dst2(destinationPos) > move.len2()) {
            soursePosition.add(move);
        } else {
            soursePosition.set(destinationPos);
        }
    }
}
