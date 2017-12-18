package com.wdtpr.augus.debugnetexample.Pet.presenter.calendar;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.calendar.CalendarModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.calendar.ICalendarModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

/**
 * Created by augus on 2017/12/16.
 */

public class CalendarPresenter extends BasePresenter implements ICalendarContract.Presnter {

    private ICalendarContract.CalendarStateView calendarStateView;
    private CalendarModel calendarModel;

    public CalendarPresenter(ICalendarContract.CalendarStateView calendarStateView) {
        this.calendarStateView = calendarStateView;
        calendarModel = new CalendarModel(calendarStateListener);
    }

    public ICalendarModel.CalendarStateListener calendarStateListener = new ICalendarModel.CalendarStateListener() {
        @Override
        public void onStart() {
            calendarStateView.showLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            calendarStateView.showUnknowError(errorStr);
        }

        @Override
        public void onComplete() {
            calendarStateView.hideLoading();
        }

        @Override
        public void CalendarFail() {
            calendarStateView.CalendarFail();
        }

        @Override
        public void GETCalendarList(CalendarListBean bean) {
            calendarStateView.GETCalendarList(bean);
        }

        @Override
        public void POSTCalendar(CalendarCallBackBean bean) {
            calendarStateView.POSTCalendar(bean);
        }

        @Override
        public void PUTCalendarStatus(Status bean) {
            calendarStateView.PUTCalendarStatus(bean);
        }

        @Override
        public void DeleteCalendar(Status bean) {
            calendarStateView.DeleteCalendar(bean);
        }
    };

    @Override
    public void unsubscribe() {
        calendarModel.unsubscribe();
        calendarModel = null;
        calendarStateView = null;
    }

    @Override
    public void GETCalendarList(String Authorization, int UserId, boolean paginator, String start_date, String end_date, int page) {
        calendarModel.GETCalendarList(Authorization, UserId, paginator, start_date, end_date, page);
    }

    @Override
    public void POSTCalendar(String Authorization, int UserId, String datetime, String address, String description) {
        calendarModel.POSTCalendar(Authorization, UserId, datetime, address, description);
    }

    @Override
    public void PUTCalendarStatus(String Authorization, int calendar_id, String status, String datetime, String address, String description) {
        calendarModel.PUTCalendarStatus(Authorization, calendar_id, status, datetime, address, description);
    }

    @Override
    public void DeleteCalendar(String Authorization, int calendar_id) {
        calendarModel.DeleteCalendar(Authorization, calendar_id);
    }
}
