package com.example.luka.pocketsoccerapp.GameEngine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.HashMap;
import java.util.Map;

public class SoundManager {

    private static int MAX_STREAMS = 100;
    private SoundPool soundPool;
    private Map<Integer,Integer> soundIds;

    public SoundManager(){
        soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        soundIds  = new HashMap<>();
    }

    public boolean playSoundIfExists(int soundResId){
        Integer id = soundIds.get(soundResId);
        if(id != null){
            soundPool.play(id,0.8f,0.8f,1,0,1f);
            return true;
        }
        return false;
    }

    public void registerSound(int soundResId, Context context){
        if(soundIds.get(soundResId) == null) {
            int id = soundPool.load(context, soundResId, 1);
            soundIds.put(soundResId, id);
        }
    }

}
