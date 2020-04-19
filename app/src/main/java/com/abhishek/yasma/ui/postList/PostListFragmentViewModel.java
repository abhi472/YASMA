package com.abhishek.yasma.ui.postList;

import androidx.databinding.ObservableField;

import com.abhishek.yasma.R;
import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.repository.ApiRepository;
import com.abhishek.yasma.repository.ApiRepositoryHelper;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PostListFragmentViewModel extends BaseViewModel {

    private ApiRepository repository;

    public ObservableField<Boolean> progressVisibility = new ObservableField<>(true);
    public ObservableField<Boolean> errorVisibility = new ObservableField<>(false);

    private PostListViewContract contract;

    @Inject
    public PostListFragmentViewModel(ApiRepositoryHelper repository) {
        this.repository = repository;

    }

    public void setContract(PostListViewContract contract) {
        this.contract = contract;
    }

    public void startNetworkRequest() {
        getCompositeDisposable()
                .add(repository
                        .getPosts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(posts -> {
                            contract.onSuccess(posts);
                            progressVisibility.set(false);


                        }, throwable -> {
                            contract.onError(R.string.generic_error);
                            progressVisibility.set(false);
                            errorVisibility.set(true);

                        })
                );
    }

}
