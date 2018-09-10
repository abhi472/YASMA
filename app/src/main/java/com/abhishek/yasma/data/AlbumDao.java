package com.abhishek.yasma.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.abhishek.yasma.model.Album;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

@Dao
public interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long saveAlbum(AlbumEntity albumEntity);

    @Query("SELECT * FROM album")
    Single<ArrayList<AlbumEntity>> getAlbums();

}
