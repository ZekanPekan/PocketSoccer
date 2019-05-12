package com.example.luka.pocketsoccerapp.StoredInformation.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class PlayedGames {
    @PrimaryKey(autoGenerate = true)
    private Integer playedGameId;
    private String player1Name;
    private String player2Name;
    private Integer t1Score;
    private Integer t2Score;
    private String time;

    public PlayedGames(){

    }
    @Ignore
    public PlayedGames(String player1Name, String player2Name, Integer t1Score, Integer t2Score, String time) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.t1Score = t1Score;
        this.t2Score = t2Score;
        this.time = time;
    }

    @NonNull
    public Integer getPlayedGameId() {
        return playedGameId;
    }

    public void setPlayedGameId(@NonNull Integer playedGameId) {
        this.playedGameId = playedGameId;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public Integer getT1Score() {
        return t1Score;
    }

    public void setT1Score(Integer t1Score) {
        this.t1Score = t1Score;
    }

    public Integer getT2Score() {
        return t2Score;
    }

    public void setT2Score(Integer t2Score) {
        this.t2Score = t2Score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String timeMillis) {
        this.time = timeMillis;
    }
}
