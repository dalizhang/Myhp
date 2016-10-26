package com.lazahata.myhp.model;

import android.text.TextUtils;

import com.lazahata.myhp.network.Hipda;
import com.lazahata.myhp.ui.Tip;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dalizhang on 24/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class HipdaModel {

    private static final HipdaModel SINGLE_INSTANCE_HOLDER = new HipdaModel();
    OkHttpClient client;
    Hipda hipda;

    private HipdaModel() {
        client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.hi-pda.con/forum/").client(client).build();
        hipda = retrofit.create(Hipda.class);
    }

    public static HipdaModel getInstance() {
        return SINGLE_INSTANCE_HOLDER;
    }

    public void login(final String username, final String password) {
        hipda.getFormHashPage().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                onFormHashReceived(s, username, password);
            }
        });
    }

    private void onFormHashReceived(String s, String username, String password) {
        String formhash = _getFormHash(s);
        String cookietime = _getCookieTime(s);
        if (!TextUtils.isEmpty(formhash)) {
            String referer = "http://www.hi-pda.com/forum/index.php";
            String loginfield = "username";
            String questionid = "0";
            String answer = "";
            hipda.login(formhash, referer, loginfield, username, password, questionid, answer, cookietime).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(String s) {

                }
            });
        } else {
            Tip.toastLong("获取不到formhash，无法登录");
        }
    }

    private String _getCookieTime(String page) {
        return _getValue(page, "cookietime");
    }

    private String _getFormHash(String page) {
        return _getValue(page, "formhash");
    }

    private String _getValue(String page, String name) {
        Elements elements = Jsoup.parse(page).getElementsByAttributeValue("name", name);
        int size = null == elements ? 0 : elements.size();
        String value = "";
        if (size >= 1)  value = elements.get(0).val();
        return value;
    }

}
