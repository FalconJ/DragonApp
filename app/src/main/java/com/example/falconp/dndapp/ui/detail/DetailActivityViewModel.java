package com.example.falconp.dndapp.ui.detail;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.falconp.dndapp.data.database.CharacterEntry;

/**
 * {@link ViewModel} for {@link DetailActivity}
 */
public class DetailActivityViewModel extends ViewModel{

    // Character the user is looking at
    private MutableLiveData<CharacterEntry> mCharacter;

    public DetailActivityViewModel(){
        mCharacter = new MutableLiveData<>();
    }

    public MutableLiveData<CharacterEntry> getCharacter() {
        return mCharacter;
    }

    public void setCharacter(CharacterEntry characterEntry){
        mCharacter.postValue(characterEntry);
    }
}
