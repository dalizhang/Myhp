package com.lazahata.myhp.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.FragmentMeBinding;
import com.lazahata.myhp.ui.common.BaseVPFragment;
import com.lazahata.myhp.utils.Log;

/**
 * Created by dalizhang on 25/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class MeFragment extends BaseVPFragment {

    private FragmentMeBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_me, container, false);
        binding.setFragment(this);
        return binding.getRoot();
    }

    public void onSettingClicked(View view) {
        Intent go = new Intent(getActivity(), SettingsActivity.class);
        getActivity().startActivity(go);
    }

    @Override
    protected void onRealResume() {

    }

    @Override
    protected void onRealPause() {

    }

}
