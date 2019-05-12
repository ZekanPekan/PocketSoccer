package com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting;


public interface GameEnder{
    boolean gameEnded(int score1,int score2,long time);
    String getConfigString();
}
