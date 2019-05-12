package com.example.luka.pocketsoccerapp.GameEngine.ImageStrategy;

import android.graphics.Bitmap;

import java.util.Iterator;
import java.util.List;

public class GifImageStrategy implements ImageStrategy {

    private List<Bitmap> images;
    private Iterator<Bitmap> iterator;


    public GifImageStrategy(List<Bitmap> images){
        this.images = images;
        this.iterator = images.iterator();
    }


    @Override
    public Bitmap getCurrentLook() {
        if(!iterator.hasNext())
            iterator = images.iterator();
        return iterator.next();
    }
}
