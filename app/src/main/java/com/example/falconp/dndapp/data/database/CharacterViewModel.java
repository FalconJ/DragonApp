package com.example.falconp.dndapp.data.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class CharacterViewModel extends AndroidViewModel {

    private CharacterRepository mRepository;
    private LiveData<List<CharacterEntry>> mAllCharacters;

    public CharacterViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CharacterRepository(application);
        mAllCharacters = mRepository.getAllCharacters();
    }

    LiveData<List<CharacterEntry>> getAllCharacters(){return mAllCharacters;}

    public void insert(CharacterEntry character){mRepository.insert(character);}


}
