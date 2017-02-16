package com.lazahata.core.gbkconverter;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by lazahata on 16/2/2017.
 */

public class GbkStringResponseBodyConverter implements Converter<ResponseBody, String> {
    static final GbkStringResponseBodyConverter INSTANCE = new GbkStringResponseBodyConverter();
    private static final Charset GBK = Charset.forName("GBK");

    @Override
    public String convert(ResponseBody value) throws IOException {
        return new String(value.bytes(), GBK);
    }
}
