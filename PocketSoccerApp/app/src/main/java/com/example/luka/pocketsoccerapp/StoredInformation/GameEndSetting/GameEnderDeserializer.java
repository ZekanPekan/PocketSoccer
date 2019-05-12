package com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting;

import android.content.SharedPreferences;

import com.example.luka.pocketsoccerapp.StoredInformation.StoredInfoKeys;

public class GameEnderDeserializer {

    public static final int GameEndTimeModeValue = 0;
    public static final int GameEndGoalsModeValue = 1;

    public static GameEnder buildGameEnder(SharedPreferences sp){
        int mode = sp.getInt(StoredInfoKeys.GameEndModeDefault,-1);
        mode = sp.getInt(StoredInfoKeys.GameEndMode,mode);
        if( mode == GameEndGoalsModeValue){
            int goals = sp.getInt(StoredInfoKeys.GameEndGoalsDefault,-1);
            goals = sp.getInt(StoredInfoKeys.GameEndGoals,goals);
            return new ScoreGameEnder(goals);
        }else if ( mode == GameEndTimeModeValue) {
            long time = sp.getLong(StoredInfoKeys.GameEndTimeDefault,-1);
            time = sp.getLong(StoredInfoKeys.GameEndTime,time);
            return  new TimeGameEnder(time);
        }

        return null;
    }

    public static GameEnder buildGameEnder(String gameEnder){
        String[] ll = gameEnder.split(":");
        int i = Integer.parseInt(ll[0]);
        if(i == GameEndGoalsModeValue){
            return new ScoreGameEnder(Integer.parseInt(ll[1]));
        }else if (i == GameEndTimeModeValue){
            return new TimeGameEnder(Long.parseLong(ll[1]));
        }
        return null;
    }

}
