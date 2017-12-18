package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarListBean;

import io.reactivex.Flowable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by augus on 2017/12/10.
 * Calendar 記事日誌 API
 */

public interface CalendarAPI {

    //取得時間範圍為內的記事日誌
    @GET("/api/user/{UserId}/time-calendar")
    Flowable<Result<CalendarListBean>> GETCalendarList(@Header("Authorization") String Authorization, @Path("UserId") int UserId,
                                                       @Query("paginator") boolean paginator, @Query("start_date") String start_date,
                                                       @Query("end_date") String end_date, @Query("page") int page);

    //建立記事本
    @FormUrlEncoded
    @POST("/api/time-calendar")
    Flowable<Result<CalendarCallBackBean>> POSTCalendar(@Header("Authorization") String Authorization, @Field("user_id") int user_id,
                                                        @Field("datetime") String datetime, @Field("address") String address, @Field("description") String description);

    //更新記事內容
    @FormUrlEncoded
    @PUT("/api/time-calendar/{calendar_id}/update")
    Flowable<Result<Status>> PUTCalendarStatus(@Header("Authorization") String Authorization, @Path("calendar_id") int calendar_id,
                                               @Field("status") String status, @Field("datetime") String datetime, @Field("address") String address,
                                               @Field("description") String description);

    //刪除記事本
    @DELETE("/api/time-calendar/{calendar_id}")
    Flowable<Result<Status>> DeleteCalendar(@Header("Authorization") String Authorization, @Path("calendar_id") int calendar_id);
}
