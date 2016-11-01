package com.lazahata.myhp.utils;

import com.lazahata.myhp.BuildConfig;

/**
 * Created by dalizhang on 26/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class Log {

    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            android.util.Log.i(tag, msg);
        }
    }



}
