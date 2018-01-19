package com.wdtpr.augus.spellkeyboard.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;

import java.math.BigDecimal;

/**
 * Created by augus on 2018/1/19.
 */

public class BitmapUtils {
    /**
     * 計算比例縮小 圖示
     *
     * @param scaleBitmap [放大或是縮小圖檔]
     * @param itemHW      //設定長寬
     * @return 圖示
     */
    public  static Bitmap scaleBitmap(Bitmap scaleBitmap, int itemHW) {
        float scale;
        float scalew = new BigDecimal((float) itemHW / (float) scaleBitmap.getWidth()).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
        float scaleH = new BigDecimal((float) itemHW / (float) scaleBitmap.getHeight()).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
        scale = scalew > scaleH ? scaleH : scalew;
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale); //长和宽放大缩小的比例
        LogUtils.d("寬[放大或是縮效後]:" + itemHW + " , 寬[原圖]:" + scaleBitmap.getWidth() +" ; "
                +"高[放大或是縮效後]:" + itemHW + " , 高[原圖]:" + scaleBitmap.getHeight()+" ; "+"放大或是縮小比例:" + scale);
        return Bitmap.createBitmap(scaleBitmap, 0, 0, scaleBitmap.getWidth(), scaleBitmap.getHeight(), matrix, true);
    }
}
