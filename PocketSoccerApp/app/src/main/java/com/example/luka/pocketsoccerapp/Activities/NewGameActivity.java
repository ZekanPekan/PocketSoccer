package com.example.luka.pocketsoccerapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.luka.pocketsoccerapp.Activities.Helpers.TeamSpinnerTracker;
import com.example.luka.pocketsoccerapp.R;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredInfoKeys;

public class NewGameActivity extends Activity {

    private TeamSpinnerTracker[] trackers = new TeamSpinnerTracker[]{new TeamSpinnerTracker(0),new TeamSpinnerTracker(1)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.new_game_activity);
    }

    public void t1Left(View view){
       int i = getId(trackers[0].getPrevious());
        ImageView iv = findViewById(R.id.flag1);
        iv.setImageResource(i);
    }
    public void t1Right(View view){
        int i = getId(trackers[0].getNext());
        ImageView iv = findViewById(R.id.flag1);
        iv.setImageResource(i);
    }
    public void t2Left(View view){
        int i = getId(trackers[1].getPrevious());
        ImageView iv = findViewById(R.id.flag2);
        iv.setImageResource(i);
    }
    public void t2Right(View view){
        int i = getId(trackers[1].getNext());
        ImageView iv = findViewById(R.id.flag2);
        iv.setImageResource(i);
    }

    private int getId(String imgName){
        return getResources().getIdentifier(imgName, "drawable", getPackageName());
    }

    public void next(View view){
        EditText et1 = findViewById(R.id.team1Name);
        EditText et2 = findViewById(R.id.team2Name);
        String t = et1.getText().toString();
        String t2 = et2.getText().toString();
        boolean error = false;
        if(t.isEmpty()){
            error = true;
            et1.setError("Name me!");
        }
        if(t2.isEmpty()){
            error = true;
            et2.setError("Name me!");
        }else if(t.equals(t2)){
            error = true;
            et2.setError("Be more creative");
        }

        if(!error){
            Intent i = new Intent(this,GameActivity.class);
            i.putExtra(StoredInfoKeys.Team1Name,t);
            i.putExtra(StoredInfoKeys.Team2Name,t2);
            i.putExtra(StoredInfoKeys.Team1Flag,getId(trackers[0].getCurrenct()));
            i.putExtra(StoredInfoKeys.Team2Flag,getId(trackers[1].getCurrenct()));
            CheckBox b = findViewById(R.id.checkBox);
            i.putExtra(StoredInfoKeys.Team1Computer,b.isChecked());
            b = findViewById(R.id.checkBox2);
            i.putExtra(StoredInfoKeys.Team2Computer,b.isChecked());
            finish();
            startActivity(i);
        }
    }

}
