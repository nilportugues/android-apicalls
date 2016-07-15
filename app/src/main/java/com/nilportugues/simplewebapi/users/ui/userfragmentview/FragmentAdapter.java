package com.nilportugues.simplewebapi.users.ui.userfragmentview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nilportugues.simplewebapi.users.ui.userpager.FragmentOne;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentThree;
import com.nilportugues.simplewebapi.users.ui.userpager.FragmentTwo;


public class FragmentAdapter extends FragmentStatePagerAdapter
{
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: return new FragmentOne();
            case 1: return new FragmentTwo();
            case 2: return new FragmentThree();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}