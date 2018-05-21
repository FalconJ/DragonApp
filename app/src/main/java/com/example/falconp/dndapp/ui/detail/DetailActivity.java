package com.example.falconp.dndapp.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.falconp.dndapp.LogicCreation;
import com.example.falconp.dndapp.R;
import com.example.falconp.dndapp.data.database.CharacterEntry;

public class DetailActivity extends AppCompatActivity {
    public static final String CHARACTER_EXTRA = "CHARACTER";
    private CharacterEntry mCharacter;
    ImageView mIconClass;
    TextView mClass;
    TextView mHitpoints;
    TextView mLevel;
    TextView mExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mIconClass = findViewById(R.id.class_icon);
        mClass = findViewById(R.id.class_desc);
        mHitpoints = findViewById(R.id.char_hp);
        mLevel = findViewById(R.id.char_level);
        mExperience = findViewById(R.id.char_exp);

        LogicCreation logic = new LogicCreation();
        String charJson = getIntent().getExtras().getString(CHARACTER_EXTRA);
        mCharacter = logic.getCharacter(charJson);

        mIconClass.setImageResource(R.drawable.knight);
        mClass.setText(mCharacter.getCharClass());
        mHitpoints.setText(getString(R.string.character_hitpoints_now, 10, 12));


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("General"));
        tabLayout.addTab(tabLayout.newTab().setText("Stats"));
        tabLayout.addTab(tabLayout.newTab().setText("Spells"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final DetailPageAdapter adapter = new DetailPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                }
        );
    }

    @Nullable
    public CharacterEntry getCharacter() {
        return mCharacter;
    }
}
