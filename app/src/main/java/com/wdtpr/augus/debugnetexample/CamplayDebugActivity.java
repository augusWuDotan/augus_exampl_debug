package com.wdtpr.augus.debugnetexample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.wdtpr.augus.debugnetexample.camplay.model.bean.source.dynamic.DynamicModel;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by augus on 2017/12/5.
 */

public class CamplayDebugActivity extends AppCompatActivity {
    private String SeverToken = "17-96-C5-81-C2-69-B0-EA-22-78-FD-2E-E3-C8-CA-27-C3-D3-B1-AC-09-53-CC-10-7A-35-6F-E6-64-81-44-5C-34-CA-0F-CE-F7-A4-6C-60-FC-48-B7-B0-5A-56-D9-32-BF-49-CB-8E-37-B8-7A-96-A8-24-CE-C9-3A-2E-CD-53-2F-03-CB-3E-89-25-6E-ED-AF-7B-A2-32-D6-CE-CB-4E-73-AF-4B-9E-BE-79-8F-34-0C-EB-7D-5A-C1-57-E1-C6-2D-0A-2E-15-79-99-D3-C4-87-23-29-DB-E7-1C-6C-59-95-CC-5E-0E-34-9E-EF-EE-0C-D4-5B-12-6E-80-4A-76";
    private String AccessToken = "C5-D3-E2-61-27-81-8B-6A-D9-3D-A6-48-F2-1E-C9-D0-F3-51-69-BA-34-1D-63-47-CF-26-D0-5F-D7-52-5A-EA-DC-2C-B3-31-52-0C-B7-82-19-81-CD-E7-3A-71-2A-D3-58-9E-70-86-C7-3D-21-B5-59-3C-53-17-A1-6B-E9-48-2C-CD-CC-5A-FC-BC-29-3D-E3-57-C7-C3-E4-F4-3D-E0-68-1E-64-B9-FB-C8-6E-85-13-DD-3F-CB-EE-00-24-5E-8F-7D-F3-24-D7-BF-34-50-81-7E-D9-98-3F-15-73-AC-02-0D-99-74-03-12-8D-2E-F0-A6-38-5E-32-BF-A8-BE";
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

        for(int i = 0 ; i<count ; i++){
            try {
                Thread.sleep(doTimeAgain);
                if(i==0){
                    new Thread(mRunnable).start();
                }else if (i==1){
                    Thread.sleep(doTimeAgain);
                    new Thread(mRunnable).start();
                }else{
                    new Thread(mRunnable).start();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        account();
        DynamicAPI();
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
