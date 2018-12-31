package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class GameSimpleObject {

    protected ImageStrategy imageStrategy;
    protected long lastDrawNanoTime;
    protected GameSurface gameSurface;
    protected Vector location;


    public GameSimpleObject(ImageStrategy imageStrategy, GameSurface gameSurface, Vector location){
        this.imageStrategy = imageStrategy;
        this.gameSurface = gameSurface;
        this.location = location;
        this.lastDrawNanoTime = -1;
    }

    //TODO ADD checkers when converting?
    public void draw(Canvas canvas)  {
        Bitmap bitmap = this.imageStrategy.getCurrentLook();
        Vector drawLoc = getDrawVector();
        canvas.drawBitmap(bitmap, (int)Math.floor(drawLoc.getX()), (int)Math.floor(drawLoc.getY()), null);
        this.lastDrawNanoTime= System.nanoTime();
    }

    protected Vector getDrawVector(){
        return location;
    }





}
