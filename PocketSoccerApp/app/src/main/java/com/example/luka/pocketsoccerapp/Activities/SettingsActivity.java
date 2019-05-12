package com.example.luka.pocketsoccerapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.luka.pocketsoccerapp.R;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredInfoKeys;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettings;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettingsWriter;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.settings);
    }

    public void reset(View view){
        StoredSettingsWriter.reset(this.getSharedPreferences(StoredInfoKeys.SharedPreferences, Context.MODE_PRIVATE));
        Toast.makeText(this,"Reset to default successfully",Toast.LENGTH_SHORT).show();
    }

    public void fieldSetterStart(View view){
        startActivity(new Intent(this,FieldSetterActivity.class));
    }

    public void matchSetterStart(View view){
        startActivity(new Intent(this,MatchSetterActivity.class));
    }

    public void speedSetterStart(View view){
        startActivity(new Intent(this,SpeedSetterActivity.class));
    }
}
