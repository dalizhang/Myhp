package com.lazahata.myhp;

import android.app.Application;

/**
 * Created by ZHANGHAICHUAN889 on 25/10/2016.
 * E-mail: zhanghaichuan889@pingan.com.cn
 */

public class App extends Application {

    private static App _instance;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = (App) getApplicationContext();
    }

    public static App get() {
        return _instance;
    }
}
