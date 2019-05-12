package com.example.luka.pocketsoccerapp.GameEngine.GameObjects;

import android.graphics.Bitmap;

import com.example.luka.pocketsoccerapp.GameEngine.GameSurface;
import com.example.luka.pocketsoccerapp.GameEngine.ImageStrategy.SingleImageStrategy;

public class PlayerBall extends  Ball{

    boolean team;

    public PlayerBall(double px, double py, double vx, double vy, double r, GameSurface gameSurface, boolean team, Bitmap teamPicture) {
        super(px, py, vx, vy, r, gameSurface, new SingleImageStrategy(teamPicture));
        this.team = team;
    }

    public boolean getTeam(){
        return team;
    }
}
