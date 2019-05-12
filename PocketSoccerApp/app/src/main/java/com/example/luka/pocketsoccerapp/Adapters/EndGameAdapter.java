package com.example.luka.pocketsoccerapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luka.pocketsoccerapp.R;
import com.example.luka.pocketsoccerapp.StoredInformation.Database.PlayedGames;

import java.util.ArrayList;
import java.util.List;

public class EndGameAdapter extends RecyclerView.Adapter<EndGameAdapter.PlayedGameHolder> {
    private List<PlayedGames> playedGames = new ArrayList<>();

    @NonNull
    @Override
    public PlayedGameHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.played_game, viewGroup, false);
        return new PlayedGameHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayedGameHolder playedGameHolder, int i) {
        PlayedGames playedGame = playedGames.get(i);
        playedGameHolder.time.setText(playedGame.getTime());
        playedGameHolder.name1.setText(playedGame.getPlayer1Name());
        playedGameHolder.name2.setText(playedGame.getPlayer2Name());
        playedGameHolder.score1.setText(playedGame.getT1Score());
        playedGameHolder.score2.setText(playedGame.getT2Score());
    }

    @Override
    public int getItemCount() {
        return playedGames.size();
    }

    public void setPlayedGames(List<PlayedGames> playedGames) {
        this.playedGames = playedGames;
        notifyDataSetChanged();
    }

    class PlayedGameHolder extends RecyclerView.ViewHolder {
        private TextView time;
        private TextView name1;
        private TextView name2;
        private TextView score1;
        private TextView score2;

        public PlayedGameHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.textViewTime);
            name1 = itemView.findViewById(R.id.name1ViewTime);
            name2 = itemView.findViewById(R.id.name2ViewTime);
            score1 = itemView.findViewById(R.id.score1ViewTime);
            score2 = itemView.findViewById(R.id.score2ViewTime);
        }
    }
}
