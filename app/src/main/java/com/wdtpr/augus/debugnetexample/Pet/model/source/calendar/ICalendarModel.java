package com.wdtpr.augus.debugnetexample.Pet.model.source.calendar;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Permission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.provider.ProviderListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreAvatar;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreDetail;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreListBean;

/**
 * Created by augus on 2017/12/4.
 */

public interface ICalendarModel {

    interface CalendarStateListener {

        void onStart();

        void onUnknowError(String errorStr);

        void onComplete();

        void CalendarFail();

        void GETCalendarList(CalendarListBean bean);

        void POSTCalendar(CalendarCallBackBean bean);

        void PUTCalendarStatus(Status bean);

        void DeleteCalendar(Status bean);

    }

    void GETCalendarList(String Authorization, int UserId, boolean paginator, String start_date, String end_date, int page);

    void POSTCalendar(String Authorization, int UserId, String datetime, String address, String description);

    void PUTCalendarStatus(String Authorization, int calendar_id, String status,
                           String datetime, String address, String description);

    void DeleteCalendar(String Authorization, int calendar_id);


}
