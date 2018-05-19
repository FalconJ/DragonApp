package com.example.falconp.dndapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.falconp.dndapp.Fragment.AttacksSpellsFragment;
import com.example.falconp.dndapp.Fragment.BasicFragment;
import com.example.falconp.dndapp.Fragment.EquipmentFragment;
import com.example.falconp.dndapp.Fragment.FeaturesFragment;
import com.example.falconp.dndapp.Fragment.PersonalityFragment;
import com.example.falconp.dndapp.Fragment.ProficienciesFragment;
import com.example.falconp.dndapp.MenuActivity;
import com.example.falconp.dndapp.R;

public class CharacterActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BasicFragment.OnFragmentInteractionListener, AttacksSpellsFragment.OnFragmentInteractionListener, EquipmentFragment.OnFragmentInteractionListener, ProficienciesFragment.OnFragmentInteractionListener, PersonalityFragment.OnFragmentInteractionListener, FeaturesFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment= new BasicFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_character, fragment).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.character, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment = null;
        boolean fragmentSeleccionado=false;

        if (id == R.id.nav_basic) {
            miFragment=new BasicFragment();
            fragmentSeleccionado=true;
        }  else if (id == R.id.nav_ataspell) {
            miFragment=new AttacksSpellsFragment();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_equipment) {
            miFragment=new EquipmentFragment();
            fragmentSeleccionado=true;

        }  else if (id == R.id.nav_proficiencies) {
            miFragment=new ProficienciesFragment();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_personality) {
            miFragment=new PersonalityFragment();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_features) {

            miFragment=new FeaturesFragment();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_mycharacters) {
            Intent mychara = new Intent(getApplicationContext(),MenuActivity.class);
            startActivity(mychara);

        } else if (id== R.id.nav_exit){

        }

        if(fragmentSeleccionado){

            getSupportFragmentManager().beginTransaction().replace(R.id.content_character,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
