package com.abhishek.yasma;

import android.content.Context;

import com.abhishek.yasma.di.DaggerAppComponent;
import com.abhishek.yasma.di.DatabaseModule;
import com.abhishek.yasma.di.NetworkModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class YASMApp extends DaggerApplication {
    AndroidInjector<? extends DaggerApplication> androidInjector;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        androidInjector = DaggerAppComponent.builder()
                .application(this)
                .network(new NetworkModule())
                .database(new DatabaseModule())
                .build();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return androidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
