package com.abhishek.yasma.di;

import com.abhishek.yasma.ui.AlbumListFragment;
import com.abhishek.yasma.ui.MainActivity;
import com.abhishek.yasma.ui.MainActivityModule;
import com.abhishek.yasma.ui.PostListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainInjector();

    @ContributesAndroidInjector
    abstract PostListFragment postListFragmentProvider();

    @ContributesAndroidInjector
    abstract AlbumListFragment albumListFragmentProvider();

}
