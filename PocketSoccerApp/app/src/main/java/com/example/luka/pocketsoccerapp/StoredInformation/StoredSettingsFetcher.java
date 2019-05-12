package com.example.luka.pocketsoccerapp.StoredInformation;

import android.content.SharedPreferences;

import com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting.GameEnder;
import com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting.GameEnderDeserializer;

public class StoredSettingsFetcher {

    private static StoredSettings ss = null;

    public synchronized static StoredSettings fetchFullSettings(SharedPreferences sp){
        if(ss == null){
            ss = new StoredSettings(getGameFieldDirectly(sp), GameEnderDeserializer.buildGameEnder(sp), getGameSpeedDirectly(sp));
        }else{
            if( ss.getGameSpeed() == null){
                ss.setGameSpeed(getGameSpeedDirectly(sp));
            }
            if( ss.getChosenField() == null){
                ss.setChosenField(getGameFieldDirectly(sp));
            }
            if( ss.getGameEnder() == null){
                ss.setGameEnder(GameEnderDeserializer.buildGameEnder(sp));
            }
        }
        return  ss;
    }

    public static int getGameFieldId(SharedPreferences sp){
        if(ss == null){
            ss = new StoredSettings();
            ss.setChosenField(getGameFieldDirectly(sp));
        }else if( ss.getChosenField() == null){
            ss.setChosenField(getGameFieldDirectly(sp));
        }
        return ss.getChosenField();
    }

    public static int getGameSpeedModifier(SharedPreferences sp){
        if(ss == null){
            ss = new StoredSettings();
            ss.setGameSpeed(getGameSpeedDirectly(sp));
        }else if(ss.getGameSpeed() == null) {
            ss.setGameSpeed(getGameSpeedDirectly(sp));
        }
        return ss.getGameSpeed();
    }

    public static GameEnder getGameEnder(SharedPreferences sp){
        if(ss == null){
            ss = new StoredSettings();
            ss.setGameEnder(GameEnderDeserializer.buildGameEnder(sp));
        }else if(ss.getGameEnder() == null){
            ss.setGameEnder(GameEnderDeserializer.buildGameEnder(sp));
        }
        return ss.getGameEnder();
    }

    private static int getGameSpeedDirectly(SharedPreferences sp){
        int def_field = sp.getInt(StoredInfoKeys.GameSpeedDefault,-1);
        return sp.getInt(StoredInfoKeys.GameSpeedCurrent,def_field);
    }

    private static int getGameFieldDirectly(SharedPreferences sp){
        int def_field = sp.getInt(StoredInfoKeys.GameFieldDefault,-1);
         return sp.getInt(StoredInfoKeys.GameField,def_field);
    }

}
