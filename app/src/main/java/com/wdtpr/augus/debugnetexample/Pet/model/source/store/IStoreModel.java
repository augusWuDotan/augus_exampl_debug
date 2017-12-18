package com.wdtpr.augus.debugnetexample.Pet.model.source.store;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Permission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.provider.ProviderListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.Store;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreAvatar;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreDetail;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.UserInfo;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outPermission;

import okhttp3.MultipartBody;
import retrofit2.http.Multipart;

/**
 * Created by augus on 2017/12/2.
 */

public interface IStoreModel {

    interface StoreStateListener {

        void onStart();

        void onUnknowError(String errorStr);

        void onComplete();

        void storeFail();

        void GETStoreListSuccess(StoreListBean storeListBean);

        void GETStoreDetailSuccess(StoreDetail storeDetail);

        void GETStoreProviderSuccess(ProviderListBean providerListBean);

        void PUTStoreDetailSuccess(Status status);

        void GETStoreAvatarSuccess(StoreAvatar storeAvatar);

        void POSTStoreAvatarSuccess(Status status);

        void GETPermissionSuccess(Permission permission);

        void POSTPermissionSuccess(Status status);

        void POSTStoreBindCustomerSuccess(Status status);

    }

    //store資訊
    void GETStoreList(String Authorization);//列表
    void GETStoreDetail(String Authorization,int Store_Id);//詳細
    void GETStoreProvider(String Authorization,int Store_Id);//美容師列表
    void PUTStoreDetail(String Authorization, int Store_Id, Store store);//詳細
    void GETStoreAvatar(String Authorization,int Store_Id);//頭像
    void POSTStoreAvatar(String Authorization, int Store_Id, MultipartBody.Part avatar);//加載頭像
    //permission
    void GetPermission(String Authorization,int Store_Id);
    void PostPermission(String Authorization,int Store_Id,outPermission permission);
    //bind
    void POSTStoreBindCustomer(String Authorization, int Store_Id,String CustomerMail);//綁定顧客


}
