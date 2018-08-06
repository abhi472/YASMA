package com.abhishek.yasma.di;

import com.abhishek.yasma.ui.MainActivity;
import com.abhishek.yasma.ui.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainInjector();

}
