package com.abhishek.yasma.di;

import com.abhishek.yasma.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainInjector();

}
