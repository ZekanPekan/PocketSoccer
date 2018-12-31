package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.luka.pocketsoccerapp.R;

import java.util.ArrayList;
import java.util.List;

public class GameInitializer {

    public static List<GameSimpleObject> initEnvirometn(GameSurface gameSurface, int chosenFieldID){
        List<GameSimpleObject> retVal = new ArrayList<>();
        retVal.add(new GameEnvironmentObjects(BitmapFactory.decodeResource(gameSurface.getResources(),chosenFieldID),gameSurface));
        retVal.add(new GameEnvironmentObjects(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.fieldkeeper_hd),gameSurface));
        return retVal;
    }

    //TODO calculate starting possitions so it looks normal, and sizes
    public static List<GameMovingObject> initAllPlayerBalls(int team1ID, int team2ID,GameSurface gameSurface){
        List<GameMovingObject> retVal = new ArrayList<>();
        Bitmap team1Img = BitmapFactory.decodeResource(gameSurface.getResources(), team1ID);

        retVal.add(new PlayerBall(0,0,0,0,0,gameSurface,true,team1Img));
        retVal.add(new PlayerBall(0,0,0,0,0,gameSurface,true,team1Img));
        retVal.add(new PlayerBall(0,0,0,0,0,gameSurface,true,team1Img));

        Bitmap team2Img = BitmapFactory.decodeResource(gameSurface.getResources(), team2ID);


        retVal.add(new PlayerBall(0,0,0,0,0,gameSurface,false,team2Img));
        retVal.add(new PlayerBall(0,0,0,0,0,gameSurface,false,team2Img));
        retVal.add(new PlayerBall(0,0,0,0,0,gameSurface,false,team2Img));

        return  retVal;
    }

    //TODO change measures
    public static FootBall initFootBall(GameSurface gameSurface){
        List<Bitmap> balls = new ArrayList<>();
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball0));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball1));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball2));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball3));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball4));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball5));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball6));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball7));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball8));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball9));
        balls.add(BitmapFactory.decodeResource(gameSurface.getResources(),R.drawable.ball10));

        return new FootBall(gameSurface.getWidth()/2,gameSurface.getHeight()/2,0,0,gameSurface.getWidth()/10,gameSurface,balls);
    }
}
