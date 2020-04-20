package com.abhishek.yasma.ui.postList;

import androidx.databinding.ObservableField;

import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.data.PostEntity;

import javax.inject.Inject;

public class PostListAdapterViewModel extends BaseViewModel {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<String> body = new ObservableField<>("");

    @Inject
    public PostListAdapterViewModel() {
    }

    public void setFields(PostEntity post) {
        name.set(post.getUserId().toString());
        title.set(post.getTitle());
        body.set(post.getBody());
    }


    public void onClick() {

    }
}
