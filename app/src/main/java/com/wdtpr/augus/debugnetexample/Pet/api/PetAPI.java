package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetCreateStatusBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetHasMonthCardBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetVariety;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by augus on 2017/12/10.
 * Pet 寵物 API
 */

public interface PetAPI {

    //Pet列表
    @GET("/api/pet")
    Flowable<Result<PetListBean>> GETPetList(@Header("Authorization") String Authorization);

    //Pet詳細
    @GET("/api/pet/{PetId}/edit")
    Flowable<Result<PetDetailBean>> GETPetDetail(@Header("Authorization") String Authorization, @Path("PetId") int PetId);

    //建立pet資訊
    @FormUrlEncoded
    @POST("/api/pet")
    Flowable<Result<PetCreateStatusBean>> POSTCreatePet(@Header("Authorization") String Authorization,
                                                        @Field("name") String name, @Field("age") String age, @Field("variety_id") int variety_id,
                                                        @Field("zh_variety") String zh_variety, @Field("en_variety") String en_variety, @Field("blood_type") String blood_type,
                                                        @Field("weight") String weight, @Field("chip") boolean chip, @Field("description") String description);

    //建立pet資訊
    @FormUrlEncoded
    @PUT("/api/pet/{PetId}/update")
    Flowable<Result<Status>> PUTPetDetail(@Header("Authorization") String Authorization, @Path("PetId") int PetId,
                                          @Field("name") String name, @Field("age") String age, @Field("variety_id") int variety_id,
                                          @Field("zh_variety") String zh_variety, @Field("en_variety") String en_variety, @Field("blood_type") String blood_type,
                                          @Field("weight") String weight, @Field("chip") boolean chip, @Field("description") String description);

    //建立寵物頭像
    @Multipart
    @POST("/api/pet/{PetId}/avatar")
    Flowable<Result<Status>> POSTPetAvatar(@Header("Authorization") String Authorization, @Path("PetId") int PetId, @Part MultipartBody.Part avatar);

    //刪除寵物
    @DELETE("/api/pet/{PetId}")
    Flowable<Result<Status>> DeletePet(@Header("Authorization") String Authorization, @Path("PetId") int PetId);

    //取得寵物是否有在這個店家開卡
    @GET("/api/pet/{PetId}/has-monthly-card/{StoreId}")
    Flowable<Result<PetHasMonthCardBean>> GETPetMonthly(@Header("Authorization") String Authorization, @Path("PetId") int PetId, @Path("StoreId") int StoreId);

    //取得所有寵物品種
    @GET("/api/pet/variety")
    Flowable<Result<PetVariety>> GETPetVariety(@Header("Authorization") String Authorization, @Query("search_key") String search_key, @Query("page") int page);
}
