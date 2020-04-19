package com.abhishek.yasma.ui.albumList;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.abhishek.yasma.R;
import com.abhishek.yasma.databinding.AlbumCardBinding;
import com.abhishek.yasma.model.AlbumDataImpl;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.ViewHolder> {
    private final Context context;
    private List<? extends AlbumDataImpl> albumArrayList;

    @Inject
    public AlbumListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         AlbumCardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.album_card,
                parent,
                false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumListAdapter.ViewHolder holder, int position) {

        AlbumListAdapterViewModel viewModel = new AlbumListAdapterViewModel();
        viewModel.setFields(albumArrayList.get(holder.getAdapterPosition()));
        holder.setViewModel(viewModel);
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public void setItems(List<? extends AlbumDataImpl> items) {
        this.albumArrayList = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AlbumCardBinding binding;

        public ViewHolder(AlbumCardBinding itemView) {
            super(itemView.root);
            this.binding  = itemView;
        }

        public void setViewModel(AlbumListAdapterViewModel viewModel) {
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }

    }
}
