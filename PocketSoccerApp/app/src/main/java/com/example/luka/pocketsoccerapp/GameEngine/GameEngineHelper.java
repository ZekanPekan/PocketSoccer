package com.example.luka.pocketsoccerapp.GameEngine;

import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Ball;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameMovingObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameSimpleObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.PlayerBall;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Vector;

import java.util.List;

public class GameEngineHelper {

    public static Ball getNearestPlayer(List<GameMovingObject> ll, Vector v, boolean team){
        Ball player = null;
        int distance = Integer.MAX_VALUE;
        for(GameSimpleObject gso : ll){
            if(gso instanceof PlayerBall){
                PlayerBall p = (PlayerBall) gso;
                if(p.getTeam() == team){
                    int d = (int)Math.floor(Math.sqrt((p.getLocation().getX()-v.getX())*(p.getLocation().getX()-v.getX())+(p.getLocation().getY()-v.getY())*(p.getLocation().getY()-v.getY())));
                    if(d < distance && d < p.getR()*3){
                        distance = d;
                        player = p;
                    }
                }
            }
        }

        return player;
    }

}
