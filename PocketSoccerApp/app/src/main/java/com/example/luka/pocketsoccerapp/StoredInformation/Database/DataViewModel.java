package com.example.luka.pocketsoccerapp.StoredInformation.Database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class DataViewModel extends AndroidViewModel {
    private DataRepository dataRepository;

    public DataViewModel(@NonNull Application application) {
        super(application);
        dataRepository = new DataRepository(application);
    }

    public LiveData<List<PlayedGames>> fetchPlayedGamesByNameComb(String name1, String name2) {
        return dataRepository.fetchPlayedGamesByNameComb(name1, name2);
    }

    public void insert(PlayedGames playedGames) {
        dataRepository.insert(playedGames);
    }

    public void deleteAll() {
        dataRepository.deleteAll();
    }

    public void deletePlayedGamesByNameComb(String name1,String name2){
        dataRepository.deletePlayedGamesByNameComb(name1, name2);
    }
}
