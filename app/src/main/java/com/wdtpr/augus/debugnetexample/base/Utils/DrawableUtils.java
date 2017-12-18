package com.wdtpr.augus.debugnetexample.base.Utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.support.annotation.ColorInt;

/**
 * Created by augus on 2017/12/2.
 * DrawableUtils
 * 繪製圖形
 */

public final class DrawableUtils {

    /**
     * 正常來說這個會用在正方形 > 圓形
     * error狀況 如果 width < height  弧度預設 height/2 則會報錯
     * \\canvas.drawRoundRect(rectF, height / 2, height / 2, paint);\\
     * @param color
     * @return
     */
    public static ShapeDrawable backgroundDrawable(@ColorInt final int color) {
        return new ShapeDrawable(new Shape() {
            @Override
            public void draw(Canvas canvas, Paint paint) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                paint.setAntiAlias(true);
                paint.setDither(true);
                paint.setColor(color);
                paint.setStyle(Paint.Style.FILL);
                RectF rectF = new RectF(0, 0, width, height);
                canvas.drawRoundRect(rectF, height / 2, height / 2, paint);
            }
        });
    }

    /**
     * 重繪 矩形圓角 by augus
     * @param color
     * @param radius 弧度
     * @return
     */
    public static ShapeDrawable backgroundDrawable(@ColorInt final int color, final int radius) {
        return new ShapeDrawable(new Shape() {
            @Override
            public void draw(Canvas canvas, Paint paint) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                paint.setAntiAlias(true);
                paint.setDither(true);
                paint.setColor(color);
                paint.setStyle(Paint.Style.FILL);
                RectF rectF = new RectF(0, 0, width, height);
                canvas.drawRoundRect(rectF, radius, radius, paint);
            }
        });
    }
}
