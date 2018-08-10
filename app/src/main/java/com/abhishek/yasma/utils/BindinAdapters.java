package com.abhishek.yasma.utils;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

public class BindinAdapters {

    @BindingAdapter("isVisible")
    public void isVisible(View view, Boolean status) {

      if(status)
          view.setVisibility(View.VISIBLE);
      else
          view.setVisibility(View.GONE);

    }

    @BindingAdapter("isRefreshing")
    public void isRefreshing(SwipeRefreshLayout view, Boolean status) {

        view.setRefreshing(status);

    }
}
