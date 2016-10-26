package com.lazahata.myhp.ui;

import android.widget.Toast;

import com.lazahata.myhp.App;

/**
 * Created by ZHANGHAICHUAN889 on 25/10/2016.
 * E-mail: zhanghaichuan889@pingan.com.cn
 */

public class Tip {

    public static void toastLong(String msg) {
        Toast.makeText(App.get(), msg, Toast.LENGTH_LONG).show();
    }

    public static void toastShort(String msg) {
        Toast.makeText(App.get(), msg, Toast.LENGTH_SHORT).show();
    }
}
