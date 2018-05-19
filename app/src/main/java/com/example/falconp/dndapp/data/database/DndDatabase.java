package com.example.falconp.dndapp.data.database;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

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

    public static DndDatabase getsInstance(Context context){
        Log.d(LOG_TAG, "Getting the database");
        if(sInstance == null){
            synchronized (LOCK){
                sInstance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        DndDatabase.class,
                        DndDatabase.DATABASE_NAME)
                        .addCallback(sRoomDatabaseCallback).build();
                Log.d(LOG_TAG, "Made new database");
            }
        }
        return sInstance;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(sInstance).execute();
                }
            };

    // The associated DAOs for the database
    public abstract CharacterDao characterDao();


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final CharacterDao mDao;

        PopulateDbAsync(DndDatabase p0) {
            mDao = p0.characterDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {



            return null;
        }
    }
}
