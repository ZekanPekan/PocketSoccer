package com.example.luka.pocketsoccerapp.StoredInformation.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import java.util.List;

public class DataRepository {
    private DaoAccess daoAccess;

    public DataRepository(Application application) {
        Database database = Database.getInstance(application);
        daoAccess = database.daoAccess();
    }

    public LiveData<List<PlayedGames>> fetchPlayedGamesByNameComb(String name1, String name2) {
        return daoAccess.fetchPlayedGamesByNameComb(name1, name2);
    }

    public void insert(PlayedGames playedGames) {
        new InsertAsyncTask(daoAccess).execute(playedGames);
    }

    public void deleteAll() {
        new DeleteAllAsyncTask(daoAccess).execute();
    }

    public void deletePlayedGamesByNameComb(String name1,String name2){
        new DeletePlayedGamesByNameComb(daoAccess).execute(name1, name2);
    }

    private static class InsertAsyncTask extends AsyncTask<PlayedGames, Void, Void> {
        private DaoAccess daoAccess;

        private InsertAsyncTask(DaoAccess daoAccess) {
            this.daoAccess = daoAccess;
        }

        @Override
        protected Void doInBackground(PlayedGames... playedGames) {
            daoAccess.insertOnlySinglePlayedGame(playedGames[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoAccess daoAccess;

        private DeleteAllAsyncTask(DaoAccess daoAccess) {
            this.daoAccess = daoAccess;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            daoAccess.deleteAll();
            return null;
        }
    }

    private static class DeletePlayedGamesByNameComb extends AsyncTask<String, Void, Void> {
        private DaoAccess daoAccess;

        private DeletePlayedGamesByNameComb(DaoAccess daoAccess) {
            this.daoAccess = daoAccess;
        }

        @Override
        protected Void doInBackground(String... strings) {
            daoAccess.deletePlayedGamesByNameComb(strings[0], strings[1]);
            return null;
        }
    }
}
