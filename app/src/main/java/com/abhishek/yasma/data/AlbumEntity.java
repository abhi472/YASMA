package com.abhishek.yasma.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.abhishek.yasma.model.AlbumDataImpl;

@Entity(tableName = "album")
public class AlbumEntity implements AlbumDataImpl{

    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;

    private Integer userId;


    private String title;

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
