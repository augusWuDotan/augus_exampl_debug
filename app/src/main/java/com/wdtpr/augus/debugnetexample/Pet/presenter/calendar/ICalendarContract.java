package com.wdtpr.augus.debugnetexample.Pet.presenter.calendar;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerListBean;
import com.wdtpr.augus.debugnetexample.base.IBasePresenter;
import com.wdtpr.augus.debugnetexample.base.IBaseView;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/13.
 *
 */

public interface ICalendarContract {

    interface CalendarStateView extends IBaseView {

        void CalendarFail();

        void GETCalendarList(CalendarListBean bean);

        void POSTCalendar(CalendarCallBackBean bean);

        void PUTCalendarStatus(Status bean);

        void DeleteCalendar(Status bean);

    }

    interface Presnter extends IBasePresenter {

        void GETCalendarList(String Authorization, int UserId, boolean paginator, String start_date, String end_date, int page);

        void POSTCalendar(String Authorization, int UserId, String datetime, String address, String description);

        void PUTCalendarStatus(String Authorization, int calendar_id, String status, String datetime, String address, String description);

        void DeleteCalendar(String Authorization, int calendar_id);
    }
}
