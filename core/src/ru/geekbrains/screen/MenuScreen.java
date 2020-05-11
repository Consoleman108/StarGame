package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import javax.xml.soap.Text;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Spaceship;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;
    private Texture sh;
    private Background background;
    private Spaceship spaceship;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/bg.png");
        sh = new Texture("textures/mainAtlas.png");
        background = new Background(bg);
        spaceship = new Spaceship(sh);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        spaceship.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        spaceship.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        bg.dispose();
        sh.dispose();
        super.dispose();
    }

}
