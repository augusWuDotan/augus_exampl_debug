package com.wdtpr.augus.debugnetexample.base.network.progress;

import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by augus on 2017/12/9.
 * //協調上傳 下載 進度監聽 工具類
 */

public class ProgressHelper {
    //
    private static ProgressBean progressBean = new ProgressBean();
    private static ProgressHandler mProgressHandler;//回調UI

    public static void setProgressHandler(ProgressHandler progressHandler) {
        mProgressHandler = progressHandler;
    }


    public static OkHttpClient addProgressDownLoadBuilder(OkHttpClient.Builder builder) {
        if (builder == null) {
            builder = new OkHttpClient.Builder();
        }

        //進度 回調
        final ProgressBackListener progressBackListener = new ProgressBackListener() {
            // 该方法在子线程中运行
            @Override
            public void onProgress(long progress, long total, boolean done) {
                LogUtils.e("progress: " + String.format("%d%% \n", (100 * progress) / total));
                if (mProgressHandler == null) {
                    return;
                }
                progressBean.setReadByte(progress);
                progressBean.setTotalByte(total);
                progressBean.setDone(done);
                mProgressHandler.sendMessage(progressBean);
            }
        };

        //攔截 response 傳遞訊息
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拦截
                Response mResponse = chain.proceed(chain.request());
                //包装响应体并返回
                return mResponse.newBuilder()
                        .body(new ProgressResponseBody(mResponse.body(), progressBackListener))
                        .build();
            }
        });


        return builder.build();
    }




}
