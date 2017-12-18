package com.wdtpr.augus.debugnetexample.Pet.model.source.pet;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetCreateStatusBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetHasMonthCardBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetVariety;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/3.
 */

public interface IPetModel {

    interface PetListener {

        void onStart();

        void onUnknowError(String errorStr);

        void onComplete();

        void PetFail();

        void GETPetList(PetListBean bean);

        void GETPetDetail(PetDetailBean bean);

        void POSTCreatePet(PetCreateStatusBean bean);

        void PUTPetDetail(Status bean);

        void POSTPetAvatar(Status bean);

        void DeletePet(Status bean);

        void GETPetMonthly(PetHasMonthCardBean bean);

        void GETPetVariety(PetVariety bean);
    }


    void GETPetList(String Authorization);
    void GETPetDetail(String Authorization,int PetId);
    void POSTCreatePet(String Authorization,
                       String name,String age,int variety_id,
                       String zh_variety,String en_variety,String blood_type,
                       String weight,boolean chip,String description);
    void PUTPetDetail(String Authorization,int PetId,
                       String name,String age,int variety_id,
                       String zh_variety,String en_variety,String blood_type,
                       String weight,boolean chip,String description);
    void POSTPetAvatar(String Authorization, int PetId, MultipartBody.Part avatar);

    void DeletePet(String Authorization,int PetId);
    void GETPetMonthly(String Authorization,int PetId,int StoreId);
    void GETPetVariety(String Authorization,String search_key,int page);
}
