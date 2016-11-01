package com.lazahata.myhp.model;

import android.text.TextUtils;

import com.lazahata.myhp.network.Hipda;
import com.lazahata.myhp.ui.Tip;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
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
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.hi-pda.com/forum/").client(client).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(ScalarsConverterFactory.create()).build();
        hipda = retrofit.create(Hipda.class);
    }

    public static HipdaModel getInstance() {
        return SINGLE_INSTANCE_HOLDER;
    }

    public interface LoginCallback {
        void success();

        void fail(String msg);
    }

    /**
     * some values must be retrieved before the real login
     * @param username
     * @param password
     * @param callback
     */
    public void kickStartLogin(final String username, final String password, final LoginCallback callback) {
        hipda.getFormHashPage().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                callback.fail(e.getMessage());
            }

            @Override
            public void onNext(String s) {
                onFormHashReceived(s, username, password, callback);
            }
        });
    }

    private void onFormHashReceived(String page, String username, String password, final LoginCallback callback) {
        String formhash = _getFormHash(page);
        String cookietime = _getCookieTime(page);
        if (!TextUtils.isEmpty(formhash)) {
            String referer = "http://www.hi-pda.com/forum/index.php";
            String loginfield = "username";
            String questionid = "0";
            String answer = "";
            try {
                username = URLEncoder.encode(username, "GB2312");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                callback.fail("username encode失败");
                return;
            }
            hipda.login(formhash, referer, loginfield, username, password, questionid, answer, cookietime).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    callback.fail("");
                }

                @Override
                public void onNext(String s) {
                    if (null != s && (s.contains("欢迎您回来") || s.contains("现在将转入登录前页面"))) {
                        callback.success();
                    } else if (null != s && s.contains("登录失败")) {
                        callback.fail("登录失败, 请确认用户名和密码正确");
                    } else {
                        callback.fail("登录失败, 请尝试使用浏览器登录");
                    }
                }
            });
        } else {
            callback.fail("获取不到formhash, 无法登录, 请尝试使用浏览器登录");
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
