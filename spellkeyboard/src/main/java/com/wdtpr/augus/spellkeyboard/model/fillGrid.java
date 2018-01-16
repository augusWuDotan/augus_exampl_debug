package com.wdtpr.augus.spellkeyboard.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.io.Serializable;

/**
 * Created by augus on 2018/1/15.
 */

public class fillGrid implements Serializable {
    public String Action_Fillgrid = "fillgrid";//格子
    public String Action_Space = "Space";//空格

    private String content;
    private String Action;//使用資料型態 [keyboard,Back]
    private Rect mDrawRect;//繪製的範圍 [答案格位置]
    private Bitmap showBitmap;//繪製的圖版底//尚未使用
    private Canvas mCanvas;//繪製//尚未使用
    private boolean isUse = false;//是否被用過//預設false
    private float startX;//開始x座標
    private float startY;//開始Ｙ座標

    @Override
    public String toString() {
        return "fillGrid{" +
                "Action_Fillgrid='" + Action_Fillgrid + '\'' +
                ", Action_Space='" + Action_Space + '\'' +
                ", content='" + content + '\'' +
                ", Action='" + Action + '\'' +
                ", mDrawRect=" + mDrawRect +
                ", showBitmap=" + showBitmap +
                ", mCanvas=" + mCanvas +
                ", isUse=" + isUse +
                ", startX=" + startX +
                ", startY=" + startY +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public Rect getmDrawRect() {
        return mDrawRect;
    }

    public void setmDrawRect(Rect mDrawRect) {
        this.mDrawRect = mDrawRect;
    }

    public Bitmap getShowBitmap() {
        return showBitmap;
    }

    public void setShowBitmap(Bitmap showBitmap) {
        this.showBitmap = showBitmap;
    }

    public Canvas getmCanvas() {
        return mCanvas;
    }

    public void setmCanvas(Canvas mCanvas) {
        this.mCanvas = mCanvas;
    }
}
