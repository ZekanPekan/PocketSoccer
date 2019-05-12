package com.example.luka.pocketsoccerapp.GameEngine.GameObjects;

import com.example.luka.pocketsoccerapp.GameEngine.GameSurface;
import com.example.luka.pocketsoccerapp.GameEngine.ImageStrategy.ImageStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ball extends  GameMovingObject{

    private List<Ball> balls;
    private Goal[] goals;

    private double r;
    protected GameSurface gameSurface;
    public Ball(double px, double py, double vx, double vy, double r, GameSurface gameSurface, ImageStrategy imageStrategy) {
        super(imageStrategy,new Vector(px, py),new Vector(vx, vy));
        this.gameSurface = gameSurface;
        this.r = r;
        this.balls = new ArrayList<>();
    }

    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }

    @Override
    protected Vector getDrawVector() {
        return new Vector(location.getX() - r/2,location.getY() -r/2);
    }

    public void setOtherMovingObjects(List<Ball> balls){
        this.balls = balls;
    }

    public void addMovingRoundObject(Ball e){
        this.balls.add(e);
    }

    public void addOtherMovingObjects(Ball ...balls){
        for(Ball b : balls)
            this.balls.add(b);
    }

    public boolean collides(Ball b) {
        return location.sub(b.location).getSize() <= (r / 2 + b.r / 2);
    }

    public void transferEnergy(Ball b) {
        Vector nv2 = location.sub(b.location);
        nv2.normalize();
        nv2.multiply(movement.dot(nv2));

        Vector nv1 = movement.sub(nv2);
        Vector nv2b = b.location.sub(location);
        nv2b.normalize();
        nv2b.multiply(b.movement.dot(nv2b));
        Vector nv1b = b.movement.sub(nv2b);

        b.movement = nv2.add(nv1b);
        movement = nv1.add(nv2b);
    }



    @Override
    public void update() {
        location.setX(location.getX() + movement.getX());
        location.setY(location.getY() + movement.getY());
        for (Ball b : balls) {
            if (this != b && collides(b)) {
                location.setX(location.getX() - movement.getX());
                location.setY(location.getY() - movement.getY());
                transferEnergy(b);
                break;
            }
        }
        updateGoalsCollision();
        updateWallCollision();
        applyTableFriction();
    }

    public double getR(){
        return  r;
    }


    private void updateGoalsCollision(){
        for(Goal g: goals) {
            g.updateBall(this);
        }
    }

    private void updateWallCollision() {
        if (location.getX()-r/2<0){
            movement.setX(Math.abs(movement.getX()));
        }
        else if (location.getX()+r/2>gameSurface.getWidth()){
            movement.setX(-Math.abs(movement.getX()));
        }
        if (location.getY()-r/2<0){
            movement.setY(Math.abs(movement.getY()));
        }
        else if (location.getY()+r/2>gameSurface.getHeight()){
            movement.setY(-Math.abs(movement.getY()));
        }
    }

    private void applyTableFriction() {
        movement.setX(movement.getX() * 0.985);
        movement.setY(movement.getY() * 0.985);
    }


}
