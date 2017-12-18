package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerListBean;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
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
 * Customer 顧客 API
 */

public interface CustomerAPI {


    //顧客列表 //Authorization 僅商家token可以用
    @GET("/api/customer")
    Flowable<Result<CustomerListBean>> GETCustomerList(@Header("Authorization") String Authorization);

    //顧客詳細 /customer/{id}/edit
    @GET("/api/customer/{Customer_id}/edit")
    Flowable<Result<CustomerDetailBean>> GETCustomerDetail(@Header("Authorization") String Authorization, @Path("Customer_id") int Customer_id);

    //更新 顧客詳細
    @FormUrlEncoded
    @PUT("/api/customer/{Customer_id}/update")
    Flowable<Result<Status>> PUTStoreDetail(@Header("Authorization") String Authorization, @Path("Customer_id") int Customer_id, @Field("representative_pet_id") int representative_pet_id,
                                            @Field("address") String address, @Field("customer_number") String customer_number, @Field("phone") String phone, @Field("mobile") String mobile,
                                            @Field("description") String description);

    //建立顧客頭像
    @Multipart
    @POST("/api/customer/{Customer_id}/avatar")
    Flowable<Result<Status>> POSTCustomerAvatar(@Header("Authorization") String Authorization, @Path("Customer_id") int Customer_id, @Part MultipartBody.Part avatar);

    //顧客綁訂商家
    @FormUrlEncoded
    @POST("/api/customer/{Customer_id}/store/bind")
    Flowable<Result<Status>> POSTCustomerBindStore(@Header("Authorization") String Authorization, @Path("Customer_id") int Customer_id, @Field("email") String StoreMail);

}
