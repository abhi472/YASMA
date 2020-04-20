package com.abhishek.yasma.remote;

import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.data.PostEntity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class ApiServiceHelper implements ApiService {

    private final ApiService service;

    @Inject
    public ApiServiceHelper(ApiService service) {
        this.service = service;
    }

    @Override
    public Observable<List<PostEntity>> getPosts() {

        return service.getPosts();

    }

    @Override
    public Observable<List<AlbumEntity>> getAlbums() {
        return service.getAlbums();
    }
}
