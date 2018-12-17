package com.cuncisboss.matchschedule.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cuncisboss.matchschedule.R;
import com.cuncisboss.matchschedule.Utils;
import com.cuncisboss.matchschedule.detail.DetailActivity;

import java.util.ArrayList;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private static final String TAG = "MatchAdapter";

    private ArrayList<Event> events;
    private Context context;

    public MatchAdapter(ArrayList<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_match, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Event event = events.get(position);
        holder.tvDate.setText(Utils.getDateEvent(event.getDateEvent()));
        holder.tvHomeTeam.setText(event.getHomeTeam());
        holder.tvAwayTeam.setText(event.getAwayTeam());

        if (event.getHomeScore().equals("null") && event.getAwayScore().equals("null")) {
            holder.tvHomeScore.setText("");
            holder.tvAwayScore.setText("");
        } else {
            holder.tvHomeScore.setText(event.getHomeScore());
            holder.tvAwayScore.setText(event.getAwayScore());
        }

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvHomeTeam, tvAwayTeam, tvHomeScore, tvAwayScore;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvHomeTeam = itemView.findViewById(R.id.tv_homeTeam);
            tvAwayTeam = itemView.findViewById(R.id.tv_awayTeam);
            tvHomeScore = itemView.findViewById(R.id.tv_homeScore);
            tvAwayScore = itemView.findViewById(R.id.tv_awayScore);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Berhasil menampilkan detail..", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(), DetailActivity.class);
                    i.putExtra("EVENT_ID", events.get(getAdapterPosition()).getIdEvent());
                    i.putExtra("HOME_TEAM_ID", events.get(getAdapterPosition()).getIdHomeTeam());
                    i.putExtra("AWAY_TEAM_ID", events.get(getAdapterPosition()).getIdAwayTeam());
                    (itemView.getContext()).startActivity(i);
                }
            });
        }
    }

}
