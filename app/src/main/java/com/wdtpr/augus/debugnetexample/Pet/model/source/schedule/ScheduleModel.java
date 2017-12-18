package com.wdtpr.augus.debugnetexample.Pet.model.source.schedule;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.ScheduleAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleDayBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleWeekBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outSchedule;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import java.util.List;
import java.util.Stack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/9.
 */

public class ScheduleModel extends BaseModel implements IScheduleModel {

    private IScheduleModel.ScheduleStateListener scheduleStateListener;

    public ScheduleModel(ScheduleStateListener scheduleStateListener) {
        this.scheduleStateListener = scheduleStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        scheduleStateListener = null;
    }

    @Override
    public void GETDaySchedule(String Authorization, int store_id, String date) {
        if (scheduleStateListener == null) return;
        scheduleStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(ScheduleAPI.class).GETDaySchedule("Bearer "+Authorization,store_id,date)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new ResourceSubscriber<Result<ScheduleDayBean>>(){
            @Override
            public void onNext(Result<ScheduleDayBean> scheduleDayBeanResult) {
                //
                final int responseCode = scheduleDayBeanResult.response().code();
                if (responseCode == 200) {
                    ScheduleDayBean bean = scheduleDayBeanResult.response().body();
                    scheduleStateListener.GETDayScheduleSuccess(bean);
                } else {
                    String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                    if (!StringUtils.isEmpty(errorStr))
                        scheduleStateListener.onUnknowError(errorStr);
                    else scheduleStateListener.ScheduleFail();
                }
            }

            @Override
            public void onError(Throwable t) {
                disposableManager.clear();
                scheduleStateListener.onUnknowError(t.getMessage());
            }

            @Override
            public void onComplete() {
                scheduleStateListener.onComplete();
            }
        }));
    }

    @Override
    public void GETWeekSchedule(String Authorization, int store_id) {
        if (scheduleStateListener == null) return;
        scheduleStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(ScheduleAPI.class).GETWeekSchedule("Bearer "+Authorization,store_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<ScheduleWeekBean>>(){
                    @Override
                    public void onNext(Result<ScheduleWeekBean> scheduleWeekBeanResult) {
                        //
                        final int responseCode = scheduleWeekBeanResult.response().code();
                        if (responseCode == 200) {
                            ScheduleWeekBean bean = scheduleWeekBeanResult.response().body();
                            scheduleStateListener.GETWeekScheduleSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                scheduleStateListener.onUnknowError(errorStr);
                            else scheduleStateListener.ScheduleFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        scheduleStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        scheduleStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTScheduleRule(String Authorization, String weekday, List<outSchedule> time_ranges) {
        if (scheduleStateListener == null) return;
        scheduleStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(ScheduleAPI.class).POSTScheduleRule("Bearer "+Authorization,weekday,time_ranges)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>(){
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            scheduleStateListener.POSTScheduleRuleSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                scheduleStateListener.onUnknowError(errorStr);
                            else scheduleStateListener.ScheduleFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        scheduleStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        scheduleStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTDayScheduleRule(String Authorization, String date, List<outSchedule> time_ranges) {
        if (scheduleStateListener == null) return;
        scheduleStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(ScheduleAPI.class).POSTDayScheduleRule("Bearer "+Authorization,date,time_ranges)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>(){
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            scheduleStateListener.POSTDayScheduleRuleSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                scheduleStateListener.onUnknowError(errorStr);
                            else scheduleStateListener.ScheduleFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        scheduleStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        scheduleStateListener.onComplete();
                    }
                }));
    }
}
