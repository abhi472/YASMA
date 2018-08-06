package com.abhishek.yasma.ui;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public class MainActivityModule {

    @Provides
    MainPagerAdapter mainPagerAdapterProvider(MainActivity activity) {
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }
}
