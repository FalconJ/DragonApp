package com.example.falconp.dndapp;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.falconp.dndapp.data.database.CharacterDao;
import com.example.falconp.dndapp.data.database.CharacterEntry;
import com.example.falconp.dndapp.data.database.DndDatabase;

import java.util.List;

public class NewCharacterActivity extends AppCompatActivity {


    CharacterEntry newCharacter = new CharacterEntry();
    CharacterEntry characterPrueba = new CharacterEntry();
    Spinner spinRace, spinClass, spinAlignment, spinBackground,spinSkills1,spinSkills2, spinSpell1,spinSpell2;
    Button create,butstr,butdec,butcon,butint,butwis,butcha;
    EditText textChar,str,dex,con,inte,wis,cha;
    String json = "";
    LogicCreation logic = new LogicCreation();
    //DndDatabase dndDatabase = DndDatabase.getsInstance(getApplicationContext());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_character);

        spinRace= findViewById(R.id.spinRace);
        spinClass= findViewById(R.id.spinClass);
        spinAlignment= findViewById(R.id.spinAlignment);
        spinBackground= findViewById(R.id.spinBackgound);
        spinSkills1=findViewById(R.id.spinSkill1);
        spinSkills2=findViewById(R.id.spinSkill2);
        spinSpell1=findViewById(R.id.spinSpell1);
        spinSpell2=findViewById(R.id.spinSpell2);
        create = findViewById(R.id.butCreate);
        butstr = findViewById(R.id.butStr);
        butdec = findViewById(R.id.butDex);
        butcon = findViewById(R.id.butCon);
        butint = findViewById(R.id.butInt);
        butwis = findViewById(R.id.butWis);
        butcha = findViewById(R.id.butCha);
        textChar=findViewById(R.id.textChaName);
        str=findViewById(R.id.numStr);
        dex=findViewById(R.id.numDex);
        con=findViewById(R.id.numCon);
        inte=findViewById(R.id.numInt);
        wis=findViewById(R.id.numWis);
        cha=findViewById(R.id.numCha);

        ArrayAdapter<CharSequence> adapterR= ArrayAdapter.createFromResource(getApplicationContext(),R.array.races, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterC= ArrayAdapter.createFromResource(getBaseContext(),R.array.classes, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterA= ArrayAdapter.createFromResource(getBaseContext(),R.array.alignments, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterB= ArrayAdapter.createFromResource(getBaseContext(),R.array.backgrounds, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterS1= ArrayAdapter.createFromResource(getBaseContext(),R.array.skills, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterS2= ArrayAdapter.createFromResource(getBaseContext(),R.array.skills, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterS3= ArrayAdapter.createFromResource(getBaseContext(),R.array.spells, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterS4= ArrayAdapter.createFromResource(getBaseContext(),R.array.spells, android.R.layout.simple_spinner_item);

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
                newCharacter.setSkill_1(spinSkills1.getSelectedItem().toString());
                newCharacter.setSkill_2(spinSkills2.getSelectedItem().toString());
                newCharacter.setPlayerId(1);
                newCharacter.setLevel(1);
                newCharacter.setExp(0);
                newCharacter.setProficiency(2);
                newCharacter.setCharName(textChar.getText().toString());
                newCharacter.setRace(spinRace.getSelectedItem().toString());
                newCharacter.setCharClass(spinClass.getSelectedItem().toString());
                newCharacter.setBackground(spinBackground.getSelectedItem().toString());
                newCharacter.setAlignment(spinAlignment.getSelectedItem().toString());
                newCharacter.setStr(Integer.parseInt(str.getText().toString()));
                newCharacter.setDex(Integer.parseInt(dex.getText().toString()));
                newCharacter.setCon(Integer.parseInt(con.getText().toString()));
                newCharacter.setIntel(Integer.parseInt(inte.getText().toString()));
                newCharacter.setWis(Integer.parseInt(wis.getText().toString()));
                newCharacter.setCha(Integer.parseInt(cha.getText().toString()));
                newCharacter = logic.RaceModif(newCharacter);
                newCharacter = logic.CalcularMods(newCharacter);
                newCharacter = logic.CalcularExtras(newCharacter);

                json = logic.getJson(newCharacter);
                characterPrueba = logic.getCharacter(json);

                //dndDatabase.characterDao().insert(newCharacter);

                Intent intent = new Intent(NewCharacterActivity.this, CharacterListActivity.class);

                NewCharacterActivity.this.startActivity(intent);
            }
        });



    }
}
