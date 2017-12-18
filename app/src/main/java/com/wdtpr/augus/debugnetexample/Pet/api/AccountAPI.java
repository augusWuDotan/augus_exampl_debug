package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountListBean;

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
 * Account 帳表 api
 */

public interface AccountAPI {

    //取得 store 日期範圍帳單
    @GET("/api/store/{Store_id}/account")
    Flowable<Result<AccountListBean>> GETAccount(@Header("Authorization") String Authorization, @Path("Store_id") int Store_id,
                                                 @Query("start_date") String start_date, @Query("end_date") String end_date);

    //新增帳單
    @FormUrlEncoded
    @POST("/api/store/{id}/account")
    Flowable<Result<AccountCallBackBean>> POSTAccount(@Header("Authorization") String Authorization, @Path("id") int Store_id,
                                                      @Field("customer_id") int customer_id, @Field("date") String date, @Field("title") String title,
                                                      @Field("description") String description, @Field("cost") int cost);

    //取得 會員 日期範圍帳單
    @GET("/api/customer/{customer_id}/account")
    Flowable<Result<AccountListBean>> GETAccountCustomer(@Header("Authorization") String Authorization, @Path("customer_id") int customer_id,
                                                         @Query("start_date") String start_date, @Query("end_date") String end_date);


    //修改帳單
    @FormUrlEncoded
    @PUT("/api/account/{account_id}")
    Flowable<Result<Status>> PUTAccount(@Header("Authorization") String Authorization, @Path("account_id") int account_id,
                                        @Field("customer_id") int customer_id, @Field("title") String title,
                                        @Field("description") String description, @Field("cost") int cost);

    //刪除帳單
    @DELETE("/api/account/{account_id}")
    Flowable<Result<Status>> DeleteAccount(@Header("Authorization") String Authorization, @Path("account_id") int account_id);
}
