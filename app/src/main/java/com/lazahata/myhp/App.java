package com.lazahata.myhp;

import android.app.Application;

import com.lazahata.myhp.utils.Conf;
import com.newrelic.agent.android.NewRelic;
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
        NewRelic.withApplicationToken(
                "AAf31cd2b4d7fc8770758e949220aec03d11efda7e"
        ).start(this.getApplicationContext());
    }

    public static App get() {
        return _instance;
    }
}
