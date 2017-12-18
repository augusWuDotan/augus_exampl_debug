package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Permission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.provider.ProviderListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreAvatar;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreDetail;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outPermission;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by augus on 2017/12/10.
 * Store 商家 API
 */

public interface StoreAPI {


    //商家列表 //Authorization 僅顧客token可以用
    @GET("/api/store")
    Flowable<Result<StoreListBean>> GETStoreList(@Header("Authorization") String Authorization);

    //商家詳細
    @GET("/api/store/{Store_Id}/edit")
    Flowable<Result<StoreDetail>> GETStoreDetail(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id);

    //商家美容師資訊
    @GET("/api/store/{Store_Id}/providers")
    Flowable<Result<ProviderListBean>> GETStoreProvider(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id);

    //更新 商家詳細
    @FormUrlEncoded
    @PUT("/api/store/{Store_Id}/update")
    Flowable<Result<Status>> PUTStoreDetail(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id, @Field("name") String name,
                                            @Field("open_time") String open_time, @Field("address") String address, @Field("website") String website, @Field("instagram") String instagram,
                                            @Field("fanpage") String fanpage, @Field("phone") String phone, @Field("mobile") String mobile, @Field("description") String description);

    //取得商家logo
    @GET("/api/store/{Store_Id}/avatar")
    Flowable<Result<StoreAvatar>> GETStoreAvatar(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id);

    //更換商家logo
    @Multipart
    @POST("/api/store/{Store_Id}/avatar")
    Flowable<Result<Status>> POSTStoreAvatar(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id, @Part MultipartBody.Part avatar);

    //permission //取得權限
    @GET("/api/store/{Store_Id}/permission")
    Flowable<Result<Permission>> GETPermission(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id);

    //permission //修改權限
    @POST("/api/store/{Store_Id}/permission")
    Flowable<Result<Status>> POSTPermission(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id, @Body outPermission permission);

    //
    @FormUrlEncoded
    @POST("/api/store/{Store_Id}/customer/bind")
    Flowable<Result<Status>> POSTStoreBindCustomer(@Header("Authorization") String Authorization, @Path("Store_Id") int Store_Id, @Field("email") String CustomerMail);
}
