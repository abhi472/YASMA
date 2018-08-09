package com.abhishek.yasma.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.abhishek.yasma.SingleLiveEvent;
import com.abhishek.yasma.model.ViewState;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel{

    public MutableLiveData<ViewState> viewState = new MutableLiveData<>();



    private CompositeDisposable disposable = new CompositeDisposable();

    public BaseViewModel() {
    }


    public CompositeDisposable getCompositeDisposable() {
        return disposable;
    }

    public void showProgressBar() {
        viewState.setValue(new ViewState(true));
    }

    public void hideProgressBar() {
        viewState.setValue(new ViewState(false));
    }

    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
