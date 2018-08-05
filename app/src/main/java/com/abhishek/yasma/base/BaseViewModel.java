package com.abhishek.yasma.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.abhishek.yasma.SingleLiveEvent;
import com.abhishek.yasma.model.ViewState;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<T> extends ViewModel{

    public MutableLiveData<ViewState> viewState = new MutableLiveData<>();


    public SingleLiveEvent<T> command = new SingleLiveEvent<>();

    private CompositeDisposable disposable = new CompositeDisposable();

    public BaseViewModel() {
        viewState.setValue(new ViewState());
    }

    public SingleLiveEvent<T> getCommand() {
        return command;
    }

    public CompositeDisposable getDisposable() {
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
