package com.wdtpr.augus.debugnetexample.facebook.Model.source.login;

import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.gson.Gson;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.FBLoginProfile.LoginUser;

import org.json.JSONObject;

/**
 * Created by augus on 2017/12/15.
 */

public class FbLoginModel extends BaseModel implements IFbLoginModel {

    private IFbLoginModel.LoginListener loginListener;

    public FbLoginModel(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    @Override
    public void FaceBooklogin(Bundle parameters) {
        loginListener.onStart();

        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Insert your code here
                        try {
                            LogUtils.d(response.toString());
                            if(response.getConnection().getResponseCode()==200){
                                LoginUser loginUser = new Gson().fromJson(object.toString(), LoginUser.class);
                                loginListener.LoginSucess(loginUser);
                            }else{
                                LogUtils.e(response.getError().getErrorMessage());
                                loginListener.onUnknowError(response.getError().getErrorMessage());
                            }

                        }catch (Exception e){
                            loginListener.onUnknowError(e.getMessage());
                        }finally {
                            loginListener.onComplete();
                        }
                    }
                });

        request.setParameters(parameters);
        request.executeAsync();
    }

}
