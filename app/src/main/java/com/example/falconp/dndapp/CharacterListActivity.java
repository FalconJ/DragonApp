package com.example.falconp.dndapp;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.falconp.dndapp.data.database.CharacterListAdapter;

public class CharacterListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final CharacterListAdapter adapter = new CharacterListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
