package com.example.luka.pocketsoccerapp.GameEngine;

import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Ball;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameMovingObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.GameSimpleObject;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.PlayerBall;
import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Vector;

import java.util.List;

public class AIPlayer {

    private boolean team;
    private GameSurface gs;
    private boolean turnAck;
    private long ackMilis;
    private long humanMillis;
    private boolean blocked;

    public AIPlayer(GameSurface gs,boolean team,long milisTimeOut){
        this.gs = gs;
        this.team = team;
        this.ackMilis = 0;
        this.turnAck = false;
        this.humanMillis = milisTimeOut;
        this.blocked = false;
    }

    public void update(){
        if(blocked)
            return;
        if(gs.isTeamTurn() == team){
            gs.getGameTurnProcessor().block();
            if(!turnAck){
                turnAck = true;
                ackMilis = System.currentTimeMillis();
            }else if(System.currentTimeMillis() >= ackMilis + humanMillis){
                play();
                gs.getGameTurnProcessor().unblock();
                gs.setTeamTurn(!gs.isTeamTurn());
                turnAck = false;
            }
        }
    }
    public void block(){
        this.blocked = true;
    }

    public void unblock(){
        this.blocked = false;
    }

    public void play(){
        Ball p = getNearestPlayer(gs.getMovingObjects(), gs.getBall().getLocation());
        p.setMovement(new Vector((gs.getBall().getLocation().getX()-p.getLocation().getX())/gs.getState().getSpeed(),(gs.getBall().getLocation().getY()-p.getLocation().getY())/gs.getState().getSpeed()));
    }

    public Ball getNearestPlayer(List<GameMovingObject> ll, Vector v){
        Ball player = null;
        int distance = Integer.MAX_VALUE;
        for(GameSimpleObject gso : ll){
            if(gso instanceof PlayerBall){
                PlayerBall p = (PlayerBall) gso;
                if(p.getTeam() == this.team){
                    int d = (int)Math.floor(Math.sqrt((p.getLocation().getX()-v.getX())*(p.getLocation().getX()-v.getX())+(p.getLocation().getY()-v.getY())*(p.getLocation().getY()-v.getY())));
                    if(d < distance){
                        distance = d;
                        player = p;
                    }
                }
            }
        }

        return player;
    }

}
