package com.wdtpr.augus.debugnetexample.facebook.Model.source.post;


import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;

import org.json.JSONObject;

/**
 * Created by augus on 2017/12/14.
 */

public class FbGeneralPostModel implements IFbGeneralPostModel {

    private IFbGeneralPostModel.GeneralPostListener generalPostListener;

    public FbGeneralPostModel(GeneralPostListener generalPostListener) {
        this.generalPostListener = generalPostListener;
    }

    @Override
    public void FaceBookFeedPost(Bundle bundle) {
        generalPostListener.onStart();

        GraphRequest graphRequest = new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/feed",
                bundle,
                HttpMethod.POST, new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse response) {
                try {
                    LogUtils.d(response.toString());
                    if(response.getConnection().getResponseCode()==200){
                        LogUtils.d(response.getJSONObject().toString());
                        JSONObject object = response.getJSONObject();
                        String[] result = object.getString("id").split("_");
                        String fbUserId = result[0];
                        String fbPostId = result[1];
                        StringBuffer buffer = new StringBuffer();
                        buffer.append(fbUserId).append("/posts/").append(fbPostId);
                        generalPostListener.GeneralPostSucess(buffer.toString());
                    }else{
                        LogUtils.e(response.getError().getErrorMessage());
                        generalPostListener.onUnknowError(response.getError().getErrorMessage());
                    }
                }catch (Exception e){
                    generalPostListener.onUnknowError(e.getMessage());
                }finally {
                    generalPostListener.onComplete();
                }
            }
        });
        graphRequest.executeAsync();
    }


    public void unsubscribe() {
        generalPostListener = null;
    }
}
