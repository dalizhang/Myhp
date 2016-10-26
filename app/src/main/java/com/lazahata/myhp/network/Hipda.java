package com.lazahata.myhp.network;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by dalizhang on 24/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public interface Hipda {

    @GET("logging.php?action=login")
    Observable<String> getFormHashPage();

    @FormUrlEncoded
    @POST("logging.php?action=login&loginsubmit=yes&inajax=1")
    Observable<String> login(@Field("formhash") String formhash, @Field("referer") String referer, @Field("loginfield") String loginfield, @Field("username") String username,
               @Field("password") String password, @Field("questionid") String questionid, @Field("answer") String answer, @Field("cookietime") String cookietime);


}
