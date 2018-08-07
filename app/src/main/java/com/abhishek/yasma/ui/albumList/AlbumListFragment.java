package com.abhishek.yasma.ui.albumList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhishek.yasma.R;
import com.abhishek.yasma.base.BaseFragment;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumListFragment extends BaseFragment {


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

}
