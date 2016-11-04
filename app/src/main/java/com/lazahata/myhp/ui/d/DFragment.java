package com.lazahata.myhp.ui.d;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.FragmentDBinding;
import com.lazahata.myhp.entity.Thread;
import com.lazahata.myhp.ui.Tip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalizhang on 25/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class DFragment extends Fragment {

    private FragmentDBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_d, container, false);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Thread t1 = new Thread();
            t1.setAuthor("作者" + i);
            t1.setReplyCount(i + "");
            t1.setTitle("标题" + i);
            threads.add(t1);
        }
        binding.list.setAdapter(new DAdapter(threads, new Callback() {
            @Override
            public void onClick(Thread thread) {
                Tip.toastShort(thread.getTitle());
            }
        }));
        return binding.getRoot();
    }

}
