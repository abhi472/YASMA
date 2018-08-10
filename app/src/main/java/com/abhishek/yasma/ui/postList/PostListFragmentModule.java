package com.abhishek.yasma.ui.postList;

import dagger.Module;
import dagger.Provides;

@Module
public class PostListFragmentModule {

    @Provides
    PostListAdapter adapterProvider(PostListFragment fragment) {
        return new PostListAdapter(fragment.getContext());
    }
}
