package com.example.luka.pocketsoccerapp.GameEngine.GameObjects;

import android.graphics.Bitmap;

import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameSimpleObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Vector;
import com.example.luka.pocketsoccerapp.GameEngine.GameSurface;
import com.example.luka.pocketsoccerapp.GameEngine.ImageStrategy.SingleImageStrategy;

public class GameEnvironmentObjects extends GameSimpleObject {

    public GameEnvironmentObjects(Bitmap image) {
        super(new SingleImageStrategy(image), new Vector(0,0));
    }
}
