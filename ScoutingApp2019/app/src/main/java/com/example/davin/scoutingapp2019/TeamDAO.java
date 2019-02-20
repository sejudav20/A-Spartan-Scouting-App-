package com.example.davin.scoutingapp2019;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TeamDAO {


    @Insert
    void insert(Team t);


    @Query("Select * From TeamInfo ")
    LiveData<List<Team>> getAllData();

    @Query("Select * From TeamInfo Where team=:o")
    LiveData<List<Team>> getAllTeamData(int o);


    @Query("Select * From TeamInfo Order By `Total balls in Cargo Ship`")
    LiveData<List<Team>> mostCargoBalls();

    @Query("Select * From TeamInfo Order By `Total hatches in Cargo Ship`")
    LiveData<List<Team>> mostCargoHatches();

    @Query("Select * From TeamInfo Order By `Total balls in Rocket Ship`")
    LiveData<List<Team>> mostRocketBalls();


    @Query("Select * From TeamInfo Order By `Total hatches in Rocket Ship`")
    LiveData<List<Team>> mostRocketHatches();



}
