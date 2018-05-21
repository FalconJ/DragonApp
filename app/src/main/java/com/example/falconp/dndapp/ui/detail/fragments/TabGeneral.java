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

public class TabGeneral extends Fragment {
    private CharacterEntry character;
    private TextView mRace;
    private TextView mClass;
    private TextView mAlignment;
    private TextView mBackground;
    private TextView mProficiency;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.extra_char_general, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DetailActivity activity = (DetailActivity) getActivity();

        mRace = view.findViewById(R.id.char_race);
        mAlignment = view.findViewById(R.id.char_alignment);
        mBackground = view.findViewById(R.id.char_background);
        mProficiency = view.findViewById(R.id.char_proficiency);

        character = activity.getCharacter();
        if(character != null){
            mRace.setText(character.getRace());
            mAlignment.setText(character.getAlignment());
            mBackground.setText(character.getBackground());
            mProficiency.setText(character.getSkill_1() );
        }
    }
}
