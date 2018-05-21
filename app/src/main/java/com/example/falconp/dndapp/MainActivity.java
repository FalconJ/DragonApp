package com.example.falconp.dndapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.falconp.dndapp.data.adapters.CharacterListAdapter;
import com.example.falconp.dndapp.data.adapters.CharacterListAdapter2;
import com.example.falconp.dndapp.data.database.CharacterEntry;
import com.example.falconp.dndapp.ui.character.CharacterViewModel;
import com.example.falconp.dndapp.ui.character.NewCharacterActivity;
import com.example.falconp.dndapp.ui.detail.DetailActivity;
import com.google.gson.Gson;

import java.util.List;

import static com.example.falconp.dndapp.ui.character.NewCharacterActivity.EXTRA_REPLY;

public class MainActivity extends AppCompatActivity implements
        CharacterListAdapter2.CharacterAdapterOnItemClickHandler{

    public static final int NEW_CHAR_REQUEST_CODE = 1;

    private CharacterViewModel mCharacterViewModel;
    private CharacterListAdapter2 mCharacterAdapter;
    private RecyclerView mRecyclerView;
    private int mPosition = RecyclerView.NO_POSITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Using findViewById, we get a reference to our RecyclerView from xml. This allows us to
         * do things like set the adapter of the RecyclerView and toggle the visibility.
         */
        mRecyclerView = findViewById(R.id.recyclerview);

        /*
         * A LinearLayoutManager is responsible for measuring and positioning item views within a
         * RecyclerView into a linear list. This means that it can produce either a horizontal or
         * vertical list depending on which parameter you pass in to the LinearLayoutManager
         * constructor. In our case, we want a vertical list, so we pass in the constant from the
         * LinearLayoutManager class for vertical lists, LinearLayoutManager.VERTICAL.
         *
         * There are other LayoutManagers available to display your data in uniform grids,
         * staggered grids, and more! See the developer documentation for more details.
         *
         * The third parameter (shouldReverseLayout) should be true if you want to reverse your
         * layout. Generally, this is only true with horizontal lists that need to support a
         * right-to-left layout.
         */
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        /* setLayoutManager associates the LayoutManager we created above with our RecyclerView */
        mRecyclerView.setLayoutManager(layoutManager);

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        //mRecyclerView.setHasFixedSize(true);

        /*
         * The ForecastAdapter is responsible for linking our weather data with the Views that
         * will end up displaying our weather data.
         *
         * Although passing in "this" twice may seem strange, it is actually a sign of separation
         * of concerns, which is best programming practice. The ForecastAdapter requires an
         * Android Context (which all Activities are) as well as an onClickHandler. Since our
         * MainActivity implements the ForecastAdapter ForecastOnClickHandler interface, "this"
         * is also an instance of that type of handler.
         */
        final CharacterListAdapter2 adapter = new CharacterListAdapter2(this, this);

        /* Setting the adapter attaches it to the RecyclerView in our layout. */
        mRecyclerView.setAdapter(adapter);

        mCharacterViewModel = ViewModelProviders.of(this).get(CharacterViewModel.class);
        mCharacterViewModel.getAllCharacters().observe(this, new Observer<List<CharacterEntry>>() {
            @Override
            public void onChanged(@Nullable List<CharacterEntry> characterEntries) {
                // Update the cached copy of the words in the adapter
                adapter.setCharacters(characterEntries);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewCharacterActivity.class);
                startActivityForResult(intent, NEW_CHAR_REQUEST_CODE);
            }
        });
    }

    /**
     * This method is for responding to clicks from our list.
     *
     * @param characterId id of character
     */
    @Override
    public void onItemClick(CharacterEntry charSelected) {
        Intent characterDetail = new Intent(MainActivity.this, DetailActivity.class);
        LogicCreation logic = new LogicCreation();

        String json = logic.getJson(charSelected);

        characterDetail.putExtra(DetailActivity.CHARACTER_EXTRA, json);
        startActivity(characterDetail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_CHAR_REQUEST_CODE && resultCode == RESULT_OK){
            CharacterEntry newChar = parseJson(data.getStringExtra(EXTRA_REPLY));
            mCharacterViewModel.insert(newChar);
        }
    }

    public CharacterEntry parseJson(String json){
        Gson gson = new Gson();
        CharacterEntry character = gson.fromJson(json, CharacterEntry.class);
        return character;
    }
}
