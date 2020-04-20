package com.abhishek.yasma.ui.albumList;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.abhishek.yasma.R;
import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.repository.ApiRepository;
import com.abhishek.yasma.repository.ApiRepositoryHelper;
import com.abhishek.yasma.repository.DatabaseRepository;
import com.abhishek.yasma.repository.DatabaseRepositoryHelper;
import com.google.android.gms.common.util.CollectionUtils;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AlbumListFragmentViewModel extends BaseViewModel {

    private ApiRepository repository;

    private List<AlbumEntity> albumEntitie;


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


    public void getAlbumData() {
        Observable<List<AlbumEntity>> observable = Observable.concatArrayEagerDelayError(fetchDataFromDB(),
                fetchDataFromNetwork()

                );

        getCompositeDisposable().add(observable
                .subscribeOn(Schedulers.io())
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(albums -> {
                    contract.onSuccess(albums);
                    progressVisibility.set(false);


                }, throwable -> {
                    contract.onError(R.string.generic_error);
                    progressVisibility.set(false);
                    errorVisibility.set(true);
                }));

    }

    private Observable<List<AlbumEntity>> fetchDataFromNetwork() {
        return repository
                .getAlbums().doOnNext(albums -> {
                    Log.e("REPOSITORY DB *** ", "saveAlbum"+albums.size());

                    for (AlbumEntity albumEntity : albums) {
                        databaseRepository.saveAlbum(albumEntity);

                    }
                }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends List<AlbumEntity>>>() {
                    @Override
                    public ObservableSource<? extends List<AlbumEntity>> apply(Throwable throwable) throws Exception {
                        if(throwable instanceof UnknownHostException && !CollectionUtils.isEmpty(albumEntitie))
                            return  Observable.just(albumEntitie);
                        else return  Observable.error(throwable);
                    }
                });

    }

    private Observable<List<AlbumEntity>> fetchDataFromDB() {


        return databaseRepository.getAlbums().toObservable().doOnNext(new Consumer<List<AlbumEntity>>() {

            @Override
            public void accept(List<AlbumEntity> albumEntities) throws Exception {
                Log.e("REPOSITORY DB *** ", "getAlbumData()");
                albumEntitie = albumEntities;

            }
        });

    }

}