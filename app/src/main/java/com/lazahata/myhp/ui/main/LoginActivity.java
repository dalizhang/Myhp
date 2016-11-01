package com.lazahata.myhp.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.lazahata.core.util.Hash;
import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.ActivityLoginBinding;
import com.lazahata.myhp.model.HipdaModel;
import com.lazahata.myhp.ui.Tip;

/**
 * Created by dalizhang on 01/11/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class LoginActivity extends Activity  {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setActivity(this);
    }

    private boolean loginInProgress = false;
    private synchronized boolean isLoginInProgress() {
        return loginInProgress;
    }
    private synchronized void setLoginInProgress(boolean loginInProgress) {
        this.loginInProgress = loginInProgress;
    }

    public void login(View view) {
        String username = binding.username.getText().toString().trim();
        String password = binding.password.getText().toString().trim();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !isLoginInProgress()) {
            setLoginInProgress(true);
            String pwdHash = Hash.md5(password.getBytes());
            showProgress();
            HipdaModel.getInstance().login(username, pwdHash, new HipdaModel.LoginCallback() {
                @Override
                public void success() {
                    Tip.toastLong("login success");
                    gotoMain();
                    stopProgress();
                    setLoginInProgress(false);
                }

                @Override
                public void fail(String msg) {
                    Tip.toastLong(msg);
                    stopProgress();
                    setLoginInProgress(false);
                }
            });
        }
    }

    private void gotoMain() {
        Intent go = new Intent(this, MainActivity.class);
        go.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(go);
        this.finish();
    }

    private void stopProgress() {
        binding.progressBar.setVisibility(View.GONE);
    }

    private void showProgress() {
        binding.progressBar.bringToFront();
        binding.progressBar.setVisibility(View.VISIBLE);
    }


}
