package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Bitmap;

public class GameEnvironmentObjects extends GameSimpleObject {

    public GameEnvironmentObjects(Bitmap image, GameSurface gameSurface) {
        super(new SingleImageStrategy(image), gameSurface, new Vector(0,0));
    }
}
