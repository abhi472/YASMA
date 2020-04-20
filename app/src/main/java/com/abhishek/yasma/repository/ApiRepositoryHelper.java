package com.abhishek.yasma.repository;

import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.data.PostEntity;
import com.abhishek.yasma.remote.ApiServiceHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class ApiRepositoryHelper implements ApiRepository {

    private ApiServiceHelper apiServiceHelper;

    @Inject
    public ApiRepositoryHelper (ApiServiceHelper apiServiceHelper) {
        this.apiServiceHelper = apiServiceHelper;
    }


    @Override
    public Observable<List<PostEntity>> getPosts() {
        return apiServiceHelper.getPosts();
    }

    @Override
    public Observable<List<AlbumEntity>> getAlbums() {
        return apiServiceHelper.getAlbums();
    }
}
