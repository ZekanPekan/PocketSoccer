package com.example.luka.pocketsoccerapp.GameEngine;

public class MovingVelocity {

    private long xCord;
    private long yCord;
    private double pixelPerMillis;


    public MovingVelocity(long xCord, long yCord, double pixelPerMillis){
        this.xCord = xCord;
        this.yCord = yCord;
        this.pixelPerMillis = pixelPerMillis;
    }

    public long getxCord() {
        return xCord;
    }

    public void setxCord(long xCord) {
        this.xCord = xCord;
    }

    public long getyCord() {
        return yCord;
    }

    public void setyCord(long yCord) {
        this.yCord = yCord;
    }

    public double getPixelPerMillis() {
        return pixelPerMillis;
    }

    public void setPixelPerMillis(double pixelPerMillis) {
        this.pixelPerMillis = pixelPerMillis;
    }

    //TODO where to check walls and other colliding objects?
    public Vector getCurrentLocation(Vector lastVector, long millisPassed){
            return new Vector(lastVector.getX()+xCord*millisPassed, lastVector.getY()+yCord*millisPassed);
    }
}
