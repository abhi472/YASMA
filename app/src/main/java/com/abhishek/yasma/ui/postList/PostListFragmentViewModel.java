package com.abhishek.yasma.ui.postList;

import com.abhishek.yasma.base.BaseCommand;
import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.repository.ApiRepository;
import com.abhishek.yasma.repository.ApiRepositoryHelper;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PostListFragmentViewModel extends BaseViewModel<BaseCommand> {

    private ApiRepository repository;

    @Inject
    public PostListFragmentViewModel(ApiRepositoryHelper repository) {
        this.repository = repository;
    }

    public void startNetworkRequest() {
        getCompositeDisposable()
                .add(repository
                        .getPosts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(posts -> {

                            command.setValue(new BaseCommand.UpdateAdapter(posts));


                        }, throwable -> {

                            command.setValue(new BaseCommand.ShowError("Some error occured"));
                        })
                );
    }

}
