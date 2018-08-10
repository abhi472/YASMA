package com.abhishek.yasma.ui.albumList;

import android.databinding.ObservableField;
import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.repository.ApiRepository;
import com.abhishek.yasma.repository.ApiRepositoryHelper;
import com.abhishek.yasma.ui.postList.PostListViewContract;

import javax.inject.Inject;

public class AlbumListFragmentViewModel extends BaseViewModel {

    private ApiRepository repository;

    public ObservableField<Boolean> progressVisibility = new ObservableField<>(true);
    public ObservableField<Boolean> errorVisibility = new ObservableField<>(false);

    private AlbumListViewContract contract;

    @Inject
    public AlbumListFragmentViewModel(ApiRepositoryHelper repository) {
        this.repository = repository;

    }

    public void setContract(AlbumListViewContract contract) {
        this.contract = contract;
    }

    public void startNetworkRequest() {

    }

}