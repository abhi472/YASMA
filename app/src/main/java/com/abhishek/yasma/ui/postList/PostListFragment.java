package com.abhishek.yasma.ui.postList;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhishek.yasma.R;
import com.abhishek.yasma.base.BaseFragment;
import com.abhishek.yasma.databinding.FragmentPostListBinding;
import com.abhishek.yasma.di.ViewModelFactory;
import com.abhishek.yasma.model.Post;
import com.abhishek.yasma.model.PostDataImpl;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostListFragment extends BaseFragment implements PostListViewContract {

    @Inject
    ViewModelFactory factory;

    @Inject
    PostListAdapter adapter;

    public static final String TAG = "PostListFragmentTag";
    private PostListFragmentViewModel viewModel;

    private FragmentPostListBinding binding;

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
        viewModel = ViewModelProviders.of(this, factory).get(PostListFragmentViewModel.class);
        binding = DataBindingUtil.bind(view);
        if (binding != null) {
            binding.setViewModel(viewModel);
        } else {
            Log.d(TAG, "binding is null");
        }
        viewModel.setContract(this);
        viewModel.startNetworkRequest();
    }


    @Override
    public void onSuccess(ArrayList<? extends PostDataImpl> posts) {

        adapter.setItems(posts);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

    }

    @Override
    public void onError(int errorString) {

    }
}
