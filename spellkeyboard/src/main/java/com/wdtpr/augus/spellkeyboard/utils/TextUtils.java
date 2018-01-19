package com.wdtpr.augus.spellkeyboard.utils;

import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by augus on 2018/1/19.
 */

public class TextUtils {

    /**
     * 字體自適應
     */
    public static void setTextSizeForWidth(Paint paint, float desiredHeight) {

        // Pick a reasonably large value for the test. Larger values produce
        // more accurate results, but may cause problems with hardware
        // acceleration. But there are workarounds for that, too; refer to
        // http://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
        /**
         * 預設 paint字體大小
         */
        final float testTextSize = 12f;
        /**
         * 依據字體
         */
        String accordText = "n";

        /**
         * 確認 paint填寫的範圍 rect
         */
        paint.setTextSize(testTextSize);
        Rect bounds = new Rect();
        paint.getTextBounds(accordText, 0, accordText.length(), bounds);


        /**
         * Calculate the desired size as a proportion of our testTextSize.
         * 重新計算 使用字體的大小
         * desiredTextSizer = 計算後字體大小
         */
        float desiredTextSize = testTextSize * desiredHeight / bounds.height() * 2 / 5;
        LogUtils.d("paint 字體大小: " + desiredTextSize);

        /**
         * Set the paint for that size.
         * 設定字體大小
         */
        paint.setTextSize(desiredTextSize);
    }
}
