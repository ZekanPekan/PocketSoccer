package com.example.luka.pocketsoccerapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.luka.pocketsoccerapp.R;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredInfoKeys;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettingsWriter;

public class SpeedSetterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.speed_setter);
    }

    public void setSpeed(View v){
        StoredSettingsWriter.writeNewGameSpeedModifier(this.getSharedPreferences(StoredInfoKeys.SharedPreferences, Context.MODE_PRIVATE),Integer.parseInt(v.getTag().toString()));
        Toast.makeText(this,"Changed successfully",Toast.LENGTH_SHORT).show();
    }
}
