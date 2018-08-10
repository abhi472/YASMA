package com.abhishek.yasma.ui.postList;

import android.databinding.ObservableField;

import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.model.Post;

import javax.inject.Inject;

public class PostListAdapterViewModel extends BaseViewModel {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<String> body = new ObservableField<>("");

    @Inject
    public PostListAdapterViewModel() {
    }

    public void setFields(Post post) {
        name.set(post.getUserId().toString());
        title.set(post.getTitle());
        body.set(post.getBody());
    }


    public void onClick() {

    }
}
