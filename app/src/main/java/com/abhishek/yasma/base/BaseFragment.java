package com.abhishek.yasma.base;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.abhishek.yasma.model.ViewState;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
        setHasOptionsMenu(false);
    }


    void renderViewState(ViewState viewState) {
        if(viewState != null) {
            boolean bool = viewState.isLoading;
            if (bool)
                showProgress();
            else hideProgress();
        }
    }

    void hideProgress() {

    }

    void showProgress() {

    }


}
