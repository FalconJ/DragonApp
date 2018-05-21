package com.example.falconp.dndapp.ui.detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.falconp.dndapp.ui.detail.fragments.TabGeneral;
import com.example.falconp.dndapp.ui.detail.fragments.TabSpells;
import com.example.falconp.dndapp.ui.detail.fragments.TabStats;

public class DetailPageAdapter extends FragmentStatePagerAdapter {

    private String title[] = {"General", "Stats", "Spells"};
    private int numTabs = 3;

    public DetailPageAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                TabGeneral tabGeneral = new TabGeneral();
                return tabGeneral;
            case 1:
                TabStats tabStats= new TabStats();
                return tabStats;
            case 2:
                TabSpells tabSpells= new TabSpells();
                return tabSpells;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
