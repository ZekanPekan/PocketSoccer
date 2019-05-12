package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.res.ResourcesCompat;
public class GameTimeProcessor {

    private long millisTime;
    private long lastCountedTime;
    private GameSurface gs;
    private Paint p;

    public GameTimeProcessor(long timeInMilis,GameSurface gs,int fontid,float fontSize){
        this.millisTime = timeInMilis;
        this.lastCountedTime = System.currentTimeMillis();
        this.gs = gs;
        this.p = new Paint();
        this.p.setTypeface(ResourcesCompat.getFont(gs.getContext(), fontid));
        this.p.setTextSize(fontSize);
        this.p.setColor(Color.WHITE);
    }

    public long getMillisTime(){return this.millisTime;}

    public long getTimeInSec(){return Math.round(this.millisTime/1000d);}

    public void update(){
        long cur = System.currentTimeMillis();
        this.millisTime +=(cur - lastCountedTime);
        this.lastCountedTime = cur;
    }

    public String getTimeString(){
        long t = this.millisTime/1000;
        long min = t / 60;
        long sec = t % 60;
        return min+":"+sec;
    }

    public void draw(Canvas canvas){
        String text = getTimeString();
        canvas.drawText(text,gs.getWidth()-p.measureText(text)*1.5f,p.getTextSize(),p);
    }
}
