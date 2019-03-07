package com.example.davin.scoutingapp2019;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class DataDisplay extends AppCompatActivity {


    public static TeamViewModel teamViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        Intent intent=getIntent();


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final TeamListAdapter adapter = new TeamListAdapter(this);
        recyclerView.setAdapter(adapter);

        Log.d("View","entered DataDisplay");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        teamViewModel = ViewModelProviders.of(this,new TeamViewModelFactory(this.getApplication())).get(TeamViewModel.class);

        Log.d("View","Intent to Datadisplay gives "+intent.getIntExtra("type",0));
        teamViewModel.getAllTeams().observe(this, new Observer<List<Team>>() {
            @Override
            public void onChanged(@Nullable final List<Team> teams) {
                // Update the cached copy of the words in the adapter.

               Log.d("View","adapter changed");
                adapter.setTeams(teams);

            }
        });

        if(intent.getIntExtra("type",0)==7){
            Log.d("View","Got in should change ");
            Destring destring = new Destring(intent.getStringExtra("Ree"));
          Team  newTeam = new Team(destring.getTeamNumber(), destring.getPosition(), destring.isCrossedHabline(), destring.getSandstorm("cargo balls"), destring.getSandstorm("cargo hatches"), destring.getSandstorm("rocket balls"), destring.getSandstorm("rocket hatches"), destring.getTeleop("cargo balls"), destring.getTeleop("cargo hatches"), destring.getTeleop("rocket balls"), destring.getTeleop("rocket hatches"), destring.getRocketRole(), destring.getClimberRole(), destring.getOverallRole(), destring.getOtherComments());


            teamViewModel.insert(newTeam);
        }

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("View","reached data display "+requestCode+" result:"+resultCode);
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Destring destring=new Destring(data.getStringExtra("str"));
            Team newTeam= new Team(destring.getTeamNumber(),destring.getPosition(),destring.isCrossedHabline(),destring.getSandstorm("cargo balls"),destring.getSandstorm("cargo hatches"),destring.getSandstorm("rocket balls"),destring.getSandstorm("rocket hatches"),destring.getTeleop("cargo balls"),destring.getTeleop("cargo hatches"),destring.getTeleop("rocket balls"),destring.getTeleop("rocket hatches"),destring.getRocketRole(),destring.getClimberRole(),destring.getOverallRole(),destring.getOtherComments());

            Log.d("View","inserted new team: "+newTeam.getTeamNumber());
            teamViewModel.insert(newTeam);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }






}
