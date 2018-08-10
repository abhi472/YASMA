package com.abhishek.yasma.di;

import com.abhishek.yasma.ui.albumList.AlbumListFragment;
import com.abhishek.yasma.ui.MainActivity;
import com.abhishek.yasma.ui.MainActivityModule;
import com.abhishek.yasma.ui.postList.PostListFragment;
import com.abhishek.yasma.ui.postList.PostListFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainInjector();

    @ContributesAndroidInjector(modules = PostListFragmentModule.class)
    abstract PostListFragment postListFragmentProvider();

    @ContributesAndroidInjector
    abstract AlbumListFragment albumListFragmentProvider();

}
