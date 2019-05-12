package com.example.luka.pocketsoccerapp.GameEngine.GameObjects;

public class Vector {

    private double x;
    private double y;

    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector add(Vector v) {
        return new Vector(x + v.x, y + v.y);
    }

    public Vector sub(Vector v) {
        return new Vector(x - v.x, y - v.y);
    }

    public void multiply(double f) {
        x *= f;
        y *= f;
    }

    public void divide(int d){
        x /= d;
        y /= d;
    }

    public double distance(Vector v){
        double dx = x - v.x;
        double dy = y - v.y;
        return Math.sqrt(dx*dx+dy*dy);
    }

    public void setSize(double size) {
        normalize();
        multiply(size);
    }

    public double getSize() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        double intensity = getSize();
        x /= intensity;
        y /= intensity;
    }

    public double dot(Vector v) {
        return x * v.x + y * v.y;
    }

}
