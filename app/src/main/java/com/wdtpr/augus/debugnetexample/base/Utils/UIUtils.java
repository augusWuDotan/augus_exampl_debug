package com.wdtpr.augus.debugnetexample.base.Utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

import com.wdtpr.augus.debugnetexample.base.BaseApplication;

/**
 * Created by augus on 2017/12/8.
 * UI 工具類
 * [Context | View ]
 * [Resources]
 * [Stirng | String[] ]
 * [Drawable]
 * [int color | ColorStateList]
 */

public class UIUtils {

    /**
     * 取得 context
     * @return
     */
    public static Context getContext() {
        return BaseApplication.getContext();
    }

    /**
     * 獲取佈局
     * @param resId
     * @return
     */
    public static View inflate(int resId) {
        return LayoutInflater.from(getContext()).inflate(resId, null);
    }

    /**
     * 獲取資源
     * @return
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 獲取字串
     * @param resId
     * @return
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }


    /**
     * 獲取String陣列
     * @param resId
     * @return
     */
    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 獲取 dimen
     * @param resId
     * @return
     */
    public static int getDimens(int resId) {
        return getResources().getDimensionPixelSize(resId);
    }


    /**
     * 獲取Drawable
     * @param resId
     * @return
     */
    public static Drawable getDrawable(int resId) {
        return getResources().getDrawable(resId);
    }


    /**
     * 獲取顏色
     * @param resId
     * @return
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }


    /**
     * 獲取顏色選擇器
     * @param resId
     * @return
     */
    public static ColorStateList getColorStateList(int resId) {
        return getResources().getColorStateList(resId);
    }

}
