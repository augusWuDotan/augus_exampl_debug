package com.wdtpr.augus.debugnetexample.Pet.presenter.schedule;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleDayBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleWeekBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outSchedule;
import com.wdtpr.augus.debugnetexample.Pet.model.source.schedule.IScheduleModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.schedule.ScheduleModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

import java.util.List;

/**
 * Created by augus on 2017/12/17.
 */

public class SchedulePresenter extends BasePresenter implements IScheduleContract.Presnter {

    private IScheduleContract.ScheduleView scheduleView;
    private ScheduleModel scheduleModel;

    public SchedulePresenter(IScheduleContract.ScheduleView scheduleView) {
        this.scheduleView = scheduleView;
        scheduleModel = new ScheduleModel(scheduleStateListener);
    }

    public IScheduleModel.ScheduleStateListener scheduleStateListener = new IScheduleModel.ScheduleStateListener() {
        @Override
        public void onStart() {
            scheduleView.showLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            scheduleView.showUnknowError(errorStr);
        }

        @Override
        public void onComplete() {
            scheduleView.hideLoading();
        }

        @Override
        public void ScheduleFail() {
            scheduleView.ScheduleFail();
        }

        @Override
        public void GETDayScheduleSuccess(ScheduleDayBean bean) {
            scheduleView.GETDayScheduleSuccess(bean);
        }

        @Override
        public void GETWeekScheduleSuccess(ScheduleWeekBean bean) {
            scheduleView.GETWeekScheduleSuccess(bean);
        }

        @Override
        public void POSTScheduleRuleSuccess(Status bean) {
            scheduleView.POSTScheduleRuleSuccess(bean);
        }

        @Override
        public void POSTDayScheduleRuleSuccess(Status bean) {
            scheduleView.POSTDayScheduleRuleSuccess(bean);
        }
    };

    @Override
    public void unsubscribe() {
        scheduleModel.unsubscribe();
        scheduleModel = null;
        scheduleView = null;
    }

    @Override
    public void GETDaySchedule(String Authorization, int store_id, String date) {
        scheduleModel.GETDaySchedule(Authorization, store_id, date);
    }

    @Override
    public void GETWeekSchedule(String Authorization, int store_id) {
        scheduleModel.GETWeekSchedule(Authorization, store_id);
    }

    @Override
    public void POSTScheduleRule(String Authorization, String weekday, List<outSchedule> time_ranges) {
        scheduleModel.POSTScheduleRule(Authorization, weekday, time_ranges);
    }

    @Override
    public void POSTDayScheduleRule(String Authorization, String date, List<outSchedule> time_ranges) {
        scheduleModel.POSTDayScheduleRule(Authorization, date, time_ranges);
    }
}
