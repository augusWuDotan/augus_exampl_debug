package com.wdtpr.augus.debugnetexample.Pet.presenter.schedule;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetCreateStatusBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetHasMonthCardBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetVariety;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleDayBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleWeekBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outSchedule;
import com.wdtpr.augus.debugnetexample.base.IBasePresenter;
import com.wdtpr.augus.debugnetexample.base.IBaseView;

import java.util.List;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/13.
 * User
 */

public interface IScheduleContract {

    interface ScheduleView extends IBaseView {

        void ScheduleFail();

        void GETDayScheduleSuccess(ScheduleDayBean bean);

        void GETWeekScheduleSuccess(ScheduleWeekBean bean);

        void POSTScheduleRuleSuccess(Status bean);

        void POSTDayScheduleRuleSuccess(Status bean);
    }

    interface Presnter extends IBasePresenter {

        //取得 store 當日營業
        void GETDaySchedule(String Authorization,int store_id,String date);

        //取得 store 當週營業
        void GETWeekSchedule(String Authorization,int store_id);

        //建立 store 週營業規則
        void POSTScheduleRule(String Authorization,String weekday,List<outSchedule> time_ranges);

        //建立 store 日營業規則
        void POSTDayScheduleRule(String Authorization,String date,List<outSchedule> time_ranges);

    }
}
