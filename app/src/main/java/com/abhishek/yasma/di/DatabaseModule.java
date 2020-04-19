package com.abhishek.yasma.di;


import androidx.room.Room;

import com.abhishek.yasma.YASMApp;
import com.abhishek.yasma.data.AlbumDao;
import com.abhishek.yasma.data.PostDao;
import com.abhishek.yasma.data.YasmaDB;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public YasmaDB provideTrackerDatabase(YASMApp app) {
        return Room.databaseBuilder(app, YasmaDB.class, "yasma.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    AlbumDao provideAlbumDao(YasmaDB db) {
        return db.albumDao();
    }

    @Provides
    @Singleton
    PostDao providePostDao(YasmaDB db) {
        return db.postDao();
    }
}
