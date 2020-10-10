package com.lazahata.myhp.ui.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.lazahata.myhp.R;
import com.lazahata.myhp.databinding.ActivitySettingsBinding;
import com.lazahata.myhp.db.Lite;

/**
 * Created by ZHANGHAICHUAN889 on 01/11/2016.
 * E-mail: zhanghaichuan889@pingan.com.cn
 */

public class SettingsActivity extends Activity {

    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings);
        binding.setActivity(this);
    }

    public void onLogOutClicked(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
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
        Activity activity = this;
        Intent go = new Intent(activity, LoginActivity.class);
        go.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        activity.startActivity(go);
        activity.finish();
    }
}
