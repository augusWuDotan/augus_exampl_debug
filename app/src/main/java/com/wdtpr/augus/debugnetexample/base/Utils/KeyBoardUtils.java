package com.wdtpr.augus.debugnetexample.base.Utils;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by augus on 2017/12/2.
 */

public class KeyBoardUtils {

    public static void hideSoftKeyBoardByClick(final Context context, View view) {
        // 點擊空白處，隱藏軟鍵盤
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return false;
            }
        });
    }

    /**
     * 只會關閉鍵盤
     *
     * @param context
     */
    public static void hideSoftKeyBoard(Context context, View view) {
        //
        // 當鍵盤是關閉狀態，就會開啟。反之亦然
        InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showOrHideSoftKeyBoard(Context context) {
        // 當鍵盤是關閉狀態，就會開啟。反之亦然
        InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
