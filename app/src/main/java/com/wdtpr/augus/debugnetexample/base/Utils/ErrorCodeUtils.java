package com.wdtpr.augus.debugnetexample.base.Utils;

/**
 * Created by augus on 2017/12/14.
 */

public class ErrorCodeUtils {

    public static String getErrorCallBack(int code){
        switch (code) {
            case 400:
            case 401:
            case 403:
                return "資訊錯誤";
            case 406:
                return "找不到使用者資訊";
            case 422:
                return "傳送資訊錯誤";
            default:
               return "";
        }
    }
}
