package com.example.luka.pocketsoccerapp.GameEngine.Settings;

import android.content.SharedPreferences;


import com.example.luka.pocketsoccerapp.GameEngine.GameSurface;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredInfoKeys;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettingsWriter;
import com.google.gson.Gson;

public class GameSaver {

    public static void saveGame(GameSurface gs, SharedPreferences sp){
        SavedGame sg = serialize(gs);
        Gson gson = new Gson();
        StoredSettingsWriter.writeString(sp, StoredInfoKeys.SavedGameKey,gson.toJson(sg));
    }

    public static void deleteSavedGame(SharedPreferences sp){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(StoredInfoKeys.SavedGameKey,null);
        editor.apply();
    }

    public static SavedGame getSavedGame(SharedPreferences sp){
        String savedGame = sp.getString(StoredInfoKeys.SavedGameKey,null);
        if(savedGame != null){
            Gson g = new Gson();
            return g.fromJson(savedGame,SavedGame.class);
        }
        return null;
    }

    public static boolean savedGameExists(SharedPreferences sp){
        if(sp.getString(StoredInfoKeys.SavedGameKey,null) != null)
            return true;
        return  false;
    }

    public static SavedGame serialize(GameSurface gs){
        SavedGame savedGame = new SavedGame();
        savedGame.extractAndSetBallStates(gs.getMovingObjects());
        savedGame.setField(gs.getState().getFieldId());
        savedGame.setGameEnder(gs.getState().getGameEnder().getConfigString());
        savedGame.setSpeed(gs.getState().getSpeed());
        savedGame.setTeam1Logo(gs.getState().getTeam1Logo());
        savedGame.setTeam1score(gs.getState().getTeam1Score());
        savedGame.setTeam2Logo(gs.getState().getTeam2Logo());
        savedGame.setTeam2score(gs.getState().getTeam2Score());
        savedGame.setTeam1Name(gs.getState().getTeam1Name());
        savedGame.setTeam2Name(gs.getState().getTeam2Name());
        savedGame.setTimeseconds(gs.getTimer().getTimeInSec());
        savedGame.setTeam1Ai(gs.getState().isTeam1Ai());
        savedGame.setTeam2Ai(gs.getState().isTeam2Ai());
        return  savedGame;
    }





}
