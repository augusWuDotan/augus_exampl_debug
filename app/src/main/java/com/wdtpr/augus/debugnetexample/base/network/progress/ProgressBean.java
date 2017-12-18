package com.wdtpr.augus.debugnetexample.base.network.progress;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/9.
 * //下載｜上傳 進度 資料結構
 */

public class ProgressBean implements Serializable {

    private long readByte;//已經讀取的資料量
    private long totalByte;//所有資料量
    private boolean done;//是否下載完畢

    public long getReadByte() {
        return readByte;
    }

    public void setReadByte(long readByte) {
        this.readByte = readByte;
    }

    public long getTotalByte() {
        return totalByte;
    }

    public void setTotalByte(long totalByte) {
        this.totalByte = totalByte;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ProgressBean{" +
                "readByte=" + readByte +
                ", totalByte=" + totalByte +
                ", done=" + done +
                '}';
    }
}
