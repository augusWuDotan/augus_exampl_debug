package com.wdtpr.augus.debugnetexample.base.network.progress;

import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/**
 * Created by augus on 2017/12/8.
 * 計算 進度 工具類
 */

public class ProgressResponseBody extends ResponseBody {

    //傳遞進來的response 響應體
    private final ResponseBody responseBody;
    //進度 回調
    private final ProgressBackListener progressBackListener;
    //包装完成的BufferedSource
    private BufferedSource bufferedSource;

    /**
     * 建構
     *
     * @param responseBody
     * @param progressBackListener
     */
    public ProgressResponseBody(ResponseBody responseBody, ProgressBackListener progressBackListener) {
        this.responseBody = responseBody;
        this.progressBackListener = progressBackListener;
        LogUtils.d("讀取 responseBody：" + responseBody.toString());
    }


    /**
     * 覆寫 ResponseBody MediaType
     *
     * @return
     */
    @Override
    public MediaType contentType() {
        LogUtils.d("讀取 responseBody.contentType()：" + responseBody.contentType().toString());
        return responseBody.contentType();
    }

    @Override
    public long contentLength() {
        LogUtils.d("讀取 responseBody.contentLength()：" + responseBody.contentLength());
        return responseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (bufferedSource == null) {
            //重新包裝
            bufferedSource = Okio.buffer(source(responseBody.source()));
        }
        return bufferedSource;
    }


    /**
     * 擷取讀取狀況
     *
     * @param source
     * @return
     */
    private Source source(Source source) {
        return new ForwardingSource(source) {
            //讀取現在的字元數
            long totalBytesRead = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                LogUtils.d("讀取 byteCount ：" + byteCount);
                LogUtils.d("讀取 bytesRead：" + bytesRead);

                //讀取現在的字元數，讀取結束會返回-1
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;

                if(responseBody.contentLength() == -1 && byteCount>bytesRead){
                    //資料量少於一次可以讀取量
                    progressBackListener.onProgress(totalBytesRead, totalBytesRead, responseBody.contentLength() == -1);
                }else{
                    //資料量大於一次可以讀取量
                    progressBackListener.onProgress(totalBytesRead, responseBody.contentLength(), responseBody.contentLength() == -1);
                }

                return bytesRead;
            }

            @Override
            public Timeout timeout() {
                return super.timeout();
            }

            @Override
            public void close() throws IOException {
                super.close();
            }

            @Override
            public String toString() {
                return super.toString();
            }


        };
    }
}
