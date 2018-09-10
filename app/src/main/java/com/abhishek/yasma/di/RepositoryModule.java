package com.abhishek.yasma.di;


import com.abhishek.yasma.repository.ApiRepository;
import com.abhishek.yasma.repository.ApiRepositoryHelper;
import com.abhishek.yasma.repository.DatabaseRepository;
import com.abhishek.yasma.repository.DatabaseRepositoryHelper;

import dagger.Binds;
import dagger.Module;

@Module
public interface RepositoryModule {

    @Binds
    ApiRepository bindApiRepository(ApiRepositoryHelper helper);

    @Binds
    DatabaseRepository bindDatabaseRepository(DatabaseRepositoryHelper helper);
}
