package com.abhishek.yasma.ui.albumList;

import androidx.databinding.ObservableField;

import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.data.AlbumEntity;

import javax.inject.Inject;

public class AlbumListAdapterViewModel extends BaseViewModel {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> title = new ObservableField<>("");

    @Inject
    public AlbumListAdapterViewModel() {
    }

    public void setFields(AlbumEntity post) {
        name.set(post.getUserId().toString());
        title.set(post.getTitle());
    }


    public void onClick() {

    }
}
