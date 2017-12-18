package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateAmountBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateGroupBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplatePrototypeListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateUpdateCallbackBean;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by augus on 2017/12/11.
 */

public interface TemplateAPI {

    //取的對應的已建立模板列表
    @GET("/api/store/{store_id}/template")
    Flowable<Result<TemplateListBean>> GETTemplateList(@Header("Authorization") String Authorization,
                                                       @Path("store_id") int store_id, @Query("type") String type);

    //取得該模板主題列表
    @GET("/api/template-prototype/group")
    Flowable<Result<TemplateGroupBean>> GETTemplateBoardGroupList(@Header("Authorization") String Authorization, @Query("theme") String theme);

    //取得該模板主題 - 模板項目列表
    @GET("/api/template-prototype")
    Flowable<Result<TemplatePrototypeListBean>> GETTemplatePrototypeList(@Header("Authorization") String Authorization, @Query("theme_group") String theme_group);

    //取得該模板類別 可建立數量
    @GET("/api/store/{store_id}/theme-counter")
    Flowable<Result<TemplateAmountBean>> GETTemplateBoardCount(@Header("Authorization") String Authorization, @Path("store_id") int store_id, @Query("theme") String theme);

    //建立模板
    @FormUrlEncoded
    @POST("/api/store/{store_id}/template")
    Flowable<Result<TemplateCreateCallbackBean>> POSTTemplate(@Header("Authorization") String Authorization, @Path("store_id") int store_id,
                                                              @Field("template_prototype_id") String template_prototype_id);

    //取得單筆模板
    @GET("/api/store/template/{store_template_id}")
    Flowable<Result<TemplateDetailBean>> GETTemplateBoard(@Header("Authorization") String Authorization, @Path("store_template_id") String store_template_id);

    //刪除模板
    @DELETE("/api/store/template/{store_template_id}")
    Flowable<Result<Status>> DeleteTemplateBoard(@Header("Authorization") String Authorization, @Path("store_template_id") String store_template_id);

    //模板 更新 textArea | textList
    @FormUrlEncoded
    @POST
    Flowable<Result<TemplateUpdateCallbackBean>> POSTUpdateTemplateText(@Url String url,@Header("Authorization") String Authorization,  @Field("text") String text);

    //模板 更新 image
    @Multipart
    @POST
    Flowable<Result<TemplateUpdateCallbackBean>> POSTUpdateTemplateImage(@Url String url, @Header("Authorization") String Authorization, @Part MultipartBody.Part avatar);


}
