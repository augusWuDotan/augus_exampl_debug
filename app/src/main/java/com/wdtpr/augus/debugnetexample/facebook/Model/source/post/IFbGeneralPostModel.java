package com.wdtpr.augus.debugnetexample.facebook.Model.source.post;

import android.os.Bundle;

/**
 * Created by augus on 2017/12/14.
 */

public interface IFbGeneralPostModel {

    interface GeneralPostListener{

        void onStart();

        void GeneralPostSucess(String UrlStr);

        void onUnknowError(String errorStr);

        void onComplete();
    }

    void FaceBookFeedPost(Bundle bundle);
}
