package com.lazahata.core.gbkconverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by lazahata on 16/2/2017.
 */

public class GbkStringConverterFactory extends Converter.Factory {
    public static GbkStringConverterFactory create() {
        return new GbkStringConverterFactory();
    }

    private GbkStringConverterFactory() {
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return GbkStringRequestBodyConverter.INSTANCE;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return GbkStringResponseBodyConverter.INSTANCE;
    }


}
