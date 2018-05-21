package com.example.falconp.dndapp.data.database;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.example.falconp.dndapp.AppExecutors;

/**
 * {@link DndDatabase} database for the application including table for {@link CharacterEntry}
 * with the DAO {@link CharacterDao}
 */

@Database(entities = {CharacterEntry.class}, version = 1)
public abstract class DndDatabase extends RoomDatabase{
    private final static String LOG_TAG = DndDatabase.class.getSimpleName();
    private final static String DATABASE_NAME = "nakama";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static DndDatabase sInstance;

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();


    public static DndDatabase getsInstance(final Context context){
        Log.d(LOG_TAG, "Getting the database");
        if(sInstance == null){
            synchronized (DndDatabase.class){
                if(sInstance == null){
                    sInstance = buildDatabase(context.getApplicationContext());
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
                Log.d(LOG_TAG, "Made new database");
            }
        }
        return sInstance;
    }

    private static DndDatabase buildDatabase(final Context ctx){
        return Room.databaseBuilder(ctx.getApplicationContext(), DndDatabase.class, DndDatabase.DATABASE_NAME).build();
    }

    private void updateDatabaseCreated(final Context ctx){
        if(ctx.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    // The associated DAOs for the database
    public abstract CharacterDao characterDao();

    public LiveData<Boolean> getDatabaseCreated(){
        return mIsDatabaseCreated;
    }
}
