package com.wdtpr.augus.ranking;



/**
 * Created by augus on 2017/12/2.
 */

public class BaseModel {
    protected DisposableManager disposableManager;

    public BaseModel() {
        disposableManager = DisposableManager.instance();
    }
}
