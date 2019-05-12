package com.example.luka.pocketsoccerapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.luka.pocketsoccerapp.GameEngine.GameSurface;
import com.example.luka.pocketsoccerapp.GameEngine.Settings.GameSaver;
import com.example.luka.pocketsoccerapp.GameEngine.Settings.GameState;
import com.example.luka.pocketsoccerapp.GameEngine.Settings.SavedGame;
import com.example.luka.pocketsoccerapp.StoredInformation.Database.DataViewModel;
import com.example.luka.pocketsoccerapp.StoredInformation.Database.PlayedGames;
import com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting.GameEnderDeserializer;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredInfoKeys;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettings;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettingsFetcher;

public class GameActivity extends Activity {
    //JEBENI ANDROID!!!!!!!!!!!!!
    private static GameSurface gs;
    private static boolean flagHack = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        if (savedInstanceState == null) {


            SharedPreferences sp = this.getSharedPreferences(StoredInfoKeys.SharedPreferences, Context.MODE_PRIVATE);
            Intent i = getIntent();
            if (i.getBooleanExtra(StoredInfoKeys.SavedGameKey, false)) {
                SavedGame saved = GameSaver.getSavedGame(sp);
                GameSaver.deleteSavedGame(sp);
                gs = new GameSurface(this, saved);
            } else {
                GameSaver.deleteSavedGame(sp);
                StoredSettings settings = StoredSettingsFetcher.fetchFullSettings(sp);
                GameState gameState = new GameState(settings.getChosenField(), settings.getGameSpeed(), settings.getGameEnder(), i.getIntExtra(StoredInfoKeys.Team1Flag, -1), i.getIntExtra(StoredInfoKeys.Team2Flag, -1), i.getStringExtra(StoredInfoKeys.Team1Name), i.getStringExtra(StoredInfoKeys.Team2Name),i.getBooleanExtra(StoredInfoKeys.Team1Computer,false),i.getBooleanExtra(StoredInfoKeys.Team2Computer,false));
                gs = new GameSurface(this, gameState);
            }
        }
        else {
            flagHack = true;
            this.setContentView(gs);
        }
    }

    @Override
    public void onBackPressed() {
        if (gs != null && gs.getTimer()!= null && !gs.gameEnded()) {
            GameSaver.saveGame(gs, this.getSharedPreferences(StoredInfoKeys.SharedPreferences, Context.MODE_PRIVATE));
            gs.getGameThread().end();
            this.finish();
        }
        super.onBackPressed();
    }

    @Override
    public void onPause() {
        if(flagHack && gs != null && gs.getTimer()!= null && !gs.gameEnded()) {
            GameSaver.saveGame(gs, this.getSharedPreferences(StoredInfoKeys.SharedPreferences, Context.MODE_PRIVATE));
            gs.getGameThread().end();
            this.finish();
        }
        super.onPause();
    }

    @Override
    public void finish() {
//        if(gs != null && gs.getTimer()!= null && gs.gameEnded()){
//            Intent i = new Intent(this,EndScreenActivity.class);
//            i.putExtra(StoredInfoKeys.Team1Name,gs.getState().getTeam1Name());
//            i.putExtra(StoredInfoKeys.Team2Name,gs.getState().getTeam2Name());
//            i.putExtra(StoredInfoKeys.Team1Score,gs.getState().getTeam1Score());
//            i.putExtra(StoredInfoKeys.Team2Score,gs.getState().getTeam1Score());
//            i.putExtra(StoredInfoKeys.ElapsedTime,gs.getTimer().getTimeString());
//            startActivity(i);
//        }
        super.finish();
    }
}
