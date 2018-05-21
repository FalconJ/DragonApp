package com.example.falconp.dndapp.ui.detail.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.falconp.dndapp.R;
import com.example.falconp.dndapp.data.database.CharacterEntry;
import com.example.falconp.dndapp.ui.detail.DetailActivity;

import java.text.Format;

public class TabSpells extends Fragment {
    private CharacterEntry character;
    private TextView mSpell1;
    private TextView mSpell2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.extra_char_spells, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DetailActivity activity = (DetailActivity) getActivity();

        mSpell1 = view.findViewById(R.id.char_spell_1);
        mSpell2 = view.findViewById(R.id.char_spell_2);

        character = activity.getCharacter();
        if(character != null){
            mSpell1.setText("Magic Missiles");
            mSpell2.setText("Burning Hands");
        }
    }
}
