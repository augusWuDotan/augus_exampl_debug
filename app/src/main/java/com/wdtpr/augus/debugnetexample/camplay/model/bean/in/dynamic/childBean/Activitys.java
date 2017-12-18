package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/5.
 */

public class Activitys implements Serializable {
    //activity
        /*
        {
        "Activity_ID": 19,
        "Activity_Cover": "https://campimages.blob.core.windows.net/images/Activity/20170725180924943.jpg",
        "Activity_Title": "朋友多94狂",
        "Activity_Date": "2017-07-25T00:00:00",
        "Activity_DueDate": "2017-08-07T00:00:00",
        "Activity_URL": "http://wowfans.digwow.com/index.php?eventsn=67745",
        "ActivityPics": [
          {
            "ActivityPic_ID": 30,
            "Activity_ID": 19,
            "ActivityPic_URL": "https://campimages.blob.core.windows.net/images/Activity/20170725180925162.jpg",
            "ActivityPic_Sort": 1
          }
        ]
      }
         */

    private String Activity_ID;//
    private String Activity_Cover;//
    private String Activity_Title;//標題
    private String Activity_Date;//開始時間
    private String Activity_DueDate;//結束時間
    private String Activity_URL;//連結網址
    private List<ActivityPics> ActivityPics;//下一頁 廣告圖示


    public String getActivity_ID() {
        return Activity_ID;
    }

    public void setActivity_ID(String activity_ID) {
        Activity_ID = activity_ID;
    }

    public String getActivity_Cover() {
        return Activity_Cover;
    }

    public void setActivity_Cover(String activity_Cover) {
        Activity_Cover = activity_Cover;
    }

    public String getActivity_Title() {
        return Activity_Title;
    }

    public void setActivity_Title(String activity_Title) {
        Activity_Title = activity_Title;
    }

    public String getActivity_Date() {
        return Activity_Date;
    }

    public void setActivity_Date(String activity_Date) {
        Activity_Date = activity_Date;
    }

    public String getActivity_DueDate() {
        return Activity_DueDate;
    }

    public void setActivity_DueDate(String activity_DueDate) {
        Activity_DueDate = activity_DueDate;
    }

    public String getActivity_URL() {
        return Activity_URL;
    }

    public void setActivity_URL(String activity_URL) {
        Activity_URL = activity_URL;
    }

    public List<ActivityPics> getActivityPics() {
        return ActivityPics;
    }

    public void setActivityPics(List<ActivityPics> activityPics) {
        ActivityPics = activityPics;
    }

    @Override
    public String toString() {
        return "Activitys{" +
                "Activity_ID='" + Activity_ID + '\'' +
                ", Activity_Cover='" + Activity_Cover + '\'' +
                ", Activity_Title='" + Activity_Title + '\'' +
                ", Activity_Date='" + Activity_Date + '\'' +
                ", Activity_DueDate='" + Activity_DueDate + '\'' +
                ", Activity_URL='" + Activity_URL + '\'' +
                ", ActivityPics=" + ActivityPics +
                '}';
    }
}
