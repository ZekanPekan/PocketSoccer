package com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting;

public class ScoreGameEnder implements GameEnder {

    public int goals;

    public ScoreGameEnder(int goals){
        this.goals = goals;
    }

    @Override
    public boolean gameEnded(int score1, int score2, long time) {
        if(score1 >= goals || score2 >=goals)
            return true;
        return false;
    }

    @Override
    public String getConfigString() {
        return GameEnderDeserializer.GameEndGoalsModeValue+":"+goals;
    }


}
