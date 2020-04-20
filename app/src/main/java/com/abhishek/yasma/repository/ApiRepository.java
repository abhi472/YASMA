package com.abhishek.yasma.repository;

import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.data.PostEntity;

import java.util.List;

import io.reactivex.Observable;

public interface ApiRepository {

    Observable<List<PostEntity>> getPosts();

    Observable<List<AlbumEntity>> getAlbums();


}
