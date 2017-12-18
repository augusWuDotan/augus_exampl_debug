package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSNotReadBean;

import io.reactivex.Flowable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by augus on 2017/12/10.
 * sns 推播訊息 API
 */

public interface snsAPI {

    //刪除 sns
    @DELETE("/api/sns/endpoint")
    Flowable<Result<SNSCallbackBean>> DeleteSNS(@Header("Authorization") String Authorization);

    //建立 sns 連接 [重複連接具有中斷功能]
    @FormUrlEncoded
    @POST("/api/sns/endpoint")
    Flowable<Result<SNSCallbackBean>> POSTSNS(@Header("Authorization") String Authorization, @Field("token") String token,
                                              @Field("endpoint_device") String endpoint_device);

    //群發推播
    @FormUrlEncoded
    @POST("/api/sns/send")
    Flowable<Result<Status>> POSTSendAll(@Header("Authorization") String Authorization, @Field("message") String message);

    //推播 對顧客
    @FormUrlEncoded
    @POST("/api/sns/{customerId}/send")
    Flowable<Result<Status>> POSTSendOne(@Header("Authorization") String Authorization, @Path("customerId") String customerId,
                                         @Field("message") String message);

    //取得 user sns 所有紀錄
    @GET("/api/sns")
    Flowable<Result<SNSListBean>> GETSNS(@Header("Authorization") String Authorization);

    //取得 user sns 所有紀錄
    @GET("/api/sns/not-read-count")
    Flowable<Result<SNSNotReadBean>> GETSNSNotReadCount(@Header("Authorization") String Authorization);

    //取得 sns id  取得紀錄
    @GET("/api/sns/{snsLogId}")
    Flowable<Result<SNSDetailBean>> GETSNSForId(@Header("Authorization") String Authorization, @Path("snsLogId") int snsLogId);

    //未讀 - 已讀
    @POST("/api/sns/{snsLogId}/mark-as-readed")
    Flowable<Result<Status>> POSTChangeSNSReadStatus(@Header("Authorization") String Authorization, @Path("snsLogId") int snsLogId);
}
