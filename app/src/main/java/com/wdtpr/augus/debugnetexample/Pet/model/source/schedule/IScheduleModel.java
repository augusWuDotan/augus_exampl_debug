package com.wdtpr.augus.debugnetexample.Pet.model.source.schedule;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleDayBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleWeekBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSNotReadBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outSchedule;

import java.util.List;

/**
 * Created by augus on 2017/12/9.
 */

public interface IScheduleModel {


    interface ScheduleStateListener {

        void onStart();

        void onUnknowError(String errorStr);

        void onComplete();

        void ScheduleFail();

        void GETDayScheduleSuccess(ScheduleDayBean bean);

        void GETWeekScheduleSuccess(ScheduleWeekBean bean);

        void POSTScheduleRuleSuccess(Status bean);

        void POSTDayScheduleRuleSuccess(Status bean);


    }

    //取得 store 當日營業
    void GETDaySchedule(String Authorization,int store_id,String date);

    //取得 store 當週營業
    void GETWeekSchedule(String Authorization,int store_id);

    //建立 store 週營業規則
    void POSTScheduleRule(String Authorization,String weekday,List<outSchedule> time_ranges);

    //建立 store 日營業規則
    void POSTDayScheduleRule(String Authorization,String date,List<outSchedule> time_ranges);
}
