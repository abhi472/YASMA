package com.abhishek.yasma.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.abhishek.yasma.BuildConfig;

@Database(entities = {AlbumEntity.class, PostEntity.class},
        version = BuildConfig.DB_SCHEMA_VERSION,
        exportSchema = false)
public abstract class YasmaDB extends RoomDatabase{

    public abstract AlbumDao albumDao();

    public abstract PostDao postDao();
}
