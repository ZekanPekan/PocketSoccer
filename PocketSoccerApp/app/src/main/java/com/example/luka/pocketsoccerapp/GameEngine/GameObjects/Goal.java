package com.example.luka.pocketsoccerapp.GameEngine.GameObjects;

public class Goal {
    private GoalPost[] posts;
    private boolean team;

    public Goal(GoalPost gpTop,GoalPost gpBot,boolean team){
        posts = new GoalPost[2];
        posts[0]=gpTop;
        posts[1]=gpBot;
        this.team = team;
    }

    public boolean isGoal(FootBall ball){
        if(!posts[0].fromInside(ball.getLocation()) && betweenVertical(ball.getLocation()))
            return true;
        return false;
    }

    private boolean betweenVertical(Vector v){
        if((posts[0].getY() < v.getY()) && (posts[1].getY() > v.getY()))
            return true;
        return  false;
    }

    public void updateBall(Ball ball){
        for(GoalPost gp : posts) {
            gp.updateBall(ball);
        }
    }
}
