package com.abhishek.yasma.di;


import com.abhishek.yasma.repository.ApiRepository;
import com.abhishek.yasma.repository.ApiRepositoryHelper;

import dagger.Binds;
import dagger.Module;

@Module
public interface RepositoryModule {

    @Binds
    ApiRepository bindApiRepository(ApiRepositoryHelper helper);
}
