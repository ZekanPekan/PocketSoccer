package com.example.luka.pocketsoccerapp.StoredInformation.Database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@android.arch.persistence.room.Database(entities = {PlayedGames.class},version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static final String DATABASE_NAME = "playedGames_db";
    private static  Database instance;
    public abstract DaoAccess daoAccess();

    public static synchronized Database getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context,Database.class,DATABASE_NAME).fallbackToDestructiveMigration().build();
        }
        return  instance;
    }


}
