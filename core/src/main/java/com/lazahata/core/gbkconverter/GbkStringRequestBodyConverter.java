package com.lazahata.core.gbkconverter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/**
 * Created by lazahata on 16/2/2017.
 */

public class GbkStringRequestBodyConverter implements Converter<String, RequestBody> {
    static final GbkStringRequestBodyConverter INSTANCE = new GbkStringRequestBodyConverter();
    private static final MediaType MEDIA_TYPE = MediaType.parse("text/plain; charset=GBK");
    private static final Charset GBK = Charset.forName("GBK");

    private GbkStringRequestBodyConverter() {
    }

    @Override
    public RequestBody convert(String value) throws IOException {
        Buffer buffer = new Buffer();
        Writer writer = new OutputStreamWriter(buffer.outputStream(), GBK);
        writer.write(value);
        writer.close();
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }
}
