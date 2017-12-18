package com.wdtpr.augus.debugnetexample.facebook.Model.bean.setting;

import java.util.List;

/**
 * Created by augus on 2017/12/14.
 * fb permission 申請權限bean
 */

public class FBPermission {

    private List<String> Publish ;
    private List<String> read ;

    public List<String> getPublish() {
        return Publish;
    }

    public void setPublish(List<String> publish) {
        Publish = publish;
    }

    public List<String> getRead() {
        return read;
    }

    public void setRead(List<String> read) {
        this.read = read;
    }
}
