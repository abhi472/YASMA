package com.abhishek.yasma.ui.albumList;

import com.abhishek.yasma.model.Post;

import java.util.ArrayList;

public interface AlbumListViewContract {

    void onSuccess(ArrayList<Post> posts);

    void onError(int errorString );

}
