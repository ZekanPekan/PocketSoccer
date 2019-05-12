package com.example.luka.pocketsoccerapp.StoredInformation;

import android.content.SharedPreferences;

import com.example.luka.pocketsoccerapp.R;
import com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting.GameEnderDeserializer;

public class StoredSettingsWriter {

    private static void writeInt(SharedPreferences sp,String key, int value){
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public static void writeLong(SharedPreferences sp,String key,long value){
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key,value);
        editor.apply();
    }

    public static void writeString(SharedPreferences sp, String key, String value){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,value);
        editor.apply();
    }

    public static void writeNewGameSpeedModifier(SharedPreferences sp, int speed){
        writeInt(sp,StoredInfoKeys.GameSpeedCurrent,speed);
    }

    public static void writeNewGameChosenField(SharedPreferences sp, int fieldId){
        writeInt(sp,StoredInfoKeys.GameField,fieldId);
    }

    public static void writeNewGameEndMode(SharedPreferences sp, int mode){
        writeInt(sp,StoredInfoKeys.GameEndMode,mode);
    }

    public static void writeNewGameEndTime(SharedPreferences sp, long time){
        writeLong(sp,StoredInfoKeys.GameEndTime,time);
    }

    public static void writeNewGameEndGoals(SharedPreferences sp, int goals){
        writeInt(sp,StoredInfoKeys.GameEndGoals,goals);
    }

    public static void initSharedPreferences(SharedPreferences sp){
        if(!sp.getBoolean(StoredInfoKeys.SharedPreferencesInited,false)){
            writeDefault(sp);
        }
    }

    public static void reset(SharedPreferences sp){
        clearCurrent(sp);
    }

    private static void writeDefault(SharedPreferences sp){
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(StoredInfoKeys.GameEndGoalsDefault,10);
        editor.putLong(StoredInfoKeys.GameEndTimeDefault,300l);
        editor.putInt(StoredInfoKeys.GameEndModeDefault, GameEnderDeserializer.GameEndGoalsModeValue);
        editor.putInt(StoredInfoKeys.GameSpeedDefault,3);
        editor.putInt(StoredInfoKeys.GameFieldDefault, R.drawable.field1_hd);
        editor.putBoolean(StoredInfoKeys.SharedPreferencesInited,true);
        editor.apply();
    }
    private static void clearCurrent(SharedPreferences sp){
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(StoredInfoKeys.GameEndGoals);
        editor.remove(StoredInfoKeys.GameEndTime);
        editor.remove(StoredInfoKeys.GameEndMode);
        editor.remove(StoredInfoKeys.GameSpeedCurrent);
        editor.remove(StoredInfoKeys.GameField);
        editor.apply();
    }

}
