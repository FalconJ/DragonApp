package com.example.falconp.dndapp.ui.character;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.falconp.dndapp.data.DragonRepository;
import com.example.falconp.dndapp.data.database.CharacterEntry;

import java.util.List;

public class CharacterViewModel extends AndroidViewModel {
    private DragonRepository mRepository;
    private LiveData<List<CharacterEntry>> mAllCharacters;

    public CharacterViewModel(Application application){
        super(application);
        mRepository = new DragonRepository(application);
        mAllCharacters = mRepository.getAllCharacters();
    }

    public LiveData<List<CharacterEntry>> getAllCharacters(){
        return mAllCharacters;
    }

    public void insert(CharacterEntry character){
        mRepository.insert(character);
    }
}
