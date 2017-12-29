package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by augus on 2017/12/26.
 */
@StringDef({Profile_Level.gray, Profile_Level.yellow,Profile_Level.red,Profile_Level.green})
@Retention(RetentionPolicy.SOURCE)
public @interface Level {
}
