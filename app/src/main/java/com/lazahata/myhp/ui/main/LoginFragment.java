package com.lazahata.myhp.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lazahata.core.util.Hash;
import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.FragmentLoginBinding;
import com.lazahata.myhp.model.HipdaModel;
import com.lazahata.myhp.ui.Tip;

/**
 * Created by dalizhang on 25/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, true);
        binding.setFragment(this);
        return binding.getRoot();
    }

    public void login(View view) {
        String username = binding.username.getText().toString().trim();
        String password = binding.password.getText().toString().trim();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            String pwdHash = Hash.md5(password.getBytes());
            HipdaModel.getInstance().login(username, pwdHash, new HipdaModel.LoginCallback() {
                @Override
                public void success() {
                    Tip.toastLong("login success");

                }

                @Override
                public void fail(String msg) {
                    Tip.toastLong("login fail");

                }
            });
        }
    }

}
