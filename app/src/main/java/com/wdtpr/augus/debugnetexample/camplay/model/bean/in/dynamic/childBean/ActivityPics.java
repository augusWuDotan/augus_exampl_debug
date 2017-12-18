package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/5.
 */

public class ActivityPics implements Serializable {
    /*
       "ActivityPics": [
         {
           "ActivityPic_ID": 30,
           "Activity_ID": 19,
           "ActivityPic_URL": "https://campimages.blob.core.windows.net/images/Activity/20170725180925162.jpg",
           "ActivityPic_Sort": 1
         }
       ]
       */
    private String ActivityPic_ID;//base
    private String Activity_ID;//base
    private String ActivityPic_URL;//活動點進去的的圖片url
    private String ActivityPic_Sort;

    public String getActivity_ID() {
        return Activity_ID;
    }

    public void setActivity_ID(String activity_ID) {
        Activity_ID = activity_ID;
    }

    public String getActivityPic_ID() {
        return ActivityPic_ID;
    }

    public void setActivityPic_ID(String activityPic_ID) {
        ActivityPic_ID = activityPic_ID;
    }

    public String getActivityPic_URL() {
        return ActivityPic_URL;
    }

    public void setActivityPic_URL(String activityPic_URL) {
        ActivityPic_URL = activityPic_URL;
    }

    public String getActivityPic_Sort() {
        return ActivityPic_Sort;
    }

    public void setActivityPic_Sort(String activityPic_Sort) {
        ActivityPic_Sort = activityPic_Sort;
    }

    @Override
    public String toString() {
        return "ActivityPics{" +
                "ActivityPic_ID='" + ActivityPic_ID + '\'' +
                ", Activity_ID='" + Activity_ID + '\'' +
                ", ActivityPic_URL='" + ActivityPic_URL + '\'' +
                ", ActivityPic_Sort='" + ActivityPic_Sort + '\'' +
                '}';
    }
}
