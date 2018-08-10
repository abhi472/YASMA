package com.abhishek.yasma.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.abhishek.yasma.model.Album;

import java.util.List;

@Dao
public interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long savePost(AlbumEntity postEntity);

    @Query("SELECT * FROM album")
    LiveData<List<AlbumEntity>> getPosts();

}
