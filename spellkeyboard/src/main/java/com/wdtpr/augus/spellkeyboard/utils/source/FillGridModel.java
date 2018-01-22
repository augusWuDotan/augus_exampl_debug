package com.wdtpr.augus.spellkeyboard.utils.source;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.wdtpr.augus.spellkeyboard.model.bean.fillGrid;
import com.wdtpr.augus.spellkeyboard.utils.LogUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by augus on 2018/1/18.
 */

public class FillGridModel {
    private List<fillGrid> fillGrids;

    public FillGridModel() {
    }

    public void unsubscribe() {
        if (fillGrids != null) {
            fillGrids.clear();
            fillGrids = null;
        }
    }


    /**
     *
     *
     * @param answer
     * @param fillGridMRL
     * @param fillGridItemW
     * @param fillGridItemSpace
     * @param fillGridMTB
     * @param fillGridItemH
     * @param xOffset 位移
     * @return
     */
    public List<fillGrid> setFillGridItemSizeAndDraw(String answer, Canvas mCanvas, Paint mFillGridPaint, int mType, Bitmap FillGridItemNormalType1,
                                                 Bitmap FillGridItemNormalType2,int fillGridMRL, int fillGridItemW, float fillGridItemSpace,
                                                     int fillGridMTB, int fillGridItemH , int xOffset) {
        /**
         * 建立格子資訊
         * (fillGridItemW/2)*spaceNum 空格
         * [外層間距 SpellKeyBoardMargin]
         */
        fillGrids = new ArrayList<>();
        int index = 0;
        int spaceNum = 0;
        for (char c : answer.toCharArray()) {
            float fillx = new BigDecimal((float) fillGridMRL + (fillGridItemW / 2) * spaceNum +
                    (((float) fillGridItemW + (fillGridItemSpace * 2)) * (float) index)).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue() + 0.5f;
            float filly = +fillGridMTB;

            fillGrid fb = new fillGrid();
            fb.setContent(String.valueOf(c));
            fb.setStartX(fillx);
            fb.setStartX(filly);
            /**
             *
             */
            Rect r = new Rect((int) fillx-xOffset, (int) filly, (int) (fillx + fillGridItemW)-xOffset, (int) (filly + fillGridItemH));
            fb.setmDrawRect(r);//放入繪製範圍

            if (String.valueOf(c).equals(" ")) {
                //空格資料
                fb.setAction(fb.Action_Space);
                spaceNum++;
            } else {
                //非空格資料
                fb.setAction(fb.Action_Fillgrid);
                mCanvas.drawBitmap(mType == 1 ? FillGridItemNormalType1 : FillGridItemNormalType2, null, r, mFillGridPaint);
                index++;
            }

            LogUtils.d("index :"+(index+spaceNum)+" 答案格資料: " + fb.toString());
            fillGrids.add(fb);
        }

        return fillGrids;
    }


    public  void drawItem(fillGrid fillGrid , Canvas canvas ,Paint paint, int mType , Bitmap FillGridItemNormalType1,Bitmap FillGridItemNormalType2){
        if (String.valueOf(fillGrid.getAction()).equals(" ")) {
            //空格
        } else {
            //非空格資料
            canvas.drawBitmap(mType == 1 ? FillGridItemNormalType1 : FillGridItemNormalType2, null, fillGrid.getmDrawRect() , paint);
        }
    }


}
