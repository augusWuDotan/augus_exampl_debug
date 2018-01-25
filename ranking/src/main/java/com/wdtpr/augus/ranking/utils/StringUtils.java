package com.wdtpr.augus.ranking.utils;

/**
 * Created by augus on 2017/12/8.
 * String 工具類
 */

public class StringUtils {

    /**
     * 檢查是否為 "" or null
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        if (value != null && !"".equalsIgnoreCase(value.trim()) && !"null".equalsIgnoreCase(value.trim())) {
            return false;
        } else {
            return true;
        }
    }

}
