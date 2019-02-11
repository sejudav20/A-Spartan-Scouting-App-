package com.example.davin.scoutingapp2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamViewHolder> {



    class TeamViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private TeamViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }




    private final LayoutInflater mInflater;
    private List<Team> mTeams; // Cached copy of words

    TeamListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TeamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        if (mTeams != null) {
            Team current = mTeams.get(position);
            holder.wordItemView.setText(current.getTeamNumber());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }



    void setTeams(List<Team> teams){
        mTeams = teams;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTeams != null)
            return mTeams.size();
        else return 0;
    }






}
