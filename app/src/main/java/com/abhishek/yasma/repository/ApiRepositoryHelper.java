package com.abhishek.yasma.repository;

import com.abhishek.yasma.model.Album;
import com.abhishek.yasma.model.Post;
import com.abhishek.yasma.remote.ApiServiceHelper;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ApiRepositoryHelper implements ApiRepository {

    private ApiServiceHelper apiServiceHelper;

    @Inject
    public ApiRepositoryHelper (ApiServiceHelper apiServiceHelper) {
        this.apiServiceHelper = apiServiceHelper;
    }


    @Override
    public Single<ArrayList<Post>> getPosts() {
        return apiServiceHelper.getPosts();
    }

    @Override
    public Single<ArrayList<Album>> getAlbums() {
        return apiServiceHelper.getAlbums();
    }
}
