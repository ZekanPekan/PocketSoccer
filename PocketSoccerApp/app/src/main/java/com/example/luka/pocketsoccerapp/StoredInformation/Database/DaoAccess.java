package com.example.luka.pocketsoccerapp.StoredInformation.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySinglePlayedGame(PlayedGames playedGames);

    @Query("SELECT * FROM PlayedGames WHERE (player1Name = :name1 AND player2Name = :name2) OR (player1Name = :name2 AND player2Name = :name1)")
    LiveData<List<PlayedGames>> fetchPlayedGamesByNameComb(String name1, String name2);

    @Query("DELETE FROM PlayedGames")
    void deleteAll();

    @Query("DELETE FROM PlayedGames WHERE (player1Name = :name1 AND player2Name = :name2) OR (player1Name = :name2 AND player2Name = :name1)")
    void deletePlayedGamesByNameComb(String name1,String name2);


}
