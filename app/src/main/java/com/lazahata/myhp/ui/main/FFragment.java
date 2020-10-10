package com.lazahata.myhp.ui.main;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.FragmentFBinding;
import com.lazahata.myhp.ui.common.BaseVPFragment;

/**
 * Created by dalizhang on 25/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class FFragment extends BaseVPFragment {

    private FragmentFBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_f, container, false);
        binding.setFragment(this);
        return binding.getRoot();
    }

    @Override
    protected void onRealResume() {

    }

    @Override
    protected void onRealPause() {

    }
}
