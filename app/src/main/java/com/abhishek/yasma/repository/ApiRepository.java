package com.abhishek.yasma.repository;

import com.abhishek.yasma.model.Post;

import java.util.ArrayList;

import io.reactivex.Single;

interface ApiRepository {

    Single<ArrayList<Post>> getPosts();

}
