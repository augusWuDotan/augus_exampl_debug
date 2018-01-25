package com.wdtpr.augus.debugnetexample.base;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;
import com.wdtpr.augus.debugnetexample.base.Utils.DisplayUtils;
import com.wdtpr.augus.debugnetexample.base.network.DisposableManager;

/**
 * Created by augus on 2017/12/2.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());

        mContext = getApplicationContext();//取得 context

        DisposableManager.instance();

        // Display
        DisplayUtils.instance(getApplicationContext());
    }

    public static Context getContext(){
        return mContext;
    }
}
