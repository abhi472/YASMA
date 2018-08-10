package com.abhishek.yasma.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long savePost(PostEntity postEntity);

    @Query("SELECT * FROM post")
    LiveData<List<PostEntity>> getPosts();

}
