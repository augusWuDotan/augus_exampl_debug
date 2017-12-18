package com.wdtpr.augus.debugnetexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.BaseExpandableListAdapter;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Permission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.PointCreateCallbackBean;
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
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.Store;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreAvatar;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreDetail;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateAmountBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateGroupBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplatePrototypeListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateUpdateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.UserInfo;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outPermission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outSchedule;
import com.wdtpr.augus.debugnetexample.Pet.model.source.account.AccountModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.appointment.AppointmentModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.appointment.AppointmentStatus;
import com.wdtpr.augus.debugnetexample.Pet.model.source.card.CardModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.card.CardService;
import com.wdtpr.augus.debugnetexample.Pet.model.source.schedule.IScheduleModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.schedule.weekday;
import com.wdtpr.augus.debugnetexample.Pet.model.source.template.TemplateModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.template.TemplateType;
import com.wdtpr.augus.debugnetexample.Pet.presenter.account.AccountPresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.account.IAccountContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.appointment.AppointmentPresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.appointment.IAppointmentContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.calendar.CalendarPresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.calendar.ICalendarContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.card.CardPresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.card.ICardContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.customer.CustomerPresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.customer.ICustomerContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.faq.FAQPresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.faq.IFAQContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.item.IItemContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.item.ItemPresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.pet.IPetContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.pet.PetPresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.schedule.IScheduleContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.schedule.SchedulePresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.sns.ISNSContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.sns.SNSPresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.store.IStoreContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.store.StorePresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.template.ITemplateContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.template.TemplatePresenter;
import com.wdtpr.augus.debugnetexample.Pet.presenter.user.IUserContract;
import com.wdtpr.augus.debugnetexample.Pet.presenter.user.UserPresenter;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.fileUtils;
import com.wdtpr.augus.debugnetexample.base.network.progress.DownLoadProgressHandler;
import com.wdtpr.augus.debugnetexample.base.network.progress.ProgressHelper;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/5.
 */

public class PetDebugActivity extends AppCompatActivity {
    private String storeToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyNTc1NDgwLCJleHAiOjE1MjA0NjQ3MDAsIm5iZiI6MTUxMjU3NTQ4MCwianRpIjoiQk9hcXhJV1NwOTVkZWtOSCJ9.GODk-Ozt8iKnaKgDeSY56ckXWxQ4WGxKbamXTF0CS70";
    private String CustomerToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjE3LCJpc3MiOiJodHRwczpcL1wvbW9tb2RpLmNvbS50d1wvYXBpXC91c2VyXC9sb2dpbiIsImlhdCI6MTUxMjU3NzgyOCwiZXhwIjoxNTIwNDY3MDQ4LCJuYmYiOjE1MTI1Nzc4MjgsImp0aSI6IlR2b0x4VXRYeERhR3VDd0sifQ.YJ1nWqK9fPH6VVvThl4-vb24UGbUPlfUYyT7haZWTgI";
    private int storeID = 2;
    private int customerId = 17;
    private int provider_id = 5;
    private int PetId = 5;

    private String snsToken = "cDIRKIWjFB8:APA91bFx_0D3B_aisXVFWbrJj3WHPui2MA0MZmqDMDvgceZLONs4cX3Ea6AfIcIE7PZCSsXfqoGiFsj5CA_hMjmUpJiyQKLeTbzyhfUt1CmG4gq6yE_53cwWEg9lzS3sUnMz4CDu5zx-";
    private String model = "HTC One dual 802d";

    private String date = "2017-12-12";
    private String start_date = "2017-01-01";
    private String end_date = "2017-12-31";

    //appointment
    private String appointmentStartTime = "2017-12-15 10:00:00";
    private String appointmentEndTime = "2017-12-15 11:00:00";

    private UserPresenter userPresenter;
    private StorePresenter storePresenter;
    private CustomerPresenter customerPresenter;
    private PetPresenter petPresenter;
    private CalendarPresenter calendarPresenter;
    private FAQPresenter faqPresenter;
    private ItemPresenter itemPresenter;
    private SNSPresenter snsPresenter;
    private SchedulePresenter schedulePresenter;
    private AccountPresenter accountPresenter;
    private AppointmentPresenter appointmentPresenter;
    private CardPresenter cardPresenter;
    private TemplatePresenter templatePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressHelper.setProgressHandler(new DownLoadProgressHandler() {
            @Override
            protected void onProgress(long bytesRead, long contentLength, boolean done) {
                LogUtils.d("是否為主線程: " + String.valueOf(Looper.getMainLooper() == Looper.myLooper()));
                LogUtils.d("讀取資料量: " + String.valueOf(bytesRead));
                LogUtils.d("總資料量: " + String.valueOf(contentLength));
                LogUtils.d("onProgress: " + String.format("%d%% \n", (100 * bytesRead) / contentLength));
                LogUtils.d("是否已經讀取完成: " + String.valueOf(done));
//                dialog.setMax((int) (contentLength / 1024));
//                dialog.setProgress((int) (bytesRead / 1024));
//
//                if (done) {
//                    dialog.dismiss();
//                }
            }
        });


