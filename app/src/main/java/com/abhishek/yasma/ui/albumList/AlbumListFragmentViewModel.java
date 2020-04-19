package com.abhishek.yasma.ui.albumList;

import androidx.databinding.ObservableField;

import com.abhishek.yasma.R;
import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.repository.ApiRepository;
import com.abhishek.yasma.repository.ApiRepositoryHelper;
import com.abhishek.yasma.repository.DatabaseRepository;
import com.abhishek.yasma.repository.DatabaseRepositoryHelper;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AlbumListFragmentViewModel extends BaseViewModel {

    private ApiRepository repository;

    private DatabaseRepository databaseRepository;

    public ObservableField<Boolean> progressVisibility = new ObservableField<>(true);
    public ObservableField<Boolean> errorVisibility = new ObservableField<>(false);

    private AlbumListViewContract contract;

    @Inject
    public AlbumListFragmentViewModel(ApiRepositoryHelper repository,
                                      DatabaseRepositoryHelper databaseRepository) {
        this.repository = repository;
        this.databaseRepository = databaseRepository;

    }

    public void setContract(AlbumListViewContract contract) {
        this.contract = contract;
    }

    public void startNetworkRequest() {

        getCompositeDisposable()
                .add(repository
                        .getAlbums()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(albums -> {
                            contract.onSuccess(albums);
                            progressVisibility.set(false);


                        }, throwable -> {
                            contract.onError(R.string.generic_error);
                            progressVisibility.set(false);
                            errorVisibility.set(true);

                        })
                );
    }

    public void fetchData() {

        getCompositeDisposable()
                .add(Single.concat
                        (databaseRepository.getAlbums(),
                                repository.getAlbums())
                        .take(1).subscribe(albumData -> {
                            contract.onSuccess(albumData);
                            progressVisibility.set(false);

                        }, throwable -> {
                            contract.onError(R.string.generic_error);
                            progressVisibility.set(false);
                            errorVisibility.set(true);
                        }));

    }

}