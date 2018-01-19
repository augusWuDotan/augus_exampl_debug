package com.wdtpr.augus.spellkeyboard.model.bean;

import android.graphics.Rect;

import java.io.Serializable;

/**
 * Created by augus on 2018/1/15.
 */

public class fillGrid implements Serializable {
    public static String Action_Fillgrid = "fillgrid";//格子
    public static String Action_Space = "Space";//空格

    private String content;
    private String Action;//使用資料型態 [keyboard,Back]
    private Rect mDrawRect;//繪製的範圍 [答案格位置]
    private float startX;//開始x座標
    private float startY;//開始Ｙ座標

    private boolean isUse = false;//是否被用過//預設false
    private Rect answerRect;//答案的範圍
    private int answerIndex;//答案使用的是 keyboardlist 的 哪一個 index

    private boolean isAdd;//是否執行 填空動畫
    private boolean isClear;//是否執行 清除動畫
    private boolean isAnim;//動畫是否執行
    private boolean isMove;//是否隨答案滑動
    private boolean isAnimStart;//動畫使否初始化
    private int AnimateValue = 0;//動畫進度  0-100
    private Rect LocusStartRect;//動畫開始範圍
    private Rect LocusEndRect;//動畫結束範圍
    private float percentage = 0;//執行百分比
    private boolean animFinished;//動畫結束呼叫

    @Override
    public String toString() {
        return "fillGrid{" +
                "content='" + content + '\'' +
                ", Action='" + Action + '\'' +
                ", mDrawRect=" + mDrawRect +
                ", startX=" + startX +
                ", startY=" + startY +
                ", isUse=" + isUse +
                ", answerRect=" + answerRect +
                ", isAdd=" + isAdd +
                ", isClear=" + isClear +
                ", isAnim=" + isAnim +
                ", LocusStartRect=" + LocusStartRect +
                ", LocusEndRect=" + LocusEndRect +
                ", percentage=" + percentage +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    public Rect getAnswerRect() {
        return answerRect;
    }

    public void setAnswerRect(Rect answerRect) {
        this.answerRect = answerRect;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }

    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean clear) {
        isClear = clear;
    }

    public boolean isAnim() {
        return isAnim;
    }

    public void setAnim(boolean anim) {
        isAnim = anim;
    }

    public int getAnimateValue() {
        return AnimateValue;
    }

    public void setAnimateValue(int animateValue) {
        AnimateValue = animateValue;
    }

    public Rect getLocusStartRect() {
        return LocusStartRect;
    }

    public void setLocusStartRect(Rect locusStartRect) {
        LocusStartRect = locusStartRect;
    }

    public Rect getLocusEndRect() {
        return LocusEndRect;
    }

    public void setLocusEndRect(Rect locusEndRect) {
        LocusEndRect = locusEndRect;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public boolean isAnimFinished() {
        return animFinished;
    }

    public void setAnimFinished(boolean animFinished) {
        this.animFinished = animFinished;
    }

    public boolean isAnimStart() {
        return isAnimStart;
    }

    public void setAnimStart(boolean animStart) {
        isAnimStart = animStart;
    }

    public boolean isMove() {
        return isMove;
    }

    public void setMove(boolean move) {
        isMove = move;
    }
}
