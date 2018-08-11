package com.abhishek.yasma.ui.albumList;

import com.abhishek.yasma.model.Album;
import com.abhishek.yasma.model.AlbumDataImpl;

import java.util.ArrayList;

public interface AlbumListViewContract {

    void onSuccess(ArrayList<? extends AlbumDataImpl> posts);

    void onError(int errorString );

}
