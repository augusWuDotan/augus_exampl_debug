package com.wdtpr.augus.debugnetexample.camplay.model.bean.source.dynamic;

/**
 * Created by augus on 2017/12/5.
 */

public interface IDynamicModel {

    void getDynamicAndBloger(String token, String accountToken, int PageNum, int Member_ID);

    void GetActiveMessage(String token,String accountToken,int Member_ID,int PageNum);

    void GetActiveMessageByBloger(String token,String accountToken,int Member_ID,int PageNum,int Bloger_ID);

    void GetActiveMessageByActiveID(String token,String accountToken,int Member_ID,int Active_ID);
}
