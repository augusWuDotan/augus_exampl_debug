package com.wdtpr.augus.spellkeyboard.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.wdtpr.augus.spellkeyboard.R;
import com.wdtpr.augus.spellkeyboard.model.fillGrid;
import com.wdtpr.augus.spellkeyboard.model.keyboard;
import com.wdtpr.augus.spellkeyboard.utils.LogUtils;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by augus on 2018/1/15.
 * Spell 鍵盤區域
 */

public class SpellKeyBoard extends View {
    /**
     * 畫筆
     * mTextPaint 文字
     * mKeyboardPaint 鍵盤
     * mContextPaint 顯示
     */
    private Paint mContextPaint;
    private Paint mTextPaint;
    private Paint mKeyboardPaint;
    private Paint mFillGridPaint;

    /**
     * 傳入版型 ["1","2"]
     */
    private String version;
    /**
     * 畫布底版
     */
    private Canvas mCanvas;//母體

    private Bitmap mBitmap;//母體底圖

    /**
     * 字體
     */
    Typeface mfont;
    /**
     * 佈局 全局高 全局寬
     */
    private int SpellKeyBoardH;

    private int SpellKeyBoardW;
    /**
     * 傳入的答案
     */
    private String answer;
    /**
     * 傳入的答案長度含空格
     */
    private int answerlength;

    /**
     * 傳入的答案長度 不含空格
     */
    private int answerNonSpacelength;

    /**
     * 鍵盤按鍵數量
     */
    private int KeyBoardNum = 18;
    /**
     * 鍵盤每一層按鍵數量
     */
    private int KeyBoardLevelNum;
    /**
     * 鍵盤按鍵區域 寬度
     */
    private int KeyBoardW;
    /**
     * 鍵盤按鍵區域 高度
     */
    private int KeyBoardH;
    /**
     * 鍵盤按鍵區域 margin TOP BOTTOM
     * //先算 物件高度 三行   [剩下高度/2]
     */
    private int KeyBoardMTB;
    /**
     * 鍵盤按鍵區域 margin Left Right
     * //先算 物件高度 6 or 4   [剩下寬度/2]
     */
    private int KeyBoardMRL;
    /**
     * 上一個點擊的 按鍵 index
     */
    private int KeyBoardItemPreviousIndex = -1;


    /**
     * 填寫區域 寬度
     */
    private int fillGridW;
    /**
     * 填寫區域 高度
     */
    private int fillGridH;
    /**
     * 填寫區域 margin Left Right
     * //先算 物件寬度 加總 加上 寬度間隔加總 [剩下寬度/2]
     */
    private int fillGridMRL;
    /**
     * 填寫區域 margin TOP BOTTOM
     * //先算 物件高度 僅一行  [剩下寬度/2]
     */
    private int fillGridMTB;
    /**
     * 下一個使用的做答格子 index
     */
    private int fillGridUseNextIndex = 0;

    /**
     * 顯示 填寫格子 數量
     */
    private int fillGridNum;
    /**
     * 填寫格子 寬度
     */
    private int fillGridItemW;
    /**
     * 填寫格子 高度
     */
    private int fillGridItemH;
    /**
     * 填寫格子 margin spance 左右
     */
    private float fillGridItemSpace;
    /**
     * 大於鍵盤按鈕一點點的邊距
     */
    private float fillGridItemPadding = 1;

    /**
     * 按鍵 寬度
     */
    private int KeyBoardItemW;
    /**
     * 按鍵 高度
     */
    private int KeyBoardItemH;
    /**
     * 按鍵 spance 左右
     */
    private float KeyBoardItemSpaceRL = 10;
    /**
     * 按鍵 spance 上下
     */
    private float KeyBoardItemSpaceTB = 10;
    /**
     * normal點擊圖示 鍵盤
     */
    private Bitmap KeyBoardItemNormal;
    /**
     * touch點擊圖示 鍵盤
     */
    private Bitmap KeyBoardItemTouch;
    /**
     * 鍵盤 back normal
     */
    private Bitmap KeyboardItemBackOne;
    /**
     * 鍵盤 back press
     */
    private Bitmap KeyboardItemBackTwo;
    /**
     * 輸入框 normal
     */
    private Bitmap FillGridItemNormal;

    /**
     * 儲存現在 按鍵 的所有資訊
     */
    private List<keyboard> keyWords;
    /**
     * 儲存現在 填寫格子 的所有資訊
     */
    private List<fillGrid> fillGrids;
    /**
     * 答案紀錄
     */
    private List<Integer> answerList;
    /**
     * touch x 座標
     */
    private float touchX;
    /**
     * touch y 座標
     */
    private float touchY;
    /**
     * touch keyboard index
     */
    private int touchIndex;

    /**
     * 是否啟動 退後鍵
     */
    private boolean isBack = false;
    /**
     * 是否啟動 加入答案
     */
    private boolean isAdd = false;

