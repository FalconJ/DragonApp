package com.example.falconp.dndapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.falconp.dndapp.Classes.LogicCreation;
import com.example.falconp.dndapp.Entidades.Character;
import com.example.falconp.dndapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewCharacterFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewCharacterFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewCharacterFragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    LogicCreation logic = new LogicCreation();
    Character newCharacter = new Character();
    Character characterPrueba = new Character();
    Button create,butstr,butdec,butcon,butint,butwis,butcha;
    EditText textChar,str,dex,con,inte,wis,cha;
    Spinner spinRace, spinClass, spinAlignment, spinBackground,spinSkills1,spinSkills2, spinSpell1,spinSpell2;
    String json = "";

    private OnFragmentInteractionListener mListener;

    public NewCharacterFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewCharacterFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static NewCharacterFragment2 newInstance(String param1, String param2) {
        NewCharacterFragment2 fragment = new NewCharacterFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_new_character_fragment2, container, false);

        spinRace= v.findViewById(R.id.spinRace);
        spinClass= v.findViewById(R.id.spinClass);
        spinAlignment= v.findViewById(R.id.spinAlignment);
        spinBackground= v.findViewById(R.id.spinBackgound);
        spinSkills1=v.findViewById(R.id.spinSkill1);
        spinSkills2=v.findViewById(R.id.spinSkill2);
        spinSpell1=v.findViewById(R.id.spinSpell1);
        spinSpell2=v.findViewById(R.id.spinSpell2);
        create = v.findViewById(R.id.butCreate);
        butstr = v.findViewById(R.id.butStr);
        butdec = v.findViewById(R.id.butDex);
        butcon = v.findViewById(R.id.butCon);
        butint = v.findViewById(R.id.butInt);
        butwis = v.findViewById(R.id.butWis);
        butcha = v.findViewById(R.id.butCha);
        textChar= v.findViewById(R.id.textChaName);
        str=v.findViewById(R.id.numStr);
        dex=v.findViewById(R.id.numDex);
        con=v.findViewById(R.id.numCon);
        inte=v.findViewById(R.id.numInt);
        wis=v.findViewById(R.id.numWis);
        cha=v.findViewById(R.id.numCha);

        ArrayAdapter<CharSequence> adapterR= ArrayAdapter.createFromResource((Activity) getContext(),R.array.races, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterC= ArrayAdapter.createFromResource((Activity) getContext(),R.array.classes, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterA= ArrayAdapter.createFromResource((Activity) getContext(),R.array.alignments, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterB= ArrayAdapter.createFromResource((Activity) getContext(),R.array.backgrounds, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterS1= ArrayAdapter.createFromResource((Activity) getContext(),R.array.skills, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterS2= ArrayAdapter.createFromResource((Activity) getContext(),R.array.skills, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterS3= ArrayAdapter.createFromResource((Activity) getContext(),R.array.spells, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterS4= ArrayAdapter.createFromResource((Activity) getContext(),R.array.spells, android.R.layout.simple_spinner_item);

        spinRace.setAdapter(adapterR);
        spinClass.setAdapter(adapterC);
        spinAlignment.setAdapter(adapterA);
        spinBackground.setAdapter(adapterB);
        spinSkills1.setAdapter(adapterS1);
        spinSkills2.setAdapter(adapterS2);
        spinSpell1.setAdapter(adapterS3);
        spinSpell2.setAdapter(adapterS4);


        butstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.setText(logic.randomNumber(3,18).toString());
            }
        });

        butdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dex.setText(logic.randomNumber(3,18).toString());
            }
        });
        butcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                con.setText(logic.randomNumber(3,18).toString());
            }
        });
        butint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inte.setText(logic.randomNumber(3,18).toString());
            }
        });
        butwis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wis.setText(logic.randomNumber(3,18).toString());
            }
        });
        butcha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cha.setText(logic.randomNumber(3,18).toString());
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newCharacter.setSkill1(spinSkills1.getSelectedItem().toString());
                newCharacter.setSkill2(spinSkills2.getSelectedItem().toString());
                newCharacter.setPlayerId(1);
                newCharacter.setLevel(1);
                newCharacter.setExperience(0);
                newCharacter.setProficiency(2);
                newCharacter.setCharacterName(textChar.getText().toString());
                newCharacter.setRace(spinRace.getSelectedItem().toString());
                newCharacter.setCharacterClass(spinClass.getSelectedItem().toString());
                newCharacter.setBackround(spinBackground.getSelectedItem().toString());
                newCharacter.setAlignment(spinAlignment.getSelectedItem().toString());
                newCharacter.setStrength(Integer.parseInt(str.getText().toString()));
                newCharacter.setDexterity(Integer.parseInt(dex.getText().toString()));
                newCharacter.setConstitution(Integer.parseInt(con.getText().toString()));
                newCharacter.setInteligence(Integer.parseInt(inte.getText().toString()));
                newCharacter.setWisdom(Integer.parseInt(wis.getText().toString()));
                newCharacter.setCharisma(Integer.parseInt(cha.getText().toString()));
                newCharacter = logic.RaceModif(newCharacter);
                newCharacter = logic.CalcularMods(newCharacter);
                newCharacter = logic.CalcularExtras(newCharacter);
                newCharacter = logic.SkillIncrees(newCharacter);
                newCharacter.setSpells(logic.spells(spinSpell1.getSelectedItem().toString(),spinSpell2.getSelectedItem().toString()));
                json = logic.getJson(newCharacter);
                characterPrueba = logic.getCharacter(json);
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
