package com.wdtpr.augus.debugnetexample.Pet.api;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Permission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetCreateStatusBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetHasMonthCardBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetVariety;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.provider.ProviderListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleDayBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule.ScheduleWeekBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSNotReadBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreAvatar;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreDetail;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.UserInfo;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outPermission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outSchedule;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
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
 * Created by augus on 2017/12/2.
 * API
 */

public interface UserAPI {

    /*
    user 使用者
     */

    //顧客註冊
    @FormUrlEncoded
    @POST("/api/user/customer/register")
    Flowable<Result<registBackBean>> POSTCustomerRegist(@Field("email") String email, @Field("name") String name, @Field("password") String password,
                                                        @Field("password_confirmation") String password_confirmation, @Field("address") String address, @Field("phone") String phone, @Field("mobile") String mobile, @Field("birthday") String birthday);

    //登入
    @FormUrlEncoded
    @POST("/api/user/login")
    Flowable<Result<UserInfo>> POSTLogin(@Field("email") String email, @Field("password") String name);


}
