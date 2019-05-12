package com.example.luka.pocketsoccerapp.GameEngine.GameObjects;
import com.example.luka.pocketsoccerapp.GameEngine.ImageStrategy.ImageStrategy;

public abstract  class GameMovingObject extends  GameSimpleObject {


    protected Vector movement;

    public GameMovingObject(ImageStrategy imageStrategy, Vector location, Vector movement) {
        super(imageStrategy,location);
        this.movement = movement;
    }

    public void setMovement(Vector v){
        movement = v;
    }

    public Vector getMovement(){
        return this.movement;
    }

    public abstract void update();

}
