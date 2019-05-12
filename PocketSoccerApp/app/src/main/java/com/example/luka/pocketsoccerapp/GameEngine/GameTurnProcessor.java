package com.example.luka.pocketsoccerapp.GameEngine;

import android.view.MotionEvent;

import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Ball;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Vector;

public class GameTurnProcessor {

    private GameSurface gs;
    private Vector startVec;
    private Ball selectedPlayer;
    private long turnTimeMillis;
    private long turnStarted;
    private long soundTrackLastPlayed =0;
    private int soundTrack;
    private boolean block = false;
    private static long SOUND_TRACK_MILLIS = 3000;
    private static long SOUND_TRACK_RATE = 1000;

    public GameTurnProcessor(GameSurface gs, long turnTimeMillis,int soundTrack){
        this.gs = gs;
        this.startVec = null;
        this.selectedPlayer = null;
        this.turnTimeMillis = turnTimeMillis;
        this.soundTrack = soundTrack;
        gs.getSoundManager().registerSound(soundTrack,gs.getContext());
    }

    public void reset(){
        startVec = null;
        selectedPlayer = null;
        turnStarted = System.currentTimeMillis();
    }

    public void update(){
        if(block)
            return;
        long curr = System.currentTimeMillis();
        long turnEnd = turnStarted+turnTimeMillis;
        if(curr >= turnEnd) {
            reset();
            gs.setTeamTurn(!gs.isTeamTurn());
        }else if(curr >= turnEnd - SOUND_TRACK_MILLIS){
            if(curr - soundTrackLastPlayed >= SOUND_TRACK_RATE){
                soundTrackLastPlayed = curr;
                gs.getSoundManager().playSoundIfExists(soundTrack);
            }
        }

    }

    public void block(){
        this.block = true;
    }
    public void unblock(){
        this.block = false;
    }

    public void processTouchEvent(MotionEvent event){
        if(block)
            return;
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            startVec = new Vector(event.getX(),event.getY());
            selectedPlayer = GameEngineHelper.getNearestPlayer(gs.getMovingObjects(), startVec, gs.isTeamTurn());
            if(selectedPlayer == null)
                startVec = null;
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            if(startVec != null){
                Vector moving = new Vector(event.getX()-startVec.getX(),event.getY()-startVec.getY());
                moving.divide(gs.getState().getSpeed());
                selectedPlayer.setMovement(moving);
                gs.setTeamTurn(!gs.isTeamTurn());
                reset();
            }
        }
    }
}
