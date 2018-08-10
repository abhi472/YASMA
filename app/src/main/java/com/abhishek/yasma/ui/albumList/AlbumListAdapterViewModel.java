package com.abhishek.yasma.ui.albumList;

import android.databinding.ObservableField;

import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.model.Album;
import com.abhishek.yasma.model.Post;

import javax.inject.Inject;

public class AlbumListAdapterViewModel extends BaseViewModel {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> title = new ObservableField<>("");

    @Inject
    public AlbumListAdapterViewModel() {
    }

    public void setFields(Album post) {
        name.set(post.getUserId().toString());
        title.set(post.getTitle());
    }


    public void onClick() {

    }
}
