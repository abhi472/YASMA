package com.abhishek.yasma.repository;

import android.arch.lifecycle.LiveData;

import com.abhishek.yasma.data.AlbumDao;
import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.data.PostDao;
import com.abhishek.yasma.data.PostEntity;
import com.abhishek.yasma.data.YasmaDB;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

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
    public Completable savePost(PostEntity postEntity) {
        return Completable.create(e -> {
            db.runInTransaction(() -> {
                postDao.savePost(postEntity);
            });
            e.onComplete();
        });
    }

    @Override
    public ArrayList<PostEntity> getPosts() {
        return postDao.getPosts();
    }

    @Override
    public Completable saveAlbum(AlbumEntity albumEntity) {
        return Completable.create(e -> {
            db.runInTransaction(() -> {
                albumDao.saveAlbum(albumEntity);
            });
            e.onComplete();
        });
    }

    @Override
    public ArrayList<AlbumEntity> getAlbums() {
        return albumDao.getAlbums();
    }
}
