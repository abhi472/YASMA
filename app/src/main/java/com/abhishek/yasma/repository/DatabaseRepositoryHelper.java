package com.abhishek.yasma.repository;


import com.abhishek.yasma.data.AlbumDao;
import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.data.PostDao;
import com.abhishek.yasma.data.PostEntity;
import com.abhishek.yasma.data.YasmaDB;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class DatabaseRepositoryHelper implements DatabaseRepository {

    private YasmaDB db;
    private AlbumDao albumDao;
    private PostDao postDao;


    @Inject
    public DatabaseRepositoryHelper(YasmaDB db, AlbumDao albumDao, PostDao postDao) {
        this.albumDao = albumDao;
        this.postDao = postDao;
        this.db = db;
    }


    @Override
    public void savePost(PostEntity postEntity) {
        postDao.savePost(postEntity);

    }

    @Override
    public Single<List<PostEntity>> getPosts() {
        return postDao.getPosts();
    }

    @Override
    public void saveAlbum(AlbumEntity albumEntity) {
        albumDao.saveAlbum(albumEntity);

    }

    @Override
    public Single<List<AlbumEntity>> getAlbums() {
        return albumDao.getAlbums();
    }
}
