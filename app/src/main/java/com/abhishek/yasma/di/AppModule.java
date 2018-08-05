package com.abhishek.yasma.di;

import dagger.Module;

@Module(includes = {DatabaseModule.class, NetworkModule.class, ViewModelModule.class})
class AppModule {
}
