package com.abhishek.yasma.ui.postList;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.abhishek.yasma.R;
import com.abhishek.yasma.base.BaseViewModel;
import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.data.PostEntity;
import com.abhishek.yasma.repository.ApiRepository;
import com.abhishek.yasma.repository.ApiRepositoryHelper;
import com.abhishek.yasma.repository.DatabaseRepository;
import com.google.android.gms.common.util.CollectionUtils;

import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PostListFragmentViewModel extends BaseViewModel {

    private final DatabaseRepository databaseRepository;
    private ApiRepository repository;

    public ObservableField<Boolean> progressVisibility = new ObservableField<>(true);
    public ObservableField<Boolean> errorVisibility = new ObservableField<>(false);

    private PostListViewContract contract;
    private List<PostEntity> postEntitie;

    @Inject
    public PostListFragmentViewModel(ApiRepositoryHelper repository, DatabaseRepository databaseRepository) {
        this.repository = repository;
        this.databaseRepository = databaseRepository;

    }

    public void setContract(PostListViewContract contract) {
        this.contract = contract;
    }

    public void getPostData() {
        Observable<List<PostEntity>> observable = Observable.concatArrayEagerDelayError(fetchDataFromDB(),
                fetchDataFromNetwork()

        );

        getCompositeDisposable().add(observable
                .subscribeOn(Schedulers.io())
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(post -> {
                    contract.onSuccess(post);
                    progressVisibility.set(false);


                }, throwable -> {
                    contract.onError(R.string.generic_error);
                    progressVisibility.set(false);
                    errorVisibility.set(true);
                }));

    }

    private Observable<List<PostEntity>> fetchDataFromNetwork() {
        return repository
                .getPosts().doOnNext(posts -> {

                    for (PostEntity postEntity : posts) {
                        databaseRepository.savePost(postEntity);

                    }
                }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends List<PostEntity>>>() {
                    @Override
                    public ObservableSource<? extends List<PostEntity>> apply(Throwable throwable) throws Exception {
                        if(throwable instanceof UnknownHostException && !CollectionUtils.isEmpty(postEntitie))
                            return  Observable.just(postEntitie);
                        else return  Observable.error(throwable);
                    }
                });

    }

    private Observable<List<PostEntity>> fetchDataFromDB() {


        return databaseRepository.getPosts().toObservable().doOnNext(new Consumer<List<PostEntity>>() {

            @Override
            public void accept(List<PostEntity> postEntities) throws Exception {
                Log.e("REPOSITORY DB *** ", "getAlbumData()");
                postEntitie = postEntities;

            }
        });

    }

}

