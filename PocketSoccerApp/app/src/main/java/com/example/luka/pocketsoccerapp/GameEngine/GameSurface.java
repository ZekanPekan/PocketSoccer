package com.example.luka.pocketsoccerapp.GameEngine;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.FootBall;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameMovingObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameSimpleObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Goal;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.MovingObjectState;
import com.example.luka.pocketsoccerapp.GameEngine.Settings.GameState;
import com.example.luka.pocketsoccerapp.GameEngine.Settings.SavedGame;
import com.example.luka.pocketsoccerapp.StoredInformation.Database.DataViewModel;
import com.example.luka.pocketsoccerapp.StoredInformation.Database.DatabaseBroker;
import com.example.luka.pocketsoccerapp.StoredInformation.Database.PlayedGames;

import java.util.ArrayList;
import java.util.List;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {
    private List<GameSimpleObject> gameEnvirometObject;
    private List<GameMovingObject> movingObjects;
    private GameThread gameThread = null;
    private boolean teamTurn = true;
    private GameState state;
    private FootBall ball = null;
    private Goal[] goals = null;
    private SoundManager soundManager = new SoundManager();
    private GameTurnProcessor gameTurnProcessor;
    private MovingObjectState[] savedMovingObjectStates = null;
    private ScoredGoalProcessor scoredGoalProcessor = null;
    private GameTimeProcessor timer = null;
    private List<AIPlayer> players;

    public GameSurface(Context context,GameState gs){
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
        state = gs;
    }

    public GameSurface(Context context, SavedGame sg){
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
        state = new GameState(sg);
        savedMovingObjectStates = sg.getBallStates();
    }

    public void update(){
        if(gameEnded())
            endGame();
        for(GameMovingObject m : movingObjects){
            m.update();
        }
        for(AIPlayer player : players)
            player.update();

        gameTurnProcessor.update();
        scoredGoalProcessor.process();
        timer.update();
    }

    @Override
    public void draw(Canvas canvas)  {
        super.draw(canvas);

        for (GameSimpleObject o : gameEnvirometObject)
            o.draw(canvas);
        for(GameMovingObject m : movingObjects )
            m.draw(canvas);

        scoredGoalProcessor.draw(canvas);
        timer.draw(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        GameInitializer.initGame(this,holder);
        gameThread.setRunning();
        gameThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gameTurnProcessor.processTouchEvent(event);
        return true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public boolean gameEnded(){
        return state.getGameEnder().gameEnded(state.getTeam1Score(),state.getTeam2Score(),timer.getMillisTime()/1000);
    }

    public void endGame(){
        getGameThread().end();
        ((Activity)this.getContext()).finish();
    }

    public GameThread getGameThread() {
        return gameThread;
    }
    public List<GameMovingObject> getMovingObjects() {
        return movingObjects;
    }
    public GameState getState() {
        return state;
    }
    public FootBall getBall() {
        return ball;
    }
    public MovingObjectState[] getMovingObjectState(){
        return savedMovingObjectStates;
    }
    public SoundManager getSoundManager(){return soundManager;}
    public boolean isTeamTurn() {
        return teamTurn;
    }
    public Goal[] getGoals(){
        return this.goals;
    }
    public GameTimeProcessor getTimer() {
        return timer;
    }
    public GameTurnProcessor getGameTurnProcessor() {
        return gameTurnProcessor;
    }
    public void setTeamTurn(boolean turn){this.teamTurn = turn;}
    public void setGameEnvirometObject(List<GameSimpleObject> gameEnvirometObject) {
        this.gameEnvirometObject = gameEnvirometObject;
    }
    public void setMovingObjects(List<GameMovingObject> movingObjects) {
        this.movingObjects = movingObjects;
    }
    public void setGameThread(GameThread gameThread) {
        this.gameThread = gameThread;
    }
    public void setState(GameState state) {
        this.state = state;
    }
    public void setBall(FootBall ball) {
        this.ball = ball;
    }
    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }
    public void setSoundManager(SoundManager soundManager) {
        this.soundManager = soundManager;
    }
    public void setGameTurnProcessor(GameTurnProcessor gameTurnProcessor) {
        this.gameTurnProcessor = gameTurnProcessor;
    }
    public void setSavedMovingObjectStates(MovingObjectState[] savedMovingObjectStates) {
        this.savedMovingObjectStates = savedMovingObjectStates;
    }
    public void setScoredGoalProcessor(ScoredGoalProcessor scoredGoalProcessor) {
        this.scoredGoalProcessor = scoredGoalProcessor;
    }
    public void setTimer(GameTimeProcessor timer) {
        this.timer = timer;
    }

    public List<AIPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<AIPlayer> players) {
        this.players = players;
    }
}
