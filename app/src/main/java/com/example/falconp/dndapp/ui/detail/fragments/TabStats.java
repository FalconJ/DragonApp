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

public class TabStats extends Fragment {
    private CharacterEntry character;
    private TextView mStrength;
    private TextView mDexterity;
    private TextView mConstitution;
    private TextView mIntelligence;
    private TextView mWisdom;
    private TextView mCharisma;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.extra_stats, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DetailActivity activity = (DetailActivity) getActivity();

        mStrength = view.findViewById(R.id.char_strength);
        mDexterity = view.findViewById(R.id.char_dexterity);
        mConstitution = view.findViewById(R.id.char_constitution);
        mIntelligence = view.findViewById(R.id.char_intelligence);
        mWisdom = view.findViewById(R.id.char_wisdom);
        mCharisma = view.findViewById(R.id.char_charisma);

        character = activity.getCharacter();
        if(character != null){
            String str, dex, con, intel, wis, cha;
            str = Integer.toString(character.getStr());
            dex = Integer.toString(character.getDex());
            con = Integer.toString(character.getCon());
            intel = Integer.toString(character.getIntel());
            wis = Integer.toString(character.getWis());
            cha = Integer.toString(character.getCha());


            mStrength.setText(str);
            mDexterity.setText(dex);
            mConstitution.setText(con);
            mIntelligence.setText(intel);
            mWisdom.setText(wis);
            mCharisma.setText(cha);
        }
    }
}
