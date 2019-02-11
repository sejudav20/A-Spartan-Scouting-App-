package com.example.davin.scoutingapp2019;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class TeamRepository {

private TeamDAO teamDAO;
private LiveData<List<Team>> allData;
    TeamRepository(Application application) {
        TeamsDatabase db = TeamsDatabase.getDatabase(application);
        teamDAO = db.teamDAO();
        allData = teamDAO.getAllData();
    }

    LiveData<List<Team>> getAllWords() {
        return allData;
    }

    public void insert (Team team) {
        new insertAsyncTask(teamDAO).execute(team);
    }



    private static class insertAsyncTask extends AsyncTask<Team, Void, Void> {

        private TeamDAO mAsyncTaskDao;

        insertAsyncTask(TeamDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Team... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
