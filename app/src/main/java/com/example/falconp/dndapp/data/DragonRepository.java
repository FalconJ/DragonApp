package com.example.falconp.dndapp.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.example.falconp.dndapp.AppExecutors;
import com.example.falconp.dndapp.data.database.CharacterDao;
import com.example.falconp.dndapp.data.database.CharacterEntry;
import com.example.falconp.dndapp.data.database.DndDatabase;

import java.util.List;

/**
 * Handles data operations in DndHelper. Act as a mediator between {@link CharacterDao}
 */

public class DragonRepository {
    private CharacterDao mCharacterDao;
    private LiveData<List<CharacterEntry>> mAllCharacters;

    public DragonRepository(Application application){
        DndDatabase db = DndDatabase.getsInstance(application);
        mCharacterDao = db.characterDao();
        mAllCharacters = mCharacterDao.loadAllCharacters();
    }

    public LiveData<List<CharacterEntry>> getAllCharacters(){
        return mAllCharacters;
    }

    public void insert(CharacterEntry characterEntry){
        new insertAsyncTask(mCharacterDao).execute(characterEntry);
    }

    private static class insertAsyncTask extends AsyncTask<CharacterEntry, Void, Void>{
        private CharacterDao mAsyncTaskDao;

        insertAsyncTask(CharacterDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final CharacterEntry... characterEntries) {
            mAsyncTaskDao.bulkInssert(characterEntries);
            return null;
        }
    }
}
