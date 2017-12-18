package com.wdtpr.augus.debugnetexample.base.network.progress;

/**
 * Created by augus on 2017/12/9.
 * response 回傳進度 [供給 上傳下載]
 */

public interface ProgressBackListener {
    /**
     *
     * @param progress  已經上傳或下載資料量
     * @param total     總資料量
     * @param done      是否完成
     */
    void onProgress(long progress, long total, boolean done);
}
