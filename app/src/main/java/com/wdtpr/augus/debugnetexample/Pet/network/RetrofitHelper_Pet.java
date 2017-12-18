package com.wdtpr.augus.debugnetexample.Pet.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wdtpr.augus.debugnetexample.Pet.api.APIURLHelper;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.common_type.Components;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;
import com.wdtpr.augus.debugnetexample.base.network.progress.ProgressHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by augus on 2017/12/2.
 */

public class RetrofitHelper_Pet {
    private static volatile RetrofitHelper_Pet apiHelper;
    private static final int CONNECTTIMEOUT = 2 * 5;
    private static final int WRITETIMEOUT = 2 * 5;
    private static final int READTIMEOUT = 6 * 5;
    private Retrofit.Builder retrofit;

    public static RetrofitHelper_Pet instance() {
        if (apiHelper == null) {
            synchronized (RetrofitHelper_Pet.class) {
                if (apiHelper == null) {
                    apiHelper = new RetrofitHelper_Pet();
                }
            }
        }
        return apiHelper;
    }

    //
    public RetrofitHelper_Pet() {
        retrofit = RetrofitBuilder();
    }

    private static OkHttpClient.Builder OkHttpClientBuilder() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                //超時
                .connectTimeout(CONNECTTIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITETIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READTIMEOUT, TimeUnit.SECONDS)
                // 發布時，要mark 紀錄日誌
                .addNetworkInterceptor(interceptor);
                //錯誤重新連接
//                .retryOnConnectionFailure(true);

        return builder;
    }

    private static Gson gson() {
        Gson gson = new GsonBuilder()
                // 拓展Gson用法，對於null做處理
                .registerTypeAdapter(String.class, new StringAdapter())
                .registerTypeAdapter(Integer.class, new IntegerAdapter())
                .registerTypeAdapter(Components.class,new Components.ComponentsDeserializer())
                .serializeNulls()
                .create();
        return gson;
    }


    private static Retrofit.Builder RetrofitBuilder() {
        Retrofit.Builder retrofit = new Retrofit.Builder()
                .baseUrl(APIURLHelper.DOMAIN)
                .client(OkHttpClientBuilder().build())
                .addConverterFactory(GsonConverterFactory.create(gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return retrofit;
    }

    //一般
    public <T> T create(Class<T> service) {
        return retrofit.build().create(service);
    }

    //下載進度監聽
    public <T> T createForProgress(Class<T> service) {

        return retrofit
                .client(ProgressHelper.addProgressDownLoadBuilder(OkHttpClientBuilder()))
                .build()
                .create(service);

    }


    private static class StringAdapter extends TypeAdapter<String> {

        @Override
        public void write(JsonWriter out, String value) throws IOException {
            out.value(value);
            Log.d("RetrofitHelper:", value);
        }

        @Override
        public String read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return "";
            }
            return in.nextString();
        }
    }

    private static class IntegerAdapter extends TypeAdapter<Integer> {

        @Override
        public void write(JsonWriter out, Integer value) throws IOException {
            out.value(value);
            Log.d("RetrofitHelper:", value + "");
        }

        @Override
        public Integer read(JsonReader in) throws IOException {
            try {
                return Integer.parseInt(in.nextString());
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    private class T {
    }
}
