package com.abhishek.yasma.ui;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.abhishek.yasma.ui.albumList.AlbumListFragment;
import com.abhishek.yasma.ui.postList.PostListFragment;

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
