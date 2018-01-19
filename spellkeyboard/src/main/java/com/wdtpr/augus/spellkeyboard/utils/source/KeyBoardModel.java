package com.wdtpr.augus.spellkeyboard.utils.source;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.wdtpr.augus.spellkeyboard.model.bean.keyboard;
import com.wdtpr.augus.spellkeyboard.utils.LogUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by augus on 2018/1/18.
 * 鍵盤
 */

public class KeyBoardModel {

    private List<keyboard> mkeyboardlist;

    public KeyBoardModel() {
    }

    public void unsubscribe() {
        if (mkeyboardlist != null)
            mkeyboardlist.clear();
        mkeyboardlist = null;
    }

    /**
     * 每一個鍵盤的位置 座標 初始繪製 每一個按鍵
     *
     * @param keyboards           鍵盤按鍵 [尚未給予座標]
     * @param mCanvas             畫布
     * @param KeyBoardLevelCount  每一層的按鍵數量
     * @param KeyBoardMRL         鍵盤整體左右間距
     * @param KeyBoardMTB         鍵盤整體上下間距
     * @param KeyBoardItemSpaceRL 鍵盤按鍵左右間距
     * @param KeyBoardItemSpaceTB 鍵盤按鍵上下間距
     * @param KeyBoardItemW       鍵盤按鍵 寬
     * @param KeyBoardItemH       鍵盤按鍵 高
     * @param fillGridH           答案區 高
     * @param KeyBoardItemNormal  鍵盤按鍵 圖示[一般鍵/尚未點擊]
     * @param KeyboardItemBackOne 鍵盤按鍵 圖示[退後鍵]
     * @param mKeyboardPaint      鍵盤圖示畫筆
     * @param mTextPaint          鍵盤內容畫筆
     * @return
     */
    public List<keyboard> setKeyBoardItemSize(List<keyboard> keyboards, Canvas mCanvas, int KeyBoardLevelCount,
                                              int KeyBoardMRL, int KeyBoardMTB, float KeyBoardItemSpaceRL, float KeyBoardItemSpaceTB,
                                              int KeyBoardItemW, int fillGridH, int KeyBoardItemH, Bitmap KeyBoardItemNormal,
                                              Bitmap KeyboardItemBackOne, Paint mKeyboardPaint, Paint mTextPaint) {
        mkeyboardlist = keyboards;
        /**
         * 迴圈內必須知道建立的是第幾個按鍵
         * 假設 KeyBoardNum = 18 | KeyBoardLevelNum = 3 | KeyBoardLevelCount = 6
         * 處理的position 0-17
         * 1.x層級 = position%KeyBoardLevelCount [0-5] [依據每一層的數量給予餘數 = index]
         * 2.y層級 = position/KeyBoardLevelCount
         */

        int index = 0;
        BigDecimal Count = new BigDecimal(KeyBoardLevelCount);
        Rect r = null;
        LogUtils.d("每一層 幾個鍵  : " + KeyBoardLevelCount);
        LogUtils.d("鍵盤左右間距  : " + KeyBoardMRL);
        LogUtils.d("鍵盤上下間距  : " + KeyBoardMTB);
        LogUtils.d("鍵盤按鍵左右間距  : " + KeyBoardItemSpaceRL);
        LogUtils.d("鍵盤按鍵上下間距  : " + KeyBoardItemSpaceTB);
        for (keyboard k : keyboards) {
            BigDecimal index_ = new BigDecimal(index);
            int x = (int) (index_.divideAndRemainder(Count)[1].floatValue());
            int y = (int) (index_.divide(Count, 0, BigDecimal.ROUND_DOWN).floatValue());
            /**
             * 設定繪圖參數
             * x = [外層間距 SpellKeyBoardMargin]＋[左側鍵盤間隔寬度 KeyBoardMRL] + (([按鍵寬度 KeyBoardItemW] + [按鍵左右間隔*2  KeyBoardItemSpaceRL * 2])* x(x層級)
             * y = [外層間距 SpellKeyBoardMargin]＋[答案輸入範圍高度 fillGridH] + [按鍵寬度 KeyBoardItemH]+[按鍵左右間隔*2  KeyBoardItemSpaceRL * 2]
             */
            float ItemX = KeyBoardMRL + KeyBoardItemSpaceRL + ((KeyBoardItemW + (KeyBoardItemSpaceRL * 2)) * x);
            float ItemY = fillGridH + KeyBoardMTB + ((KeyBoardItemH + (KeyBoardItemSpaceTB * 2)) * y);
            k.setStartX(ItemX);
            k.setStartY(ItemY);
            r = new Rect((int) ItemX, (int) ItemY,
                    (int) ItemX + KeyBoardItemW, (int) ItemY + KeyBoardItemH);
            k.setmDrawRect(r);
            LogUtils.d("層級 x : " + x + ", ItemW: " + (int) ItemX +" ; 層級 y : " + y + ", ItemH: " + (int) ItemY
            +";\n"+"index:" + index + ",rect" + k.getmDrawRect().toString()+" ; "
                    +"left:" + k.getmDrawRect().left + ",top:" + k.getmDrawRect().top + ",right:" + k.getmDrawRect().right + ",bottom:" + k.getmDrawRect().bottom);
            /**
             * 區分 back  and 一般
             * 如果已經使用 use = true 在答案格上 [多]繪製
             */
            if (k.getAction().equals(keyboard.Action_Keyboard)) {
                //一般鍵
                mCanvas.drawBitmap(KeyBoardItemNormal, null, k.getmDrawRect(), mKeyboardPaint);
                int textX = (int) (k.getStartX() + KeyBoardItemW / 2);
                int textY = (int) (k.getStartY() + (KeyBoardItemW / 2 - ((mTextPaint.descent() + mTextPaint.ascent()))) - 0.5f);
                mCanvas.drawText(k.getContent(), textX, textY, mTextPaint);
            }
            if (k.getAction().equals(keyboard.Action_Back)) {
                //back
                mCanvas.drawBitmap(KeyboardItemBackOne, null, k.getmDrawRect(), mKeyboardPaint);
            }
            //
            index++;
        }
        return mkeyboardlist;
    }
}
