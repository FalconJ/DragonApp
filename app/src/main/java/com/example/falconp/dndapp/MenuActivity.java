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

import com.example.falconp.dndapp.Fragment.FindCamFragment;
import com.example.falconp.dndapp.Fragment.MyCampaingFragment;
import com.example.falconp.dndapp.Fragment.MyCharacterFragment;
import com.example.falconp.dndapp.Fragment.NewCampaingFragment;
import com.example.falconp.dndapp.Fragment.NewCharacterFragment2;
import com.example.falconp.dndapp.MainActivity;
import com.example.falconp.dndapp.R;


public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,NewCampaingFragment.OnFragmentInteractionListener, FindCamFragment.OnFragmentInteractionListener, MyCharacterFragment.OnFragmentInteractionListener, MyCampaingFragment.OnFragmentInteractionListener, NewCharacterFragment2.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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


        Fragment fragment= new MyCharacterFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_menu, fragment).commit();

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
        getMenuInflater().inflate(R.menu.menu, menu);
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

        if (id == R.id.nav_charac) {
            miFragment=new MyCharacterFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_camp) {
            miFragment=new MyCampaingFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_ficamp) {
            miFragment=new FindCamFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_newchara) {
            Intent intent = new Intent(MenuActivity.this, NewCharacterActivity.class);
            MenuActivity.this.startActivity(intent);

        } else if (id == R.id.nav_newcamp) {
            miFragment=new NewCampaingFragment();
            fragmentSeleccionado=true;

        } else if (id== R.id.nav_exit){

            Intent login = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(login);
        }


        if(fragmentSeleccionado){

            getSupportFragmentManager().beginTransaction().replace(R.id.content_menu,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}