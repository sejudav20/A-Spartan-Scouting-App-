package com.example.davin.scoutingapp2019;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Team.class}, version = 1)
public abstract class TeamsDatabase extends RoomDatabase {


    public abstract TeamDAO teamDAO();

    private static volatile TeamsDatabase INSTANCE;


    static TeamsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TeamsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TeamsDatabase.class, "Team_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
