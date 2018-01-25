package com.wdtpr.augus.bjprofile.bjDemo.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecord;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_Record;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.Movie;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarBean;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.ServerBean;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.Speak;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.Spell;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.SpellData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_Record;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordData;


import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by augus on 2017/12/2.
 * API
 */

public interface API {


    //SERVER TOKEN
    @FormUrlEncoded
    @POST("api/Student/ServerAccess")
    Flowable<ServerBean> GetServerToken(@Field("server_account") String account, @Field("server_password") String password);

    //irs
    @FormUrlEncoded
    @POST("api/LearnRecord/GetIRSRecord")
    Flowable<Result<IRS_Record>> GetIRSRecord(@Header("server_token") String server_token, @Field("studentID") int studentID, @Field("courseNo") String courseNo);

    //movie
    @FormUrlEncoded
    @POST("api/LearnRecord/GetMovieRecord")
    Flowable<Result<Movie>> GetMovieRecord(@Header("server_token") String server_token, @Field("studentID") int studentID, @Field("courseNo") String courseNo);

    //test
    @FormUrlEncoded
    @POST("api/LearnRecord/GetTestRecord")
    Flowable<Result<TEST_Record>> GetTestRecord(@Header("server_token") String server_token, @Field("studentID") int studentID, @Field("bookNo") String bookNo);

    //Radar
    @FormUrlEncoded
    @POST("api/LearnRecord/GetRadar")
    Flowable<Result<RadarBean>> GetRadar(@Header("server_token") String server_token, @Field("studentID") int studentID);

    //Radar
    @FormUrlEncoded
    @POST("api/LearnRecord/GetSpeakTestRecordByID")
    Flowable<Result<Speak>> GetSpeakTestRecordByID(@Header("server_token") String server_token, @Field("StudentID") int studentID);

    //Radar
    @FormUrlEncoded
    @POST("api/LearnRecord/GetGoldRecord")
    Flowable<Result<GoldRecord>> GetGoldRecord(@Header("server_token") String server_token, @Field("StudentID") int studentID);

    //Spell
    @FormUrlEncoded
    @POST("api/LearnRecord/GetSpellTestRecord")
    Flowable<Result<Spell>> GetSpellTestRecord(@Header("server_token") String server_token, @Field("StudentID") int studentID);

}
