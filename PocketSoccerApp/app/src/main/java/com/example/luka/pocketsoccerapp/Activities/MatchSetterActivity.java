package com.example.luka.pocketsoccerapp.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luka.pocketsoccerapp.R;
import com.example.luka.pocketsoccerapp.StoredInformation.GameEndSetting.GameEnderDeserializer;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredInfoKeys;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredSettingsWriter;

public class MatchSetterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.match_type_setter);
        NumberPicker np = findViewById(R.id.match_number_picker);
        np.setMinValue(1);
        np.setMaxValue(10);
        np.setWrapSelectorWheel(true);
    }

    public void saveMatch(View view){
        NumberPicker np = findViewById(R.id.match_number_picker);
        SharedPreferences sp = this.getSharedPreferences(StoredInfoKeys.SharedPreferences, Context.MODE_PRIVATE);
        int tt = np.getValue();
        RadioButton rg = findViewById(R.id.radioButton);
        if(rg.isChecked()){
            StoredSettingsWriter.writeNewGameEndMode(sp, GameEnderDeserializer.GameEndTimeModeValue);
            StoredSettingsWriter.writeNewGameEndTime(sp,tt*60);
        }else{
            StoredSettingsWriter.writeNewGameEndMode(sp,GameEnderDeserializer.GameEndGoalsModeValue);
            StoredSettingsWriter.writeNewGameEndGoals(sp,tt);
        }
        Toast.makeText(this,"Saved new game ending",Toast.LENGTH_SHORT).show();
    }

}
