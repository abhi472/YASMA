package com.abhishek.yasma.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abhishek.yasma.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelProvider.Factory factory;

    MainActivityViewModel viewModel;

    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);


    }
}
