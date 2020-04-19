package com.abhishek.yasma.data;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.abhishek.yasma.model.PostDataImpl;

@Entity(tableName = "post")
public class PostEntity implements PostDataImpl{


    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;

    private Integer userId;


    private String title;

    private String body;


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

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }
}
