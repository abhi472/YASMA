package com.abhishek.yasma.ui.postList;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhishek.yasma.R;
import com.abhishek.yasma.databinding.PostCardBinding;
import com.abhishek.yasma.model.Post;

import java.util.ArrayList;

import javax.inject.Inject;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {


    private final Context context;
    private ArrayList<Post> postArrayList = new ArrayList<>();

    @Inject
    public PostListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PostListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         PostCardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.post_card,
                parent,
                false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostListAdapter.ViewHolder holder, int position) {

        PostListAdapterViewModel viewModel = new PostListAdapterViewModel();
        viewModel.setFields(postArrayList.get(holder.getAdapterPosition()));
        holder.setViewModel(viewModel);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public void setItems(ArrayList<Post> items) {
        this.postArrayList = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        PostCardBinding binding;

        public ViewHolder(PostCardBinding itemView) {
            super(itemView.root);
            this.binding  = itemView;
        }

        public void setViewModel(PostListAdapterViewModel viewModel) {
             binding.setViewModel(viewModel);
             binding.executePendingBindings();
        }

    }
}
