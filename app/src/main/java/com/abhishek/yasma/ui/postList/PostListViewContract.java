package com.abhishek.yasma.ui.postList;

import com.abhishek.yasma.model.Post;
import com.abhishek.yasma.model.PostDataImpl;

import java.util.ArrayList;

public interface PostListViewContract {

    void onSuccess(ArrayList<? extends PostDataImpl> posts);

    void onError(int errorString );
}
