package com.wdtpr.augus.spellkeyboard.utils.source;

import com.wdtpr.augus.spellkeyboard.model.bean.keyboard;
import com.wdtpr.augus.spellkeyboard.utils.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by augus on 2018/1/18.
 * 單字篩選
 */

public class WorkFilterModel {

    private List<keyboard> keyWords;
    private Set mSet;

    public WorkFilterModel() {
    }

    public void unsubscribe() {
        //
        if (keyWords != null) {
            keyWords.clear();
            keyWords = null;
        }
        //
        if (mSet != null) {
            mSet.clear();
            mSet = null;
        }


    }

    /**
     * 建立鍵盤內容
     * @param answer 答案
     * @param KeyboardItemNum 鍵盤數
     * @param KeyBoardLevelCount 每一層的數量
     * @return
     */
    public  List<keyboard> getKeyboardWord(String answer , int KeyboardItemNum ,int KeyBoardLevelCount){
        /**
         *鍵盤內容 [ (back)*1 , 其他按鍵(不重複)]
         */
        mSet = new HashSet();//儲存體「不重複」以篩選為主
        keyWords = new ArrayList();//實際儲存回傳

        /**
         * 置入答案 建立 按鍵訊息
         * Set 檢查用
         * keyWords 儲存答案
         */
        for (char c : answer.toCharArray()) {
            StringBuffer b = new StringBuffer();
            b.append(c);
            if (!String.valueOf(c).equals(" ") && mSet.add(b.toString())) {
                //回傳true 表示不重複
                keyboard k = new keyboard();
                k.setAction(keyboard.Action_Keyboard);
                k.setContent(b.toString());
                keyWords.add(k);
            }
        }
        LogUtils.d("刪選集合長度 : " + mSet.size() + ", "+"儲存集合長度 : " + keyWords.size());

        /**
         * 如果答案儲存完 仍不足 鍵盤數量內容
         * 篩選比對單字集 補足鍵盤內容
         */
        do {
            StringBuffer buffer = new StringBuffer();
            Random r = new Random();
            buffer.append(getRandomEnglishChar(r.nextInt(53)));//A~Z a~z ' - ; 54個char ; 0-53
            if (mSet.add(buffer.toString())) {
                //回傳true 表示不重複
                keyboard k = new keyboard();
                k.setAction(keyboard.Action_Keyboard);
                k.setContent(String.valueOf(buffer.toString()));
                keyWords.add(k);
            }
        } while (keyWords.size() < KeyboardItemNum - 1);
        LogUtils.d("KeyBoardNum:" + KeyboardItemNum);
        LogUtils.d("mSet 按鍵集合 set : " + mSet.size() +"\n"+"mSet 按鍵內容 set : " + mSet.toString());
        LogUtils.d("mSet 按鍵集合 list : " + keyWords.size()+"\n"+"mSet 按鍵內容 list : " + keyWords.toString());
        /**
         *  排序打亂
         */
        Collections.shuffle(keyWords);
        /**
         * 加入back
         */
        keyboard k_back = new keyboard();
        k_back.setAction(keyboard.Action_Back);
        keyWords.add((KeyBoardLevelCount - 1), k_back);
        LogUtils.d("按鍵內容 list index[KeyBoardLevelCount-1] : " + keyWords.get(KeyBoardLevelCount - 1).toString());

        return keyWords;
    }


    /**
     * 取得隨機 英文字 A~Z , a~z , ' -  [54個字母]
     *
     * @param index
     * @return
     */
    private static String getRandomEnglishChar(int index) {

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
}
