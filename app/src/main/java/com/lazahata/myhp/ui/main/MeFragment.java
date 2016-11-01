package com.lazahata.myhp.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lazahata.myhp.App;
import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.FragmentMeBinding;
import com.lazahata.myhp.utils.Log;
import com.squareup.picasso.Picasso;

/**
 * Created by dalizhang on 25/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class MeFragment extends Fragment {

    private FragmentMeBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_me, container, false);
        binding.setFragment(this);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isVisible() && getUserVisibleHint()) {
            onRealResume();
        }
    }

    private void onRealResume() {
        Log.i("test:", "onRealResume");
//        Picasso.with(App.get()).load(url).into(binding.avatar);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isVisible()) {
            onRealResume();
        }
    }


}
