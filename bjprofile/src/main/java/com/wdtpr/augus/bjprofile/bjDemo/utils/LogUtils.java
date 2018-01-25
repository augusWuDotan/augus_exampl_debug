package com.wdtpr.augus.bjprofile.bjDemo.utils;

import android.util.Log;

/**
 * Created by augus on 2017/12/9.
 */

public class LogUtils {

    private final static boolean DEBUG = true;
    private final static String  LOG_TAG = "BJ";

    public static void v(String msg) {
        if (DEBUG) {
            Log.v(LOG_TAG, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void d(String msg) {
        if (DEBUG) {
            Log.d(LOG_TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String msg) {
        if (DEBUG) {
            Log.i(LOG_TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void w(String msg) {
        if (DEBUG) {
            Log.w(LOG_TAG, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void e(String msg) {
        if (DEBUG) {
            Log.e(LOG_TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }


}
