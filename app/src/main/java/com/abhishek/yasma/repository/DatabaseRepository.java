package com.abhishek.yasma.repository;


import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.data.PostEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface DatabaseRepository {

    void savePost(PostEntity postEntity);

    Single<List<PostEntity>> getPosts();

    void saveAlbum(AlbumEntity albumEntity);

    Single<List<AlbumEntity>> getAlbums();
}
