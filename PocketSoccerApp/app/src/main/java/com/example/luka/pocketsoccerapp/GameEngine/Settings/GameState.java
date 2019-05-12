package com.example.luka.pocketsoccerapp.GameEngine.Settings;

import com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting.GameEnder;
import com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting.GameEnderDeserializer;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettings;

public class GameState extends GameSettings {

    private int team1Score;
    private int team2Score;
    private long timeseconds;

    private boolean team1Ai;
    private boolean team2Ai;


    public GameState(SavedGame savedGame){
        super(savedGame.getField(),savedGame.getSpeed(), GameEnderDeserializer.buildGameEnder(savedGame.getGameEnder()),savedGame.getTeam1Logo(),savedGame.getTeam2Logo(),savedGame.getTeam1Name(),savedGame.getTeam2Name());
        this.team1Score = savedGame.getTeam1score();
        this.team2Score = savedGame.getTeam2score();
        this.timeseconds = savedGame.getTimeseconds();
        this.team1Ai = savedGame.isTeam1Ai();
        this.team2Ai = savedGame.isTeam2Ai();
    }

    public GameState(int fieldId, int speed, GameEnder gameEnder, int team1Logo, int team2Logo,String t1n,String t2n,boolean t1ai,boolean t2ai) {
        super(fieldId, speed, gameEnder, team1Logo, team2Logo,t1n,t2n);
        init0();
        this.team1Ai = t1ai;
        this.team2Ai = t2ai;
    }

    public GameState(StoredSettings ss, int team1Logo, int team2Logo,String t1n,String t2n,boolean t1ai,boolean t2ai) {
        super(ss, team1Logo, team2Logo,t1n,t2n);
        init0();
        this.team1Ai = t1ai;
        this.team2Ai = t2ai;

    }

    private void init0(){
        team1Score = 0;
        team2Score = 0;
        timeseconds = 0l;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public void setTimeseconds(long timeseconds) {
        this.timeseconds = timeseconds;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public long getTimeseconds() {
        return timeseconds;
    }

    public boolean isTeam1Ai() {
        return team1Ai;
    }

    public boolean isTeam2Ai() {
        return team2Ai;
    }
}
