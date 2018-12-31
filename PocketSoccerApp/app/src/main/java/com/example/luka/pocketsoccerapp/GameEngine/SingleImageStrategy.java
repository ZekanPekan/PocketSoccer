package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Bitmap;

public class SingleImageStrategy implements  ImageStrategy{

    private Bitmap image;

    public SingleImageStrategy(Bitmap image){
        this.image = image;
    }

    @Override
    public Bitmap getCurrentLook() {
        return image;
    }
}
