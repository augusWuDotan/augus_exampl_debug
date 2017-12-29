package com.wdtpr.augus.bjprofile.bjDemo.utils;

import android.icu.text.SimpleDateFormat;
import android.util.Log;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by augus on 2017/10/22.
 */

public class DateUtils {

    /**
     * 取得不一樣時間格式的字串
     *
     * @param time    時間
     * @param FormNow 原始格式
     * @param ForNext 新的格式
     * @return
     */
    public static String getFormTimeStr(String time, String FormNow, String ForNext) {

        try {

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                SimpleDateFormat sdf_now = new SimpleDateFormat(FormNow);
                SimpleDateFormat sdf_next = new SimpleDateFormat(ForNext);
                sdf_now.setLenient(false);//檢查時間 //不正確 會有問題
                sdf_next.setLenient(false);//檢查時間 //不正確 會有問題
                Date curDate = sdf_now.parse(time);
                return sdf_next.format(curDate);
            } else {
                java.text.SimpleDateFormat sdf_now = new java.text.SimpleDateFormat(FormNow);
                java.text.SimpleDateFormat sdf_next = new java.text.SimpleDateFormat(ForNext);
                sdf_now.setLenient(false);//檢查時間 //不正確 會有問題
                sdf_next.setLenient(false);//檢查時間 //不正確 會有問題
                Date curDate = sdf_now.parse(time);
                return sdf_next.format(curDate);
            }

        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 取得現在的時間
     *
     * @param Form 顯示的格式
     * @return
     */
    public static String getDateNow(String Form) {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

            SimpleDateFormat sdf_next = new SimpleDateFormat(Form);
            sdf_next.setLenient(false);//檢查時間 //不正確 會有問題
            Date curDate = new Date();
            return sdf_next.format(curDate);
        } else {
            java.text.SimpleDateFormat sdf_next = new java.text.SimpleDateFormat(Form);
            sdf_next.setLenient(false);//檢查時間 //不正確 會有問題
            Date curDate = new Date();
            return sdf_next.format(curDate);
        }

    }

    /**
     * 檢查是否有超過一個月「包月」
     * @param creatTime
     * @return
     */
    public static boolean getTimeIsOutMonthly(String creatTime) {
        try {
            long curMillis;//傳入
            long nowMillis;//現在
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setLenient(false);//檢查時間 //不正確 會有問題

                Date curDate = sdf.parse(creatTime);
                curMillis = curDate.getTime(); //傳入時間

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -1);//減一個月
                Date nowDate = calendar.getTime();
                nowMillis = nowDate.getTime(); //現在時間

            } else {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setLenient(false);//檢查時間 //不正確 會有問題

                Date curDate = sdf.parse(creatTime);
                curMillis = curDate.getTime(); //傳入時間

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -1);//減一個月
                Date nowDate = calendar.getTime();
                nowMillis = nowDate.getTime(); //現在時間
            }

            if(nowMillis>curMillis){
                return true;//過期
            }else{
                return false;//還沒過期
            }

        } catch (ParseException e) {
            Log.e("DateModule","ParseException");
            return false;
        }
    }

    //不能提早完工 [開始時間之後才能使用]
    public static boolean checkFinishTime( String finishTime){
        long curMillis;//傳入
        long nowMillis;//現在
        try {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setLenient(false);//檢查時間 //不正確 會有問題

                Date curDate = sdf.parse(finishTime);
                curMillis = curDate.getTime(); //傳入時間

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -1);//減一個月
                Date nowDate = calendar.getTime();
                nowMillis = nowDate.getTime(); //現在時間

            } else {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setLenient(false);//檢查時間 //不正確 會有問題

                Date curDate = sdf.parse(finishTime);
                curMillis = curDate.getTime(); //傳入時間

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -1);//減一個月
                Date nowDate = calendar.getTime();
                nowMillis = nowDate.getTime(); //現在時間
            }

            if(nowMillis>curMillis){
                return true;//可以點擊完工
            }else{
                return false;//還沒到開始時間
            }

        } catch (ParseException e) {
            Log.e("checkFinishTime","ParseException");
            return false;
        }
    }
}
