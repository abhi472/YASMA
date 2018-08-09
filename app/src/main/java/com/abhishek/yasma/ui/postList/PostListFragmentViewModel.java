package com.abhishek.yasma.ui.postList;

import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.repository.ApiRepository;
import com.abhishek.yasma.repository.ApiRepositoryHelper;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PostListFragmentViewModel extends BaseViewModel {

    private ApiRepository repository;

    private ViewContract contract;

    @Inject
    public PostListFragmentViewModel(ApiRepositoryHelper repository) {
        this.repository = repository;

    }

    public void setContract(ViewContract contract) {
        this.contract = contract;
    }

    public void startNetworkRequest() {
        getCompositeDisposable()
                .add(repository
                        .getPosts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(posts -> {
contract.onSuccess();


                        }, throwable -> {
                            contract.onError();

                        })
                );
    }

}
