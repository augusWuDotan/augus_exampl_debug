package com.wdtpr.augus.spellkeyboard.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

import com.wdtpr.augus.spellkeyboard.R;
import com.wdtpr.augus.spellkeyboard.model.bean.fillGrid;
import com.wdtpr.augus.spellkeyboard.model.bean.keyboard;
import com.wdtpr.augus.spellkeyboard.model.listener.SpellKeyBoardListener;
import com.wdtpr.augus.spellkeyboard.utils.BitmapUtils;
import com.wdtpr.augus.spellkeyboard.utils.LogUtils;
import com.wdtpr.augus.spellkeyboard.utils.TextUtils;
import com.wdtpr.augus.spellkeyboard.utils.source.FillGridModel;
import com.wdtpr.augus.spellkeyboard.utils.source.KeyBoardModel;
import com.wdtpr.augus.spellkeyboard.utils.source.WorkFilterModel;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    private Paint mAnimPaint;
    /**
     * animatedValue 繪製完成度
     * AccelerateDecelerateInterpolator 加速 - 減速
     */
    private int animTime = 500;//填寫答案動畫時間500毫秒
    private int animClearTime = 300;//清除動畫時間 300毫秒
    private int animAllClearTime = 500;//清除動畫時間 300毫秒
    private int maxAnimCode = 1000;//最大值
    private int minAnimCode = 0;//最小值
    private int animateDelay = 2000;//作答結束[正確] 動畫延遲執行時間 預設2000[2秒]

    /**
     * 傳入版型 [1,2]
     */
    private int mType = 1;
    /**
     * 畫布底版
     */
    private Canvas mCanvas;//底圖畫布
    private Bitmap mBitmap;//底圖圖片
    private Canvas mKeyBoardCanvas;//鍵盤區畫布
    private Bitmap mKeyBoardBitmap;//鍵盤區圖片
    private Canvas mFillGridCanvas;//答題區畫布
    private Bitmap mFillGridBitmap;//答題區圖片

    /**
     * callback 回傳機制
     */
    public SpellKeyBoardListener listener;
    /**
     * 1.鍵盤模組
     * 2.鍵盤內容建立模組
     */
    private KeyBoardModel keyBoardModel;
    private WorkFilterModel workFilterModel;
    private FillGridModel fillGridModel;


    /**
     * 答題 與 鍵盤區域比例
     */
    private float fillAreaPercentage = 0.4f;
    private float keyboardAreaPercentage = 0.6f;

    /**
     * 字體
     */
    Typeface mfont;

    /**
     * 佈局 全局高 全局寬 全局margin(預設20)
     */
    private int SpellKeyBoardH;
    private int SpellKeyBoardW;

    /**
     * 傳入的答案
     */
    private String answer = "";
    /**
     * 傳入的答案長度含空格
     */
    private int answerlength;

    /**
     * 傳入的答案長度 不含空格
     */
    private int answerNonSpacelength;

    /**
     * keyKoard rect 範圍
     */
    private Rect keyBoardRect;

    /**
     * 鍵盤按鍵數量
     */
    private int KeyBoardNum = 12;
    /**
     * 鍵盤有幾層
     */
    private int KeyBoardLevelNum = 3;
    /**
     * 鍵盤每一層按鍵數量
     */
    private int KeyBoardLevelCount = 4;
    /**
     * 鍵盤按鍵區域 寬度
     */
    private int KeyBoardW = -1;
    /**
     * 鍵盤按鍵區域 高度
     */
    private int KeyBoardH = -1;
    /**
     * 鍵盤按鍵區域 margin TOP BOTTOM
     * //先算 物件高度 三行   [剩下高度/2]
     */
    private int KeyBoardMTB = -1;
    /**
     * 鍵盤按鍵區域 margin Left Right
     * //先算 物件高度 6 or 4   [剩下寬度/2]
     */
    private int KeyBoardMRL = -1;
    /**
     * 上一個點擊的 按鍵 index
     */
    private int KeyBoardItemPreviousIndex = -1;
    /**
     * 填答案 偏移量
     */
    private int KeyBoardItemPadding = 5;
    /**
     * keyboard touch index
     */
    private int keyBoardTouchIndex = -1;

    /**
     * fillGrid rect 範圍
     */
    private Rect fillGridRect;
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
     * 答題區 左右 滑動極限 X = +-？
     * fillGridMaxX最大值
     * fillGridMinX最小值
     * fillGridCanScroll 是否可滑動
     * fillGridMoveNum 可以移動 [預設 + ]
     * fillGridXOffset = x偏移量 [答題或是退回 偏移量]
     */
    private float fillGridMaxX;
    private float fillGridMinX;
    private float fillGridMoveNum;
    private boolean fillGridCanScroll;
    private float fillGridXOffset = 0;
    private boolean fillGridXDirection = false; // false 向左 // true 向右

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
     * 輸入框背景 type1
     */
    private Bitmap FillGridItemNormalType1;
    /**
     * 輸入框背景 type2
     */
    private Bitmap FillGridItemNormalType2;

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
     * 是否鎖住畫布 touch = false , draw = false
     */
    private boolean isLock = false;
    /**
     * 是否啟動 退後鍵
     */
    private boolean isBack = false;
    /**
     * 是否啟動 加入答案
     */
    private boolean isAdd = false;
    /**
     * true 開始繪製 清除動畫
     * false 動畫結束 或是 不執行
     */
    private boolean isClear = false;
    /**
     * true 開始繪製 移動動畫
     * false 動畫結束 或是 不執行
     */
    private boolean isMove = true;
    /**
     * true 答題成功 動畫結束
     * false 一般刪除答案
     */
    private boolean isFinish = false;

    public SpellKeyBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LogUtils.d("SpellKeyBoard context");
        //init model
        keyBoardModel = new KeyBoardModel();
        fillGridModel = new FillGridModel();
        workFilterModel = new WorkFilterModel();

