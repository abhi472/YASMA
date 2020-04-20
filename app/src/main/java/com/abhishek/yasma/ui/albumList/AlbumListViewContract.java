package com.abhishek.yasma.ui.albumList;

import com.abhishek.yasma.data.AlbumEntity;

import java.util.List;

public interface AlbumListViewContract {

    void onSuccess(List<AlbumEntity> posts);

    void onError(int errorString );

}
