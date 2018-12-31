package com.example.luka.pocketsoccerapp.GameEngine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.luka.pocketsoccerapp.R;

import java.util.List;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {
    private List<GameSimpleObject> gameEnvirometObject;
    private List<GameMovingObject> movingObjects;

    private FootBall ball;

    //TODO add fieald and teams to be parametrized
    public GameSurface(Context context)  {
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
        gameEnvirometObject = GameInitializer.initEnvirometn(this, R.drawable.field1_hd);
        movingObjects = GameInitializer.initAllPlayerBalls(R.drawable.partizan,R.drawable.zvezda,this);
        ball = GameInitializer.initFootBall(this);
        movingObjects.add(ball);
    }

    public void update(){
        for(GameMovingObject m : movingObjects){
            m.update();
        }
//        ball.wasGoal();
    }

    @Override
    public void draw(Canvas canvas)  {
        super.draw(canvas);
        for (GameSimpleObject o : gameEnvirometObject)
            o.draw(canvas);
        for(GameMovingObject m : movingObjects )
            m.draw(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
