package ru.geekbrains.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Bullet extends Sprite {

    private Rect worldBounds;
    private Vector2 v;
    private int damage;
    private Sprite owner;
    private Music sfx;

    public Bullet() {
        regions = new TextureRegion[1];
        v = new Vector2();
        sfx = Gdx.audio.newMusic(Gdx.files.internal("sound/sfx.mp3"));
        sfx.setVolume(0.3f);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }

    public void set(
            Sprite owner,
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rect worldBounds,
            int damage
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos0);
        this.v.set(v0);
        setHeightProportion(height);
        this.worldBounds = worldBounds;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public Sprite getOwner() {
        return owner;
    }

    public void playSoundShot() {
        sfx.play();
    }

    public void stopSoundShot() {
        sfx.stop();
    }
}