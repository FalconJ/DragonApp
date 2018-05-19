package com.example.falconp.dndapp.data.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class CharacterRepository {

    private CharacterDao mCharacterDao;
    private LiveData<List<CharacterEntry>> mAllCharacters;

    CharacterRepository(Application application) {
        DndDatabase db = DndDatabase.getsInstance(application);
        mCharacterDao = db.characterDao();
        mAllCharacters = mCharacterDao.getAllCharacters();
    }

    LiveData<List<CharacterEntry>> getAllCharacters() {
        return mAllCharacters;
    }

    public void insert (CharacterEntry character) {
        new insertAsyncTask(mCharacterDao).execute(character);
    }

    private static class insertAsyncTask extends AsyncTask<CharacterEntry, Void, Void> {

        private CharacterDao mAsyncTaskDao;

        insertAsyncTask(CharacterDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final CharacterEntry... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
