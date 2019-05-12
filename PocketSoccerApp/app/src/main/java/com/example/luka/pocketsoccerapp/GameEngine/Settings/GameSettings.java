package com.example.luka.pocketsoccerapp.GameEngine.Settings;

import com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting.GameEnder;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettings;

public class GameSettings{

    private int fieldId;
    private int speed;
    private GameEnder gameEnder;

    private int team1Logo;
    private int team2Logo;

    private String team1Name;
    private String team2Name;

    public GameSettings(int fieldId, int speed, GameEnder gameEnder, int team1Logo, int team2Logo,String t1n,String t2n) {
        this.fieldId = fieldId;
        this.speed = speed;
        this.gameEnder = gameEnder;
        this.team1Logo = team1Logo;
        this.team2Logo = team2Logo;
        this.team1Name = t1n;
        this.team2Name = t2n;
    }

    public  GameSettings(StoredSettings ss, int team1Logo, int team2Logo,String team1Name,String team2Name){
        this.fieldId = ss.getChosenField();
        this.speed = ss.getChosenField();
        this.gameEnder = ss.getGameEnder();
        this.team1Logo = team1Logo;
        this.team2Logo = team2Logo;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public GameEnder getGameEnder() {
        return gameEnder;
    }

    public void setGameEnder(GameEnder gameEnder) {
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
}
