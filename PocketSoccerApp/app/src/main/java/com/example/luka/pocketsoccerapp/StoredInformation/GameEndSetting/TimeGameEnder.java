package com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting;

public class TimeGameEnder implements GameEnder {

    private long timeLimit;

    public TimeGameEnder(long timeLimit){
        this.timeLimit = timeLimit;
    }

    @Override
    public boolean gameEnded(int score1, int score2, long time) {
        if(time >= timeLimit)
            return true;
        return false;
    }

    @Override
    public String getConfigString() {
        return GameEnderDeserializer.GameEndTimeModeValue+":"+timeLimit;
    }
}
