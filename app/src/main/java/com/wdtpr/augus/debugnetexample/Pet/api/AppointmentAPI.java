package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentListBean;

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
 * Appointment 預約 api
 */

public interface AppointmentAPI {


    //取得 store 所有預約
    @GET("/api/appointment")
    Flowable<Result<AppointmentListBean>> GETAppointment(@Header("Authorization") String Authorization, @Query("start_time") String start_time,
                                                         @Query("end_time") String end_time, @Query("paginator") boolean paginator, @Query("page") int page);

    //取得 store 單筆預約[依據appointment id]
    @GET("/api/appointment/{id}")
    Flowable<Result<AppointmentDetailBean>> GETAppointmentWithId(@Header("Authorization") String Authorization, @Path("id") int AppointmentId);

    //取得 store 所有預約 [依據狀態]
    @GET("/api/appointment/{status}")
    Flowable<Result<AppointmentListBean>> GETAppointmentWithStatus(@Header("Authorization") String Authorization, @Path("status") String status, @Query("start_time") String start_time,
                                                                   @Query("end_time") String end_time, @Query("paginator") boolean paginator, @Query("page") int page);

    //取得 store 取該商家的所有預約
    @GET("/api/store/{store_id}/appointments")
    Flowable<Result<AppointmentListBean>> GETAppointmentWithStroe(@Header("Authorization") String Authorization, @Path("store_id") int store_id, @Query("start_time") String start_time,
                                                                  @Query("end_time") String end_time, @Query("paginator") boolean paginator, @Query("page") int page);

    //取得 store 取該商家的所有預約 [依據狀態]
    @GET("/api/store/{store_id}/appointments/{status}")
    Flowable<Result<AppointmentListBean>> GETAppointmentWithStroeWithStatus(@Header("Authorization") String Authorization, @Path("store_id") int store_id, @Path("status") String status,
                                                                            @Query("start_time") String start_time, @Query("end_time") String end_time, @Query("paginator") boolean paginator,
                                                                            @Query("page") int page);

    //取得  取該顧客的所有預約
    @GET("/api/customer/{customer_id}/appointments")
    Flowable<Result<AppointmentListBean>> GETAppointmentWithCustomer(@Header("Authorization") String Authorization, @Path("customer_id") int customer_id, @Query("start_time") String start_time,
                                                                     @Query("end_time") String end_time, @Query("paginator") boolean paginator, @Query("page") int page);

    //取得 取該顧客的所有預約 [依據狀態]
    @GET("/api/customer/{customer_id}/appointments/{status}")
    Flowable<Result<AppointmentListBean>> GETAppointmentWithCustomerWithStatus(@Header("Authorization") String Authorization, @Path("customer_id") int store_id, @Path("status") String status,
                                                                               @Query("start_time") String start_time, @Query("end_time") String end_time, @Query("paginator") boolean paginator,
                                                                               @Query("page") int page);


    //新增預約 商家使用 指定 美容師 近 accept
    @FormUrlEncoded
    @POST("/api/appointment")
    Flowable<Result<Status>> POSTAppointment_Store(@Header("Authorization") String Authorization, @Field("store_id") int Store_id,
                                                   @Field("customer_id") int customer_id, @Field("provider_id") int provider_id, @Field("pet_id") int pet_id,
                                                   @Field("start_at") String start_at, @Field("end_at") String end_at, @Field("is_monthly") boolean is_monthly,
                                                   @Field("with_lodging") boolean with_lodging, @Field("description") String description);

    //新增預約 顧客使用 pending
    @FormUrlEncoded
    @POST("/api/appointment")
    Flowable<Result<Status>> POSTAppointment_Customer(@Header("Authorization") String Authorization, @Field("store_id") int Store_id,
                                                      @Field("customer_id") int customer_id, @Field("pet_id") int pet_id, @Field("start_at") String start_at,
                                                      @Field("end_at") String end_at, @Field("is_monthly") boolean is_monthly, @Field("with_lodging") boolean with_lodging,
                                                      @Field("description") String description);

    //同意訂單 並指派 美容師 //更改此筆訂單狀態 accepted
    @FormUrlEncoded
    @POST("/api/appointment/{appointmentId}/accept")
    Flowable<Result<Status>> POSTAppointmentAccept(@Header("Authorization") String Authorization, @Path("appointmentId") int appointmentId, @Field("provider_id") int provider_id);

    //訂單完工 //更改此筆訂單狀態 finished
    @POST("/api/appointment/{appointmentId}/finish")
    Flowable<Result<Status>> POSTAppointmentFinish(@Header("Authorization") String Authorization, @Path("appointmentId") int appointmentId);

    //訂單拒絕 //直接刪除此筆訂單
    @POST("/api/appointment/{appointmentId}/deny")
    Flowable<Result<Status>> POSTAppointmentDeny(@Header("Authorization") String Authorization, @Path("appointmentId") int appointmentId);

    //訂單取消 //更改此筆訂單狀態 cancel
    @POST("/api/appointment/{appointmentId}/cancel")
    Flowable<Result<Status>> POSTAppointmentCancel(@Header("Authorization") String Authorization, @Path("appointmentId") int appointmentId);

}
