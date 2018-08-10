package com.abhishek.yasma.ui.albumList;

import com.abhishek.yasma.ui.postList.PostListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class AlbumListFragmentModule {

    @Provides
    AlbumListAdapter adapterProvider(AlbumListFragment fragment) {
        return new AlbumListAdapter(fragment.getContext());
    }
}
