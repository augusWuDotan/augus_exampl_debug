package com.wdtpr.augus.spellkeyboard.utils;

import android.view.View;

/**
 * Created by augus on 2018/1/15.
 */

public class UI {
    public static int resolveSize(int size, int measureSpec) {
        int result = size;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case View.MeasureSpec.UNSPECIFIED:
                result = size;
                break;
            case View.MeasureSpec.AT_MOST:
                result = Math.min(size, specSize);
                break;
            case View.MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }
}
