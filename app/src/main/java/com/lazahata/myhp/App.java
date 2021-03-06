package com.lazahata.myhp;

import android.app.Application;

import com.lazahata.myhp.utils.Conf;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by dalizhang on 26/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class App extends Application {

    private static App _instance;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "900057914", Conf.isDebug());
        _instance = (App) getApplicationContext();
    }

    public static App get() {
        return _instance;
    }
}
