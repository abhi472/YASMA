package com.abhishek.yasma.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.abhishek.yasma.R;
import com.abhishek.yasma.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelProvider.Factory factory;

    private MainActivityViewModel viewModel;

    private ActivityMainBinding binding;

    @Inject
    MainPagerAdapter adapter;

    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.viewpager.setAdapter(adapter);
        binding.tvToolbarTitle.setText(getString(R.string.app_name));
        binding.tabs.setupWithViewPager(binding.viewpager);


    }
}
