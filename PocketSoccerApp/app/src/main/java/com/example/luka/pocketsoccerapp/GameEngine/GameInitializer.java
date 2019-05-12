package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.SurfaceHolder;

import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Ball;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.FootBall;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameEnvironmentObjects;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameMovingObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameSimpleObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Goal;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GoalPost;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.MovingObjectState;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.PlayerBackground;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.PlayerBall;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Vector;
import com.example.luka.pocketsoccerapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GameInitializer {

    public static List<GameSimpleObject> initEnvironment(GameSurface gameSurface) {
        List<GameSimpleObject> retVal = new ArrayList<>();
        retVal.add(new GameEnvironmentObjects(scaleImage(gameSurface, BitmapFactory.decodeResource(gameSurface.getResources(), gameSurface.getState().getFieldId()))));
        retVal.add(new GameEnvironmentObjects(scaleImage(gameSurface, BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.fieldkeeper_hd))));
        retVal.add(new PlayerBackground(scaleImageSquare(gameSurface, BitmapFactory.decodeResource(gameSurface.getResources(), gameSurface.getState().getTeam1Logo()), 1,0.5f), new Vector(gameSurface.getWidth() / 4, gameSurface.getHeight() / 2), true,gameSurface));
        retVal.add(new PlayerBackground(scaleImageSquare(gameSurface, BitmapFactory.decodeResource(gameSurface.getResources(), gameSurface.getState().getTeam2Logo()), 1,0.5f
        ), new Vector(gameSurface.getWidth() / 4 * 3, gameSurface.getHeight() / 2), false,gameSurface));

        return retVal;
    }


    public static List<Ball> initAllPlayerBalls(GameSurface gameSurface) {
        int radius = gameSurface.getWidth() / 18;
        Bitmap team1Img = scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), gameSurface.getState().getTeam1Logo()), radius);

        Ball p1 = new PlayerBall(gameSurface.getWidth() / 5, gameSurface.getHeight() / 5, 0, 0, radius, gameSurface, true, team1Img);
        Ball p2 = new PlayerBall(gameSurface.getWidth() * 2 / 5, gameSurface.getHeight() /2, 0, 0, radius, gameSurface, true, team1Img);
        Ball p3 = new PlayerBall(gameSurface.getWidth() / 5, gameSurface.getHeight() * 4 / 5, 0, 0, radius, gameSurface, true, team1Img);

        Bitmap team2Img = scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), gameSurface.getState().getTeam2Logo()), radius);


        Ball p4 = new PlayerBall(gameSurface.getWidth() * 4 / 5, gameSurface.getHeight() / 5, 0, 0, radius, gameSurface, false, team2Img);
        Ball p5 = new PlayerBall(gameSurface.getWidth() * 3 / 5, gameSurface.getHeight() /2, 0, 0, radius, gameSurface, false, team2Img);
        Ball p6 = new PlayerBall(gameSurface.getWidth() * 4 / 5, gameSurface.getHeight() * 4 / 5, 0, 0, radius, gameSurface, false, team2Img);

        p1.addOtherMovingObjects(p2, p3, p4, p5, p6);
        p2.addOtherMovingObjects(p1, p3, p4, p5, p6);
        p3.addOtherMovingObjects(p1, p2, p4, p5, p6);
        p4.addOtherMovingObjects(p1, p2, p3, p5, p6);
        p5.addOtherMovingObjects(p1, p2, p3, p4, p6);
        p6.addOtherMovingObjects(p1, p2, p3, p4, p5);

        List<Ball> ll = Arrays.asList(p1, p2, p3, p4, p5, p6);
        if (gameSurface.getMovingObjectState() != null) {
            Iterator<Ball> it = ll.iterator();

            for (MovingObjectState m : gameSurface.getMovingObjectState()) {
                Ball b;
                if(it.hasNext())
                    b = it.next();
                else
                    break;
                b.setLocation(m.getLocation());
                b.setMovement(m.getMovement());
            }
        }
        return ll;
    }

    public static void initAiPlayers(GameSurface gs){
        gs.setPlayers(new ArrayList<AIPlayer>());
        if(gs.getState().isTeam1Ai()){
            gs.getPlayers().add(new AIPlayer(gs,true,2000));
        }
        if(gs.getState().isTeam2Ai()){
            gs.getPlayers().add(new AIPlayer(gs,false,2000));
        }
    }

    public static FootBall initFootBall(GameSurface gameSurface) {
        List<Bitmap> balls = new ArrayList<>();
        int radius = gameSurface.getWidth() / 20;
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball0), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball1), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball2), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball3), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball4), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball5), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball6), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball7), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball8), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball9), radius));
        balls.add(scaleImage(BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.ball10), radius));

        FootBall b = new FootBall(gameSurface.getWidth() / 2, gameSurface.getHeight() / 2, 0, 0, Math.round(radius/3), gameSurface, balls);

        if (gameSurface.getMovingObjectState() != null) {
            b.setLocation(gameSurface.getMovingObjectState()[6].getLocation());
            b.setMovement(gameSurface.getMovingObjectState()[6].getMovement());
        }

        return b;
    }

    public static Bitmap scaleImage(GameSurface gs, Bitmap image) {
        return Bitmap.createScaledBitmap(image, gs.getWidth(),gs.getHeight(), true);
    }

    public static Bitmap scaleImage(Bitmap image, int size) {
        return Bitmap.createScaledBitmap(image, size, size, true);
    }

    public static Bitmap scaleImageSquare(GameSurface gs,Bitmap image,float percentageH,float percentageW){
        int h = (int) (gs.getHeight()*percentageH);
        int w = (int) (gs.getWidth()*percentageW);
        int size = h > w ? w : h;
        return scaleImage(image,size);
    }

    public static Bitmap scaleImage(GameSurface gs, Bitmap image, float percentageH,float percentageW) {
        return Bitmap.createScaledBitmap(image, Math.round(gs.getWidth()*percentageW), Math.round(gs.getHeight()*percentageH), true);
    }

    private static double scaleNum(double v, double max, double real) {
        return v * real / max;
    }

    public static Goal[] initGoals(GameSurface gs) {
        Goal[] retVal = new Goal[2];
        GoalPost t1t = new GoalPost(new Vector(0, scaleNum(173, 480, gs.getHeight())), new Vector(scaleNum(44, 800, gs.getWidth()), scaleNum(173, 480, gs.getHeight())), gs.getHeight() / 110);
        GoalPost t1b = new GoalPost(new Vector(0, scaleNum(307, 480, gs.getHeight())), new Vector(scaleNum(44, 800, gs.getWidth()), scaleNum(307, 480, gs.getHeight())), gs.getHeight() / 110);
        GoalPost t2t = new GoalPost(new Vector(gs.getWidth(), scaleNum(173, 480, gs.getHeight())), new Vector(scaleNum(756, 800, gs.getWidth()), scaleNum(173, 480, gs.getHeight())), gs.getHeight() / 110);
        GoalPost t2b = new GoalPost(new Vector(gs.getWidth(), scaleNum(307, 480, gs.getHeight())), new Vector(scaleNum(756, 800, gs.getWidth()), scaleNum(307, 480, gs.getHeight())), gs.getHeight() / 110);

        retVal[0] = new Goal(t1t, t1b, true);
        retVal[1] = new Goal(t2t, t2b, false);
        return retVal;
    }

    public static void setGoals(List<Ball> b,Goal[] g){
        for(Ball bb : b)
            bb.setGoals(g);
    }

    public static void setGoal(Ball b, Goal[] g){
        b.setGoals(g);
    }
    //TODO register sounds or not?
    public static SoundManager initSoundManager(GameSurface gs){
        SoundManager sm = new SoundManager();
//        sm.registerSound(R.raw.bounce,gs.getContext());
        return sm;
    }
    
    public static void initGame(GameSurface gs, SurfaceHolder holder){

        gs.setSoundManager(GameInitializer.initSoundManager(gs));
        gs.setGameTurnProcessor(new GameTurnProcessor(gs,10000,R.raw.time));
        gs.setGameEnvirometObject(GameInitializer.initEnvironment(gs));
        ArrayList<GameMovingObject> movingObjects = new ArrayList<>();
        gs.setGoals(GameInitializer.initGoals(gs));
        List<Ball> balls = GameInitializer.initAllPlayerBalls(gs);
        GameInitializer.setGoals(balls,gs.getGoals());
        FootBall ball = GameInitializer.initFootBall(gs);
        GameInitializer.setGoal(ball,gs.getGoals());
        for(Ball b : balls){
            b.addMovingRoundObject(ball);
        }
        ball.setOtherMovingObjects(balls);
        movingObjects.addAll(balls);
        movingObjects.add(ball);
        gs.setBall(ball);
        gs.setMovingObjects(movingObjects);
        gs.setGameThread(new GameThread(gs, holder));
        gs.setSavedMovingObjectStates(null);
        gs.setScoredGoalProcessor(new ScoredGoalProcessor(scaleImage(gs,BitmapFactory.decodeResource(gs.getResources(),R.drawable.gamescore_hd)),R.raw.goal_cheers,5100,gs,R.font.alienencounters,500,100));
        gs.setTimer(new GameTimeProcessor(gs.getState().getTimeseconds()*1000,gs,R.font.alienencounters,100));
        initAiPlayers(gs);
    }

    public static void resetBallsAfterGoal(GameSurface gs){
        gs.getBall().setMovement(new Vector(0,0));
        gs.getBall().setLocation(new Vector(gs.getWidth() / 2, gs.getHeight() / 2));
        gs.getGameTurnProcessor().reset();
        Vector[] team1Vec = new Vector[3];
        team1Vec[0]=new Vector(gs.getWidth() / 5, gs.getHeight() / 5);
        team1Vec[1]=new Vector(gs.getWidth() * 2 / 5, gs.getHeight() /2);
        team1Vec[2]=new Vector(gs.getWidth() / 5, gs.getHeight() * 4 / 5);
        int t1Ite = 0;
        Vector[] team2Vec = new Vector[3];
        team2Vec[0]=new Vector(gs.getWidth() *4/ 5, gs.getHeight() / 5);
        team2Vec[1]=new Vector(gs.getWidth() * 3 / 5, gs.getHeight() /2);
        team2Vec[2]=new Vector(gs.getWidth() *4/ 5, gs.getHeight() * 4 / 5);
        int t2Ite = 0;
        for( GameMovingObject b : gs.getMovingObjects()){
            if(b instanceof PlayerBall){
                if(((PlayerBall) b).getTeam()){
                    b.setLocation(team1Vec[t1Ite++]);
                }else
                    b.setLocation(team2Vec[t2Ite++]);
            }
            b.setMovement(new Vector(0,0));
        }
    }

}
