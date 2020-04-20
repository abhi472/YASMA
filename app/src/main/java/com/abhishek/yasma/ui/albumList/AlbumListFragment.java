package com.abhishek.yasma.ui.albumList;


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
import com.abhishek.yasma.data.AlbumEntity;
import com.abhishek.yasma.databinding.FragmentAlbumListBinding;
import com.abhishek.yasma.di.ViewModelFactory;
import com.google.android.gms.common.util.CollectionUtils;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;


public class AlbumListFragment extends BaseFragment implements AlbumListViewContract {

    @Inject
    ViewModelFactory factory;

    @Inject
    AlbumListAdapter adapter;


    private AlbumListFragmentViewModel viewModel;
    private FragmentAlbumListBinding binding;

    public static final String TAG = "AlbumListFragmentTAG";
    private List<AlbumEntity> albumArrayList;


    public static AlbumListFragment newInstance() {

        Bundle args = new Bundle();

        AlbumListFragment fragment = new AlbumListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public AlbumListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(AlbumListFragmentViewModel.class);
        binding = DataBindingUtil.bind(view);
        if (binding != null) {
            binding.setViewModel(viewModel);
        } else {
            Log.d(TAG, "binding is null");
        }
        viewModel.setContract(this);
        viewModel.getAlbumData();
    }

    @Override
    public void onSuccess(List<AlbumEntity> albumArrayList) {
        this.albumArrayList = albumArrayList;
        adapter.setItems(albumArrayList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onError(int errorString) {



    }
}
