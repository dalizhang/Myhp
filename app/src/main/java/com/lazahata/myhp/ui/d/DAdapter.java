package com.lazahata.myhp.ui.d;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.ThreadItemBinding;
import com.lazahata.myhp.entity.Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalizhang on 02/11/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class DAdapter extends RecyclerView.Adapter<DAdapter.DHolder> {

    List<Thread> threadList = new ArrayList<>();
    private Callback mCallback;

    public DAdapter(List<Thread> list, Callback callback) {
        this.threadList.addAll(list);
        this.mCallback = callback;
    }

    @Override
    public DHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ThreadItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.thread_item, parent, false);
        DHolder holder = new DHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(DHolder holder, int position) {
        holder.getBinding().setData(threadList.get(position));
        holder.getBinding().setCallback(mCallback);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return threadList.size();
    }

    public class DHolder extends RecyclerView.ViewHolder {

        private ThreadItemBinding binding;

        public DHolder(View itemView) {
            super(itemView);
        }

        public ThreadItemBinding getBinding() {
            return binding;
        }

        public void setBinding(ThreadItemBinding binding) {
            this.binding = binding;
        }
    }
}


