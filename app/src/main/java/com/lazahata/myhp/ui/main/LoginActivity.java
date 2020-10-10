package com.lazahata.myhp.ui.main;

import android.app.Activity;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.lazahata.core.util.Hash;
import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.ActivityLoginBinding;
import com.lazahata.myhp.db.Lite;
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
        autoLogin();
    }

    private void autoLogin() {
        String username = Lite.get(Lite.USERNAME);
        String pwdHash = Lite.get(Lite.PASSWORD_HASH);
        if (!TextUtils.isEmpty(username)) {
            binding.username.setText(username);
        }
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pwdHash)) {
            login(username, pwdHash);
        }
    }

    private boolean loginInProgress = false;
    private synchronized boolean isLoginInProgress() {
        return loginInProgress;
    }
    private synchronized void setLoginInProgress(boolean loginInProgress) {
        this.loginInProgress = loginInProgress;
    }

    public void onLoginClicked(View view) {
        final String username = binding.username.getText().toString().trim();
        if (!TextUtils.isEmpty(username)) {
            Lite.put(Lite.USERNAME, username);
        }
        String password = binding.password.getText().toString().trim();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !isLoginInProgress()) {
            final String pwdHash = Hash.md5(password.getBytes());
            login(username, pwdHash);
        }
    }

    private void login(final String username, final String pwdHash) {
        setLoginInProgress(true);
        showProgress();
        HipdaModel.getInstance().kickStartLogin(username, pwdHash, new HipdaModel.LoginCallback() {
            @Override
            public void success() {
                Tip.toastShort("欢迎回来, " + username + " 现在将转入您的主页");
                gotoMain();
                stopProgress();
                setLoginInProgress(false);
                Lite.put(Lite.USERNAME, username);
                Lite.put(Lite.PASSWORD_HASH, pwdHash);
            }

            @Override
            public void fail(String msg) {
                Tip.toastLong(msg);
                stopProgress();
                setLoginInProgress(false);
            }
        });
    }

    private void gotoMain() {
        Intent go = new Intent(this, MainActivity.class);
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
