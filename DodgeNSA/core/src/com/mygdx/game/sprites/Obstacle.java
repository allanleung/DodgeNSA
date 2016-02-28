package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.DodgeNSA;

import java.util.Random;

public class Obstacle {
//    public static final int FLUCTUATION = 130;
//    public static final int OBSTACLE_GAP = 100;
//    public static final int LOWEST_OPENING = 120;
//    private Texture topObstacle, bottomObstacle;
//    private Vector2 posTopObstacle, posBotObstacle;
    private Random rand;
    private static final int GRAVITY = -15;
    private Vector2 position;
    private Vector2 velocity;
    private Texture obstacle;
    private Rectangle bounds;

    public Obstacle(){
        obstacle = new Texture("obstacle.png");
        rand = new Random();
        position = new Vector2(rand.nextInt(DodgeNSA.WIDTH), DodgeNSA.HEIGHT);
        velocity = new Vector2(0,0);
        bounds = new Rectangle(position.x,position.y,obstacle.getWidth(),obstacle.getHeight());

//        topObstacle = new Texture("topObstacle.png");
//        bottomObstacle = new Texture("bottomObstacle.png");
//        rand = new Random();
//
//        posTopObstacle = new Vector2(x, rand.nextInt(FLUCTUATION) + OBSTACLE_GAP + LOWEST_OPENING);
//        posBotObstacle = new Vector2(x, posBotObstacle.y - OBSTACLE_GAP - bottomObstacle.getHeight());
    }

    public void update(float dt) {
        velocity.add(0,GRAVITY);
        velocity.scl(dt);
        position.add(0,velocity.y);
        velocity.scl(1/dt);
        bounds.setPosition(position.x,position.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(bounds);
    }

    public Texture getObstacle() {
        return obstacle;
    }

    public Vector2 getPosition() {
        return position;
    }

//    public Texture getTopObstacle() {
//        return topObstacle;
//    }
//
//    public Texture getBottomObstacle() {
//        return bottomObstacle;
//    }
//
//    public Vector2 getPosTopObstacle() {
//        return posTopObstacle;
//    }
//
//    public Vector2 getPosBotObstacle() {
//        return posBotObstacle;
//    }
}