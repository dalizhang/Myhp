package com.lazahata.myhp.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.lazahata.myhp.App;

/**
 * Created by dalizhang on 01/11/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class Lite {

    private static SharedPreferences sharedPreferences = App.get().getSharedPreferences("lite", Context.MODE_PRIVATE);

    public static final String USERNAME = "lite.username";
    public static final String PASSWORD_HASH = "lite.password.hash";


    public static void put(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public static String get(String key) {
        return sharedPreferences.getString(key, null);
    }

    public static void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }
}
