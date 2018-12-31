package com.example.luka.pocketsoccerapp.GameEngine;

public abstract  class GameMovingObject extends  GameSimpleObject {


    protected Vector movement;

    public GameMovingObject(ImageStrategy imageStrategy, GameSurface gameSurface, Vector location,Vector movement) {
        super(imageStrategy, gameSurface, location);
        this.movement = movement;
    }

    public abstract void update();

}
