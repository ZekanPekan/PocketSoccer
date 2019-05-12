package com.example.luka.pocketsoccerapp.Activities.Helpers;

public class TeamSpinnerTracker {

    private static String prefix[] = new String[]{"f","t"};
    private int totalNum[] = new int[]{33,32};
    private int curr;
    private int curType;

    public TeamSpinnerTracker(int curType){
        this.curr = 0;
        this.curType = curType;
    }

    public String getNext(){
        curr++;
        if(curr == totalNum[curType]){
            curType = (curType+1) % totalNum.length;
            curr = 0;
        }
        return createString();
    }

    public String getPrevious(){
        curr--;
        if(curr < 0){
            curType = (totalNum.length + curType - 1) % totalNum.length;
            curr = totalNum[curType]-1;
        }
        return createString();
    }

    public String getCurrenct(){
        return createString();
    }

    private String createString(){
        return prefix[curType]+curr;
    }
}
