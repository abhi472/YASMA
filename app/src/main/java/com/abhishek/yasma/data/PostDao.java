package com.abhishek.yasma.data;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long savePost(PostEntity postEntity);

    @Query("SELECT * FROM post")
    Single<List<PostEntity>> getPosts();

}
