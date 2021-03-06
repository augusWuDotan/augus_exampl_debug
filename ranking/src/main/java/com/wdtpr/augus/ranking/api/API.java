package com.wdtpr.augus.ranking.api;


import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.ranking.model.bean.in.ServerBean;
import com.wdtpr.augus.ranking.model.bean.in.ranking.Rank_all;
import com.wdtpr.augus.ranking.model.bean.in.ranking.Rank_single;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by augus on 2017/12/2.
 * API
 */

public interface API {


    //SERVER TOKEN
    @FormUrlEncoded
    @POST("api/Student/ServerAccess")
    Flowable<ServerBean> GetServerToken(@Field("server_account") String account, @Field("server_password") String password);


    //
    @FormUrlEncoded
    @POST("api/LearnRecord/GetSingleStudentRanking")
    Flowable<Result<Rank_single>> GetSingleStudentRanking(@Header("server_token") String server_token, @Field("Type") String Type, @Field("StudentID") int studentID);

    //
    @FormUrlEncoded
    @POST("api/LearnRecord/GetStudentRanking")
    Flowable<Result<Rank_all>> GetStudentRanking(@Header("server_token") String server_token, @Field("Type") String Type,
                                                          @Field("StudentID") int studentID, @Field("PageNumber") int PageNumber);


}
