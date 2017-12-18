package com.wdtpr.augus.debugnetexample.base.Utils;

import java.util.List;

/**
 * Created by augus on 2017/12/8.
 * list 工具類
 */

public class ListUtils {

    /**
     * 取得 list 長度
     * @param sourceList
     *
     * @return
     */
    public static <V> int getSize(List<V> sourceList) {
        return sourceList == null ? 0 : sourceList.size();
    }

    /**
     * 檢查 list 是否為空
     * @param sourceList
     *
     * @return
     */
    public static <V> boolean isEmpty(List<V> sourceList) {
        return (sourceList == null || sourceList.size() == 0);
    }

}
