package com.wdtpr.augus.debugnetexample.base.Utils;

import java.util.regex.Pattern;

/**
 * Created by augus on 2017/12/2.
 * 輸出格式檢查
 */

public class FormatUtils {
    /**
     * 手機門號檢查程式
     *
     */
    public static final Pattern MSISDN_PATTERN = Pattern
            .compile("[+-]?\\d{10,12}");

    public static boolean isValidMSISDN(String msisdn) {
        boolean result = false;
        if (MSISDN_PATTERN.matcher(msisdn).matches()) {
            result = true;
        }
        return result;
    }
}
