package com.abhishek.yasma.remote;


import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.data.PostEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("posts")
    Observable<List<PostEntity>> getPosts();

    @GET("albums")
    Observable<List<AlbumEntity>> getAlbums();
}
