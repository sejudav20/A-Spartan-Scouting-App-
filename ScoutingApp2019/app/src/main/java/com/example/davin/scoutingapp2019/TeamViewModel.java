package com.example.davin.scoutingapp2019;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class TeamViewModel extends AndroidViewModel {
    private TeamRepository mRepository;
    private LiveData<List<Team>> mAllData;

    public TeamViewModel(Application application) {
        super(application);
        mRepository = new TeamRepository(application);
        mAllData = mRepository.getAllWords();
    }


    public LiveData<List<Team>> getAllTeams() {
        return mAllData;
    }

    public void insert(Team team) {
        mRepository.insert(team);
    }


}
