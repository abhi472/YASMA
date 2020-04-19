package com.abhishek.yasma.di;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.abhishek.yasma.ui.MainActivityViewModel;
import com.abhishek.yasma.ui.albumList.AlbumListAdapterViewModel;
import com.abhishek.yasma.ui.albumList.AlbumListFragmentViewModel;
import com.abhishek.yasma.ui.postList.PostListAdapterViewModel;
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

    @Binds
    @IntoMap
    @ViewModelKey(PostListAdapterViewModel.class)
    ViewModel bindPostListAdapterViewModel(PostListAdapterViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AlbumListFragmentViewModel.class)
    ViewModel bindAlbumListFragmentViewModel(AlbumListFragmentViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AlbumListAdapterViewModel.class)
    ViewModel bindAlbumListAdapterViewModel(AlbumListAdapterViewModel viewModel);

}
