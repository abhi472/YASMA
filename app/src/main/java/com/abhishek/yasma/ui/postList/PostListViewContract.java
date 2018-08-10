package com.abhishek.yasma.ui.postList;

import com.abhishek.yasma.model.Post;

import java.util.ArrayList;

public interface PostListViewContract {

    void onSuccess(ArrayList<Post> posts);

    void onError(int errorString );
}
