package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Bitmap;

import java.util.List;

public class FootBall extends  Ball {

    public FootBall(double px, double py, double vx, double vy, double r, GameSurface gameSurface, List<Bitmap> pictures) {
        super(px, py, vx, vy, r, gameSurface, new GifImageStrategy(pictures));
    }

    public int wasGoal(Vector leftTopTeam1,Vector rightBotTeam1,Vector leftTopTeam2,Vector rightBotTeam2){
        if(location.getX() >=leftTopTeam1.getX() && location.getX() <= rightBotTeam1.getX() && location.getY() > leftTopTeam1.getY() && location.getY() < rightBotTeam1.getY())
            return 1;
        if(location.getX() >=leftTopTeam2.getX() && location.getX() <= rightBotTeam2.getX() && location.getY() > leftTopTeam2.getY() && location.getY() < rightBotTeam2.getY())
            return 1;
        return 0;
    }
}
