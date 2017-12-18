package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
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

/**
 * Created by augus on 2017/12/10.
 * Item 價目表 API
 */

public interface ItemAPI {

    //取得 Item list
    @GET("/api/item")
    Flowable<Result<ItemListBean>> GETItemList(@Header("Authorization") String Authorization);

    //建立 item
    @FormUrlEncoded
    @POST("/api/store/{Store_Id}/item")
    Flowable<Result<ItemCallbackBean>> POSTItem(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id,
                                                @Field("title") String title, @Field("cost") int cost);

    //更新 Item
    @FormUrlEncoded
    @PUT("/api/item/{Item_Id}")
    Flowable<Result<Status>> PUTItem(@Header("Authorization") String Authorization, @Path("Item_Id") int Item_Id,
                                     @Field("title") String title, @Field("cost") int cost);

    //刪除 Item
    @DELETE("/api/item/{Item_Id}")
    Flowable<Result<Status>> DeleteItem(@Header("Authorization") String Authorization, @Path("Item_Id") int Item_Id);
}
