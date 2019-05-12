package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends  Thread {

    private GameSurface gameSurface;
    private SurfaceHolder surfaceHolder;
    private boolean running;

    public GameThread(GameSurface gameSurface, SurfaceHolder surfaceHolder){
        this.gameSurface = gameSurface;
        this.surfaceHolder = surfaceHolder;
        this.running = false;
    }

    public void setRunning(){
        this.running = true;
    }
    public void end(){this.running = false;}

    @Override
    public void run() {
        while(running){

            Canvas canvas = null;
            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (canvas){
                    this.gameSurface.update();
                    this.gameSurface.draw(canvas);
                }
            }catch (Exception e){

            }finally {
                if(canvas != null){
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
