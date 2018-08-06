package com.abhishek.yasma.ui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.abhishek.yasma.model.Post;

import javax.inject.Inject;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    @Inject
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return PostListFragment.newInstance();
            case 1: return AlbumListFragment.newInstance();
            default: return PostListFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Posts";
            case 1: return "Albums";
            default: return "";
        }
    }
}
