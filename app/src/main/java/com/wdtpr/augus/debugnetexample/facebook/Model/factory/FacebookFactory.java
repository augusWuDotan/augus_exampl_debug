package com.wdtpr.augus.debugnetexample.facebook.Model.factory;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.wdtpr.augus.debugnetexample.base.Utils.ListUtils;
import com.wdtpr.augus.debugnetexample.facebook.Model.bean.setting.FBPermission;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by augus on 2017/12/14.
 * 靜態呼叫方法
 */

public class FacebookFactory {

    private static volatile FacebookFactory facebookFactory;

    private FBPermission fbPermission;
    private CallbackManager callbackManager;


    public FacebookFactory() {
        //
        fbPermission = new FBPermission();
        callbackManager = CallbackManager.Factory.create();
    }

    public CallbackManager getCallbackManager() {
        return callbackManager;
    }

    public FBPermission getFbPermission() {
        return fbPermission;
    }

    public static FacebookFactory instance() {
        if (facebookFactory == null) {
            synchronized (FacebookFactory.class) {
                if (facebookFactory == null) {
                    facebookFactory = new FacebookFactory();
                }
            }
        }
        return facebookFactory;
    }

    public void addReadPermission(String...permission){
        List<String> readPermission = new ArrayList<>();
        for(String per : permission){
            readPermission.add(per);
        }
        fbPermission.setRead(readPermission);
    }

    public void addPublishPermission(String...permission){
        List<String> publishPermission = new ArrayList<>();
        for(String per : permission){
            publishPermission.add(per);
        }
        fbPermission.setPublish(publishPermission);
    }


    public void createPermission(LoginButton loginButton){
        int state = 0;// 0 = 在這之前沒有給予任何權限 ; 1= 在這之前有給予read權限 如果要給予publish權限  要先clear
        if(!ListUtils.isEmpty(fbPermission.getRead())){
            //read 權限
            loginButton.setReadPermissions(fbPermission.getRead());
            state = 1;//
        }
        //
        if(!ListUtils.isEmpty(fbPermission.getPublish())){
            //
            if(state == 1) loginButton.clearPermissions();
            //publish 權限
            loginButton.setPublishPermissions(fbPermission.getPublish());
        }
        //結束
        loginButton.clearPermissions();
    }



    //一般動態貼文

    //粉絲團動態貼文「訪客」

    //粉絲團動態貼文「管理員」

}
