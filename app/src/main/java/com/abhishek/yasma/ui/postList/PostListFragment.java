package com.abhishek.yasma.ui.postList;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhishek.yasma.R;
import com.abhishek.yasma.base.BaseFragment;
import com.abhishek.yasma.data.PostEntity;
import com.abhishek.yasma.databinding.FragmentPostListBinding;
import com.abhishek.yasma.di.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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
        viewModel.getPostData();
    }


    @Override
    public void onSuccess(List<PostEntity> posts) {

        adapter.setItems(posts);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

    }

    @Override
    public void onError(int errorString) {

    }
}
