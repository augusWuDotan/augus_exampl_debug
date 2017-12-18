package com.wdtpr.augus.debugnetexample.camplay.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wdtpr.augus.debugnetexample.camplay.api.Api;
import com.wdtpr.augus.debugnetexample.camplay.api.ApiUrlHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ray on 2017/8/14.
 * RetrofitHelper
 */

public class RetrofitHelper {
    private static volatile RetrofitHelper apiHelper;
    private static final int TIME = 100 * 5;
    private Retrofit retrofit;

    private RetrofitHelper() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIME, TimeUnit.SECONDS)
                .writeTimeout(TIME, TimeUnit.SECONDS)
                .readTimeout(TIME, TimeUnit.SECONDS)
                // 發布時，要mark
                .addNetworkInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .build();

        Gson gson = new GsonBuilder()
                // 拓展Gson用法，對於null做處理
                .registerTypeAdapter(String.class, new StringAdapter())
                .registerTypeAdapter(Integer.class, new IntegerAdapter())
                .create();


        retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrlHelper.DOMAIN)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitHelper instance() {
        if (apiHelper == null) {
            synchronized (RetrofitHelper.class) {
                if (apiHelper == null) {
                    apiHelper = new RetrofitHelper();
                }
            }
        }
        return apiHelper;
    }

    public Api create() {
        return retrofit.create(Api.class);
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

    private static class ListAdapter extends TypeAdapter {

        @Override
        public void write(JsonWriter out, Object value) throws IOException {

        }

        @Override
        public Object read(JsonReader in) throws IOException {
            return null;
        }
    }
}
