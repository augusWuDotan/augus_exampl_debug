package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleDayBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleWeekBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outSchedule;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by augus on 2017/12/10.
 * Schedule 營業排程 API
 */

public interface ScheduleAPI {

    //取得 store 當日營業
    @GET("/api/schedule/{store_id}/{date}")
    Flowable<Result<ScheduleDayBean>> GETDaySchedule(@Header("Authorization") String Authorization, @Path("store_id") int store_id, @Path("date") String date);

    //取得 store 當週營業
    @GET("/api/schedule/{store_id}/rule")
    Flowable<Result<ScheduleWeekBean>> GETWeekSchedule(@Header("Authorization") String Authorization, @Path("store_id") int store_id);

    //建立 store 週營業規則
    @POST("/api/schedule-rule/{weekday}")
    Flowable<Result<Status>> POSTScheduleRule(@Header("Authorization") String Authorization, @Path("weekday") String weekday, @Body List<outSchedule> time_ranges);

    //建立 store 日營業規則
    @POST("/api/schedule/{date}")
    Flowable<Result<Status>> POSTDayScheduleRule(@Header("Authorization") String Authorization, @Path("date") String date, @Body List<outSchedule> time_ranges);
}
