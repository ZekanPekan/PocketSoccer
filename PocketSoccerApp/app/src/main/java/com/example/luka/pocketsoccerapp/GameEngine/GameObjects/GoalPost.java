package com.example.luka.pocketsoccerapp.GameEngine.GameObjects;

public class GoalPost {
    private Vector outSide;
    private Vector inSide;
    private int r;

    public GoalPost(Vector outSide, Vector inSide, int r){
        this.outSide = outSide;
        this.inSide = inSide;
        this.r = r;
    }

    public boolean fromInside(Vector v){
        if(inSide.getX() > outSide.getX())
            return inSide.getX() < v.getX();
        else
            return inSide.getX() > v.getX();
    }

    public double getY(){
        return inSide.getY();
    }

    /**
     *
     * @param ball
     * @return < flag0 if no collision, flag0 if ball interaction, flag1 if wall like interaction
     */
    public int collidesMode(Ball ball){
        double length = outSide.sub(inSide).getSize();
        double t = Math.max(0, Math.min(1, ball.getLocation().sub(outSide).dot(inSide.sub(outSide)) / (length* length)));
        Vector p = inSide.sub(outSide);
        p.multiply(t);
        double dis = p.add(outSide).distance(ball.getLocation());
        if(dis < ball.getR()/2+r){
            if(fromInside(ball.getLocation()))
                return 0;
            return 1;
        }
        return -1;
    }


    public void updateBall(Ball ball){
        int mode = collidesMode(ball);
        if(mode == -1)
            return;
        if(mode == 0){
            Vector v = ball.getMovement();
            v.setX(-v.getX());
            v.setY(-v.getY());
            ball.setMovement(v);
//            Vector nv2 = ball.getLocation().sub(inSide);
//            nv2.normalize();
//            nv2.multiply(ball.getMovement().dot(nv2));
//            Vector nv1 = ball.getMovement().sub(nv2);
//
//            ball.setMovement(nv1.sub(nv1));
        }else{
            Vector v = ball.getMovement();
            v.setY(-v.getY());
            ball.setMovement(v);
        }
    }
}
