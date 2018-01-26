package com.wdtpr.augus.ranking.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;

/**
 * Created by Ray on 2017/6/15.
 * Utils
 */

public final class Utils {

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

    public static String bitmapToBase64Str(String sourcePath, int reqWidth, int reqHeight) {
        // 照片編碼(Base64)字串格式
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(sourcePath, options);
        options.inSampleSize = calculateFitSize(reqWidth, reqHeight, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;

        Bitmap dst = BitmapFactory.decodeFile(sourcePath, options);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        dst.compress(Bitmap.CompressFormat.JPEG, 80, os);
        byte[] bytes = os.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public static Bitmap pathGetbitmap(String sourcePath, int reqWidth, int reqHeight) {
        // 照片編碼(Base64)字串格式
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(sourcePath, options);
        options.inSampleSize = calculateFitSize(reqWidth, reqHeight, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(sourcePath, options);
    }


    public static void hideStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private static int calculateFitSize(int reqWidth, int reqHeight, BitmapFactory.Options options) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    /**
     * 手機門號檢查程式
     *
     */
    public static final Pattern MSISDN_PATTERN = Pattern
            .compile("[+-]?\\d{10,12}");

    public static boolean isValidMSISDN(String msisdn) {
        boolean result = false;
        if (MSISDN_PATTERN.matcher(msisdn).matches()) {
            result = true;
        }
        return result;
    }
}
