package com.example.luka.pocketsoccerapp.GameEngine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.res.ResourcesCompat;

import com.example.luka.pocketsoccerapp.GameEngine.GameObjects.Goal;
import com.example.luka.pocketsoccerapp.R;

public class ScoredGoalProcessor {

    private Bitmap goalBackGround;
    private int goalSoundId;
    private long gamePausedAnimationMillis;
    private GameSurface gs;

    private boolean gamePausedGoalAnimation;
    private long animationStart;
    private Paint pLarge;
    private Paint pSmall;

    public ScoredGoalProcessor(Bitmap goalBackGround,int goalSoundId,long gamePausedAnimationMillis,GameSurface gs,int fontid,float fontSizeLarge,float fontSizeSmall){
        this.goalBackGround = goalBackGround;
        this.goalSoundId = goalSoundId;
        this.gamePausedAnimationMillis = gamePausedAnimationMillis;
        this.gs = gs;
        this.gs.getSoundManager().registerSound(goalSoundId,gs.getContext());
        this.pLarge = new Paint();
        this.pLarge.setTypeface(ResourcesCompat.getFont(gs.getContext(), fontid));
        this.pLarge.setTextSize(fontSizeLarge);
        this.pLarge.setColor(Color.WHITE);
        this.pSmall = new Paint();
        this.pSmall.setTypeface(ResourcesCompat.getFont(gs.getContext(), fontid));
        this.pSmall.setTextSize(fontSizeSmall);
        this.pSmall.setColor(Color.WHITE);
    }

    public void process(){
        if(!gamePausedGoalAnimation) {
            Goal[] goals = gs.getGoals();
            if (goals[0].isGoal(gs.getBall())) {
                gs.setTeamTurn(true);
                gs.getState().setTeam2Score(gs.getState().getTeam2Score() + 1);
                goalProcess();
            } else if (goals[1].isGoal(gs.getBall())) {
                gs.setTeamTurn(false);
                gs.getState().setTeam1Score(gs.getState().getTeam1Score() + 1);
                goalProcess();
            }
        }else{
             if(animationStart+gamePausedAnimationMillis < System.currentTimeMillis())
                 resume();
        }
    }

    private void resume(){
        gamePausedGoalAnimation = false;
        animationStart = 0;
        gs.getGameTurnProcessor().unblock();
        for(AIPlayer player : gs.getPlayers())
            player.unblock();
    }

    private void goalProcess(){
        GameInitializer.resetBallsAfterGoal(gs);
        animationStart = System.currentTimeMillis();
        gamePausedGoalAnimation = true;
        gs.getSoundManager().playSoundIfExists(goalSoundId);
        gs.getGameTurnProcessor().block();
        for(AIPlayer player : gs.getPlayers())
            player.block();
    }

    private String getScoreStringFull(){
        return gs.getState().getTeam1Name() + " ( " +gs.getState().getTeam1Score() + " : " + gs.getState().getTeam2Score()+" ) "+gs.getState().getTeam2Name();
    }
    private String getScoreString(){
        return gs.getState().getTeam1Score() + " : " + gs.getState().getTeam2Score();
    }

    public void draw(Canvas canvas) {
        if (gamePausedGoalAnimation) {
            drawScoreBackground(canvas);
            drawScoreBig(canvas);
        }else{
            drawScoreBoard(canvas);
        }
    }

    private void drawScoreBackground(Canvas canvas){
        canvas.drawBitmap(goalBackGround,Math.round((gs.getWidth()-goalBackGround.getWidth())/2),Math.round((gs.getHeight()-goalBackGround.getHeight())/2),null);
    }

    private void drawScoreBig(Canvas canvas){
        String text = getScoreString();
        float textWidth = pLarge.measureText(text);
        float textHeight = pLarge.getTextSize();
        int xOffset = Math.round((gs.getWidth() - textWidth) / 2);
        int yOffset = Math.round((gs.getHeight()+textHeight) / 2);
        canvas.drawText(text, xOffset,yOffset , pLarge);
    }

    private void drawScoreBoard(Canvas canvas){
        String text = getScoreStringFull();
        canvas.drawText(text,pSmall.measureText(text)/20, pSmall.getTextSize(),pSmall);
    }

}
