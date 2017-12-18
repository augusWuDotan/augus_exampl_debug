package com.wdtpr.augus.debugnetexample.base.network.progress;

import android.os.Looper;
import android.os.Message;

/**
 * Created by augus on 2017/12/9.
 */

public abstract class DownLoadProgressHandler extends ProgressHandler {

    private static final int DOWNLOAD_PROGRESS = 1;

    protected ResponseHandler handler = new ResponseHandler(this, Looper.getMainLooper());

    @Override
    protected void sendMessage(ProgressBean progressBean) {
        handler.obtainMessage(DOWNLOAD_PROGRESS,progressBean).sendToTarget();
    }

    @Override
    protected void handleMessage(Message message) {
        switch (message.what) {
            case DOWNLOAD_PROGRESS:
                ProgressBean progressBean = (ProgressBean) message.obj;
                onProgress(progressBean.getReadByte(), progressBean.getTotalByte(), progressBean.isDone());
        }
    }
}
