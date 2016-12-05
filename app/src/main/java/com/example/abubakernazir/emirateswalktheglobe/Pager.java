package com.example.abubakernazir.emirateswalktheglobe;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Shami on 11/8/2016.
 */

public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }



    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                MeFragment mytab1 = new MeFragment();
                return mytab1;
            case 1:
                FriendsFragment mytab2 = new FriendsFragment();
                return mytab2;
            case 2:
                VirtualTourFragment mytab3 = new VirtualTourFragment();
                return mytab3;
            case 3:
                PlansFragment mytab4 = new PlansFragment();
                return mytab4;
            case 4:
                BeginWalkingFragment mytab5 = new BeginWalkingFragment();
                return mytab5;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}