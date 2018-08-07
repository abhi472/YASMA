package com.abhishek.yasma.ui.postList;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhishek.yasma.R;
import com.abhishek.yasma.base.BaseFragment;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostListFragment extends BaseFragment {

    @Inject
    ViewModelProvider.Factory factory;

    private PostListFragmentViewModel viewModel;

    public static PostListFragment newInstance() {

        Bundle args = new Bundle();

        PostListFragment fragment = new PostListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public PostListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(PostListFragmentViewModel.class);
    }
}
