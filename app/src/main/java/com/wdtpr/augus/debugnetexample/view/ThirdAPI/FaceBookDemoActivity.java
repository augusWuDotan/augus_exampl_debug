package com.wdtpr.augus.debugnetexample.view.ThirdAPI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.wdtpr.augus.debugnetexample.R;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.fileUtils;
import com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.FBLoginProfile.LoginUser;
import com.wdtpr.augus.debugnetexample.facebook.Model.factory.FacebookFactory;
import com.wdtpr.augus.debugnetexample.facebook.Model.source.login.FbLoginModel;
import com.wdtpr.augus.debugnetexample.facebook.Model.source.login.IFbLoginModel;
import com.wdtpr.augus.debugnetexample.facebook.Model.source.photo.FbPhotoModel;
import com.wdtpr.augus.debugnetexample.facebook.Model.source.photo.IFbPhotoModel;
import com.wdtpr.augus.debugnetexample.facebook.Model.source.post.FbGeneralPostModel;
import com.wdtpr.augus.debugnetexample.facebook.Model.source.post.IFbGeneralPostModel;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/5.
 */
public class FaceBookDemoActivity extends AppCompatActivity {
    private LoginButton mFBLoginBut;
    private FacebookFactory facebookFactory;
    private CallbackManager callbackManager;

    private String placeId = "304476396345712";
    private String friendsId1 = "324570774676649";
    private String friendsId2 = "105047410281716";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (LoginManager.getInstance() != null) {
            LogUtils.d("Facebook token:" + AccessToken.getCurrentAccessToken());
            LogUtils.d("Facebook token:" + Profile.getCurrentProfile());
//            LoginManager.getInstance().logOut();
        }

        facebookFactory = FacebookFactory.instance();
        callbackManager = facebookFactory.getCallbackManager();
        facebookFactory.addReadPermission("email", "user_friends", "public_profile","user_photos");
        facebookFactory.addPublishPermission("publish_actions");
        mFBLoginBut = findViewById(R.id.mFBLoginBut);
        facebookFactory.createPermission(mFBLoginBut);//建立權限
        LoginFb();
    }

    private void LoginFb() {

        mFBLoginBut.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                LogUtils.d("Facebook getRecentlyDeniedPermissions: " + loginResult.getRecentlyDeniedPermissions().toString());
                LogUtils.d("Facebook getRecentlyGrantedPermissions: " + loginResult.getRecentlyGrantedPermissions().toString());
                LogUtils.d("Facebook getAccessToken: " + loginResult.getAccessToken());

                FbLoginModel fbLoginModel = new FbLoginModel(loginListener);
                Bundle parameters = new Bundle();
                parameters.putString("fields", "email,friends{name,picture.height(300).width(300){url}},cover,name,id,picture.height(300).width(300){url}");
                fbLoginModel.FaceBooklogin(parameters);

            }

            @Override
            public void onCancel() {
                LogUtils.d("Facebook onCancel");
            }

            @Override
            public void onError(FacebookException error) {

                LogUtils.d("Facebook onError: "+error.getMessage());
            }
        });
    }

    //一般測試
    public void FbGeneralPost(View v){
        FbGeneralPostModel generalPostModel =  new FbGeneralPostModel(generalPostListener);
        Bundle params = new Bundle();
        params.putString("message", "test1");
        try {
            JSONObject object = new JSONObject();
            object.put("value", "SELF");
            params.putString("privacy", object.toString());
        } catch (Exception e) {

        }
        generalPostModel.FaceBookFeedPost(params);
    }

    //圖片上傳「ＵＲＬ」
    public void FbPostPhotoUrl(View v){
        List<String> urlList = new ArrayList<>();
        urlList.add("https://www.taiwan.net.tw/resources/images/Attractions/0001095.jpg");
        urlList.add("https://www.taiwan.net.tw/resources/images/Attractions/0001095.jpg");
        urlList.add("https://www.taiwan.net.tw/resources/images/Attractions/0001095.jpg");
        FbPhotoModel  fbPhotoModel = new FbPhotoModel(photoListener);
        fbPhotoModel.PostPhotoUrl(urlList);
    }

    //圖片上傳「ＵＲＬ」
    public void FbPostPhotoPath(View v){
        takeGalleryPic();
    }

    public IFbLoginModel.LoginListener loginListener = new IFbLoginModel.LoginListener() {
        @Override
        public void onStart() {
            LogUtils.d("onStart");
        }

        @Override
        public void LoginSucess(LoginUser loginUser) {
            LogUtils.d(loginUser.toString());
        }

        @Override
        public void onUnknowError(String errorStr) {
            LogUtils.e(errorStr);
        }

        @Override
        public void onComplete() {
            LogUtils.d("onComplete");
        }
    };

    public IFbGeneralPostModel.GeneralPostListener generalPostListener = new IFbGeneralPostModel.GeneralPostListener() {
        @Override
        public void onStart() {
            LogUtils.d("onStart");
        }

        @Override
        public void GeneralPostSucess(String UrlStr) {
            LogUtils.d(UrlStr);
        }

        @Override
        public void onUnknowError(String errorStr) {
            LogUtils.e(errorStr);
        }

        @Override
        public void onComplete() {
            LogUtils.d("onComplete");
        }
    };

    public IFbPhotoModel.PhotoListener photoListener = new IFbPhotoModel.PhotoListener() {
        @Override
        public void onStart() {
            LogUtils.d("onStart");
        }

        @Override
        public void PostPhotoSucess(List<String> photoIdList) {
            LogUtils.d("Photoid : "+photoIdList.toString());
        }

        @Override
        public void onUnknowError(String errorStr) {
            LogUtils.d("error : "+errorStr);
        }

        @Override
        public void onComplete() {
            LogUtils.d("onComplete");
        }
    };

    //取得相簿照片
    public void takeGalleryPic() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        //圖示
        if (requestCode == 1111 && resultCode == Activity.RESULT_OK && data != null) {
            //
            Log.d("image", data.getData().toString());
            List<Uri> uriList = new ArrayList<>();
            uriList.add( data.getData());
            uriList.add( data.getData());
            Bundle b = new Bundle();
            b.putBoolean("published", false);
            FbPhotoModel  fbPhotoModel = new FbPhotoModel(photoListener);
            try {
                fbPhotoModel.PostPhotoPath(b,uriList);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
