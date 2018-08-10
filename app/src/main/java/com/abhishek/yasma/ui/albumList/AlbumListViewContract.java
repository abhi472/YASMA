package com.abhishek.yasma.ui.albumList;

import com.abhishek.yasma.model.Album;

import java.util.ArrayList;

public interface AlbumListViewContract {

    void onSuccess(ArrayList<Album> posts);

    void onError(int errorString );

}
