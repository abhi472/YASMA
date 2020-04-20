package com.abhishek.yasma.ui.postList;

import com.abhishek.yasma.data.PostEntity;

import java.util.ArrayList;
import java.util.List;

public interface PostListViewContract {

    void onSuccess(List<PostEntity> posts);

    void onError(int errorString );
}
