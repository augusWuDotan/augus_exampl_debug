package com.wdtpr.augus.debugnetexample.base.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by augus on 2016/12/2.
 * DisplayUtils
 */

public final class DisplayUtils {
    private static final String TAG = DisplayUtils.class.getSimpleName();
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private static DisplayMetrics metrics;

    private DisplayUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void instance(Context context) {
        DisplayUtils.context = context.getApplicationContext();
        metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);
    }

    public static int getSreenW() {
        return metrics.widthPixels;
    }

    public static int getSreenH() {
        return metrics.heightPixels;
    }

    public static float getDensity() {

        return metrics.density;
    }

    public static int dp2Px(int dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
//        Log.d("scale",(int) (dpValue * scale + 0.5f)+"");
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
