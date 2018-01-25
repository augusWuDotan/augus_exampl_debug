package com.wdtpr.augus.ranking;

/**
 * Created by augus on 2017/12/2.
 */

public interface IBaseView {

    void showLoading();

    void hideLoading();

    void showUnknowError(String errorStr);

//    void progressCode(int code);
}
