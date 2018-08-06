package com.abhishek.yasma.remote;


import com.abhishek.yasma.model.Post;

import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("posts")
    public Single<ArrayList<Post>> getPosts();
}
