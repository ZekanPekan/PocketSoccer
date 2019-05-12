package com.example.luka.pocketsoccerapp.Activities;

import android.arch.lifecycle.Observer;
//import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.luka.pocketsoccerapp.Adapters.EndGameAdapter;
import com.example.luka.pocketsoccerapp.R;
import com.example.luka.pocketsoccerapp.StoredInformation.Database.DataViewModel;
import com.example.luka.pocketsoccerapp.StoredInformation.Database.PlayedGames;
import com.example.luka.pocketsoccerapp.StoredInformation.StoredInfoKeys;

import java.util.List;

public class EndScreenActivity extends AppCompatActivity {
    private DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game_activity);

//        RecyclerView recyclerView = findViewById(R.id.recyclerViewEndGame);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//
//
//        Intent i = getIntent();
//        DataViewModel dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
//        dataViewModel.insert(new PlayedGames(i.getStringExtra(StoredInfoKeys.Team1Name),i.getStringExtra(StoredInfoKeys.Team2Name),i.getIntExtra(StoredInfoKeys.Team1Score,-1),i.getIntExtra(StoredInfoKeys.Team2Score,-1),i.getStringExtra(StoredInfoKeys.ElapsedTime)));
//
//        final EndGameAdapter endGameAdapter = new EndGameAdapter();
//        recyclerView.setAdapter(endGameAdapter);
//
//        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
//
//        String name1 = i.getStringExtra(StoredInfoKeys.Team1Name);
//        String name2 = i.getStringExtra(StoredInfoKeys.Team2Name);
//
//        dataViewModel.fetchPlayedGamesByNameComb(name1, name2).observe(this, new Observer<List<PlayedGames>>() {
//            @Override
//            public void onChanged(@Nullable List<PlayedGames> playedGames) {
//                endGameAdapter.setPlayedGames(playedGames);
//            }
//        });
    }
}
