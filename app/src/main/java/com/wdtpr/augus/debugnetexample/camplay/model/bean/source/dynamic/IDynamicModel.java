package com.wdtpr.augus.debugnetexample.camplay.model.bean.source.dynamic;

import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.order.ProductOrderBean;

/**
 * Created by augus on 2017/12/5.
 */

public interface IDynamicModel {

    void getDynamicAndBloger(String token, String accountToken, int PageNum, int Member_ID);

    void GetActiveMessage(String token,String accountToken,int Member_ID,int PageNum);

    void GetActiveMessageByBloger(String token,String accountToken,int Member_ID,int PageNum,int Bloger_ID);

    void GetActiveMessageByActiveID(String token,String accountToken,int Member_ID,int Active_ID);

    //送出訂單
    void AddOrder(String token, String AccessToken, ProductOrderBean bean);
}
