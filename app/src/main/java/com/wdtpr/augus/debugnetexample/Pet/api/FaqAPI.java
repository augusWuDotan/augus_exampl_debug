package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQListBean;

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
 * FAQ 問題集 API
 */

public interface FaqAPI {

    //取得 FAQ list
    @GET("/api/store/{Store_Id}/FAQ")
    Flowable<Result<FAQListBean>> GETFAQList(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id, @Query("page") int page);

    //建立FAQ
    @FormUrlEncoded
    @POST("/api/store/{Store_Id}/FAQ")
    Flowable<Result<FAQCallbackBean>> POSTFAQ(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id,
                                              @Field("question") String question, @Field("anwser") String anwser);

    //更新FAQ
    @FormUrlEncoded
    @PUT("/api/FAQ/{FAQ_id}")
    Flowable<Result<Status>> PUTFAQ(@Header("Authorization") String Authorization, @Path("FAQ_id") int FAQ_id,
                                    @Field("question") String question, @Field("anwser") String anwser);

    //刪除FAQ
    @DELETE("/api/FAQ/{FAQ_id}")
    Flowable<Result<Status>> DeleteFAQ(@Header("Authorization") String Authorization, @Path("FAQ_id") int FAQ_id);
}
