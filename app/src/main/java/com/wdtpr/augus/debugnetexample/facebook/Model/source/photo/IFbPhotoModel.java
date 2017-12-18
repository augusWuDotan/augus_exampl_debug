package com.wdtpr.augus.debugnetexample.facebook.Model.source.photo;

import android.net.Uri;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by augus on 2017/12/15.
 */

public interface IFbPhotoModel {

    interface PhotoListener{

        void onStart();

        void PostPhotoSucess(List<String> photoIdList);

        void onUnknowError(String errorStr);

        void onComplete();
    }

    void PostPhotoUrl(List<String> urlList);

    void PostPhotoPath(Bundle bundle,List<Uri> uriList) throws FileNotFoundException;

}
