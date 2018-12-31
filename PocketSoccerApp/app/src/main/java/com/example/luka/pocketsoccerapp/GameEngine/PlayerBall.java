package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Bitmap;
public class PlayerBall extends  Ball{

    boolean team;

    public PlayerBall(double px, double py, double vx, double vy, double r, GameSurface gameSurface, boolean team, Bitmap teamPicture) {
        super(px, py, vx, vy, r, gameSurface, new SingleImageStrategy(teamPicture));
        this.team = team;
    }
}
