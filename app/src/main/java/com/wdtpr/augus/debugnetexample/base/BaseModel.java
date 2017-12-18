package com.wdtpr.augus.debugnetexample.base;

import com.wdtpr.augus.debugnetexample.base.network.DisposableManager;

/**
 * Created by augus on 2017/12/2.
 */

public class BaseModel {
    protected DisposableManager disposableManager;

    public BaseModel() {
        disposableManager = DisposableManager.instance();
    }
}
