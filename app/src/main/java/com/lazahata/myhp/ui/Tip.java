package com.lazahata.myhp.ui;

import android.widget.Toast;

import com.lazahata.myhp.App;

/**
 * Created by dalizhang on 26/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class Tip {

    public static void toastLong(String msg) {
        Toast.makeText(App.get(), msg, Toast.LENGTH_LONG).show();
    }

    public static void toastShort(String msg) {
        Toast.makeText(App.get(), msg, Toast.LENGTH_SHORT).show();
    }
}