//        setBackgroundColor(Color.TRANSPARENT);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.SpellKeyBoard);
        int normalKeyBoardItemRID = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_normalKeyboardItem, R.drawable.keyboard_normal);
        int touchKeyBoardItemRID = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_touchKeyboardItem, R.drawable.keyboard_press);
        int normalFillGridItemRID1 = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_normalFillGridItemType1, R.drawable.fillgrid_type1);
        int normalFillGridItemRID2 = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_normalFillGridItemType2, R.drawable.fillgrid_type2);
        int KeyboardItemBackOneRID = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_KeyboardItemBackOne, R.drawable.keyboard_back_normal);
        int KeyboardItemBackTwoRID = mTypedArray.getResourceId(R.styleable.SpellKeyBoard_KeyboardItemBackTwo, R.drawable.keyboard_back_press);
        animateDelay = mTypedArray.getInt(R.styleable.SpellKeyBoard_answerCorrectAnimateDelay, 2000);
        KeyBoardItemSpaceRL = mTypedArray.getDimension(R.styleable.SpellKeyBoard_KeyboardItemPadding, 10);
        KeyBoardItemSpaceTB = mTypedArray.getDimension(R.styleable.SpellKeyBoard_KeyboardItemPadding, 10);
        fillGridItemSpace = mTypedArray.getDimension(R.styleable.SpellKeyBoard_fillGridPaddingRL, 10);
        mTypedArray.recycle();
        /**
         * KeyBoardItemNormal、KeyBoardItemTouch 鍵盤使用圖片
         * FillGridItemNormalType1 填充格子使用圖片
         */
        KeyBoardItemNormal = BitmapFactory.decodeResource(getResources(), normalKeyBoardItemRID);
        KeyBoardItemTouch = BitmapFactory.decodeResource(getResources(), touchKeyBoardItemRID);
        FillGridItemNormalType1 = BitmapFactory.decodeResource(getResources(), normalFillGridItemRID1);
        FillGridItemNormalType2 = BitmapFactory.decodeResource(getResources(), normalFillGridItemRID2);
        KeyboardItemBackOne = BitmapFactory.decodeResource(getResources(), KeyboardItemBackOneRID);
        KeyboardItemBackTwo = BitmapFactory.decodeResource(getResources(), KeyboardItemBackTwoRID);
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

    public void setmType(int mType) {
        this.mType = mType;
    }

    public void setKeyBoardNum(int keyBoardNum) {
        this.KeyBoardNum = keyBoardNum;
        /**
         * 設定層級 鍵盤12個 > 4*3[層] , 鍵盤24個 > 6*4[層]
         */
        this.KeyBoardLevelNum = keyBoardNum < 24 ? 3 : 4;
        /**
         * 設定各層級數量 鍵盤12個 > 4/層 , 鍵盤24個 > 6/層
         */
        this.KeyBoardLevelCount = KeyBoardNum / KeyBoardLevelNum;//總數量 / 幾層 = 每一層幾個
        LogUtils.d("設定幾層: " + KeyBoardLevelNum);
        LogUtils.d("設定每一層的鍵盤數: " + KeyBoardLevelCount);
    }

    public void setKeyBoardItemPadding(int keyBoardItemPadding) {
        KeyBoardItemPadding = keyBoardItemPadding;
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

        //動畫
        mAnimPaint = new Paint();
        mAnimPaint.setColor(Color.YELLOW);
        mAnimPaint.setAntiAlias(true);//防鋸齒
        mfont = Typeface.createFromAsset(getResources().getAssets(), "billy.otf");
        mAnimPaint.setTypeface(mfont);//設定字體
        mAnimPaint.setTextAlign(Paint.Align.CENTER);//繪製在中心點

        mContextPaint = new Paint();
        mContextPaint.setAntiAlias(true);
        mContextPaint.setColor(Color.TRANSPARENT);
        mContextPaint.setStyle(Paint.Style.STROKE);
    }

    /**
     * 畫布初始
     */
    private void initCanvas() {
        /**
         * 繪製底圖 底圖畫布 ｜ 底圖圖示
         */
        mBitmap = Bitmap.createBitmap(SpellKeyBoardW, SpellKeyBoardH, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawRect(new Rect(0, 0, SpellKeyBoardW, SpellKeyBoardH), mContextPaint);
        /**
         * 切割區域 鍵盤區
         */
        keyBoardRect = new Rect(0, fillGridH, KeyBoardW, KeyBoardH + fillGridH);
        mKeyBoardBitmap = Bitmap.createBitmap(SpellKeyBoardW, fillGridH + KeyBoardH, Bitmap.Config.ARGB_8888);
        mKeyBoardCanvas = new Canvas(mKeyBoardBitmap);
        mKeyBoardCanvas.drawRect(keyBoardRect, mContextPaint);
        /**
         * 切割區域 答案區
         */
        fillGridRect = new Rect(0, 0, fillGridW, fillGridH);
        mFillGridBitmap = Bitmap.createBitmap(SpellKeyBoardW, fillGridH + KeyBoardH, Bitmap.Config.ARGB_8888);
        mFillGridCanvas = new Canvas(mFillGridBitmap);
        mFillGridCanvas.drawRect(fillGridRect, mContextPaint);
    }

    /**
     * 鍵盤建立
     */
    private void initKeyboard() {
        /**
         * 建立鍵盤item 長 寬 間距
         * KeyBoardLevelCount 每一層有幾個
         * KeyBoardLevelNum 共幾層
         *
         * 計算鍵盤佈局
         * 1080寬[預設]
         *
         * 比例設定[依據寬度]
         * ([總寬(KeyBoardW)]- ( [左右間距(KeyBoardItemSpaceRL)*2(兩邊各有1)] * [每一層數量(KeyBoardLevelCount)] )/[每一層數量(KeyBoardLevelCount)] = [每一個Item長度]
         * 比例設定[依據長度]
         * ([總長(KeyBoardH)]- ( [上下間距(KeyBoardItemSpaceTB)*2(上下各有1)] * [共幾層(KeyBoardLevelNum)] ))/[共幾層(KeyBoardLevelNum)] = [每一個Item長度]
         * >>>[取較短設定]<<<
         *
         * 計算鍵盤左右間距 ([總寬(KeyBoardW)] - ([每一層數量(KeyBoardLevelCount)]*([鍵盤長寬(keyboardItemHW)]+[左右間距(KeyBoardItemSpaceRL)*2(兩邊各有1)]))/2
         * 計算鍵盤上下間距 ([總長(KeyBoardH)] - ([共幾層(KeyBoardLevelNum)]*([鍵盤長寬(keyboardItemHW)]+[左右間距(KeyBoardItemSpaceRL)*2(兩邊各有1)]))/2
         */

        /**
         * 圖示 縮小或是放大
         */
        scaleMatrix();
        /**
         * 取得鍵盤按鍵內容
         * setKeyboardWord 設定內容
         */
        setKeyboardWord();
        /**
         * 建立
         * setKeyBoardItemSize [設定座標]
         */
        keyWords = keyBoardModel.setKeyBoardItemSize(keyWords, KeyBoardLevelCount, KeyBoardMRL,
                KeyBoardMTB, KeyBoardItemSpaceRL, KeyBoardItemSpaceTB, KeyBoardItemW, fillGridH, KeyBoardItemH);
        /**
         * [繪製過程]
         */
        keyBoardModel.drawKeyBoard(keyWords, mKeyBoardCanvas, KeyBoardItemW, KeyBoardItemNormal, KeyboardItemBackOne, mKeyboardPaint, mTextPaint);

    }

    /**
     * 初始化圖示 scale [縮小或是放大]
     */
    private void scaleMatrix() {
        KeyBoardItemNormal = BitmapUtils.scaleBitmap(KeyBoardItemNormal, KeyBoardItemH);
        KeyBoardItemTouch = BitmapUtils.scaleBitmap(KeyBoardItemTouch, KeyBoardItemH);
        FillGridItemNormalType1 = BitmapUtils.scaleBitmap(FillGridItemNormalType1, KeyBoardItemH);
        FillGridItemNormalType2 = BitmapUtils.scaleBitmap(FillGridItemNormalType2, KeyBoardItemH);
        KeyboardItemBackOne = BitmapUtils.scaleBitmap(KeyboardItemBackOne, KeyBoardItemH);
        KeyboardItemBackTwo = BitmapUtils.scaleBitmap(KeyboardItemBackTwo, KeyBoardItemH);
    }

    /**
     * 建立鍵盤內容[文字]
     */
    private void setKeyboardWord() {
        keyWords = workFilterModel.getKeyboardWord(answer, KeyBoardNum, KeyBoardLevelCount);
    }


    /**
     * 答案欄建立
     */
    private void initFillGrid() {
        fillGrids = fillGridModel.setFillGridItemSizeAndDraw(answer, mFillGridCanvas, mFillGridPaint, mType, FillGridItemNormalType1,
                FillGridItemNormalType2, fillGridMRL, fillGridItemW, fillGridItemSpace, fillGridMTB, fillGridItemH, 0);
    }

    /**
     * 長寬參數初始化
     */
    private void initViewSize() {
        /**
         * 鍵盤區
         */

        LogUtils.d("鍵盤按鍵左右間距1: " + (int) KeyBoardItemSpaceRL);
        //[依據寬度] ([總寬]- ( [左右間距(10)*2(兩邊各有1)] * [每一層數量(KeyBoardLevelCount)] ))/[每一層數量(KeyBoardLevelCount)] = [每一個Item長度]
        float ItemhwForWidth = new BigDecimal((((float) KeyBoardW - (KeyBoardItemSpaceRL * 2 * KeyBoardLevelCount))) / (float) KeyBoardLevelCount + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        LogUtils.d("依據寬度計算鍵盤長寬數值: " + ItemhwForWidth);
        LogUtils.d("依據寬度計算鍵盤長寬數值 int: " + (int) ItemhwForWidth);
        //[依據長度]([總長(KeyBoardH)]- ( [上下間距(KeyBoardItemSpaceTB)*2(上下各有1)] * [共幾層(KeyBoardLevelNum)] ))/[共幾層(KeyBoardLevelNum)] = [每一個Item長度]
        float ItemhwForHeight = new BigDecimal(((float) KeyBoardH - (KeyBoardItemSpaceTB * 2 * KeyBoardLevelNum)) / (float) KeyBoardLevelNum + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        LogUtils.d("依據高度計算鍵盤長寬數值: " + ItemhwForHeight);
        LogUtils.d("依據高度計算鍵盤長寬數值 int: " + (int) ItemhwForHeight);
        //鍵盤按鍵 長寬 ([總寬(KeyBoardW)] - ([每一層數量(KeyBoardLevelCount)]*([鍵盤長寬(keyboardItemHW)]+[左右間距(KeyBoardItemSpaceRL)*2(兩邊各有1)]))
        float keyboardItemHW = ItemhwForWidth > ItemhwForHeight ? ItemhwForHeight : ItemhwForWidth;//TODO
        LogUtils.d("鍵盤按鍵使用長寬: " + keyboardItemHW);
        LogUtils.d("鍵盤按鍵使用長寬 int: " + (int) keyboardItemHW);
        //確定 鍵盤本身 左右間距 ([總寬(KeyBoardW)] - ([每一層數量(KeyBoardLevelCount)]*([鍵盤長寬(keyboardItemHW)]+[左右間距(KeyBoardItemSpaceRL)*2(兩邊各有1)])
        float keyboardSpaceRL = new BigDecimal((((float) KeyBoardW - (((float) ((int) keyboardItemHW)) + (KeyBoardItemSpaceRL * 2)) * KeyBoardLevelCount)) / 2 + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        LogUtils.d("鍵盤左右間距: " + keyboardSpaceRL);
        LogUtils.d("鍵盤左右間距 int: " + (int) keyboardSpaceRL);
        /**
         * 鍵盤左右間距>50 重新設置 item左右間距
         * (137 - 80) *2 = 114 總共多出來的部分
         * 114/
         */
        if (keyboardSpaceRL > 50 && KeyBoardLevelCount > 4) {
            LogUtils.d("鍵盤按鍵左右間距2: " + (int) KeyBoardItemSpaceRL);
            KeyBoardItemSpaceRL += new BigDecimal(((keyboardSpaceRL - 50f) * 2 / ((float) KeyBoardLevelCount * 2f)) + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            LogUtils.d("重新校正 鍵盤按鍵左右間距3: " + (int) KeyBoardItemSpaceRL);
            keyboardSpaceRL = 50f;
        }
        //確定 鍵盤本身 上下間距 ([總長(KeyBoardH)] - ([共幾層(KeyBoardLevelNum)]*([鍵盤長寬(keyboardItemHW)]+[上下間距(KeyBoardItemSpaceTB)*2(兩邊各有1)])+左右間距(KeyBoardItemSpaceTB))/2
        float keyboardSpaceTB = new BigDecimal((((float) KeyBoardH - (((float) ((int) keyboardItemHW)) + (KeyBoardItemSpaceTB * 2)) * KeyBoardLevelNum) + KeyBoardItemSpaceTB) / 2 + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        LogUtils.d("鍵盤上下間距: " + keyboardSpaceTB);
        LogUtils.d("鍵盤上下間距 int: " + (int) keyboardSpaceTB);

        KeyBoardItemH = (int) keyboardItemHW;
        KeyBoardItemW = (int) keyboardItemHW;
        KeyBoardMRL = (int) keyboardSpaceRL;
        KeyBoardMTB = (int) keyboardSpaceTB;

        /**
         * 答案區
         */

        /**
         * 1.確定答案格數量
         * 1-1.計算格子長寬
         * 1-2.計算每個格子xy
         */
        LogUtils.d("答案長度[含空格]:" + answerlength);
        LogUtils.d("答案長度[不含空格]:" + answerNonSpacelength);
        /**
         * fillGridNum 需要建立的格子數量 [答案長度[含空格]]
         */
        fillGridNum = answerlength;
        /**
         * 格子長寬 = 鍵盤長寬
         */
        fillGridItemH = fillGridItemW = KeyBoardItemH;
        /**
         *計算 [答題區] 左右間距、上下間距
         */
        /**
         *單一作答格子 「＋間距」
         */
        LogUtils.d("答題格子 長寬  [不含間距]:" + KeyBoardItemW);
        LogUtils.d("答題格子[空格] 長寬  [不含間距]:" + KeyBoardItemW / 2);
        float itemWidth_ = new BigDecimal(((float) KeyBoardItemW + (fillGridItemSpace * 2f) + 0.5f)).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        float itemSpaceWidth_ = new BigDecimal((((float) KeyBoardItemW / 2f) + (fillGridItemSpace * 2f) + 0.5f)).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        float itemHeight_ = new BigDecimal(((float) KeyBoardItemH + (fillGridItemSpace * 2f) + 0.5f)).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        float totalWidth_ = new BigDecimal(itemWidth_ * (float) answerNonSpacelength + itemSpaceWidth_ * (float) (answerlength - answerNonSpacelength)).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        LogUtils.d("答題格子 長寬  [含間距]:" + (int) itemWidth_);
        LogUtils.d("答題格子[空格] 長寬  [含間距]:" + (int) itemSpaceWidth_);
        LogUtils.d("答題區 總寬度 :" + (int) totalWidth_);
        /**
         * 判斷是否可以滑動？
         * 滑動的左右Ｘ值各為多少？
         */
        if (totalWidth_ < SpellKeyBoardW) {
            /**
             * (加總寬 < 螢幕寬)  => 不能滑動
             */
            fillGridCanScroll = false;
            /**
             * 設定顯示區域母體左右上下間距
             */
            float itemMRL = new BigDecimal(((float) fillGridW - totalWidth_) / (float) 2 + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            float itemMTB = new BigDecimal(((float) fillGridH - itemHeight_) / (float) 2 + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            fillGridMRL = (int) itemMRL;
            fillGridMTB = (int) itemMTB;
            LogUtils.d("答題區 上下間距 :" + fillGridMTB + ", 答題區 左右間距 :" + fillGridMRL);
        } else {
            /**
             * (加總寬 > 螢幕寬)  => 能滑動
             */
            fillGridCanScroll = true;
            /**
             * 左右滑動極限 [X]
             */
            fillGridMaxX = new BigDecimal((totalWidth_ - (float) fillGridW) / 2f + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            fillGridMinX = new BigDecimal(((float) fillGridW - totalWidth_) / 2f + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            /**
             * 預設繪製都是由 左邊開始對齊
             * 所以給予得值 = fillGridMinX 表示可以由右向左滑動 X偏移量 + [正]
             * fillGridMoveNum = fillGridMinX;
             * fillGridMoveNum = -fillGridMinX = fillGridMaxX 時，表示 已經滑到最右邊
             * 可以由左向右滑動 X偏移量 -[負]
             */
            fillGridMoveNum = fillGridMinX;
            LogUtils.d("答題區 介面左邊滑動極限Ｘ座標 fillGridMinX :" + fillGridMinX + ", 答題區 介面右邊滑動極限Ｘ座標 fillGridMaxX :" + fillGridMaxX);
            /**
             * 設定顯示區域母體左右上下間距
             */
            float itemMRL = 0;
            float itemMTB = new BigDecimal(((float) fillGridH - itemHeight_) / (float) 2 + 0.5f).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            fillGridMRL = (int) itemMRL;
            fillGridMTB = (int) itemMTB;
            LogUtils.d("答題區 上下間距 :" + fillGridMTB + ", 答題區 左右間距 :" + fillGridMRL);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtils.d("onDraw");
        if (mKeyBoardBitmap != null) {
            canvas.drawBitmap(mKeyBoardBitmap, 0, 0, null);//鍵盤
        }
        if (mFillGridBitmap != null) {
            canvas.drawBitmap(mFillGridBitmap, 0, 0, null);//答題
        }
        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, 0, 0, null);//底圖
        }


//        if (mBitmap != null) {
//            if (isMove) {
//                moveFillGrid();
//            } else {
//                fillGridAnim(canvas);//檢查有沒有答題動畫|清除動畫;
//            }
//            canvas.drawBitmap(mBitmap, 0, 0, null);//底圖
//            canvas.drawBitmap(mFillGridBitmap, 0, 0, null);//答題
//            canvas.drawBitmap(mKeyBoardBitmap, 0, 0, null);//鍵盤
//        } else {
//            LogUtils.d("mBitmap null");
//        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        LogUtils.d("SpellKeyBoard " + "widthMode:" + widthMode + " ,heightMode:" + heightMode);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        LogUtils.d("具體座標: Xl=" + left + " Yt=" + top + " Xr=" + right + " Yb=" + bottom + ",是否變動=" + changed);
        /**
         * left,top,right,bottom
         * (changed)false = 相同佈局
         * (changed)true = 不同佈局 置換佈局
         */
        if (!changed) return;
        /**
         *設定全局 長寬
         */
        SpellKeyBoardW = right;
        SpellKeyBoardH = bottom;
        LogUtils.d("View 長寬： " + "高=" + SpellKeyBoardH + " ,寬=" + SpellKeyBoardW);
        /**
         * 建立比例
         */
//        float tdW = new BigDecimal((float) SpellKeyBoardW / (float) KeyBoardLevelCount)
//                .setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
//        float tdH = new BigDecimal((float) SpellKeyBoardH / (float) KeyBoardLevelNum)
//                .setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
//        float td = tdH > tdW ? tdW : tdH;//確定計算標準
//        LogUtils.d("td  " + "tdH:" + String.valueOf(tdH) + " ,tdW:" + String.valueOf(tdW));
//        fillAreaPercentage = new BigDecimal((float) td * 2f / (float) SpellKeyBoardH)
//                .setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
//        keyboardAreaPercentage = new BigDecimal(1f - fillAreaPercentage)
//                .setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
        fillAreaPercentage = 0.3f;
        keyboardAreaPercentage = 0.7f;
        /**
         * fillAreaPercentage < 0.3 =
         */

        LogUtils.d("Percentage " + "fillAreaPercentage:" + String.valueOf(fillAreaPercentage) +
                " ,keyboardAreaPercentage:" + String.valueOf(keyboardAreaPercentage));
        /**
         * 設定 鍵盤佈局 長寬
         */
        KeyBoardW = SpellKeyBoardW;
        KeyBoardH = (int) new BigDecimal((float) SpellKeyBoardH * keyboardAreaPercentage)
                .setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
        LogUtils.d("SpellKeyBoard " + "KeyBoardW:" + KeyBoardW + " ,KeyBoardH:" + KeyBoardH);

        /**
         * 設定 顯示佈局[滑動] 長寬
         */
        fillGridW = SpellKeyBoardW;
        fillGridH = (int) new BigDecimal((float) SpellKeyBoardH * fillAreaPercentage)
                .setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();

        LogUtils.d("SpellKeyBoard " + "fillGridW:" + fillGridW + " ,fillGridH:" + fillGridH);
        /**
         * init canvas
         */
        initCanvas();
        /**
         * 計算 佈局參數 「鍵盤、答案」
         */
        initViewSize();
        /**
         * 自適應字體
         */
        TextUtils.setTextSizeForWidth(mTextPaint, KeyBoardItemH);//自適應字體
        TextUtils.setTextSizeForWidth(mAnimPaint, KeyBoardItemH);//自適應字體[動畫用]
        /**
         * 鍵盤
         */
        initKeyboard();
        /**
         * 答案格子
         */
        initFillGrid();

        //刷新
        invalidate();

        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtils.d("event.getX():" + event.getX());
        LogUtils.d("event.getY():" + event.getY());
        LogUtils.d("getAction: " + event.getAction());
        LogUtils.d("isLock: " + isLock);

        //一般touch判斷
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchX = event.getX();
                touchY = event.getY();
                touchKeyBorad(event);
                break;
            case MotionEvent.ACTION_UP:
                freedKeyBorad();
                break;
        }
        //範圍判斷
        if (keyBoardRect.contains((int) event.getX(), (int) event.getY())) {
            /**
             * 鍵盤區域
             */
            LogUtils.d("鍵盤區");
            touchKeyBoardArea(event);
        } else {
            /**
             * 答案區域
             */
            LogUtils.d("答案區");
            /**
             * 紀錄座標
             */
            touchFillGridArea(event);
        }
        return true;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    //view 被回收怎樣處理
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.d("onDetachedFromWindow");
        /**
         * 清除內存
         */
        unsubscribe();
    }

    /**
     * 回收機制
     */
    public void unsubscribe() {
        LogUtils.d("清除資訊");
        //
        if (keyBoardModel != null) {
            keyBoardModel.unsubscribe();
            keyBoardModel = null;
        }
        if (fillGridModel != null) {
            fillGridModel.unsubscribe();
            fillGridModel = null;
        }
        if (workFilterModel != null) {
            workFilterModel.unsubscribe();
            workFilterModel = null;
        }
        //
        if (mBitmap != null) {
//            LogUtils.d("1");
            mBitmap.recycle();
            mBitmap = null;
        }
        //
        if (keyBoardRect != null) {
//            LogUtils.d("2");
            keyBoardRect = null;
        }
        //
        if (fillGridRect != null) {
//            LogUtils.d("3");
            fillGridRect = null;
        }

        //圖像
        if (KeyBoardItemNormal != null) {
//            LogUtils.d("4");
            KeyBoardItemNormal.recycle();
            KeyBoardItemNormal = null;
        }
        if (KeyBoardItemTouch != null) {
//            LogUtils.d("5");
            KeyBoardItemTouch.recycle();
            KeyBoardItemTouch = null;
        }
        if (KeyboardItemBackOne != null) {
//            LogUtils.d("6");
            KeyboardItemBackOne.recycle();
            KeyboardItemBackOne = null;
        }
        if (KeyboardItemBackTwo != null) {
//            LogUtils.d("7");
            KeyboardItemBackTwo.recycle();
            KeyboardItemBackTwo = null;
        }
        if (FillGridItemNormalType1 != null) {
//            LogUtils.d("8");
            FillGridItemNormalType1.recycle();
            FillGridItemNormalType1 = null;
        }
        if (FillGridItemNormalType2 != null) {
//            LogUtils.d("9");
            FillGridItemNormalType2.recycle();
            FillGridItemNormalType2 = null;
        }

        if (keyWords != null) {
//            LogUtils.d("10");
            keyWords.clear();
            keyWords = null;
        }
        if (fillGrids != null) {
//            LogUtils.d("11");
            fillGrids.clear();
            fillGrids = null;
        }
        if (answerList != null) {
//            LogUtils.d("12");
            answerList.clear();
            answerList = null;
        }


    }

    /**
     * 鍵盤區 KeyBoardArea touch
     */
    private void touchKeyBoardArea(MotionEvent event) {
        if(isLock) return;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtils.d("ACTION_DOWN");
                //
                touchDownKeyBoardArea(event);
                break;
            case MotionEvent.ACTION_UP:
                touchUpKeyBoardArea(event);
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtils.d("ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtils.d("ACTION_CANCEL");
                break;
        }
    }

    /**
     * 答案區 touch 事件
     */
    private void touchFillGridArea(MotionEvent event) {
        /**
         * 判斷前先防呆 如果down落點 在keyboardRect return
         * isMove  = false return
         */
        if (keyBoardRect.contains((int) touchX, (int) touchY)) return;
        if(!isMove) return;
        /**
         *
         */
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                if (isLock) {
                    LogUtils.d("鎖");

                    //防呆 避免動畫結束 還沒解除lock
                    boolean isOK = true;
                    for (fillGrid f : fillGrids) {
                        if (f.isAnim() && !f.isAnimFinished()) {
                            LogUtils.d("還有還沒結束 :" + f);
                        }
                    }
                    if (isOK) isLock = false;
                    LogUtils.d("防呆解鎖 isLock: " + isLock);

                }
                LogUtils.d("沒鎖");

                LogUtils.d("ACTION_DOWN 現在的偏移量：" + fillGridMoveNum);
                float x = new BigDecimal(touchX - event.getX()).setScale(0, BigDecimal.ROUND_HALF_DOWN).floatValue();
                LogUtils.d("X位移：" + x);
                float y = new BigDecimal(touchY - event.getY()).setScale(0, BigDecimal.ROUND_HALF_DOWN).floatValue();
                LogUtils.d("y位移：" + y);
                touchX = event.getX();
                touchY = event.getY();

                //
                if (x > 0) {
                    //左滑
                    //比對右邊邊際線 x 座標
                    Rect rect = fillGrids.get(fillGrids.size() - 1).getmDrawRect();
                    if (rect.right > (SpellKeyBoardW - fillGridMRL)) {
                        //表示可以繼續左滑
                        if ((rect.right - (x * 2)) > (SpellKeyBoardW - fillGridMRL)) {
                            //足夠的滑動空間 do null 不改變
                            LogUtils.d("不改變 " + (x * 2));
                            x = x * 2;
                        } else {
                            //不足夠的滑動空間 重新設定 x = [目前的x座標 - (總寬-答題區左右間距)]
                            x = rect.right - (SpellKeyBoardW - fillGridMRL);
                            LogUtils.d("改變 " + x);
                        }
                    } else {
                        LogUtils.d("不動");//不能滑動
                        return;
                    }
                } else {
                    //右滑
                    //比對左邊邊際線 x 座標
                    Rect rect = fillGrids.get(0).getmDrawRect();
                    if (rect.left < fillGridMRL) {
                        //表示可以繼續右滑
                        if ((rect.left - (x * 2)) < fillGridMRL) {
                            //足夠的滑動空間 do null 不改變
                            x = x * 2;
                            LogUtils.d("不改變 " + x);
                        } else {
                            //不足夠的滑動空間 重新設定 x = [目前的x座標 - (總寬-答題區左右間距)]
                            x = rect.left - fillGridMRL;
                            LogUtils.d("改變 " + x);
                        }
                    } else {
                        //不能滑動
                        LogUtils.d("不動");
                        return;
                    }

                }
                LogUtils.d("ACTION_MOVE 現在的偏移量：" + x);
                mFillGridCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                /**
                 * 繪製移動
                 */
                for (fillGrid f : fillGrids) {
                    Rect currentRect = f.getmDrawRect();
                    LogUtils.d("使用rect:" + f.getAnswerRect());
                    float xOffset_l = new BigDecimal((float) currentRect.left - x).setScale(0, BigDecimal.ROUND_HALF_DOWN).floatValue();
                    float xOffset_r = new BigDecimal((float) currentRect.right - x).setScale(0, BigDecimal.ROUND_HALF_DOWN).floatValue();
                    Rect DrawRect = new Rect((int) xOffset_l, currentRect.top, (int) xOffset_r, currentRect.bottom);
                    LogUtils.d("DrawRect:" + DrawRect);
                    f.setmDrawRect(DrawRect);
                    drawFillGridItem(f.getmDrawRect(), f.getAction());
                    /**
                     * 答案格使用中
                     */
                    if (f.isUse()) {
                        f.setAnswerRect(DrawRect);
                        drawFillGridItem(f.getmDrawRect(), mFillGridPaint, mTextPaint, f.getAction(), keyWords.get(f.getAnswerIndex()).getContent());
                    }
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }


    }

    /**
     *
     */
    private void moveFillGrid() {
        mFillGridCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        //
        int index = 0;
        for (fillGrid fillGrid : fillGrids) {
            /**
             * 上答案格底圖
             */
            if (!fillGrid.getContent().equals(" ")) {
                LogUtils.d("繪製 答案格 底圖");
                mFillGridCanvas.drawBitmap(mType == 1 ? FillGridItemNormalType1 : FillGridItemNormalType2, null, fillGrid.getmDrawRect(), mFillGridPaint);
            }
            LogUtils.d(" isUse " + fillGrid.isUse() + ", isAnim" + fillGrid.isAnim() + ", isAdd" + fillGrid.isAdd());
            /**
             * 判斷 isUse 是使用過的 或是 沒有使用過的
             */

            if (fillGrid.isUse() && !fillGrid.isAnim() && !fillGrid.isAdd()) {
                LogUtils.d("答案格 使用中");
                Rect r = new Rect(fillGrid.getAnswerRect().left + KeyBoardItemPadding, fillGrid.getAnswerRect().top + KeyBoardItemPadding
                        , fillGrid.getAnswerRect().right - KeyBoardItemPadding, fillGrid.getAnswerRect().bottom - KeyBoardItemPadding);
                mFillGridCanvas.drawBitmap(KeyBoardItemTouch, null, r, mFillGridPaint);
                int textX = (int) (fillGrid.getAnswerRect().left + KeyBoardItemW / 2);
                int textY = (int) (fillGrid.getAnswerRect().top + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
                LogUtils.d(" textX " + textX + ", textY" + textY);
                mFillGridCanvas.drawText(keyWords.get(fillGrid.getAnswerIndex()).getContent(), textX, textY, mTextPaint);

                //最重要的
                fillGrid.setMove(true);//沒加上 會重疊
            }
            index++;
        }

        //鍵盤
        drawKeyboard();
    }

    /**
     * 鍵盤 touch
     */
    private void touchKeyBorad(MotionEvent event) {

        LogUtils.d("touchKeyBorad");
        keyBoardTouchIndex = getTouchKeyboardIndex(event);
        if (keyBoardTouchIndex == -1) return;

        keyboard k = keyWords.get(keyBoardTouchIndex);
        if (k.getAction().equals(k.Action_Keyboard)) {
            //keyboard
            mKeyBoardCanvas.drawBitmap(KeyBoardItemTouch, null, k.getmDrawRect(), mKeyboardPaint);
            int textX = (int) (k.getStartX() + (KeyBoardItemW / 2 - mTextPaint.measureText(k.getContent())) + 0.5f);
            int textY = (int) (k.getStartY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
            mKeyBoardCanvas.drawText(k.getContent(), k.getStartX() + KeyBoardItemW / 2, textY, mTextPaint);

        } else {
            //back
            mKeyBoardCanvas.drawBitmap(KeyboardItemBackTwo, null, k.getmDrawRect(), mKeyboardPaint);
        }
        postInvalidate();
    }

    //鍵盤 釋放 up
    private void freedKeyBorad() {
        LogUtils.d("freedKeyBorad");
        if (keyBoardTouchIndex == -1) return;
        keyboard k = keyWords.get(keyBoardTouchIndex);
        if (k.getAction().equals(k.Action_Keyboard)) {
            //keyboard
            mKeyBoardCanvas.drawBitmap(KeyBoardItemNormal, null, k.getmDrawRect(), mKeyboardPaint);
            int textX = (int) (k.getStartX() + (KeyBoardItemW / 2 - mTextPaint.measureText(k.getContent())) + 0.5f);
            int textY = (int) (k.getStartY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
            mKeyBoardCanvas.drawText(k.getContent(), k.getStartX() + KeyBoardItemW / 2, textY, mTextPaint);

        } else {
            //back
            mKeyBoardCanvas.drawBitmap(KeyboardItemBackOne, null, k.getmDrawRect(), mKeyboardPaint);

        }
        keyBoardTouchIndex = -1;//回歸預設
        postInvalidate();
    }

    /**
     * touch down
     */
    private void touchDownKeyBoardArea(MotionEvent event) {
        /**
         * 事件參數初始
         */
        isAdd = false;
        isBack = false;
        /**
         * 紀錄XY軸
         */
        touchX = event.getX();
        touchY = event.getY();
        /**
         * 取得現在的 down keyboard index
         */
        touchIndex = getTouchKeyboardIndex(event);
        LogUtils.d("touchIndex: " + touchIndex);
        /**
         * 判斷事件
         * 「使用過」「是否退回鍵」
         */
        if (touchIndex == -1) return;//無法比對
        WeakReference<keyboard> mkeyboard = new WeakReference<keyboard>(keyWords.get(touchIndex));
        if (mkeyboard.get() == null) return;//資料空 back
        if (mkeyboard.get().isUse()) return; //已經使用過
        /**
         * 驗證back鍵
         */
        if (mkeyboard.get().getAction().equals(keyboard.Action_Back)) {
            if (KeyBoardItemPreviousIndex == -1) return;//不能退後
            //可以退後
            isBack = true;
        }
        /**
         * 驗證一般按鍵
         */
        if (mkeyboard.get().getAction().equals(keyboard.Action_Keyboard)) {
            //可以加載
            isAdd = true;
        }
        LogUtils.d("isBack:" + isBack);
        LogUtils.d("isAdd:" + isAdd);
    }

    /**
     * touch up
     */
    private void touchUpKeyBoardArea(MotionEvent event) {
        /**
         * check down up place is same?
         */
        int upIndex = getTouchKeyboardIndex(event);
        if (touchIndex != upIndex) {
            LogUtils.d("座標不一致");
            //回覆所有的按鍵狀態
            drawKeyboard();
            invalidate();
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
        /**
         * 呼叫點擊鍵盤一般按鈕
         */
        listener.alreadyAdd();
        /**
         * 鎖畫布
         */
        LogUtils.d("ADD 綁定");
        //暫存
        int fillIndex = fillGridUseNextIndex;//更換前的填入位置
        //更換狀態
        fillGrids.get(fillIndex).setUse(true);
        LogUtils.d("填寫的格子 index :" + fillIndex);
        LogUtils.d("填寫的格子 index use:" + fillGrids.get(fillIndex).isUse());

        /**
         * 檢查範圍 如果填寫的格子right 超過(最大X座標-答案區左右間距)
         * 變更所有 的 答案座標 x軸 偏移量 [填寫格子的 原始範圍 right x座標] - [最大X座標-答案區左右間距]]
         */
        LogUtils.d("MRL:" + fillGridMRL);
        if (fillGrids.get(fillIndex).getmDrawRect().right > (SpellKeyBoardW - fillGridMRL)) {
            /**
             * x偏移量 fillGridXOffset
             * 方向 fillGridXDirection false 向左 -
             */
            fillGridXOffset = (int) new BigDecimal((float) fillGrids.get(fillIndex).getmDrawRect().right - (float) (SpellKeyBoardW - fillGridMRL)).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            LogUtils.d("需求位移比對 rect:" + fillGrids.get(fillIndex).getmDrawRect());
            LogUtils.d("add X需求 偏移量" + (int) fillGridXOffset);
            fillGridXDirection = false;
            //
            Rect endRect = new Rect(fillGrids.get(fillIndex).getmDrawRect().left - (int) fillGridXOffset, fillGrids.get(fillIndex).getmDrawRect().top,
                    fillGrids.get(fillIndex).getmDrawRect().right - (int) fillGridXOffset, fillGrids.get(fillIndex).getmDrawRect().bottom);
            LogUtils.d("重新建立 rect:" + endRect);
        } else {
            if (fillGrids.get(0).getmDrawRect().left < (fillGridMRL)) {
                /**
                 * x偏移量 fillGridXOffset
                 * 方向 fillGridXDirection true 向右 +
                 */
                float x = new BigDecimal((float) fillGridMRL - (float) fillGrids.get(0).getmDrawRect().left).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
                LogUtils.d("需求位移比對 rect:" + fillGrids.get(0).getmDrawRect());
                LogUtils.d("add X需求 偏移量:" + (int) x);
                fillGridXDirection = true;
                //
                Rect endRect = new Rect(fillGrids.get(fillGridUseNextIndex).getmDrawRect().left + (int) x, fillGrids.get(fillGridUseNextIndex).getmDrawRect().top,
                        fillGrids.get(fillGridUseNextIndex).getmDrawRect().right + (int) x, fillGrids.get(fillGridUseNextIndex).getmDrawRect().bottom);
                LogUtils.d("重新建立 rect:" + endRect);
            }
        }
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
        if (fillGridUseNextIndex != fillGrids.size() && fillGridUseNextIndex < fillGrids.size()) {
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
        fillGrids.get(fillIndex).setAnswerRect(fillGrids.get(fillIndex).getmDrawRect());//設定填滿位置
        fillGrids.get(fillIndex).setAnswerIndex(keyIndex);//設定填滿使用的答案按鍵index
        fillGrids.get(fillIndex).setAnim(true);//設定為動畫執行
        fillGrids.get(fillIndex).setAdd(true);//設定為填答動畫
        fillGrids.get(fillIndex).setAnimStart(false);//設定尚未動畫初始
        fillGrids.get(fillIndex).setAnimFinished(false);//動畫執行尚未結束
        fillGrids.get(fillIndex).setLocusStartRect(keyWords.get(keyIndex).getmDrawRect());//設定繪製開始範圍
        fillGrids.get(fillIndex).setLocusEndRect(fillGrids.get(fillIndex).getmDrawRect());//設定繪製結束範圍
        LogUtils.d("填寫的格子 內容 :" + fillGrids.get(fillIndex).toString());

        //重繪
        initAnimateKeyboard(animTime, fillGrids.get(fillIndex), fillIndex);
//        if(fillGridXOffset != 0){
//            initAnimateOne(animTime, fillGrids.get(fillIndex));
//        }

        /**
         * todo 檢查是否已經回答結束
         */
//        LogUtils.d("answer list size :"+answerList.size());
//        LogUtils.d("answerNonSpacelength :"+answerNonSpacelength);
        if (answerList.size() == answerNonSpacelength && confirmCorrectAnswer()) {
            /**
             * 鎖
             */
            isLock = true;
            //測試用 預設延遲三秒執行
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    endAnswer();
                }
            }, animateDelay);

        }

    }

    /**
     * 退回答案後 資料變動
     *
     * @param keyIndex 需要變動的 keyindex
     */
    private void removeAnswerMemory(int keyIndex) {
        /**
         * 呼叫點擊鍵盤back按鈕
         */
        listener.alreadyBack();
        /**
         * 鎖畫布
         */
        LogUtils.d("CLear 綁定");


        if (fillGridUseNextIndex != 0) fillGridUseNextIndex--;
        while (fillGrids.get(fillGridUseNextIndex).getAction().equals("Space")) {
            fillGridUseNextIndex--;
        }

        /**
         * 檢查範圍 如果填寫的格子 left 小於 (答案區左右間距)
         * 變更所有 的 答案座標 x軸 偏移量 [答案區左右間距] - [填寫格子的 原始範圍 left x座標]
         */
        LogUtils.d("MRL:" + fillGridMRL);
        int OffsetIndex = fillGridUseNextIndex;
        if (fillGridUseNextIndex != 0) {
            OffsetIndex = fillGridUseNextIndex - 1;//多退一格
        }
        /**
         *
         */
        if (fillGrids.get(OffsetIndex).getmDrawRect().left < (fillGridMRL)) {
            /**
             * x 偏移量
             */
            fillGridXOffset = new BigDecimal((float) fillGridMRL - (float) fillGrids.get(OffsetIndex).getmDrawRect().left).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            LogUtils.d("需求位移比對 rect:" + fillGrids.get(OffsetIndex).getmDrawRect());
            LogUtils.d("clear X需求 偏移量:" + (int) fillGridXOffset);
            fillGridXDirection = true;
            Rect endRect = new Rect(fillGrids.get(OffsetIndex).getmDrawRect().left - (int) fillGridXOffset, fillGrids.get(OffsetIndex).getmDrawRect().top,
                    fillGrids.get(OffsetIndex).getmDrawRect().right - (int) fillGridXOffset, fillGrids.get(OffsetIndex).getmDrawRect().bottom);
            LogUtils.d("重新建立的 rect:" + endRect);
        } else {
            if (fillGrids.get(OffsetIndex).getmDrawRect().right > (SpellKeyBoardW - fillGridMRL)) {
                /**
                 * x偏移量 fillGridXOffset
                 * 方向 fillGridXDirection false 向左 -
                 */
                fillGridXOffset = (int) new BigDecimal((float) fillGrids.get(OffsetIndex).getmDrawRect().right - (float) (SpellKeyBoardW - fillGridMRL)).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
                LogUtils.d("需求位移比對 rect:" + fillGrids.get(OffsetIndex).getmDrawRect());
                LogUtils.d("clear X需求 偏移量" + (int) fillGridXOffset);
                fillGridXDirection = false;
                //
                Rect endRect = new Rect(fillGrids.get(OffsetIndex).getmDrawRect().left - (int) fillGridXOffset, fillGrids.get(OffsetIndex).getmDrawRect().top,
                        fillGrids.get(OffsetIndex).getmDrawRect().right - (int) fillGridXOffset, fillGrids.get(OffsetIndex).getmDrawRect().bottom);
                LogUtils.d("重新建立 rect:" + endRect);
            }
        }

        LogUtils.d("刪除的格子 內容1 :" + fillGrids.get(fillGridUseNextIndex).toString());
        fillGrids.get(fillGridUseNextIndex).setUse(false);
        //
        fillGrids.get(fillGridUseNextIndex).setUse(false);
        fillGrids.get(fillGridUseNextIndex).setAnim(true);
        fillGrids.get(fillGridUseNextIndex).setClear(true);
        fillGrids.get(fillGridUseNextIndex).setAnimStart(false);
        fillGrids.get(fillGridUseNextIndex).setAnimFinished(false);
        fillGrids.get(fillGridUseNextIndex).setPercentage(0f);
        fillGrids.get(fillGridUseNextIndex).setLocusStartRect(fillGrids.get(fillGridUseNextIndex).getmDrawRect());
        fillGrids.get(fillGridUseNextIndex).setLocusEndRect(keyWords.get(fillGrids.get(fillGridUseNextIndex).getAnswerIndex()).getmDrawRect());
        //
        LogUtils.d("刪除的格子 內容2 :" + fillGrids.get(fillGridUseNextIndex).toString());
        //刪除答案
        answerList.remove(answerList.size() - 1);//退回最新的一筆
        //更換退回 keyboard index
        KeyBoardItemPreviousIndex = answerList.size() == 0 ? -1 : answerList.get(answerList.size() - 1);
        //更換下一個 fillGrid index
        LogUtils.d("keyIndex: " + keyIndex);
        LogUtils.d("answerList size:" + answerList.size());
        LogUtils.d("KeyBoardItemPreviousIndex:" + KeyBoardItemPreviousIndex);
        LogUtils.d("fillGridUseNextIndex:" + fillGridUseNextIndex);

        /*
         * 重繪
         */
//        updateInvalidate();//重繪
        initAnimatefillGrids(animClearTime, fillGrids.get(fillGridUseNextIndex), fillGridUseNextIndex);
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
         * 判斷是否可以繼續答題
         */
        if (answerList == null) answerList = new ArrayList<>();
        if (answerList.size() < answerNonSpacelength) {
            /**
             * 增加紀錄
             */
            addAnswerMemory(touchIndex);
        } else {
            isAdd = false;//
        }

    }

    /**
     * 繪製鍵盤
     */
    private void drawKeyboard() {


        int index = 0;
        for (keyboard k : keyWords) {
//            LogUtils.d("index:"+index+",rect"+k.getmDrawRect().toString());
            /**
             * 區分 back  and 一般
             * 如果已經使用 use = true 在答案格上 [多]繪製
             */
            if (k.getAction().equals(keyboard.Action_Keyboard)) {
                //一般鍵
                mKeyBoardCanvas.drawBitmap(KeyBoardItemNormal, null, k.getmDrawRect(), mKeyboardPaint);
                int textX = (int) (k.getStartX() + KeyBoardItemW / 2);
                int textY = (int) (k.getStartY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
                mKeyBoardCanvas.drawText(k.getContent(), textX, textY, mTextPaint);
            }
            if (k.getAction().equals(keyboard.Action_Back)) {
                //back
                mKeyBoardCanvas.drawBitmap(KeyboardItemBackOne, null, k.getmDrawRect(), mKeyboardPaint);
            }
            //
            index++;
        }

    }

    /**
     * 回傳現在觸碰到的位置 [index]
     *
     * @param event
     * @return -1表示找不到
     */
    private int getTouchKeyboardIndex(MotionEvent event) {
        int keyIndex = 0;
        for (keyboard k : keyWords) {
            //刪選點擊範圍
            if (k.getmDrawRect().contains((int) event.getX(), (int) event.getY())) {
                return keyIndex;
            }
            keyIndex++;
        }
        return -1;
    }

    /**
     * 動畫 初始設定
     */
    private void initAnimateKeyboard(int longtime, final fillGrid fillGrid, final int index) {
        /**
         * 鍵盤填寫動畫
         */
        /**
         * 設定動畫已經初始化
         */
        fillGrid.setAnimStart(true);
        /**
         * 如果同時間 答案格有偏移量 必須先設定
         */
        for (fillGrid f : fillGrids) {
            LogUtils.d("修正前 end: " + f.getLocusEndRect());
            Rect end = fillGridXDirection ? new Rect(f.getmDrawRect().left + (int) fillGridXOffset, f.getmDrawRect().top, f.getmDrawRect().right + (int) fillGridXOffset, f.getmDrawRect().bottom)
                    : new Rect(f.getmDrawRect().left - (int) fillGridXOffset, f.getmDrawRect().top, f.getmDrawRect().right - (int) fillGridXOffset, f.getmDrawRect().bottom);
            LogUtils.d("修正後 end: " + end);
            f.setLocusEndRect(end);
        }

        final ValueAnimator animator = ValueAnimator.ofInt(minAnimCode, maxAnimCode).setDuration(longtime);
        OvershootInterpolator timeInterpolator = new OvershootInterpolator();
        animator.setInterpolator(timeInterpolator);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                /**
                 * 計算動畫數值
                 */
                int value = (int) animation.getAnimatedValue();

                /**
                 * 設定動畫沒有結束
                 */
                fillGrid.setAnimFinished(false);
                /**
                 * 設定動畫數值
                 */
                fillGrid.setAnimateValue(value);
                /**
                 * 設定動畫執行百分比
                 */
                fillGrid.setPercentage(((float) fillGrid.getAnimateValue() / (float) maxAnimCode));
                LogUtils.d("value: " + value);
                LogUtils.d("Percentage: " + ((float) fillGrid.getAnimateValue() / (float) maxAnimCode));
                /**
                 * 繪製 答案格 偏移
                 */
                fillGridItemAnim(fillGrid, mFillGridCanvas, index);
                /**
                 * 刷新
                 */
                invalidate();
            }
        });
        //判斷結束
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                LogUtils.d("cancle");
                fillGrid.setAnimFinished(true);
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                LogUtils.d("結束動畫");
                /**
                 * 結束時 設定
                 */
                for (fillGrid f : fillGrids) {
                    f.setmDrawRect(f.getLocusEndRect());
                }
                //
                fillGridXOffset = 0;
                //
                LogUtils.d("動畫釋放");
                animation.cancel();//釋放
                LogUtils.d("設定狀態");
                fillGrid.setAnimFinished(true);
                LogUtils.d("動畫狀態：" + fillGrid.isAnimFinished());
                /**
                 * 刷新
                 */
                LogUtils.d("重新刷新");
                invalidate();
                super.onAnimationEnd(animation);
            }
        });
        animator.start();
    }

    /**
     * 單一clear 動畫 初始設定
     */
    private void initAnimatefillGrids(int longtime, final fillGrid fillGrid, final int index) {
        /**
         * 清除動畫
         */

        /**
         * 如果同時間 答案格有偏移量 必須先設定
         */
        for (fillGrid f : fillGrids) {
            LogUtils.d("修正前 end: " + f.getLocusEndRect());
            Rect end = fillGridXDirection
                    ?
                    new Rect(f.getmDrawRect().left + (int) fillGridXOffset, f.getmDrawRect().top, f.getmDrawRect().right + (int) fillGridXOffset, f.getmDrawRect().bottom)
                    :
                    new Rect(f.getmDrawRect().left - (int) fillGridXOffset, f.getmDrawRect().top, f.getmDrawRect().right - (int) fillGridXOffset, f.getmDrawRect().bottom);
            LogUtils.d("修正後 end: " + end);
            f.setLocusEndRect(end);
        }

        /**
         * 設定動畫已經初始化
         */
        fillGrid.setAnimStart(true);


        final ValueAnimator animator1 = ValueAnimator.ofInt(minAnimCode, maxAnimCode).setDuration(longtime);
        Interpolator timeInterpolator = new AnticipateInterpolator();
        animator1.setInterpolator(timeInterpolator);
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                /**
                 * 計算動畫數值
                 */
                int value = (int) animation.getAnimatedValue();
                /**
                 * 設定動畫沒有結束
                 */
                fillGrid.setAnimFinished(false);
                /**
                 * 設定動畫數值
                 */
                fillGrid.setAnimateValue(value);
                /**
                 * 設定動畫執行百分比
                 */
                fillGrid.setPercentage(((float) fillGrid.getAnimateValue() / (float) maxAnimCode));
                /**
                 * 繪製 答案格 偏移
                 */
                fillGridItemClearAnim(fillGrid, mFillGridCanvas, index);
                /**
                 * 刷新
                 */
                invalidate();
            }

        });
        //判斷結束
        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                LogUtils.d("cancle");
                fillGrid.setAnimFinished(true);
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                fillGridXOffset = 0;
                for (fillGrid f : fillGrids) {
                    f.setmDrawRect(f.getLocusEndRect());
                }
                fillGridItemClearAnim(fillGrid, mFillGridCanvas, index);
                LogUtils.d("清除動畫釋放");
                animation.cancel();//釋放
                LogUtils.d("結束動畫1");
                LogUtils.d("設定狀態1");
                fillGrid.setAnimFinished(true);
                LogUtils.d("動畫狀態1：" + fillGrid.isAnimFinished());
                LogUtils.d("重新刷新1");
                invalidate();
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                LogUtils.d("onAnimationEnd");
            }
        });

        animator1.start();
    }

    /**
     * clear 動畫 初始設定
     */
    private void initAnimatefillGridsClearAll(int longtime) {
        /**
         * 清除全部動畫
         * 1.計算偏移量
         */

        /**
         * x偏移量 fillGridXOffset
         * 方向 fillGridXDirection false 向左
         */
        fillGridXOffset = (int) new BigDecimal((float) fillGridMRL - (float) fillGrids.get(0).getmDrawRect().left).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        fillGridXDirection = false;
        LogUtils.d("fillGridXOffset:" + fillGridXOffset);


        final ValueAnimator animator2 = ValueAnimator.ofInt(minAnimCode, maxAnimCode).setDuration(longtime);
        Interpolator timeInterpolator = new AnticipateInterpolator();
        animator2.setInterpolator(timeInterpolator);
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()

        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                /**
                 * 計算動畫數值
                 */
                int value = (int) animation.getAnimatedValue();
                /**
                 * 繪製 答案格 偏移
                 */
                fillGridItemClearAllAnim(mFillGridCanvas, fillGridXOffset, (float) value / (float) maxAnimCode);
                /**
                 * 刷新
                 */
                invalidate();
            }

        });
        //判斷結束
        animator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                LogUtils.d("cancle");
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                LogUtils.d("結束動畫1");
                fillGridXOffset = 0;
                mAnimPaint.setAlpha(255);
                fillGrids = fillGridModel.setFillGridItemSizeAndDraw(answer, mFillGridCanvas, mFillGridPaint, mType, FillGridItemNormalType1,
                        FillGridItemNormalType2, fillGridMRL, fillGridItemW, fillGridItemSpace, fillGridMTB, fillGridItemH, 0);
                fillGridItemClearAllAnim(mFillGridCanvas, 0, 1);
                LogUtils.d("清除動畫釋放");
                animation.cancel();//釋放
                LogUtils.d("重新刷新1");
                invalidate();
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                LogUtils.d("onAnimationEnd");
            }
        });

        animator2.start();
    }


    /**
     * 鍵盤填空動畫[個體]
     */
    private void fillGridItemAnim(fillGrid fillGrid, Canvas canvas, int index) {
        mFillGridCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        LogUtils.d("填答動畫");
        LogUtils.d("原來的範圍: " + fillGrid.getLocusStartRect() + ",前往的範圍 Y: " + fillGrid.getLocusEndRect());
        /**
         * 測量距離
         */
        float disranceX = (fillGrid.getLocusStartRect().left - fillGrid.getLocusEndRect().left);
        float disranceY = (fillGrid.getLocusStartRect().top - fillGrid.getLocusEndRect().top);
//        LogUtils.d("需位移距離X: " + (int)disranceX + ",需位移距離Y: " + (int)disranceY);
        /**
         * 百分比
         */
        float percentage = fillGrid.getPercentage();
//        LogUtils.d("percentage: "+percentage);

        /**
         * 計算要繪製的地點
         */
        float x = new BigDecimal(fillGrid.getLocusStartRect().left - disranceX * percentage)
                .setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        float y = new BigDecimal(fillGrid.getLocusStartRect().top - disranceY * percentage)
                .setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();

        int inner = 0;
        for (fillGrid f : fillGrids) {
            if (fillGridXOffset != 0) {
                LogUtils.d("偏移新增");

                //
                drawFillGridItem(f.getLocusEndRect(), f.getAction());
                //
                if (f.isUse() && inner != index) {
                    drawFillGridItem(f.getLocusEndRect(), mFillGridPaint, mTextPaint, f.getAction(), keyWords.get(f.getAnswerIndex()).getContent());
                }

            } else {
                LogUtils.d("原始新增");
                //
                drawFillGridItem(f.getmDrawRect(), f.getAction());
                //
                if (f.isUse() && inner != index) {
                    drawFillGridItem(f.getmDrawRect(), mFillGridPaint, mTextPaint, f.getAction(), keyWords.get(f.getAnswerIndex()).getContent());
                }

            }
            inner++;
        }

        /**
         *
         */
        Rect rect = new Rect((int) x, (int) y,
                (int) (x + KeyBoardItemW), (int) (y + KeyBoardItemH));
        fillGrid.setAnswerRect(rect);
        drawFillGridItem(rect, mFillGridPaint, mTextPaint, "anim", keyWords.get(fillGrid.getAnswerIndex()).getContent());


        /**
         *
         */
        LogUtils.d("動畫狀態：" + fillGrid.isAnimFinished());
        if (fillGrid.isAnimFinished()) {
            fillGridXOffset = 0;

            /**
             * 狀態變化
             * isAdd > false
             * fillGrid [anim > false , add > false ,AnimFinished> false ]
             * isLock > false
             */
            fillGrid.setAnim(false);
            fillGrid.setAnimStart(false);
            fillGrid.setAdd(false);
            fillGrid.setPercentage(0f);
            LogUtils.d("isUse: " + fillGrid.isUse() + ",isAnim: " + fillGrid.isAnim() + ",isAdd: " + fillGrid.isAdd() +
                    "\n///getLocusStartRect" + fillGrid.getLocusStartRect() + "\n///getLocusEndRect" + fillGrid.getLocusEndRect());
            /**
             * 檢查所有的答案是否都回到原來的位置
             * isOK
             */
            boolean isOK = true;
            int key = 0;
            for (fillGrid f : fillGrids) {
                LogUtils.d("isAdd: " + f.isAdd() + ",isAnim: " + f.isAnim() + ",isAnimFinished: " + f.isAnimFinished());
                if (f.isAdd() || f.isAnim()) {
                    isOK = false;
                    /**
                     * 執行過快
                     */
                    if (key > index) {

                    }
                }
                key++;
            }
            /**
             * 檢查完畢
             */
            if (isOK) {
                LogUtils.d("ADD 解除綁定");
                isAdd = false;
                isLock = false;

            }

        }

    }

    /**
     * 清除答案動畫[個體]
     */
    private void fillGridItemClearAnim(fillGrid fillGrid, Canvas canvas, int index) {
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        LogUtils.d("清除動畫");
        LogUtils.d("原來的範圍: " + fillGrid.getLocusStartRect() + ",前往的範圍 Y: " + keyWords.get(fillGrid.getAnswerIndex()).getmDrawRect());
        /**
         * 測量距離 [按鍵]
         */
        float disranceX = (fillGrid.getLocusStartRect().left - keyWords.get(fillGrid.getAnswerIndex()).getmDrawRect().left);
        float disranceY = (fillGrid.getLocusStartRect().top - keyWords.get(fillGrid.getAnswerIndex()).getmDrawRect().top);
        LogUtils.d("需位移距離X: " + (int) disranceX + ",需位移距離Y: " + (int) disranceY);
        /**
         * 百分比
         */
        float percentage = fillGrid.getPercentage();
        LogUtils.d("percentage: " + percentage);
        /**
         * 計算淡化程度
         */
        int alpha = (int) new BigDecimal(((float) 1 - percentage) * (float) 255).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        mAnimPaint.setAlpha(alpha > 255 ? 255 : alpha);
        LogUtils.d("index " + index + ",alpha : " + alpha);
        /**
         * 計算要繪製的地點
         */
        float x = new BigDecimal(fillGrid.getLocusStartRect().left - disranceX * percentage)
                .setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        float y = new BigDecimal(fillGrid.getLocusStartRect().top - disranceY * percentage)
                .setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();

        int inner = 0;
        for (fillGrid f : fillGrids) {
            drawFillGridItem(f.getmDrawRect(), f.getAction());
            if (f.isUse() && inner != index) {
                drawFillGridItem(f.getmDrawRect(), mFillGridPaint, mTextPaint, f.getAction(), keyWords.get(f.getAnswerIndex()).getContent());
            }
            inner++;
        }

        /**
         *
         */
        Rect rect = new Rect((int) x, (int) y,
                (int) (x + KeyBoardItemW), (int) (y + KeyBoardItemH));
        fillGrid.setAnswerRect(rect);
        if (!fillGrid.isAnimFinished())
            drawFillGridItem(rect, mAnimPaint, mAnimPaint, "anim", keyWords.get(fillGrid.getAnswerIndex()).getContent());
        //

        if (fillGrid.isAnimFinished()) {
            LogUtils.d("清除結束");
            fillGridXOffset = 0;
            /**
             * 狀態變化
             * isAdd > false
             * fillGrid [anim > false , add > false ,AnimFinished> false ]
             * isLock > false
             * mFillGridPaint mTextPaint 畫筆alpha重新回到255
             */
            isClear = false;
            fillGrid.setAnimStart(false);
            fillGrid.setAnim(false);
            fillGrid.setClear(false);
            fillGrid.setPercentage(0f);
            mAnimPaint.setAlpha(255);
            LogUtils.d("getAlpha: " + mAnimPaint.getAlpha());

            /**
             * 檢查所有的答案是否都回到原來的位置
             * isOK
             */
            boolean isOK = true;
            for (fillGrid f : fillGrids) {
                LogUtils.d("isAdd: " + f.isAdd() + ",isAnim: " + f.isAnim() + ",isAnimFinished: " + f.isAnimFinished());
                if (f.isAdd() || f.isAnim()) {
                    isOK = false;
                }
            }
            /**
             * 檢查完畢
             */
            if (isOK) {
                LogUtils.d("CLear 解除綁定");
                isAdd = false;
                isLock = false;
            }

            /**
             * 答題正確後 動畫已經結束 的回傳
             */
            if (isFinish && isOK) {
                /**
                 * 呼叫答題正確 全數刪除答案
                 * callback answerCorrectAnimFinish 動畫結束
                 */
                listener.answerCorrectAnimFinish();
                isFinish = false;
            }
        }
    }

    /**
     * 清除答案全體
     */
    private void fillGridItemClearAllAnim(Canvas canvas, float fillGridXOffset, float percentage) {
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        /**
         *
         */
        for (fillGrid f : fillGrids) {
            /**
             * 測量距離 [按鍵]
             */
            float disranceX = (f.getmDrawRect().left - keyWords.get(f.getAnswerIndex()).getmDrawRect().left);
            float disranceY = (f.getmDrawRect().top - keyWords.get(f.getAnswerIndex()).getmDrawRect().top);
            LogUtils.d("需位移距離X: " + (int) disranceX + ",需位移距離Y: " + (int) disranceY);

            int alpha = (int) new BigDecimal(((float) 1 - percentage) * (float) 255).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            mAnimPaint.setAlpha(alpha > 255 ? 255 : alpha);
            /**
             * 計算要繪製的地點
             */
            float keyX = new BigDecimal(f.getmDrawRect().left - disranceX * percentage)
                    .setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
            float keyY = new BigDecimal(f.getmDrawRect().top - disranceY * percentage)
                    .setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
            float fillX = new BigDecimal(f.getmDrawRect().left - fillGridXOffset * percentage)
                    .setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
            float fillY = new BigDecimal(f.getmDrawRect().top)
                    .setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();

            LogUtils.d("keyX:" + keyX + ",keyY:" + keyY);
            LogUtils.d("fillX:" + fillX + ",fillY:" + fillY);

            Rect keyRect = new Rect((int) keyX, (int) keyY,
                    (int) (keyX + KeyBoardItemH), (int) (keyY + KeyBoardItemW));

            Rect fillRect = new Rect((int) fillX, (int) fillY,
                    (int) (fillX + fillGridItemH), (int) (fillY + fillGridItemW));

            LogUtils.d("keyRect:" + keyRect);
            LogUtils.d("fillRect:" + fillRect);

            drawFillGridItem(fillRect, f.getAction());
            drawFillGridItem(keyRect, mAnimPaint, mAnimPaint, f.getAction(), keyWords.get(f.getAnswerIndex()).getContent());

        }

        boolean isOK = true;
        for (fillGrid f : fillGrids) {
            if (f.isClear() || f.isAnim()) {
                isOK = false;
            }
        }

        if (isOK) {
            LogUtils.d("CLear 解除綁定");
            isAdd = false;
            isLock = false;
        }

        if (isFinish && isOK) {
            /**
             * 呼叫答題正確 全數刪除答案
             * callback answerCorrectAnimFinish 動畫結束
             */
            listener.answerCorrectAnimFinish();
            isFinish = false;
        }


    }

    /**
     * 檢查答題是否正確
     * true 正確 false 錯誤
     */
    private boolean confirmCorrectAnswer() {
        StringBuffer b = new StringBuffer();
        for (fillGrid f : fillGrids) {
            if (!f.getAction().equals(fillGrid.Action_Space)) {
                b.append(keyWords.get(f.getAnswerIndex()).getContent());
            } else {
                b.append(" ");
            }
        }
        LogUtils.d("答案: " + b.toString());
        /**
         * 檢查答案是否正確
         */
        if (b.toString().equals(answer)) {
            listener.answerCorrect(b.toString());
            return true;
        } else {
            listener.answerError(b.toString());
            isLock = false;
            return false;
        }
    }

    /**
     * 結束答題[落幕動畫]
     */
    public void endAnswer() {
        /**
         * 中途取消 答案數量不夠 不執行跳出
         */
        if (answerList.size() != answerNonSpacelength) return;
        /**
         * 檢查範圍 如果填寫的格子right 超過(最大X座標-答案區左右間距)
         * 變更所有 的 答案座標 x軸 偏移量 [填寫格子的 原始範圍 right x座標] - [最大X座標-答案區左右間距]]
         */
        LogUtils.d("MRL:" + fillGridMRL);
        if (fillGrids.get(0).getmDrawRect().left < (fillGridMRL)) {
            /**
             * x偏移量 fillGridXOffset
             * 方向 fillGridXDirection true 向右 +
             */
            float x = new BigDecimal((float) fillGridMRL - (float) fillGrids.get(0).getmDrawRect().left).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
            LogUtils.d("需求位移比對 rect:" + fillGrids.get(0).getmDrawRect());
            LogUtils.d("add X需求 偏移量:" + (int) x);
            fillGridXDirection = false;
            //
            Rect endRect = new Rect(fillGrids.get(0).getmDrawRect().left + (int) x, fillGrids.get(0).getmDrawRect().top,
                    fillGrids.get(0).getmDrawRect().right + (int) x, fillGrids.get(0).getmDrawRect().bottom);
            LogUtils.d("重新建立 rect:" + endRect);
        }


        /**
         * 設定動畫判斷參數
         * Use = false
         * isAnim = true
         * isClear = true
         */
        for (fillGrid f : fillGrids) {
            f.setUse(false);
            f.setAnim(true);
            f.setClear(true);
            f.setAnimStart(false);
            f.setAnimFinished(false);
            f.setPercentage(0f);
            f.setLocusStartRect(f.getmDrawRect());
            f.setLocusEndRect(keyWords.get(f.getAnswerIndex()).getmDrawRect());
        }
        /**
         * 全部清除動畫
         */
        initAnimatefillGridsClearAll(animAllClearTime);
        /**
         * 資料初始化
         */
        isClear = true;
        isFinish = true;
        fillGridUseNextIndex = 0;
        KeyBoardItemPreviousIndex = -1;
        answerList.clear();
    }

    /**
     * 呼叫更新
     */
    public void updateKeyword() {

        //延遲500毫秒
        this.postDelayed(new Runnable() {
            @Override
            public void run() {
                //清空畫布
                mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                mKeyBoardCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                mFillGridCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                //尚未有點擊需要退回的index [-1 = 沒有需要退回的index]
                KeyBoardItemPreviousIndex = -1;
                //下一個使用的 作答格子[紀錄] 歸0
                fillGridUseNextIndex = 0;
                //答案資料清空
                if (answerList != null) answerList.clear();
                //計算 佈局參數 「鍵盤、答案」
                initViewSize();
                //初始化鍵盤區
                initKeyboard();
                //初始化答題區
                initFillGrid();
                //刷新
                invalidate();
                //
                listener.update();
            }
        },500);

    }

    /**
     * 畫 沒使用過的 答案格
     *
     * @param rect   範圍
     * @param Action 屬性
     */
    private void drawFillGridItem(Rect rect, String Action) {
        /**
         * Space , normal
         */
        if (!Action.equals(fillGrid.Action_Space)) {
            mFillGridCanvas.drawBitmap(mType == 1 ? FillGridItemNormalType1 : FillGridItemNormalType2, null, rect, mFillGridPaint);
        }
    }

    /**
     * 畫 使用過的 答案格
     *
     * @param rect    範圍
     * @param p       圖示畫筆
     * @param tp      文字畫筆
     * @param Action  屬性
     * @param content 文字內容
     */
    private void drawFillGridItem(Rect rect, Paint p, Paint tp, String Action, String content) {
        /**
         * Space , normal
         */
        if (!Action.equals(fillGrid.Action_Space)) {

            Rect r = new Rect(rect.left + KeyBoardItemPadding, rect.top + KeyBoardItemPadding,
                    rect.right - KeyBoardItemPadding, rect.bottom - KeyBoardItemPadding);
            mFillGridCanvas.drawBitmap(KeyBoardItemTouch, null, r, p);
            int textX = (int) (rect.left + KeyBoardItemW / 2);
            int textY = (int) (rect.top + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
            mFillGridCanvas.drawText(content, textX, textY, tp);
        }

    }

}
