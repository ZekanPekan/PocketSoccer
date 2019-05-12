package com.example.luka.pocketsoccerapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.luka.pocketsoccerapp.GameEngine.Settings.GameSaver;
import com.example.luka.pocketsoccerapp.R;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredInfoKeys;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettingsWriter;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.main_menu);
        Button b = findViewById(R.id.resume);
        SharedPreferences sp = this.getSharedPreferences(StoredInfoKeys.SharedPreferences, Context.MODE_PRIVATE);
        StoredSettingsWriter.initSharedPreferences(sp);
        b.setEnabled(GameSaver.savedGameExists(sp));
    }

    public void startNewGame(View view){
        startActivity(new Intent(this,NewGameActivity.class));
    }

    public void resumeGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(StoredInfoKeys.SavedGameKey,true);
        startActivity(intent);
    }

    public void stats(View view){

    }

    public void settings(View view){
        startActivity(new Intent(this,SettingsActivity.class));
    }
}
