package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.PointCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemListBean;

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
 * 寵物會員卡 api
 */

public interface CardAPI {

    //取得 舊的寵物會員卡 [list] //暫時棄用
    @GET("/api/pet/{pet_id}/old-card")
    Flowable<Result<ItemListBean>> GETOldCard(@Header("Authorization") String Authorization, @Path("pet_id") int pet_id, @Query("store_id") int store_id);

    //取得 會員的寵物會員卡 [list]
    @GET("/api/customer/{customer_id}/card/show")
    Flowable<Result<CardListBean>> GETCustomerPetCardList(@Header("Authorization") String Authorization, @Path("customer_id") int customer_id, @Query("store_id") int store_id);

    //取得 寵物會員卡 [detail]
    @GET("/api/pet/{pet_id}/card/show")
    Flowable<Result<CardDetailBean>> GETPetCardDetail(@Header("Authorization") String Authorization, @Path("pet_id") int pet_id, @Query("store_id") int store_id);

    //取得 舊 寵物會員卡 [detail] //暫時棄用
    @GET("/api/card/{card_id}/show-old-card")
    Flowable<Result<ItemListBean>> GETOldCardDetail(@Header("Authorization") String Authorization, @Path("card_id") int customer_id, @Query("store_id") int store_id);

    //建立 寵物會員卡片
    @FormUrlEncoded
    @POST("/api/card")
    Flowable<Result<CardCreateCallbackBean>> POSTPetCard(@Header("Authorization") String Authorization, @Field("pet_id") int pet_id, @Field("store_id") int store_id,
                                                         @Field("title") String title, @Field("cost") int cost, @Field("point_count") int point_count);

    //更新 寵物會員卡 內容
    @FormUrlEncoded
    @PUT("/api/card/{card_id}")
    Flowable<Result<Status>> PUTPetCard(@Header("Authorization") String Authorization, @Path("card_id") int card_id, @Field("title") String title,@Field("cost") int cost);

    //綁定 寵物會員卡 與該筆 消費帳單
    @FormUrlEncoded
    @PUT("/api/card/{card_id}/bind-account")
    Flowable<Result<Status>> PUTCardBindAccount(@Header("Authorization") String Authorization, @Path("card_id") int card_id, @Field("account_id") int account_id);

    //新增 寵物會員卡點數
    @FormUrlEncoded
    @POST("/api/point")
    Flowable<Result<PointCreateCallbackBean>> POSTCardPoint(@Header("Authorization") String Authorization,
                                                            @Field("card_id") int card_id, @Field("service") String service);

    //刪除 寵物會員卡的點數
    @DELETE("/api/point/{Point_Id}")
    Flowable<Result<Status>> DeleteCardPoint(@Header("Authorization") String Authorization, @Path("Point_Id") int Point_Id);
}
