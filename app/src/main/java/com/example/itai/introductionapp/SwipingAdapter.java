package com.example.itai.introductionapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Itai on 14/06/2017.
 * Swiping Adapter
 */

class SwipingAdapter extends FragmentStatePagerAdapter {
    static final String NUM_OF_PAGE = "NUMBER";
    SwipingAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NUM_OF_PAGE,position );
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
