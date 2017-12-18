package com.wdtpr.augus.debugnetexample.facebook.Model.source.photo;

import android.net.Uri;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by augus on 2017/12/15.
 */

public class FbPhotoModel extends BaseModel implements IFbPhotoModel {
    List<String> photoList;//

    //
    private IFbPhotoModel.PhotoListener photoListener;

    public FbPhotoModel(PhotoListener photoListener) {
        this.photoListener = photoListener;
    }

    @Override
    public void PostPhotoUrl(List<String> urlList) {
        photoListener.onStart();
        /*
            Bundle b = new Bundle();
            b.putBoolean("published", false);
            b.putString("url", s);
         */
        photoList = new ArrayList<>();
        final int size = urlList.size();

        for(String url: urlList){
            Bundle b = new Bundle();
            b.putBoolean("published", false);
            b.putString("url", url);

            GraphRequest graphRequest = new GraphRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/me/photos",
                    b,
                    HttpMethod.POST,
                    new GraphRequest.Callback() {
                        @Override
                        public void onCompleted(GraphResponse response) {
                            LogUtils.d(response.toString());
                            try {
                                if (response.getConnection().getResponseCode() == 200) {
                                    String photoId =response.getJSONObject().getString("id");
                                    LogUtils.d(photoId);
                                    photoList.add(photoId);
                                    if(photoList.size() == size){
                                        photoListener.PostPhotoSucess(photoList);
                                    }
                                } else {
                                    LogUtils.d(response.getError().getErrorMessage());
                                    photoListener.onUnknowError(response.getError().getErrorMessage());
                                }
                            } catch (Exception e) {
                                LogUtils.e(e.getMessage());
                                photoListener.onUnknowError(e.getMessage());
                            } finally {
                                photoListener.onComplete();
                            }
                        }
                    }
            );
            graphRequest.executeAsync();
        }
    }

    @Override
    public void PostPhotoPath(Bundle bundle,List<Uri> uriList) throws FileNotFoundException {
        /*
         Bundle b = new Bundle();
         b.putBoolean("published", false);
         */
        photoList = new ArrayList<>();
        final int size = uriList.size();

        for(Uri  uri : uriList){
            GraphRequest graphRequest = GraphRequest.newUploadPhotoRequest(
                    AccessToken.getCurrentAccessToken(),
                    "me/photos",
                    uri,
                    null,
                    bundle,
                    new GraphRequest.Callback() {
                        @Override
                        public void onCompleted(GraphResponse response) {
                            try {
                                if (response.getConnection().getResponseCode() == 200) {
                                    String photoId =response.getJSONObject().getString("id");
                                    LogUtils.d(photoId);
                                    photoList.add(photoId);
                                    if(photoList.size() == size){
                                        photoListener.PostPhotoSucess(photoList);
                                    }
                                } else {
                                    LogUtils.d(response.getError().getErrorMessage());
                                    photoListener.onUnknowError(response.getError().getErrorMessage());
                                }
                            } catch (Exception e) {
                                LogUtils.e(e.getMessage());
                                photoListener.onUnknowError(e.getMessage());
                            } finally {
                                photoListener.onComplete();
                            }
                        }
                    }
            );

            graphRequest.executeAsync();
        }
    }


    /*
      Bitmap bitmap = Utils.pathGetbitmap(s, 320, 640);


            GraphRequest request = GraphRequest.newUploadPhotoRequest(
                    AccessToken.getCurrentAccessToken(), "me/photos", bitmap, null, b,
                    new GraphRequest.Callback() {
                        @Override
                        public void onCompleted(GraphResponse response) {
                            //
                            LogUtils.debug(response.toString());

                            try {
                                if(response.getJSONObject().getString("id")!=null) {//檢查是不是回傳訊息是失敗

                                    fbImageId.add(response.getJSONObject().getString("id"));
                                    LogUtils.debug("params " + params.toString());
                                    LogUtils.debug("fbImageId " + imgListsize + " , " + fbImageId.size());
                                    if (imgListsize == fbImageId.size()) {
                                        //結束圖片傳 開啟文章上傳
                                        int index = 0;
                                        JSONArray array = new JSONArray();

                                        for (String idString : fbImageId) {
                                            JSONObject o = new JSONObject();
                                            o.put("media_fbid", idString);
                                            array.put(o);
//                                        params.putString("attached_media[" + index + "]", new JSONObject()
//                                                .put("media_fbid", idString).toString());
                                            index++;
                                        }
                                        params.putString("attached_media", array.toString());
                                        feedToFaceBook(params);
                                    }
                                }else{
                                    //一般的發佈
                                    feedToFaceBook(params);
                                }

                            } catch (JSONException e) {
                                LogUtils.error(e.getMessage());
                            }
                        }
                    });
            request.executeAsync();
     */
}
