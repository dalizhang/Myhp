package com.lazahata.myhp.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.FragmentFBinding;

/**
 * Created by dalizhang on 25/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class FFragment extends Fragment {

    private FragmentFBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_f, container, false);
        binding.setFragment(this);
        return binding.getRoot();
    }
}