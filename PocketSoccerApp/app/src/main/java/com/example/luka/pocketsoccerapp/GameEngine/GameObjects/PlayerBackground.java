package com.example.luka.pocketsoccerapp.GameEngine.GameObjects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.luka.pocketsoccerapp.GameEngine.GameSurface;
import com.example.luka.pocketsoccerapp.GameEngine.ImageStrategy.SingleImageStrategy;

public class PlayerBackground extends  GameSimpleObject{

    private boolean team;
    private Paint paint;
    private int imgWh;
    private int imgHh;

    public PlayerBackground(Bitmap image, Vector location, boolean team, GameSurface gs) {

        super(new SingleImageStrategy(image),location);
        this.team = team;
        this.imgWh = image.getWidth()/2;
        this.imgHh = image.getHeight()/2;
        paint = new Paint();
        paint.setAlpha(100);
        this.gameSurface = gs;
    }

    public void draw(Canvas canvas)  {
        if(gameSurface.isTeamTurn() == team) {
            Bitmap bitmap = this.imageStrategy.getCurrentLook();
            Vector drawLoc = getDrawVector();
            canvas.drawBitmap(bitmap, (int) Math.floor(drawLoc.getX()), (int) Math.floor(drawLoc.getY()), paint);
            this.lastDrawNanoTime = System.nanoTime();
        }
    }

    @Override
    protected Vector getDrawVector() {
        return new Vector(location.getX() - imgWh,location.getY() -imgHh);
    }
}
