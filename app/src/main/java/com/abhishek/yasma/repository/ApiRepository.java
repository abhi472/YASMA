package com.abhishek.yasma.repository;

import com.abhishek.yasma.model.Album;
import com.abhishek.yasma.model.Post;

import java.util.ArrayList;

import io.reactivex.Single;

public interface ApiRepository {

    Single<ArrayList<Post>> getPosts();

    Single<ArrayList<Album>> getAlbums();


}
