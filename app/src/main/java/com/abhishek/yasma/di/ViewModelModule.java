package com.abhishek.yasma.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.abhishek.yasma.ui.MainActivityViewModel;
import com.abhishek.yasma.ui.postList.PostListFragmentViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
interface ViewModelModule {

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    ViewModel bindMainViewModel(MainActivityViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostListFragmentViewModel.class)
    ViewModel bindPostListFragmentViewModel(PostListFragmentViewModel viewModel);

}
