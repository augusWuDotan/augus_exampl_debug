package com.wdtpr.augus.debugnetexample.Pet.model.source.calendar;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.CalendarAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetListBean;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/4.
 */

public class CalendarModel extends BaseModel implements ICalendarModel {

    private ICalendarModel.CalendarStateListener calendarStateListener;

    public CalendarModel(CalendarStateListener calendarStateListener) {
        this.calendarStateListener = calendarStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        calendarStateListener = null;
    }


    @Override
    public void GETCalendarList(String Authorization, int UserId, boolean paginator, String start_date, String end_date, int page) {
        if (calendarStateListener == null) return;
        calendarStateListener.onStart();
        //start
        disposableManager.add(RetrofitHelper_Pet.instance().create(CalendarAPI.class).GETCalendarList("Bearer " + Authorization, UserId, paginator, start_date, end_date, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<CalendarListBean>>() {
                    @Override
                    public void onNext(Result<CalendarListBean> calendarListBeanResult) {
                        //
                        final int responseCode = calendarListBeanResult.response().code();
                        if (responseCode == 200) {
                            CalendarListBean bean = calendarListBeanResult.response().body();
                            calendarStateListener.GETCalendarList(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                calendarStateListener.onUnknowError(errorStr);
                            else calendarStateListener.CalendarFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        calendarStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        calendarStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void POSTCalendar(String Authorization, int UserId, String datetime, String address, String description) {
        if (calendarStateListener == null) return;
        calendarStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CalendarAPI.class).POSTCalendar("Bearer " + Authorization, UserId, datetime, address, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<CalendarCallBackBean>>() {
                    @Override
                    public void onNext(Result<CalendarCallBackBean> calendarCallBackBeanResult) {
                        //
                        final int responseCode = calendarCallBackBeanResult.response().code();
                        if (responseCode == 200) {
                            CalendarCallBackBean bean = calendarCallBackBeanResult.response().body();
                            calendarStateListener.POSTCalendar(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                calendarStateListener.onUnknowError(errorStr);
                            else calendarStateListener.CalendarFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        calendarStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        calendarStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void PUTCalendarStatus(String Authorization, int calendar_id, String status, String datetime, String address, String description) {
        if (calendarStateListener == null) return;
        calendarStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CalendarAPI.class).PUTCalendarStatus("Bearer " + Authorization, calendar_id, status, datetime, address, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            calendarStateListener.PUTCalendarStatus(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                calendarStateListener.onUnknowError(errorStr);
                            else calendarStateListener.CalendarFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        calendarStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        calendarStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void DeleteCalendar(String Authorization, int calendar_id) {
        if (calendarStateListener == null) return;
        calendarStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CalendarAPI.class).DeleteCalendar("Bearer " + Authorization, calendar_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            calendarStateListener.DeleteCalendar(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                calendarStateListener.onUnknowError(errorStr);
                            else calendarStateListener.CalendarFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        calendarStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        calendarStateListener.onComplete();
                    }
                }));
    }
}
