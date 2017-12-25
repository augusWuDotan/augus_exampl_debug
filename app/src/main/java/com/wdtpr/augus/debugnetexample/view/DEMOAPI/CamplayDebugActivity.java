package com.wdtpr.augus.debugnetexample.view.DEMOAPI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.wdtpr.augus.debugnetexample.R;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.order.ProductOrderBean;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.source.dynamic.DynamicModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by augus on 2017/12/5.
 */

public class CamplayDebugActivity extends AppCompatActivity {
    private String SeverToken = "76-F5-F5-89-21-3B-CB-D3-9C-7A-4F-75-5E-8D-B0-3A-9D-75-44-18-BF-92-A0-9B-DB-FD-A2-ED-BC-19-AF-E7-16-5F-3A-65-39-31-7C-00-41-3C-14-E4-16-AB-0C-08-A2-44-A6-CF-18-12-3A-47-3F-CA-5B-85-6E-D9-A8-9B-38-11-08-41-DA-7E-CE-01-4B-9D-28-79-40-FF-E1-BE-85-A2-8A-76-14-FE-A6-2B-5B-26-B2-AF-80-89-8F-2E-62-81-98-AA-AE-25-4E-18-52-98-FA-25-2A-16-9A-B9-D0-77-F9-D7-7B-22-BF-BF-C6-67-07-28-88-7F-52-94";
    private String AccessToken = "61-A5-FA-B1-7D-41-77-38-CB-F9-7A-FB-D5-E6-13-D3-E4-19-33-C0-AE-4F-16-B8-4D-9D-1C-44-1D-9F-8A-43-0E-00-28-07-74-CE-BB-34-60-17-5D-15-1E-60-5B-E3-8B-56-67-19-D6-EB-80-53-88-89-C8-76-12-09-76-DF-A9-2C-43-BE-47-07-06-55-40-61-B1-D0-34-34-3B-E3-19-12-F7-24-F1-A5-32-21-0E-8D-8C-00-6E-F7-E5-FE-2D-AC-FC-D5-9B-EF-F9-32-C6-81-A0-82-B4-ED-E0-56-60-DD-DB-46-16-F3-83-01-29-EB-42-20-AA-08-25-ED";
    private int memberId_Te = 5078;
    private int memberId_wu = 4997;
    private int blogerId = 5;

    private ExecutorService mExecutor;
    private int count = 30; //執行幾次
    private long doTimeAgain = 100;//多久一次


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        for(int i = 0 ; i<count ; i++){
//            try {
//                Thread.sleep(doTimeAgain);
//                if(i==0){
//                    new Thread(mRunnable).start();
//                }else if (i==1){
//                    Thread.sleep(doTimeAgain);
//                    new Thread(mRunnable).start();
//                }else{
//                    new Thread(mRunnable).start();
//                }
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        account();
//        DynamicAPI();

        OrderAPI();
    }

    private void  DynamicAPI(){
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,2660);//1
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,167);//2
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,1862);//3
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,309);//5
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,2022);//6
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,2662);//7
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,2082);//8
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,1935);//10
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,22);//11
//        new DynamicModel().GetActiveMessageByActiveID(SeverToken,AccessToken,memberId_Te,23);//12
        //all message
//        new DynamicModel().GetActiveMessage(SeverToken,AccessToken,memberId_wu,0);
        //blogger
//        new DynamicModel().GetActiveMessageByBloger(SeverToken,AccessToken,memberId_wu,0,blogerId);
        //first
//        new DynamicModel().getDynamicAndBloger(SeverToken,AccessToken,0,memberId_Te);
    }

    private void OrderAPI(){
        /*
        {Member_ID=4997, Contact_Phone='0985166631', Contact_Address='高雄市仁武區赤山里赤南巷48號', Contact_Name='吳東承',
        detail=[ProductOrderBean{Product_ID=19, Quantity=1, OrderDetailPrice=325, OrderDetailPoints=325}]}
         */
        ProductOrderBean  bean = new ProductOrderBean();
        bean.setMember_ID(4997);
        bean.setContact_Phone("0985166631");
        bean.setContact_Address("高雄市仁武區赤山里赤南巷48號");
        bean.setContact_Name("吳東承");

        List<ProductOrderBean.Detail> detailList = new ArrayList<>();
        ProductOrderBean.Detail detail = new ProductOrderBean.Detail();
        detail.setProduct_ID(19);
        detail.setQuantity(1);
        detail.setOrderDetailPrice(325);
        detail.setOrderDetailPoints(325);
        detailList.add(detail);
        bean.setDetail(detailList);

        LogUtils.d("order: "+bean.toString());

        new DynamicModel().AddOrder(SeverToken,AccessToken,bean);

    }

    public Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            new DynamicModel().GetActiveMessage(SeverToken,AccessToken,memberId_wu,0);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
