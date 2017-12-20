package com.wdtpr.augus.debugnetexample;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;

public class DialogActivity extends AppCompatActivity {
    private MaterialDialog BasicDialog;
    private MaterialDialog ProgressDialog;
    private MaterialDialog ListDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

//        ProgressDialog();
//        ListDialog();

    }

    public void ProgressDialog(View view){
        //.backgroundColor(Color.GRAY) //背景顏色
        //.iconRes(R.mipmap.ic_launcher)//小圖示
        //.cancelable(false)//禁止dissmiss
        //.canceledOnTouchOutside(false)//禁止點擊對話視窗外部
        //.titleGravity(GravityEnum.CENTER)標題置中

        ProgressDialog = new MaterialDialog.Builder(this)
                .title("請稍等")
                .content("下載中")
                .canceledOnTouchOutside(false)
                .autoDismiss(true)
                .progress(true, 0).show();


//        startActivity(new Intent(this, PetDebugActivity.class));
//        //
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtils.d("change");
                        ProgressDialog.setContent("準備結束");
//                        LogUtils.d("close1");
//                        ProgressDialog.dismiss();
                    }
                });
            }
        },3000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LogUtils.d("close1");
                        ProgressDialog.dismiss();
                    }
                });
            }
        },6000);
    }


    public void ListDialog(View view){
        String array[] = new String[]{"test","test","test","test","test"};
        ListDialog = new MaterialDialog.Builder(this)
                .title("test list")
                .items(array)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        LogUtils.d("onSelection: position "+which+" ,text: "+text);
                    }
                })
                .show();
    }

    public void basicDialog(View view){
        BasicDialog=new MaterialDialog.Builder(this)
                .title("測試")
                .content("測試")
                .iconRes(R.mipmap.ic_launcher)//小圖示
                .maxIconSize(72)
                .positiveText("確定")
                .negativeText("取消")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        LogUtils.d("onClick: position "+which);
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        LogUtils.d("onClick: position "+which);
                    }
                })
                .show();
    }

    public void checkDialog(){

    }

    @Override
    public void onBackPressed() {
        if (ProgressDialog != null) {

        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
//        if(ProgressDialog != null){
//            ProgressDialog.build().dismiss();
//        }
    }
}