        //
        UserAPI();
        //
        storeAPI();
        //
        CustomerAPI();
        //
        PetAPI();
        //
        CalendarAPI();
        //
        FAQAPI();
        //
        ItemAPI();
        //
        SNSAPI();
        //
        ScheduleAPI();
        //
        AccountAPI();
        //
        AppointmentAPI();
        //
        CardAPI();
        //
        TemplateAPI();

    }

    //2
    private void UserAPI() {
        userPresenter = new UserPresenter(userView);
//        userPresenter.POSTCustomerRegist("paikw3w21312wq@gmail.com","jsain1221","11111","11111",
//                "高雄市","0000000000","0000000000","1988-03-31");

//        userPresenter.POSTLogin("paikw3w21312wq@gmail.com","11111");
    }

    //store 9
    private void storeAPI() {
        storePresenter = new StorePresenter(storeView);
        //商家列表
//        storePresenter.GETStoreList("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjE3LCJpc3MiOiJodHRwczpcL1wvbW9tb2RpLmNvbS50d1wvYXBpXC91c2VyXC9sb2dpbiIsImlhdCI6MTUxMjI2NTkzNCwiZXhwIjoxNTIwMTU1MTU0LCJuYmYiOjE1MTIyNjU5MzQsImp0aSI6ImlQQ21uN21lQ0U1TDl6UnUifQ.y0udaw4LY1dVqbjiYxsJmdWbhwLHPQGFGOTLMgzesyo");
        //商家詳細
//        storePresenter.GETStoreDetail("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyMjIxOTkyLCJleHAiOjE1MjAxMTEyMTIsIm5iZiI6MTUxMjIyMTk5MiwianRpIjoiaFEzeVJ4WFZiWDVFSkFkdyJ9.W0MEs93XyQFW4013JSdux8Fqpl3J03Mx8bYLEnb0z3E", 2);
        //修改商家明細
//        Store store = new Store("測試店","10:00 - 22:00","高雄市鼓山區蓮海路70號","https://www.google.com","https://www.google.com","https://www.google.com","07 525 2000","0912345678","我是帥哥");
//        storePresenter.PUTStoreDetail("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyMjIxOTkyLCJleHAiOjE1MjAxMTEyMTIsIm5iZiI6MTUxMjIyMTk5MiwianRpIjoiaFEzeVJ4WFZiWDVFSkFkdyJ9.W0MEs93XyQFW4013JSdux8Fqpl3J03Mx8bYLEnb0z3E", 2,store);
        //取得商家頭像
//        storePresenter.GETStoreAvatar("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyMjIxOTkyLCJleHAiOjE1MjAxMTEyMTIsIm5iZiI6MTUxMjIyMTk5MiwianRpIjoiaFEzeVJ4WFZiWDVFSkFkdyJ9.W0MEs93XyQFW4013JSdux8Fqpl3J03Mx8bYLEnb0z3E", 2);
//        修改頭像
//      MultipartBody.Part part = fileUtils.prepareFilePart(this,"avatar",data.getData());
//      storePresenter.POSTStoreAvatar("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyMjIxOTkyLCJleHAiOjE1MjAxMTEyMTIsIm5iZiI6MTUxMjIyMTk5MiwianRpIjoiaFEzeVJ4WFZiWDVFSkFkdyJ9.W0MEs93XyQFW4013JSdux8Fqpl3J03Mx8bYLEnb0z3E", 2,part);
//        takeGalleryPic();
//        美容師列表
//        storePresenter.GETStoreProvider("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyMjIxOTkyLCJleHAiOjE1MjAxMTEyMTIsIm5iZiI6MTUxMjIyMTk5MiwianRpIjoiaFEzeVJ4WFZiWDVFSkFkdyJ9.W0MEs93XyQFW4013JSdux8Fqpl3J03Mx8bYLEnb0z3E", 2);
//        取 商家權限
//        storePresenter.GetPermission("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyMjIxOTkyLCJleHAiOjE1MjAxMTEyMTIsIm5iZiI6MTUxMjIyMTk5MiwianRpIjoiaFEzeVJ4WFZiWDVFSkFkdyJ9.W0MEs93XyQFW4013JSdux8Fqpl3J03Mx8bYLEnb0z3E", 2);
//        修改商家權限
//        outPermission permission = new outPermission();
//        Permission.ResultObject.ProviderPermission providerPermission = new Permission.ResultObject.ProviderPermission();
//        providerPermission.setAPP_GO_FEEDBACK(false);
//        providerPermission.setAPP_QUESTION_ANSWER(false);
//        providerPermission.setCARD_ACTION_DEDUCTION_POINT(false);
//        providerPermission.setMEMBER_ACTION_CHECKOUT(false);
//        providerPermission.setSNS_ACTION_CARDPUSH(false);
//        Permission.ResultObject.AssistantPermission assistantPermission = new Permission.ResultObject.AssistantPermission();
//        assistantPermission.setAPP_PRICE_LIST(false);
//        assistantPermission.setAPP_QUESTION_ANSWER(false);
//        assistantPermission.setAPP_GO_FEEDBACK(false);
//        assistantPermission.setAPP_SET_STORE_SCHEDULE_TIME(false);
//        assistantPermission.setAPP_UPDATE_BUSSINESS_INFO(false);
//        assistantPermission.setBOARD_ACTION_SET_ADV(false);
//        assistantPermission.setBOARD_ACTION_SET_ANN(false);
//        assistantPermission.setBOARD_ACTION_SET_STORE(false);
//        assistantPermission.setCARD_ACTION_OPEN(false);
//        assistantPermission.setSNS_ACTION_MEMBERPUSH(false);
//        assistantPermission.setSNS_ACTION_MEMBERSPUSH(false);
//        permission.setProvider_permission(providerPermission);
//        permission.setAssistant_permission(assistantPermission);
//        storePresenter.PostPermission("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyMjIxOTkyLCJleHAiOjE1MjAxMTEyMTIsIm5iZiI6MTUxMjIyMTk5MiwianRpIjoiaFEzeVJ4WFZiWDVFSkFkdyJ9.W0MEs93XyQFW4013JSdux8Fqpl3J03Mx8bYLEnb0z3E", 2,permission);
        //綁定顧客
//        storePresenter.POSTStoreBindCustomer("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyMjIxOTkyLCJleHAiOjE1MjAxMTEyMTIsIm5iZiI6MTUxMjIyMTk5MiwianRpIjoiaFEzeVJ4WFZiWDVFSkFkdyJ9.W0MEs93XyQFW4013JSdux8Fqpl3J03Mx8bYLEnb0z3E",
//                2,"poop124113@gmail.com");
    }

    //customer 5
    private void CustomerAPI() {
        customerPresenter = new CustomerPresenter(customerView);
//        customerPresenter.GETCustomerList(storeToken);
//        customerPresenter.GETCustomerDetail(storeToken,17);
//        customerPresenter.PUTCustomerDetail(CustomerToken,17,0,"高雄","null","8898888888","0985622333","test");
//        customerPresenter.POSTCustomerBindStore(storeToken,17,"popo124117@gmail.com");

//        takeGalleryPic();
//        MultipartBody.Part part = fileUtils.prepareFilePart(this, "avatar", data.getData());
//        customerPresenter.POSTCustomerAvatar(CustomerToken, 17, part);
    }

    //pet 8
    private void PetAPI() {
        petPresenter = new PetPresenter(petView);
//        petPresenter.GETPetList(CustomerToken);
//        petPresenter.GETPetDetail(CustomerToken,5);
//        petPresenter.POSTCreatePet(CustomerToken,"測試","4",2,"","","O","12",false,"test");
//        petPresenter.PUTPetDetail(CustomerToken,75,"測試1","4",2,"","","O","12",false,"test");

//        MultipartBody.Part part = fileUtils.prepareFilePart(this, "pet_avatar", data.getData());
//        petPresenter.POSTPetAvatar(CustomerToken, 73, part);
//        takeGalleryPic();

//        petPresenter.DeletePet(CustomerToken,75);
//        petPresenter.GETPetMonthly(CustomerToken,75,2);
//        petPresenter.GETPetVariety(CustomerToken,"犬",1);

    }

    //Calendar 4
    private void CalendarAPI() {
        calendarPresenter = new CalendarPresenter(calendarStateView);
//       calendarPresenter.GETCalendarList(storeToken,2,true,"2017-01-01 00:00","2018-12-31 23:59",0);
//       calendarPresenter.POSTCalendar(storeToken,2,"2018-03-31 12:00","高雄市","測試用");
        //calendr
//        calendarPresenter.PUTCalendarStatus(storeToken,498,"finished","2018-03-31 12:30","高雄市仁武鄉","測試用update");
//        calendarPresenter.DeleteCalendar(storeToken,498);
    }

    //FAQ 4
    private void FAQAPI() {
        faqPresenter = new FAQPresenter(faqView);
//        faqPresenter.GETFAQList(CustomerToken,2,1);
//        faqPresenter.POSTFAQ(storeToken,2,"my question","my anwser");
//        faqPresenter.PUTFAQ(storeToken,13,"my question 1","my anwser 1");
//        faqPresenter.DeleteFAQ(storeToken,13);
    }

    //Item 4
    private void ItemAPI() {
        itemPresenter = new ItemPresenter(itemView);
//        itemPresenter.GETItemList(storeToken);
//        itemPresenter.POSTItem(storeToken,2,"小土豆",100);
//        itemPresenter.PUTItem(storeToken,98,"小土豆1",100);
//        itemPresenter.DeleteItem(storeToken,98);
    }

    //sns 8
    private void SNSAPI() {
        snsPresenter = new SNSPresenter(snsView);
//        snsPresenter.DeleteSNS(storeToken);
//        snsPresenter.POSTSNS(storeToken,snsToken,model);
//        snsPresenter.POSTSendAll(storeToken,"hello");
//        snsPresenter.POSTSendOne(storeToken,"17","hello");
//        snsPresenter.GETSNS(storeToken);
//        snsPresenter.GETSNSNotReadCount(storeToken);
//        snsPresenter.GETSNSForId(storeToken,282);
//        snsPresenter.POSTChangeSNSReadStatus(storeToken,473);

    }

    //Schedule 4
    private void ScheduleAPI() {
        schedulePresenter = new SchedulePresenter(scheduleView);

//        schedulePresenter.GETDaySchedule(storeToken,storeID,date);
//        schedulePresenter.GETWeekSchedule(storeToken,storeID);

        //data
        List<outSchedule> data = new ArrayList<>();
        outSchedule bean = new outSchedule();
        bean.setStart("08:00");
        bean.setEnd("11:00");
        outSchedule bean1 = new outSchedule();
        bean1.setStart("13:00");
        bean1.setEnd("20:00");
        data.add(bean);
        data.add(bean1);

//        schedulePresenter.POSTDayScheduleRule(storeToken,date,data);

        /* enum weekday */
        String weekdays = weekday.wednesday.name();
//        schedulePresenter.POSTScheduleRule(storeToken,weekdays,data);

    }

    //Account 5
    private void AccountAPI() {
        accountPresenter = new AccountPresenter(accountStateView);
//        accountPresenter.GETAccount(storeToken,storeID,start_date,end_date);
//        accountPresenter.GETAccountCustomer(storeToken,customerId,start_date,end_date);
//        accountPresenter.POSTAccount(storeToken, storeID, customerId, date, "API測試", "請忽略", 11);
//        accountPresenter.PUTAccount(storeToken, 91 ,customerId, "API測試", "請忽略", 11);
//        accountPresenter.DeleteAccount(storeToken,91);
    }

    //Appointment 13
    private void AppointmentAPI() {
        appointmentPresenter = new AppointmentPresenter(appointmentStateView);
        //
//        appointmentPresenter.GETAppointment(storeToken,"2017-01-01 00:00","2017-12-31 23:59",true,1);
        //
//        appointmentPresenter.GETAppointmentWithId(storeToken,266);
        //
//        appointmentPresenter.GETAppointmentWithStatus(storeToken, AppointmentStatus.pending.name(),"2017-01-01 00:00","2017-12-31 23:59",true,1);
        //
//        appointmentPresenter.GETAppointmentWithStroe(storeToken, storeID,"2017-01-01 00:00","2017-12-31 23:59",true,1);
        //
//        appointmentPresenter.GETAppointmentWithStroeWithStatus(storeToken, storeID,AppointmentStatus.pending.name(),"2017-01-01 00:00","2017-12-31 23:59",true,1);
        //
//        appointmentPresenter.GETAppointmentWithCustomer(storeToken, customerId,"2017-01-01 00:00","2017-12-31 23:59",true,1);
//        //
//        appointmentPresenter.GETAppointmentWithCustomerWithStatus(storeToken, customerId,AppointmentStatus.pending.name(),"2017-01-01 00:00","2017-12-31 23:59",true,1);
        //
//        appointmentPresenter.POSTAppointment_Store(storeToken,storeID,customerId,provider_id,PetId,"2017-12-15 10:00:00","2017-12-15 11:00:00",false,false,"test");
        //
//        appointmentPresenter.POSTAppointment_Customer(CustomerToken,storeID,customerId,PetId,"2017-12-15 10:00:00","2017-12-15 11:00:00",false,false,"test");
        //
//        appointmentPresenter.POSTAppointmentAccept(CustomerToken,266,provider_id);
        //
//        appointmentPresenter.POSTAppointmentFinish(CustomerToken,266);
        //
//        appointmentPresenter.POSTAppointmentCancel(CustomerToken,266);
        //
//        appointmentPresenter.POSTAppointmentDeny(CustomerToken,266);
    }

    //Card 9[2棄用]
    private void CardAPI() {
        cardPresenter = new CardPresenter(cardStateView);
//        cardPresenter.GETCustomerPetCardList(storeToken,customerId,storeID);
//        cardPresenter.GETPetCardDetail(storeToken,PetId,storeID);
//        cardPresenter.POSTPetCard(storeToken,PetId,storeID,"大修101次",100,10);
//        cardPresenter.PUTPetCard(storeToken,51,"大修101次",100);
//        cardPresenter.PUTCardBindAccount(storeToken,51,89);
//        cardPresenter.POSTCardPoint(storeToken,51, CardService.big.getName());
//        cardPresenter.DeleteCardPoint(storeToken,105);
    }

    //Template 9
    private void TemplateAPI() {
        templatePresenter = new TemplatePresenter(templateView);

//        templatePresenter.GETTemplateList(storeToken,storeID, TemplateType.advertisement.name());
//        templatePresenter.GETTemplateList(storeToken,storeID, TemplateType.announcement.name());
//        templatePresenter.GETTemplateList(storeToken,storeID, TemplateType.store.name());
//        templatePresenter.GETTemplateList(storeToken,storeID, TemplateType.lostSearch.name());

//        templatePresenter.GETTemplateBoardGroupList(storeToken,TemplateType.store.name());
//        templatePresenter.GETTemplatePrototypeList(storeToken,"advertisement-A");
//        templatePresenter.GETTemplateBoardCount(storeToken,storeID,TemplateType.advertisement.name());
//        templatePresenter.POSTTemplate(storeToken,storeID, "59ae9d302867e16672472921");
//        templatePresenter.GETTemplateBoard(storeToken, "5a3775242867e11108609493");
//        templatePresenter.DeleteTemplateBoard(storeToken, "5a2eb0ca2867e101353b3834");

        //image https://momodi.com.tw/api/store-template-id/5a3775242867e11108609493/component/0/content/0
        //text https://momodi.com.tw/api/store-template-id/5a3775242867e11108609493/component/2/content/
//        templatePresenter.POSTUpdateTemplateText("https://momodi.com.tw/api/store-template-id/5a3775242867e11108609493/component/2/content/",storeToken,"我很好");

//        takeGalleryPic();
//        MultipartBody.Part part = fileUtils.prepareFilePart(this, "image", data.getData());
//        templatePresenter.POSTUpdateTemplateImage("https://momodi.com.tw/api/store-template-id/5a3775242867e11108609493/component/0/content/0",storeToken,part);

    }

    //取得相簿照片
    public void takeGalleryPic() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //圖示
        if (requestCode == 1111 && resultCode == Activity.RESULT_OK && data != null) {
            //
            Log.d("image", data.getData().getPath());
            MultipartBody.Part part = fileUtils.prepareFilePart(this, "image", data.getData());
            templatePresenter.POSTUpdateTemplateImage("https://momodi.com.tw/api/store-template-id/5a3775242867e11108609493/component/0/content/0", storeToken, part);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userPresenter.unsubscribe();
        storePresenter.unsubscribe();
        customerPresenter.unsubscribe();
        petPresenter.unsubscribe();
        calendarPresenter.unsubscribe();
        faqPresenter.unsubscribe();
        itemPresenter.unsubscribe();
        snsPresenter.unsubscribe();
        schedulePresenter.unsubscribe();
        accountPresenter.unsubscribe();
        appointmentPresenter.unsubscribe();
        cardPresenter.unsubscribe();
        templatePresenter.unsubscribe();
    }

    public IUserContract.UserView userView = new IUserContract.UserView() {
        @Override
        public void registSuccess(registBackBean registBackBean) {
            LogUtils.d("Activity", registBackBean.toString());
        }

        @Override
        public void registFail() {
            LogUtils.d("Activity", "registFail");
        }

        @Override
        public void loginSuccess(UserInfo userInfo) {
            LogUtils.d("Activity", userInfo.toString());
        }

        @Override
        public void loginFail() {
            LogUtils.d("Activity", "loginFail");
        }

        @Override
        public void showLoading() {
            LogUtils.d("Activity", "showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("Activity", "hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("Activity", errorStr);
        }
    };

    public IStoreContract.StoreView storeView = new IStoreContract.StoreView() {
        @Override
        public void storeFail() {
            LogUtils.d("Activity", "storeFail");
        }

        @Override
        public void GETStoreListSuccess(StoreListBean storeListBean) {
            LogUtils.d("Activity", storeListBean.toString());
        }

        @Override
        public void GETStoreDetailSuccess(StoreDetail storeDetail) {
            LogUtils.d("Activity", storeDetail.toString());
        }

        @Override
        public void GETStoreProviderSuccess(ProviderListBean providerListBean) {
            LogUtils.d("Activity", providerListBean.toString());
        }

        @Override
        public void PUTStoreDetailSuccess(Status status) {
            LogUtils.d("Activity", status.toString());
        }

        @Override
        public void GETStoreAvatarSuccess(StoreAvatar storeAvatar) {
            LogUtils.d("Activity", storeAvatar.toString());
        }

        @Override
        public void POSTStoreAvatarSuccess(Status status) {
            LogUtils.d("Activity", status.toString());
        }

        @Override
        public void GETPermissionSuccess(Permission permission) {
            LogUtils.d("Activity", permission.toString());
        }

        @Override
        public void POSTPermissionSuccess(Status status) {
            LogUtils.d("Activity", status.toString());
        }

        @Override
        public void POSTStoreBindCustomerSuccess(Status status) {
            LogUtils.d("Activity", status.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("Activity", "showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("Activity", "hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("Activity", errorStr);
        }
    };

    public ICustomerContract.CustomerView customerView = new ICustomerContract.CustomerView() {
        @Override
        public void customerFail() {
            LogUtils.d("customerFail");
        }

        @Override
        public void GetCustomerListSuccess(CustomerListBean bean) {
            LogUtils.d("GetCustomerListSuccess : " + bean.toString());
        }

        @Override
        public void GETCustomerDetailSuccess(CustomerDetailBean bean) {
            LogUtils.d("GETCustomerDetailSuccess : " + bean.toString());
        }

        @Override
        public void PUTCustomerDetailSuccess(Status bean) {
            LogUtils.d("PUTCustomerDetailSuccess : " + bean.toString());
        }

        @Override
        public void POSTCustomerAvatarSuccess(Status bean) {
            LogUtils.d("POSTCustomerAvatarSuccess : " + bean.toString());
        }

        @Override
        public void POSTCustomerBindStoreSuccess(Status bean) {
            LogUtils.d("POSTCustomerBindStoreSuccess : " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("errorStr : " + errorStr);
        }
    };

    public IPetContract.PetView petView = new IPetContract.PetView() {
        @Override
        public void PetFail() {
            LogUtils.d("PetFail");
        }

        @Override
        public void GETPetList(PetListBean bean) {
            LogUtils.d("GETPetList " + bean.toString());
        }

        @Override
        public void GETPetDetail(PetDetailBean bean) {
            LogUtils.d("GETPetDetail " + bean.toString());
        }

        @Override
        public void POSTCreatePet(PetCreateStatusBean bean) {
            LogUtils.d("POSTCreatePet " + bean.toString());
        }

        @Override
        public void PUTPetDetail(Status bean) {
            LogUtils.d("PUTPetDetail " + bean.toString());
        }

        @Override
        public void POSTPetAvatar(Status bean) {
            LogUtils.d("POSTPetAvatar " + bean.toString());
        }

        @Override
        public void DeletePet(Status bean) {
            LogUtils.d("DeletePet " + bean.toString());
        }

        @Override
        public void GETPetMonthly(PetHasMonthCardBean bean) {
            LogUtils.d("GETPetMonthly " + bean.toString());
        }

        @Override
        public void GETPetVariety(PetVariety bean) {
            LogUtils.d("GETPetVariety " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading ");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading ");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("error " + errorStr);
        }
    };

    public ICalendarContract.CalendarStateView calendarStateView = new ICalendarContract.CalendarStateView() {
        @Override
        public void CalendarFail() {
            LogUtils.d("CalendarFail");
        }

        @Override
        public void GETCalendarList(CalendarListBean bean) {
            LogUtils.d("GETCalendarList :" + bean.toString());
        }

        @Override
        public void POSTCalendar(CalendarCallBackBean bean) {
            LogUtils.d("POSTCalendar :" + bean.toString());
        }

        @Override
        public void PUTCalendarStatus(Status bean) {
            LogUtils.d("PUTCalendarStatus :" + bean.toString());
        }

        @Override
        public void DeleteCalendar(Status bean) {
            LogUtils.d("DeleteCalendar :" + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("showUnknowError : " + errorStr);
        }
    };

    public IFAQContract.FAQView faqView = new IFAQContract.FAQView() {
        @Override
        public void FAQFail() {
            LogUtils.d("FAQFail");
        }

        @Override
        public void GETFAQListSuccess(FAQListBean bean) {
            LogUtils.d("GETFAQListSuccess: " + bean.toString());
        }

        @Override
        public void POSTFAQSuccess(FAQCallbackBean bean) {
            LogUtils.d("POSTFAQSuccess: " + bean.toString());
        }

        @Override
        public void PUTFAQSuccess(Status bean) {
            LogUtils.d("PUTFAQSuccess: " + bean.toString());
        }

        @Override
        public void DeleteFAQSuccess(Status bean) {
            LogUtils.d("DeleteFAQSuccess: " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("showUnknowError: " + errorStr);
        }
    };

    public IItemContract.ItemView itemView = new IItemContract.ItemView() {
        @Override
        public void ItemFail() {
            LogUtils.d("ItemFail");
        }

        @Override
        public void GETItemListSuccess(ItemListBean bean) {
            LogUtils.d("GETItemListSuccess: " + bean.toString());
        }

        @Override
        public void POSTItemSuccess(ItemCallbackBean bean) {
            LogUtils.d("POSTItemSuccess: " + bean.toString());
        }

        @Override
        public void PUTItemSuccess(Status bean) {
            LogUtils.d("PUTItemSuccess: " + bean.toString());
        }

        @Override
        public void DeleteItemSuccess(Status bean) {
            LogUtils.d("DeleteItemSuccess: " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("showUnknowError: " + errorStr);
        }
    };

    public ISNSContract.SNSView snsView = new ISNSContract.SNSView() {
        @Override
        public void SNSFail() {
            LogUtils.d("SNSFail");
        }

        @Override
        public void DeleteSNSSuccess(SNSCallbackBean bean) {
            LogUtils.d("DeleteSNSSuccess: " + bean.toString());
        }

        @Override
        public void POSTSNSSuccess(SNSCallbackBean bean) {
            LogUtils.d("POSTSNSSuccess: " + bean.toString());
        }

        @Override
        public void POSTSendAllSuccess(Status bean) {
            LogUtils.d("POSTSendAllSuccess: " + bean.toString());
        }

        @Override
        public void POSTSendOneSuccess(Status bean) {
            LogUtils.d("POSTSendOneSuccess: " + bean.toString());
        }

        @Override
        public void GETSNSSuccess(SNSListBean bean) {
            LogUtils.d("GETSNSSuccess: " + bean.toString());
        }

        @Override
        public void GETSNSNotReadCountSuccess(SNSNotReadBean bean) {
            LogUtils.d("GETSNSNotReadCountSuccess: " + bean.toString());
        }

        @Override
        public void GETSNSForIdSuccess(SNSDetailBean bean) {
            LogUtils.d("GETSNSForIdSuccess: " + bean.toString());
        }

        @Override
        public void POSTChangeSNSReadStatusSuccess(Status bean) {
            LogUtils.d("POSTChangeSNSReadStatusSuccess: " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("showUnknowError: " + errorStr);
        }
    };

    public IScheduleContract.ScheduleView scheduleView = new IScheduleContract.ScheduleView() {
        @Override
        public void ScheduleFail() {
            LogUtils.d("ScheduleFail");
        }

        @Override
        public void GETDayScheduleSuccess(ScheduleDayBean bean) {
            LogUtils.d("GETDayScheduleSuccess: " + bean.toString());
        }

        @Override
        public void GETWeekScheduleSuccess(ScheduleWeekBean bean) {
            LogUtils.d("GETWeekScheduleSuccess: " + bean.toString());
        }

        @Override
        public void POSTScheduleRuleSuccess(Status bean) {
            LogUtils.d("POSTScheduleRuleSuccess: " + bean.toString());
        }

        @Override
        public void POSTDayScheduleRuleSuccess(Status bean) {
            LogUtils.d("POSTDayScheduleRuleSuccess: " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("showUnknowError: " + errorStr);
        }
    };

    public IAccountContract.AccountStateView accountStateView = new IAccountContract.AccountStateView() {
        @Override
        public void AccountFail() {
            LogUtils.d("AccountFail");
        }

        @Override
        public void GETAccountSuccess(AccountListBean bean) {
            LogUtils.d("GETAccountSuccess: " + bean.toString());
        }

        @Override
        public void POSTAccountSuccess(AccountCallBackBean bean) {
            LogUtils.d("POSTAccountSuccess: " + bean.toString());
        }

        @Override
        public void GETAccountCustomerSuccess(AccountListBean bean) {
            LogUtils.d("GETAccountCustomerSuccess: " + bean.toString());
        }

        @Override
        public void PUTAccountSuccess(Status bean) {
            LogUtils.d("PUTAccountSuccess: " + bean.toString());
        }

        @Override
        public void DeleteAccountSuccess(Status bean) {
            LogUtils.d("DeleteAccountSuccess: " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("showUnknowError: " + errorStr);
        }
    };

    public IAppointmentContract.AppointmentStateView appointmentStateView = new IAppointmentContract.AppointmentStateView() {
        @Override
        public void AppointmentFail() {
            LogUtils.d("AppointmentFail");
        }

        @Override
        public void GETAppointment(AppointmentListBean bean) {
            LogUtils.d("GETAppointment: " + bean.toString());
        }

        @Override
        public void GETAppointmentWithId(AppointmentDetailBean bean) {
            LogUtils.d("GETAppointmentWithId: " + bean.toString());
        }

        @Override
        public void GETAppointmentWithStatus(AppointmentListBean bean) {
            LogUtils.d("GETAppointmentWithStatus: " + bean.toString());
        }

        @Override
        public void GETAppointmentWithStroe(AppointmentListBean bean) {
            LogUtils.d("GETAppointmentWithStroe: " + bean.toString());
        }

        @Override
        public void GETAppointmentWithStroeWithStatus(AppointmentListBean bean) {
            LogUtils.d("GETAppointmentWithStroeWithStatus: " + bean.toString());
        }

        @Override
        public void GETAppointmentWithCustomer(AppointmentListBean bean) {
            LogUtils.d("GETAppointmentWithCustomer: " + bean.toString());
        }

        @Override
        public void GETAppointmentWithCustomerWithStatus(AppointmentListBean bean) {
            LogUtils.d("GETAppointmentWithCustomerWithStatus: " + bean.toString());
        }

        @Override
        public void POSTAppointment_Store(Status bean) {
            LogUtils.d("POSTAppointment_Store: " + bean.toString());
        }

        @Override
        public void POSTAppointment_Customer(Status bean) {
            LogUtils.d("POSTAppointment_Customer: " + bean.toString());
        }

        @Override
        public void POSTAppointmentAccept(Status bean) {
            LogUtils.d("POSTAppointmentAccept: " + bean.toString());
        }

        @Override
        public void POSTAppointmentFinish(Status bean) {
            LogUtils.d("POSTAppointmentFinish: " + bean.toString());
        }

        @Override
        public void POSTAppointmentDeny(Status bean) {
            LogUtils.d("POSTAppointmentDeny: " + bean.toString());
        }

        @Override
        public void POSTAppointmentCancel(Status bean) {
            LogUtils.d("POSTAppointmentCancel: " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("showUnknowError: " + errorStr);
        }
    };

    public ICardContract.CardStateView cardStateView = new ICardContract.CardStateView() {
        @Override
        public void CardFail() {
            LogUtils.d("CardFail");
        }

        @Override
        public void GETCustomerPetCardList(CardListBean bean) {
            LogUtils.d("GETCustomerPetCardList: " + bean.toString());
        }

        @Override
        public void GETPetCardDetail(CardDetailBean bean) {
            LogUtils.d("GETPetCardDetail: " + bean.toString());
        }

        @Override
        public void POSTPetCard(CardCreateCallbackBean bean) {
            LogUtils.d("POSTPetCard: " + bean.toString());
        }

        @Override
        public void PUTPetCard(Status bean) {
            LogUtils.d("DeleteCardPoint: " + bean.toString());
        }

        @Override
        public void PUTCardBindAccount(Status bean) {
            LogUtils.d("PUTCardBindAccount: " + bean.toString());
        }

        @Override
        public void POSTCardPoint(PointCreateCallbackBean bean) {
            LogUtils.d("POSTCardPoint: " + bean.toString());
        }

        @Override
        public void DeleteCardPoint(Status bean) {
            LogUtils.d("DeleteCardPoint: " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("showUnknowError: " + errorStr);
        }
    };

    public ITemplateContract.TemplateView templateView = new ITemplateContract.TemplateView() {
        @Override
        public void TemplateFail() {
            LogUtils.d("TemplateFail");
        }

        @Override
        public void GETTemplateList(TemplateListBean bean) {
            LogUtils.d("GETTemplateList: " + bean.toString());
        }

        @Override
        public void GETTemplateBoardGroupList(TemplateGroupBean bean) {
            LogUtils.d("GETTemplateBoardGroupList: " + bean.toString());
        }

        @Override
        public void GETTemplatePrototypeList(TemplatePrototypeListBean bean) {
            LogUtils.d("GETTemplatePrototypeList: " + bean.toString());
        }

        @Override
        public void GETTemplateBoardCount(TemplateAmountBean bean) {
            LogUtils.d("GETTemplateBoardCount: " + bean.toString());
        }

        @Override
        public void POSTTemplate(TemplateCreateCallbackBean bean) {
            LogUtils.d("POSTTemplate: " + bean.toString());
        }

        @Override
        public void GETTemplateBoard(TemplateDetailBean bean) {
            LogUtils.d("GETTemplateBoard: " + bean.toString());
        }

        @Override
        public void DeleteTemplateBoard(Status bean) {
            LogUtils.d("DeleteTemplateBoard: " + bean.toString());
        }

        @Override
        public void POSTUpdateTemplateText(TemplateUpdateCallbackBean bean) {
            LogUtils.d("POSTUpdateTemplateText: " + bean.toString());
        }

        @Override
        public void POSTUpdateTemplateImage(TemplateUpdateCallbackBean bean) {
            LogUtils.d("POSTUpdateTemplateImage: " + bean.toString());
        }

        @Override
        public void showLoading() {
            LogUtils.d("showLoading");
        }

        @Override
        public void hideLoading() {
            LogUtils.d("hideLoading");
        }

        @Override
        public void showUnknowError(String errorStr) {
            LogUtils.d("showUnknowError: " + errorStr);
        }
    };
}
