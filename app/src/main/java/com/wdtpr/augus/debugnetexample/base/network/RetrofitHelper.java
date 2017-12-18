package com.wdtpr.augus.debugnetexample.base.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wdtpr.augus.debugnetexample.base.api.API;
import com.wdtpr.augus.debugnetexample.base.api.APIURLHelper;
import com.wdtpr.augus.debugnetexample.base.network.progress.ProgressHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by augus on 2017/12/2.
 */

public class RetrofitHelper {
    private static volatile RetrofitHelper apiHelper;
    private static final int CONNECTTIMEOUT = 3 * 5;
    private static final int WRITETIMEOUT = 4 * 5;
    private static final int READTIMEOUT = 4 * 5;
    private Retrofit.Builder retrofit;


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

    //
    public RetrofitHelper() {
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
                .addNetworkInterceptor(interceptor)
                //錯誤重新連接
                .retryOnConnectionFailure(true);

        return builder;
    }

    private static Gson gson() {
        Gson gson = new GsonBuilder()
                // 拓展Gson用法，對於null做處理
                .registerTypeAdapter(String.class, new StringAdapter())
                .registerTypeAdapter(Integer.class,new IntegerAdapter())
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



    public API create() {

        return retrofit.build().create(API.class);
    }

    public API createForProgress() {

        return retrofit
                .client(ProgressHelper.addProgressDownLoadBuilder(OkHttpClientBuilder()))
                .build()
                .create(API.class);

    }

    private static class StringAdapter extends TypeAdapter<String> {

        @Override
        public void write(JsonWriter out, String value) throws IOException {
            out.value(value);
            Log.d("RetrofitHelper:",value);
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
            Log.d("RetrofitHelper:",value+"");
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

}
