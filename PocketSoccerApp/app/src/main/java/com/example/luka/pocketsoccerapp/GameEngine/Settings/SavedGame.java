package com.example.luka.pocketsoccerapp.GameEngine.Settings;

import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameMovingObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.MovingObjectState;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.PlayerBall;

import java.util.List;

public class SavedGame {

    private int field;
    private int speed;
    private String gameEnder;

    private int team1Logo;
    private int team2Logo;

    private int team1score;
    private int team2score;

    private String team1Name;
    private String team2Name;

    private boolean team1Ai;
    private boolean team2Ai;

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    private long timeseconds;

    private MovingObjectState[] ballStates;

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getGameEnder() {
        return gameEnder;
    }

    public void setGameEnder(String gameEnder) {
        this.gameEnder = gameEnder;
    }

    public int getTeam1Logo() {
        return team1Logo;
    }

    public void setTeam1Logo(int team1Logo) {
        this.team1Logo = team1Logo;
    }

    public int getTeam2Logo() {
        return team2Logo;
    }

    public void setTeam2Logo(int team2Logo) {
        this.team2Logo = team2Logo;
    }

    public int getTeam1score() {
        return team1score;
    }

    public void setTeam1score(int team1score) {
        this.team1score = team1score;
    }

    public int getTeam2score() {
        return team2score;
    }

    public void setTeam2score(int team2score) {
        this.team2score = team2score;
    }

    public long getTimeseconds() {
        return timeseconds;
    }

    public void setTimeseconds(long timeseconds) {
        this.timeseconds = timeseconds;
    }

    public MovingObjectState[] getBallStates() {
        return ballStates;
    }

    public void setBallStates(MovingObjectState[] ballStates) {
        this.ballStates = ballStates;
    }

    public boolean isTeam1Ai() {
        return team1Ai;
    }

    public void setTeam1Ai(boolean team1Ai) {
        this.team1Ai = team1Ai;
    }

    public boolean isTeam2Ai() {
        return team2Ai;
    }

    public void setTeam2Ai(boolean team2Ai) {
        this.team2Ai = team2Ai;
    }

    public void extractAndSetBallStates(List<GameMovingObject> gs){
        MovingObjectState[] mos = new MovingObjectState[7];
        int t1 = 0;
        int t2 = 3;
        for(GameMovingObject gmo : gs) {
            if (gmo instanceof PlayerBall) {
                if (((PlayerBall) gmo).getTeam())
                    mos[t1++] = new MovingObjectState(gmo);
                else
                    mos[t2++] = new MovingObjectState(gmo);
            } else
                mos[6] = new MovingObjectState(gmo);
        }

        setBallStates(mos);
    }
}