    public SpellKeyBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LogUtils.d("SpellKeyBoard context");
//        setBackgroundColor(Color.TRANSPARENT);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.SpellKeyBoard);
        int normalKeyBoardItemRID = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_normalKeyboardItem, R.drawable.keyboard_normal);
        int touchKeyBoardItemRID = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_touchKeyboardItem, R.drawable.keyboard_press);
        int normalFillGridItemRID = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_normalFillGridItem, R.drawable.fillgrid_type1);
        int KeyboardItemBackOneRID = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_KeyboardItemBackOne, R.drawable.keyboard_back_normal);
        int KeyboardItemBackTwoRID = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_KeyboardItemBackTwo, R.drawable.keyboard_back_press);
        KeyBoardItemSpaceRL = mTypedArray.getDimension(R.styleable.SpellKeyBoard_KeyboardItemPadding, 10);
        KeyBoardItemSpaceTB = mTypedArray.getDimension(R.styleable.SpellKeyBoard_KeyboardItemPadding, 10);
        fillGridItemSpace = mTypedArray.getDimension(R.styleable.SpellKeyBoard_fillGridPaddingRL, 10);
        mTypedArray.recycle();
        LogUtils.d("normalKeyBoardItemRID:" + normalKeyBoardItemRID);
        LogUtils.d("touchKeyBoardItemRID:" + touchKeyBoardItemRID);
        LogUtils.d("normalFillGridItemRID:" + normalFillGridItemRID);
        LogUtils.d("KeyBoardItemSpaceRL:" + KeyBoardItemSpaceRL);
        LogUtils.d("KeyBoardItemSpaceTB:" + KeyBoardItemSpaceTB);
        LogUtils.d("fillGridItemSpace:" + fillGridItemSpace);
        /**
         * KeyBoardItemNormal、KeyBoardItemTouch 鍵盤使用圖片
         * FillGridItemNormal 填充格子使用圖片
         */
        KeyBoardItemNormal = BitmapFactory.decodeResource(getResources(), normalKeyBoardItemRID);
        KeyBoardItemTouch = BitmapFactory.decodeResource(getResources(), touchKeyBoardItemRID);
        FillGridItemNormal = BitmapFactory.decodeResource(getResources(), normalFillGridItemRID);
        KeyboardItemBackOne = BitmapFactory.decodeResource(getResources(), KeyboardItemBackOneRID);
        KeyboardItemBackTwo = BitmapFactory.decodeResource(getResources(), KeyboardItemBackTwoRID);
        LogUtils.d("KeyBoardItemNormal h: " + KeyBoardItemNormal.getHeight() + ", KeyBoardItemNormal W: " + KeyBoardItemNormal.getWidth());
        LogUtils.d("KeyBoardItemTouch h: " + KeyBoardItemTouch.getHeight() + ", KeyBoardItemTouch W: " + KeyBoardItemTouch.getWidth());
        LogUtils.d("FillGridItemNormal h: " + FillGridItemNormal.getHeight() + ", FillGridItemNormal W: " + FillGridItemNormal.getWidth());
        /**
         * 畫筆初始化
         */
        initPaint();

    }

    public void setAnswer(String answer) {
        this.answer = answer;
        this.answerlength = answer.length();//包含空格
        int length = 0;
        for (char c : answer.toCharArray()) {
            if (String.valueOf(c).equals(" ")) {
                //null
            } else {
                length++;
            }
        }
        this.answerNonSpacelength = length;//不包含空格

        LogUtils.d("answer:" + answer);
        LogUtils.d("answerlength :" + answerlength);
        LogUtils.d("answerNonSpacelength :" + answerNonSpacelength);
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setKeyBoardNum(int keyBoardNum) {
        this.KeyBoardNum = keyBoardNum;
        this.KeyBoardLevelNum = KeyBoardNum / 3;//每一層數量
        LogUtils.d("KeyBoardLevelNum: " + KeyBoardLevelNum);
    }

    /**
     * 畫筆初始化
     */
    private void initPaint() {
        //母體

        //文字
        mTextPaint = new Paint();
        mTextPaint.setColor(Color.YELLOW);
        mTextPaint.setAntiAlias(true);//防鋸齒
        mfont = Typeface.createFromAsset(getResources().getAssets(), "billy.otf");
        mTextPaint.setTypeface(mfont);//設定字體
        mTextPaint.setTextAlign(Paint.Align.CENTER);//繪製在中心點

        //鍵盤
        mKeyboardPaint = new Paint();
        mKeyboardPaint.setAntiAlias(true);

        //填充格子
        mFillGridPaint = new Paint();
        mFillGridPaint.setAntiAlias(true);

        mContextPaint = new Paint();
        mContextPaint.setAntiAlias(true);
        mContextPaint.setColor(Color.TRANSPARENT);
        mContextPaint.setStyle(Paint.Style.STROKE);
    }

    /**
     * 鍵盤建立
     */
    private void initKeyboardSize() {
        /**
         * 判斷 鍵盤按鈕 數量
         */
        if (KeyBoardNum == 18) {
            KeyBoardLevelNum = KeyBoardNum / 3; //6
            /**
             * 計算鍵盤佈局
             * 1080寬
             * 比例設定
             * (1080-(左右間距(10)*2*6))/6 = 160
             * if(((160+(10*2))*3) >  )
             */
            float itemW = new BigDecimal(((float) KeyBoardW - (float) (KeyBoardItemSpaceRL * 2 * 6)) / (float) 6).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
            LogUtils.d("itemW:" + String.valueOf((int) (itemW)));
            float allH = ((itemW) + (float) (10 * 2)) * 3;
            LogUtils.d("allH:" + (int) allH);
            if ((int) allH > KeyBoardH) {
                LogUtils.d(">KeyBoardH");
                //計算鍵盤長寬
                float itemH = new BigDecimal(((float) KeyBoardH - (float) (KeyBoardItemSpaceTB * 2 * 3)) / (float) 3).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                LogUtils.d("itemH:" + String.valueOf((int) (itemH + 0.5f)));
                KeyBoardItemH = (int) itemH;
                KeyBoardItemW = (int) itemH;
                //計算佈局 1. 鍵盤區域 上下 左右間距
                float MRL = new BigDecimal((SpellKeyBoardW - ((float) (KeyBoardItemW + (KeyBoardItemSpaceRL * 2)) * 6) + (KeyBoardItemSpaceRL)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                float MTB = new BigDecimal((KeyBoardH - ((float) (KeyBoardItemH + (KeyBoardItemSpaceTB * 2)) * 3)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                LogUtils.d("MRL:" + String.valueOf((int) (MRL)));
                KeyBoardMTB = (int) MTB;
                KeyBoardMRL = (int) MRL;
                LogUtils.d("KeyBoardMTB: " + KeyBoardMTB + ", KeyBoardMRL: " + KeyBoardMRL);
            } else {
                LogUtils.d("<KeyBoardH");
                //計算鍵盤長寬
                LogUtils.d("itemW:" + String.valueOf((int) (itemW + 0.5f)));
                KeyBoardItemH = (int) itemW;
                KeyBoardItemW = (int) itemW;
                //計算佈局 1. 鍵盤區域 上下 左右間距
                float MRL = new BigDecimal((SpellKeyBoardW - ((float) (KeyBoardItemW + (KeyBoardItemSpaceRL * 2)) * 6) + (KeyBoardItemSpaceRL)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                float MTB = new BigDecimal((KeyBoardH - ((float) (KeyBoardItemH + (KeyBoardItemSpaceTB * 2)) * 3)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                LogUtils.d("MTB:" + String.valueOf((int) (MTB + 0.5f)));
                KeyBoardMTB = (int) MTB;
                KeyBoardMRL = (int) MRL;
                LogUtils.d("KeyBoardMTB: " + KeyBoardMTB + ", KeyBoardMRL: " + KeyBoardMRL);
            }
        } else {
            KeyBoardLevelNum = KeyBoardNum / 3; //4
            /**
             * 計算鍵盤佈局
             * 1080寬
             * 比例設定
             * (1080-(左右間距(10)*2*4))/4 = 250
             * if(((250+(10*2))*3) > )
             */
            float itemW = new BigDecimal(((float) KeyBoardW - (float) (KeyBoardItemSpaceRL * 2 * 4)) / (float) 4).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
            LogUtils.d("itemW:" + String.valueOf((int) (itemW + 0.5f)));
            float allH = ((itemW + 0.5f) + (float) (10 * 2)) * 3;
            LogUtils.d("allH:" + (int) allH);
            if ((int) allH > KeyBoardH) {
                LogUtils.d(">KeyBoardH");
                //計算鍵盤長寬
                float itemH = new BigDecimal(((float) KeyBoardH - (float) (KeyBoardItemSpaceTB * 2 * 3)) / (float) 3).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                LogUtils.d("itemH:" + String.valueOf((int) (itemH + 0.5f)));
                KeyBoardItemH = (int) itemH;
                KeyBoardItemW = (int) itemH;
                //計算佈局 1. 鍵盤區域 上下 左右間距
                float MRL = new BigDecimal((SpellKeyBoardW - ((float) (KeyBoardItemW + (KeyBoardItemSpaceRL * 2)) * 4) + (KeyBoardItemSpaceRL)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                float MTB = new BigDecimal((KeyBoardH - ((float) (KeyBoardItemH + (KeyBoardItemSpaceTB * 2)) * 3)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                LogUtils.d("MRL:" + String.valueOf((int) (MRL + 0.5f)));
                KeyBoardMTB = (int) MTB;
                KeyBoardMRL = (int) MRL;
                LogUtils.d("KeyBoardMTB: " + KeyBoardMTB + ", KeyBoardMRL: " + KeyBoardMRL);
            } else {
                LogUtils.d("<KeyBoardH");
                //計算鍵盤長寬
                LogUtils.d("itemW:" + String.valueOf((int) (itemW + 0.5f)));
                KeyBoardItemH = (int) itemW;
                KeyBoardItemW = (int) itemW;
                //計算佈局 1. 鍵盤區域 上下 左右間距
                float MRL = new BigDecimal((SpellKeyBoardW - ((float) (KeyBoardItemW + (KeyBoardItemSpaceRL * 2)) * 4) + (KeyBoardItemSpaceRL)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                float MTB = new BigDecimal((KeyBoardH - ((float) (KeyBoardItemH + (KeyBoardItemSpaceTB * 2)) * 3)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
                LogUtils.d("MTB:" + String.valueOf((int) (MTB + 0.5f)));
                KeyBoardMTB = (int) MTB;
                KeyBoardMRL = (int) MRL;
                LogUtils.d("KeyBoardMTB: " + KeyBoardMTB + ", KeyBoardMRL: " + KeyBoardMRL);
            }

        }
        /**
         * 計算圖示縮小比例
         */
        KeyBoardItemNormal = scaleBitmap(KeyBoardItemNormal, KeyBoardItemH);
        KeyBoardItemTouch = scaleBitmap(KeyBoardItemTouch, KeyBoardItemH);
        FillGridItemNormal = scaleBitmap(FillGridItemNormal, KeyBoardItemH);
        KeyboardItemBackOne = scaleBitmap(KeyboardItemBackOne, KeyBoardItemH);
        KeyboardItemBackTwo = scaleBitmap(KeyboardItemBackTwo, KeyBoardItemH);
        /**
         * 鍵盤內容 18 or 16
         * 鍵盤固定內容 [answer字數 | back*1]
         * 剩餘內容 [隨機]
         * 1.寫入 answer + 隨機 [array]
         * 2.打亂排序Collections.shuffle(arrayList);
         * 3.加入 back and 加上座標
         */
        //寫入 answer + 隨機 [array] ;-1 > 預留back位置
        int RandomNum = KeyBoardNum - answerNonSpacelength - 1;
        keyWords = new ArrayList<>();
        for (char c : answer.toCharArray()) {
            if (!String.valueOf(c).equals(" ")) {
                //寫入 answer
                keyboard keyboard = new keyboard();
                StringBuffer buffer = new StringBuffer();
                buffer.append(c);
                keyboard.setContent(buffer.toString());
                keyboard.setAction(keyboard.Action_Keyboard);
                keyWords.add(keyboard);
            }
        }
        LogUtils.d("keyWords size: " + keyWords.size());
        for (int i = 0; i < RandomNum; i++) {
            //隨機 [array]
            keyboard keyboard = new keyboard();
            StringBuffer buffer = new StringBuffer();
            Random r = new Random();
            buffer.append(getRandomEnglishChar(r.nextInt(53)));//A~Z a~z ' - ; 54個char ; 0-53
            keyboard.setContent(buffer.toString());
            keyboard.setAction(keyboard.Action_Keyboard);
            keyWords.add(keyboard);
        }
        LogUtils.d("3");
        //打亂排序List.shuffle
        Collections.shuffle(keyWords);
        /**
         * //加入 back and 加上座標
         *
         * 高 fillGridH + KeyBoardMTB +((KeyBoardItemH + (KeyBoardItemSpaceTB*2))*levelH)
         * levelH = index<KeyBoardLevelNum - 1?1:index<KeyBoardLevelNum*2 - 1?2:3;//高度層級
         * levelW = 0-5 / 1 | 6-11 / 2
         *
         * 寬 KeyBoardMRL + ((KeyBoardItemW + (KeyBoardItemSpaceRL*2))*levelW)
         * int num = levelH*KeyBoardLevelNum - index;
         * levelW = num == 6 ? 1: num == 5?2:num == 4?3:num == 3?4:num == 2?5:num == 1?6:6 ;
         *
         * //預先繪製的區域
         * rect = new Rect((int)backKeyboard.getStartX(),(int)backKeyboard.getStartY(),
         *(int)backKeyboard.getStartX()+KeyBoardItemW,(int)backKeyboard.getStartY()+KeyBoardH);
         *backKeyboard.setmDrawRect(rect);
         */
        List<keyboard> mKeyWords = new ArrayList<>();
        int index = 0;
        int levelH = 1;
        int levelW = 1;
        for (keyboard keyboard : keyWords) {
            //判斷高低左右層級
            levelH = index <= KeyBoardLevelNum - 1 ? 0 : index <= KeyBoardLevelNum * 2 - 1 ? 1 : 2;//高度層級
            LogUtils.d("levelH: " + levelH);
            int num = (levelH + 1) * KeyBoardLevelNum - index;
            if (KeyBoardLevelNum == 6)
                levelW = num == 6 ? 0 : num == 5 ? 1 : num == 4 ? 2 : num == 3 ? 3 : num == 2 ? 4 : num == 1 ? 5 : 0;
            else
                levelW = num == 4 ? 0 : num == 3 ? 1 : num == 2 ? 2 : num == 1 ? 3 : 0;

            //建立繪製區
            Rect rect = null;
            Bitmap showMap = null;
            LogUtils.d("levelH: " + levelH + ",num: " + num + ",levelW: " + levelW + ",index: " + index);
            if (index <= (KeyBoardLevelNum - 1)) {
                //0-(KeyBoardLevelNum-1) => 0-3 | 0-5
                if (index == (KeyBoardLevelNum - 1)) {
                    // 3 | 5 //先back
                    keyboard backKeyboard = new keyboard();
                    backKeyboard.setAction(keyboard.Action_Back);
                    backKeyboard.setStartX(KeyBoardMRL + ((KeyBoardItemW + (KeyBoardItemSpaceRL * 2)) * levelW));
                    backKeyboard.setStartY(fillGridH + KeyBoardMTB + ((KeyBoardItemH + (KeyBoardItemSpaceTB * 2)) * levelH));
                    rect = new Rect((int) backKeyboard.getStartX(), (int) backKeyboard.getStartY(),
                            (int) backKeyboard.getStartX() + KeyBoardItemW, (int) backKeyboard.getStartY() + KeyBoardItemH);
                    backKeyboard.setmDrawRect(rect);
                    mKeyWords.add(backKeyboard);
                    index++;
                    //在normal
                    keyboard.setStartX(KeyBoardMRL + ((KeyBoardItemW + (KeyBoardItemSpaceRL * 2)) * 0));
                    keyboard.setStartY(fillGridH + KeyBoardMTB + ((KeyBoardItemH + (KeyBoardItemSpaceTB * 2)) * 1));

                    rect = new Rect((int) keyboard.getStartX(), (int) keyboard.getStartY(),
                            (int) keyboard.getStartX() + KeyBoardItemW, (int) keyboard.getStartY() + KeyBoardItemH);
                    keyboard.setmDrawRect(rect);
                    mKeyWords.add(keyboard);
                    if (index == 6)
                        LogUtils.d("levelH: " + levelH + 1 + ",levelW: " + 1 + ",index: " + index);
                } else {
                    // 0-2 | 0-4
                    keyboard.setStartX(KeyBoardMRL + ((KeyBoardItemW + (KeyBoardItemSpaceRL * 2)) * levelW));
                    keyboard.setStartY(fillGridH + KeyBoardMTB + ((KeyBoardItemH + (KeyBoardItemSpaceTB * 2)) * levelH));
                    rect = new Rect((int) keyboard.getStartX(), (int) keyboard.getStartY(),
                            (int) keyboard.getStartX() + KeyBoardItemW, (int) keyboard.getStartY() + KeyBoardItemH);
                    keyboard.setmDrawRect(rect);
                    mKeyWords.add(keyboard);
                }
            } else {
                // 4-11 | 6-17
                keyboard.setStartX(KeyBoardMRL + ((KeyBoardItemW + (KeyBoardItemSpaceRL * 2)) * levelW));
                keyboard.setStartY(fillGridH + KeyBoardMTB + ((KeyBoardItemH + (KeyBoardItemSpaceTB * 2)) * levelH));
                rect = new Rect((int) keyboard.getStartX(), (int) keyboard.getStartY(),
                        (int) keyboard.getStartX() + KeyBoardItemW, (int) keyboard.getStartY() + KeyBoardItemH);
                keyboard.setmDrawRect(rect);
                mKeyWords.add(keyboard);
            }
            index++;
            LogUtils.d("index: " + index);
        }
//        LogUtils.d("4");
        keyWords = mKeyWords;
        setTextSizeForWidth(mTextPaint, KeyBoardItemH);//自適應字體
        for (keyboard keyboard : keyWords) {
            LogUtils.d("keyWords: " + keyboard.toString());
            if (keyboard.getmDrawRect() != null) {
                WeakReference<Rect> rect = new WeakReference<Rect>(keyboard.getmDrawRect());
                if (!keyboard.getAction().equals(keyboard.Action_Back)) {
                    /**
                     * 如果已經使用 use = true
                     * 不繪圖
                     * 反向繪製
                     */
                    if (!keyboard.isUse()){
                        mCanvas.drawBitmap(KeyBoardItemNormal, null, rect.get(), mKeyboardPaint);
                        int textX = (int) (keyboard.getStartX() + (KeyBoardItemW / 2 - mTextPaint.measureText(keyboard.getContent())) + 0.5f);
                        int textY = (int) (keyboard.getStartY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
                        LogUtils.d(" textX " + textX + ", textY" + textY);
                        mCanvas.drawText(keyboard.getContent(), keyboard.getStartX() + KeyBoardItemW / 2, textY, mTextPaint);
                    }else{
                        mCanvas.drawBitmap(KeyBoardItemNormal, null, keyboard.getmDrawRectFill(), mKeyboardPaint);
                        int textX = (int) (keyboard.getStartX() + (KeyBoardItemW / 2 - mTextPaint.measureText(keyboard.getContent())) + 0.5f);
                        int textY = (int) (keyboard.getStartY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
                        LogUtils.d(" textX " + textX + ", textY" + textY);
                        mCanvas.drawText(keyboard.getContent(), keyboard.getStartX() + KeyBoardItemW / 2, textY, mTextPaint);
                    }
                } else {
                    mCanvas.drawBitmap(KeyboardItemBackOne, null, rect.get(), mKeyboardPaint);
                }

            }
        }
    }

    /**
     * 答案欄建立
     */
    private void initFillGridSize() {
        /**
         * 1.確定答案格數量
         * 1-1.計算格子長寬
         * 1-2.計算每個格子xy
         * 2.建立答案格子
         */
        LogUtils.d("答案長度[含空格]:" + answerlength);
        fillGridNum = answerlength;
        fillGridItemH = fillGridItemW = KeyBoardItemH;
        /**
         *計算格子長寬
         *先確定所有格子的加總 不用滑
         */
        //用鍵盤的寬來計算
        int itemWidth = (int) (KeyBoardItemW + (fillGridItemSpace * 2) + (fillGridItemPadding * 2));
        int itemSpaceWidth = (int) (KeyBoardItemW / 2);
        int itemHeight = (int) (KeyBoardItemH + (fillGridItemPadding * 2));
        int totalWidth = itemWidth * answerNonSpacelength + itemSpaceWidth * (answerlength - answerNonSpacelength);
        if (totalWidth < SpellKeyBoardW) {
            //加總寬 < 螢幕寬
            /**
             * 設定顯示區域母體左右上下間距
             */
            float itemMRL = new BigDecimal(((float) fillGridW - (float) totalWidth) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
            float itemMTB = new BigDecimal(((float) fillGridH - (float) (itemHeight)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
            fillGridMRL = (int) itemMRL;
            fillGridMTB = (int) itemMTB;
        } else {
            //加總寬 > 螢幕寬
            /**
             * 設定顯示區域母體左右上下間距
             */
            float itemMRL = 0;
            float itemMTB = new BigDecimal(((float) fillGridH - (float) (itemHeight)) / (float) 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
            fillGridMRL = (int) itemMRL;
            fillGridMTB = (int) itemMTB;
        }
        /**
         * 建立格子資訊
         * (fillGridItemW/2)*spaceNum 空格
         */
        fillGrids = new ArrayList<>();
        int index = 0;
        int spaceNum = 0;
        for (char c : answer.toCharArray()) {
            float fillx = new BigDecimal((float) fillGridMRL + (fillGridItemW / 2) * spaceNum +
                    (((float) fillGridItemW + (fillGridItemSpace * 2)) * (float) index)).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
            float filly = fillGridMTB;

            fillGrid fb = new fillGrid();
            fb.setContent(String.valueOf(c));
            fb.setStartX(fillx);
            fb.setStartX(filly);
            Rect r = new Rect((int) fillx, (int) filly, (int) (fillx + fillGridItemW), (int) (filly + fillGridItemH));
            fb.setmDrawRect(r);//放入繪製範圍
            if (String.valueOf(c).equals(" ")) {
                //空格資料
                fb.setAction(fb.Action_Space);
                spaceNum++;
            } else {
                //非空格資料
                fb.setAction(fb.Action_Fillgrid);
                mCanvas.drawBitmap(FillGridItemNormal, null, r, mFillGridPaint);
                index++;
            }
            LogUtils.d(" fillGrid: " + fb.toString());
            fillGrids.add(fb);

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtils.d("SpellKeyBoard onDraw");
        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        } else {
            LogUtils.d("mBitmap null");
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        LogUtils.d("SpellKeyBoard " + "widthMode:" + widthMode + " ,heightMode:" + heightMode);


        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            /**
             *設定全局 長寬
             */
            SpellKeyBoardW = MeasureSpec.getSize(widthMeasureSpec);
            SpellKeyBoardH = MeasureSpec.getSize(heightMeasureSpec);
            LogUtils.d("SpellKeyBoard " + "SpellKeyBoardW:" + SpellKeyBoardW + " ,SpellKeyBoardH:" + SpellKeyBoardH);
            /**
             * 設定 鍵盤佈局 長寬
             */

            KeyBoardW = SpellKeyBoardW;
            KeyBoardH = SpellKeyBoardH / 3 * 2;
            LogUtils.d("SpellKeyBoard " + "KeyBoardW:" + KeyBoardW + " ,KeyBoardH:" + KeyBoardH);
            /**
             * 設定 顯示佈局[滑動] 長寬
             */
            fillGridW = SpellKeyBoardW;
            fillGridH = SpellKeyBoardH / 3;
            LogUtils.d("SpellKeyBoard " + "fillGridW:" + fillGridW + " ,fillGridH:" + fillGridH);
            /**
             * 繪製畫布 底版
             */
            mBitmap = Bitmap.createBitmap(SpellKeyBoardW, SpellKeyBoardH, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
            mCanvas.drawRect(new Rect(0, 0, SpellKeyBoardW, SpellKeyBoardH), mContextPaint);

            //鍵盤
            initKeyboardSize();
            //答案格子
            initFillGridSize();
            //刷新
            invalidate();//
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtils.d("event.getX():" + event.getX());
        LogUtils.d("event.getY():" + event.getY());
        LogUtils.d("getAction: "+event.getAction());

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtils.d("ACTION_DOWN");
                for(keyboard k : keyWords){
                    if(k.getmDrawRect().contains((int)event.getX(),(int)event.getY())){
                        if(k.getAction().equals(k.Action_Keyboard)){
                            if(!k.isUse()) {
                                //keyboard
                                mCanvas.drawBitmap(KeyBoardItemTouch, null, k.getmDrawRect(), mKeyboardPaint);
                                int textX = (int) (k.getStartX() + (KeyBoardItemW / 2 - mTextPaint.measureText(k.getContent())) + 0.5f);
                                int textY = (int) (k.getStartY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
                                mCanvas.drawText(k.getContent(), k.getStartX() + KeyBoardItemW / 2, textY, mTextPaint);
                            }
                        }else{
                            //back
                            mCanvas.drawBitmap(KeyboardItemBackTwo, null, k.getmDrawRect(), mKeyboardPaint);

                        }
                        postInvalidate();
                    }
                }
                touchDown(event);
                break;
            case MotionEvent.ACTION_UP:
                for(keyboard k : keyWords){
                    if(k.getmDrawRect().contains((int)event.getX(),(int)event.getY())){
                        if(k.getAction().equals(k.Action_Keyboard)){
                            if(!k.isUse()) {
                                //keyboard
                                mCanvas.drawBitmap(KeyBoardItemNormal, null, k.getmDrawRect(), mKeyboardPaint);
                                int textX = (int) (k.getStartX() + (KeyBoardItemW / 2 - mTextPaint.measureText(k.getContent())) + 0.5f);
                                int textY = (int) (k.getStartY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
                                mCanvas.drawText(k.getContent(), k.getStartX() + KeyBoardItemW / 2, textY, mTextPaint);
                            }
                        }else{
                            //back
                            mCanvas.drawBitmap(KeyboardItemBackOne, null, k.getmDrawRect(), mKeyboardPaint);
                        }
                        postInvalidate();
                    }
                }
                touchUp(event);
                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }

        return true;
    }

    /**
     * touch down
     */
    private void touchDown(MotionEvent event) {
        /**
         * 紀錄XY軸
         */
        touchX = event.getX();
        touchY = event.getY();
        /**
         * 判斷點擊位置
         */
        int keyIndex = 0;
        e:
        for (keyboard k : keyWords) {
            /**
             * 點擊到 已經被使用過的按鍵位置 沒有作用
             */
            if (!k.isUse()) {
                /**
                 * 篩選並點擊到可以使用的按鍵位置
                 * 紀錄位置 離開此迴圈
                 */
//                if (((k.getStartX() + KeyBoardItemW) - 0.5f > event.getX() && event.getX() >= (k.getStartX() + 0.5f))
//                        && ((k.getStartY() + KeyBoardItemW) - 0.5f > event.getY() && event.getY() >= (k.getStartY() + 0.5f)))
                if (k.getmDrawRect().contains((int)touchX,(int)touchY)) {
                    LogUtils.d("content " + k.getContent());
                    LogUtils.d("Action " + k.getAction());
                    touchIndex = keyIndex;//暫時紀錄 index
                    if (k.getAction().equals(k.Action_Back)) {
                        /**
                         * back
                         */
                        if (KeyBoardItemPreviousIndex == -1) {
                            LogUtils.d("KeyBoardItemPreviousIndex " + KeyBoardItemPreviousIndex);
                            /**
                             * 不能退後
                             */
                        } else {
                            /**
                             * 可以退後 KeyBoardItemPreviousIndex 是上一個選擇的index
                             */
                            //答案退後一個
                            LogUtils.d("isBack " + isBack);
                            isBack = true;

                        }
                    } else {
                        /**
                         * 一般 按鍵
                         * answerList size 已經填入多少答案
                         * answerNonSpacelength 有多少格子可以填
                         */
                        //變更狀態 isAdd = true; canvas animate
                        isAdd = true;
                    }
                    break e;
                }
            }
            keyIndex++;
        }
        LogUtils.d("isBack:" +isBack);
        LogUtils.d("isAdd:" +isAdd);
    }

    /**
     * touch up
     */
    private void touchUp(MotionEvent event) {
        if (touchX != event.getX() && touchY != event.getY()) {
            LogUtils.d("座標不一致");
            return;
        }
        /**
         * 開始
         */
        //檢查是不是點到back
        if (isBack) KeyboardBack();
        //檢查是不是點到add
        if (isAdd) fillGridAdd();
    }

    /**
     * 新增答案後 資料變動
     *
     * @param keyIndex 需要變動的 keyindex
     */
    private void addAnswerMemory(int keyIndex) {
        //暫存
        int fillIndex = fillGridUseNextIndex;//更換前的填入位置
        //更換狀態
        keyWords.get(keyIndex).setUse(true);
        //儲存答案
        if (answerList == null) answerList = new ArrayList<>();
        answerList.add(keyIndex);
        //更換 keyboard index
        KeyBoardItemPreviousIndex = keyIndex;
        //更換下一個可以填寫的格子 fillGrid index
        fillGridUseNextIndex++;
        /**
         * 如果檢查
         */
        if(fillGridUseNextIndex != fillGrids.size() && fillGridUseNextIndex < fillGrids.size()) {
            while (fillGrids.get(fillGridUseNextIndex).getAction().equals("Space")) {
                fillGridUseNextIndex++;
            }
        }
        LogUtils.d("keyIndex: " + keyIndex);
        LogUtils.d("answerList size:" + answerList.size());
        LogUtils.d("KeyBoardItemPreviousIndex:" + KeyBoardItemPreviousIndex);
        LogUtils.d("fillGridUseNextIndex:" + fillGridUseNextIndex);
        /**
         * 繪製內容 含 動畫
         * 2.add fillGrid
         */
        int x = fillGrids.get(fillIndex).getmDrawRect().left-2;
        int y = fillGrids.get(fillIndex).getmDrawRect().top+2;
        keyWords.get(keyIndex).setmDrawRectFill(fillGrids.get(fillIndex).getmDrawRect());//設定填滿位置
        keyWords.get(keyIndex).setStartFillX(x);
        keyWords.get(keyIndex).setStartFillY(y);
        //
        updateInvalidate();//重繪
    }

    /**
     * 退回答案後 資料變動
     *
     * @param keyIndex 需要變動的 keyindex
     */
    private void removeAnswerMemory(int keyIndex) {
        //更換狀態
        keyWords.get(keyIndex).setUse(false);
        //刪除答案
        answerList.remove(answerList.size() - 1);//退回最新的一筆
        //更換退回 keyboard index
        KeyBoardItemPreviousIndex = answerList.size() == 0 ? -1 : answerList.get(answerList.size() - 1);
        //更換下一個 fillGrid index
        if (fillGridUseNextIndex != 0) fillGridUseNextIndex--;
        while (fillGrids.get(fillGridUseNextIndex).getAction().equals("Space")) {
            fillGridUseNextIndex--;
        }
        LogUtils.d("keyIndex: " + keyIndex);
        LogUtils.d("answerList size:" + answerList.size());
        LogUtils.d("KeyBoardItemPreviousIndex:" + KeyBoardItemPreviousIndex);
        LogUtils.d("fillGridUseNextIndex:" + fillGridUseNextIndex);
        /**
         * 繪製內容 含 動畫
         * 2.remove fillGrid
         */
        updateInvalidate();//重繪
    }

    /**
     * back + 動畫
     */
    private void KeyboardBack() {
        /**
         * 更改狀態回來
         */
        isBack = false;
        /**
         * 刪除紀錄
         */
        removeAnswerMemory(KeyBoardItemPreviousIndex);
        /**
         * 繪製內容 含 動畫
         */
    }

    /**
     * add + 動畫
     */
    private void fillGridAdd() {
        /**
         *
         */
        isAdd = false;
        /**
         * 增加紀錄
         */
        if(answerList==null) answerList = new ArrayList<>();
        if (answerList.size() < answerNonSpacelength) {
            addAnswerMemory(touchIndex);
        }else{
            isAdd=false;//
        }

    }

    /**
     * 取得隨機 英文字 A~Z , a~z , ' -  [54個字母]
     *
     * @param index
     * @return
     */
    private String getRandomEnglishChar(int index) {
        switch (index) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            case 8:
                return "I";
            case 9:
                return "J";
            case 10:
                return "K";
            case 11:
                return "L";
            case 12:
                return "M";
            case 13:
                return "N";
            case 14:
                return "O";
            case 15:
                return "P";
            case 16:
                return "Q";
            case 17:
                return "R";
            case 18:
                return "S";
            case 19:
                return "T";
            case 20:
                return "U";
            case 21:
                return "V";
            case 22:
                return "W";
            case 23:
                return "X";
            case 24:
                return "Y";
            case 25:
                return "Z";
            case 26:
                return "a";
            case 27:
                return "b";
            case 28:
                return "c";
            case 29:
                return "d";
            case 30:
                return "e";
            case 31:
                return "f";
            case 32:
                return "g";
            case 33:
                return "h";
            case 34:
                return "i";
            case 35:
                return "j";
            case 36:
                return "k";
            case 37:
                return "l";
            case 38:
                return "m";
            case 39:
                return "n";
            case 40:
                return "o";
            case 41:
                return "p";
            case 42:
                return "q";
            case 43:
                return "r";
            case 44:
                return "s";
            case 45:
                return "t";
            case 46:
                return "u";
            case 47:
                return "v";
            case 48:
                return "w";
            case 49:
                return "x";
            case 50:
                return "y";
            case 51:
                return "z";
            case 52:
                return "'";
            case 53:
                return "-";
            default:
                return "";
        }
    }

    /**
     * 縮小圖示
     */
    private Bitmap scaleBitmap(Bitmap scaleBitmap, int itemHW) {
        Bitmap b = scaleBitmap;
        float scale;
        LogUtils.d("itemHW:" + itemHW + " ,b.getWidth():" + b.getWidth());
        LogUtils.d("itemHW:" + itemHW + " ,b.getHeight():" + b.getHeight());
        float scalew = new BigDecimal((float) itemHW / (float) b.getWidth()).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
        float scaleH = new BigDecimal((float) itemHW / (float) b.getHeight()).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
        scale = scalew > scaleH ? scaleH : scalew;
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale); //长和宽放大缩小的比例
        LogUtils.d("scale:" + scale);
        Bitmap resizeBmp = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), matrix, true);
        return resizeBmp;
    }

    /**
     * 字體自適應
     */
    private void setTextSizeForWidth(Paint paint, float desiredHeight) {

        // Pick a reasonably large value for the test. Larger values produce
        // more accurate results, but may cause problems with hardware
        // acceleration. But there are workarounds for that, too; refer to
        // http://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
        final float testTextSize = 10f;

        // Get the bounds of the text, using our testTextSize.
        paint.setTextSize(testTextSize);
        Rect bounds = new Rect();
        paint.getTextBounds("n", 0, "n".length(), bounds);

        // Calculate the desired size as a proportion of our testTextSize.
        float desiredTextSize = testTextSize * desiredHeight / bounds.height() * 2 / 5;
        LogUtils.d("desiredTextSize: " + desiredTextSize);

        // Set the paint for that size.
        paint.setTextSize(desiredTextSize);
    }

    /**
     * 更新
     */
    public void updateInvalidate(){
        mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        /**
         * 建立格子資訊
         * (fillGridItemW/2)*spaceNum 空格
         */
        fillGrids = new ArrayList<>();
        int index = 0;
        int spaceNum = 0;
        for (char c : answer.toCharArray()) {
            final float x = new BigDecimal((float) fillGridMRL + (fillGridItemW / 2) * spaceNum +
                    (((float) fillGridItemW + (fillGridItemSpace * 2)) * (float) index)).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
            final float y = fillGridMTB;
            fillGrid fillGrid = new fillGrid();
            fillGrid.setContent(String.valueOf(c));
            fillGrid.setStartX(x);
            fillGrid.setStartX(y);
            Rect r = new Rect((int) x, (int) y, (int) (x + fillGridItemW), (int) (y + fillGridItemH));
            fillGrid.setmDrawRect(r);//放入繪製範圍
            if (String.valueOf(c).equals(" ")) {
                //空格資料
                fillGrid.setAction(fillGrid.Action_Space);
                spaceNum++;
            } else {
                //非空格資料
                fillGrid.setAction(fillGrid.Action_Fillgrid);
                mCanvas.drawBitmap(FillGridItemNormal, null, r, mFillGridPaint);
                index++;
            }
            fillGrids.add(fillGrid);

        }

        for (keyboard keyboard : keyWords) {
//            LogUtils.d("keyWords: " + keyboard.toString());
            if (keyboard.getmDrawRect() != null) {
                WeakReference<Rect> rect = new WeakReference<Rect>(keyboard.getmDrawRect());
                if (!keyboard.getAction().equals(keyboard.Action_Back)) {
                    /**
                     * 如果已經使用 use = true
                     * 不繪圖
                     * 反向繪製
                     */
                    if (!keyboard.isUse()){
                        mCanvas.drawBitmap(KeyBoardItemNormal, null, rect.get(), mKeyboardPaint);
                        int textX = (int) (keyboard.getStartX() + (KeyBoardItemW / 2 - mTextPaint.measureText(keyboard.getContent())) + 0.5f);
                        int textY = (int) (keyboard.getStartY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
//                        LogUtils.d(" textX " + textX + ", textY" + textY);
                        mCanvas.drawText(keyboard.getContent(), keyboard.getStartX() + KeyBoardItemW / 2, textY, mTextPaint);
                    }else{
                        mCanvas.drawBitmap(KeyBoardItemNormal, null, keyboard.getmDrawRectFill(), mKeyboardPaint);
                        int textX = (int) (keyboard.getStartFillX() + (KeyBoardItemW / 2 - mTextPaint.measureText(keyboard.getContent())) + 0.5f);
                        int textY = (int) (keyboard.getStartFillY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
//                        LogUtils.d(" keyboard.getStartFillX() " + keyboard.getStartFillX() + ", keyboard.getStartFillY()" + keyboard.getStartFillY());
//                        LogUtils.d(" KeyBoardItemW " + KeyBoardItemW + ", mTextPaint.measureText(keyboard.getContent()" + mTextPaint.measureText(keyboard.getContent()));
//                        LogUtils.d(" mTextPaint.descent() " + mTextPaint.descent() + ", mTextPaint.ascent()" + mTextPaint.ascent());
//                        LogUtils.d(" textX " + textX + ", textY" + textY);
                        mCanvas.drawText(keyboard.getContent(), keyboard.getStartFillX() + KeyBoardItemW / 2, textY, mTextPaint);
                    }
                } else {
                    mCanvas.drawBitmap(KeyboardItemBackOne, null, rect.get(), mKeyboardPaint);
                }

            }
        }

        invalidate();
    }

    /**
     * 呼叫更新重繪
     */
    public void updateKeyword() {
        mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        fillGridUseNextIndex = 0;//下一個使用的 作答格子 歸0
        initKeyboardSize();
        initFillGridSize();
        invalidate();
    }
}
