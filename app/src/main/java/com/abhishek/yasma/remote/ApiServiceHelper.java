package com.abhishek.yasma.remote;

import com.abhishek.yasma.model.Post;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ApiServiceHelper implements ApiService {

    private final ApiService service;

    @Inject
    public ApiServiceHelper(ApiService service) {
        this.service = service;
    }

    @Override
    public Single<ArrayList<Post>> getPosts() {

        return service.getPosts();

    }
}
