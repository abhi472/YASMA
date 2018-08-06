package com.abhishek.yasma.remote;

import com.abhishek.yasma.model.Post;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Single;

public class ApiServiceHelper {

    private final ApiService service;

    @Inject
    public ApiServiceHelper(ApiService service) {
        this.service = service;
    }

    public Single<ArrayList<Post>> getPosts() {

        return service.getPosts();

    }
}
