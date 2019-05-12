package com.example.luka.pocketsoccerapp.GameEngine.GameObjects;

public class MovingObjectState {

    private Vector location;
    private Vector movement;

    public MovingObjectState(GameMovingObject gameMovingObject){
        this.location = gameMovingObject.getLocation();
        this.movement = gameMovingObject.getMovement();
    }

    public Vector getLocation() {
        return location;
    }

    public void setLocation(Vector location) {
        this.location = location;
    }

    public Vector getMovement() {
        return movement;
    }

    public void setMovement(Vector movement) {
        this.movement = movement;
    }
}
