package com.example.luka.pocketsoccerapp.StoredInformation;

import com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting.GameEnder;

public class StoredSettings {

    private Integer chosenField;
    private GameEnder gameEnder;
    private Integer gameSpeed;

    public StoredSettings(Integer chosenField,GameEnder gameEnder, Integer gameSpeed){
        this.chosenField = chosenField;
        this.gameEnder = gameEnder;
        this.gameSpeed = gameSpeed;
    }

    public StoredSettings(){

    }

    public void setChosenField(Integer chosenField){
        this.chosenField = chosenField;
    }

    public void setGameEnder(GameEnder gameEnder){
        this.gameEnder = gameEnder;
    }

    public void setGameSpeed(Integer gameSpeed){
        this.gameSpeed = gameSpeed;
    }

    public Integer getChosenField(){
        return this.chosenField;
    }

    public GameEnder getGameEnder(){
        return this.gameEnder;
    }

    public Integer getGameSpeed(){
        return this.gameSpeed;
    }

    public boolean isFull(){
        if(chosenField != null && gameSpeed != null && gameEnder!= null)
            return  true;
        return false;
    }

}
