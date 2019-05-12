package com.example.luka.pocketsoccerapp.StoredInformation.Database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseBroker {
    private static final String DATABASE_NAME = "playedGames_db";
    private Database database;

    public DatabaseBroker(Context context){
        database = Room.databaseBuilder(context,Database.class,DATABASE_NAME).fallbackToDestructiveMigration().build();
    }

    public void saveGameStatsToDatabase(final String name1, final String name2, final int t1score, final int t2score, final String timeString){
        new Thread(new Runnable() {
            @Override
            public void run() {
                PlayedGames pg = new PlayedGames(name1,name2,t1score,t2score,timeString);
                database.daoAccess().insertOnlySinglePlayedGame(pg);
            }
        }).start();
    }



}
