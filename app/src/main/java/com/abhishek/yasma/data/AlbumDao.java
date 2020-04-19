package com.abhishek.yasma.data;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.abhishek.yasma.model.Album;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

@Dao
public interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long saveAlbum(AlbumEntity albumEntity);

    @Query("SELECT * FROM album")
    Single<List<AlbumEntity>> getAlbums();

}
