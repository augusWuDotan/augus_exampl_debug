package com.wdtpr.augus.debugnetexample.base.Gson;

import com.google.gson.Gson;

/**
 * Created by augus on 2017/12/2.
 * GsonHelper
 */

public final class GsonHelper {
    private static GsonHelper gsonHelper;
    private static Gson gson;

    private GsonHelper() {
    }

    public static GsonHelper instance() {
        if (gsonHelper == null) {
            synchronized (GsonHelper.class) {
                if (gsonHelper == null) {
                    gsonHelper = new GsonHelper();
                    gson = new Gson();
                }
            }
        }
        return gsonHelper;
    }

    public String jsonStr(Object o) {
        String str = null;
        if (gson != null) {
            str = gson.toJson(o);
        }
        return str;
    }
}
