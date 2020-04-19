package com.abhishek.yasma.ui.albumList;

import com.abhishek.yasma.model.Album;
import com.abhishek.yasma.model.AlbumDataImpl;

import java.util.ArrayList;
import java.util.List;

public interface AlbumListViewContract {

    void onSuccess(List<? extends AlbumDataImpl> posts);

    void onError(int errorString );

}
