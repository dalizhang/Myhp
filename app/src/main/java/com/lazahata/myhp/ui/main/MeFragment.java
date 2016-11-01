package com.lazahata.myhp.ui.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.lazahata.myhp.db.Lite;
import com.lazahata.myhp.utils.Log;

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

    public void onLogOutClicked(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setMessage("您确定要退出吗?");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "狠心退出", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Lite.remove(Lite.USERNAME);
                Lite.remove(Lite.PASSWORD_HASH);
                gotoLogin();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "伤心留下", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // do nothing
            }
        });
        alertDialog.show();
    }

    private void gotoLogin() {
        Activity activity = getActivity();
        Intent go = new Intent(activity, LoginActivity.class);
        go.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        activity.startActivity(go);
        activity.finish();
    }

}
