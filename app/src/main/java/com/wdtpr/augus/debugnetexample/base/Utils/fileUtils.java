package com.wdtpr.augus.debugnetexample.base.Utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;

import io.reactivex.annotations.NonNull;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by augus on 2017/12/3.
 */

public class fileUtils {

    @NonNull
    public static MultipartBody.Part prepareFilePart(Context context, String fileKey, Uri fileName) {
        String mimeType = context.getContentResolver().getType(fileName);
        Log.d("TYPE:",mimeType);
        Cursor returnCursor =
                context.getContentResolver().query(fileName, null, null, null, null);
        Log.d("returnCursor Count:",returnCursor.getCount()+"");
        int actual_image_column_index = returnCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        Log.d("image_column_index:",actual_image_column_index+"");
        returnCursor.moveToFirst();
        String img_path = returnCursor.getString(actual_image_column_index);
        Log.d("img_path:",img_path);

        File file = new File(img_path);

        if (!file.isFile()) {
            Log.d("prepareFile","null");
            return null;
        } else {
            Log.d("prepareFile","has");
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData(fileKey, file.getName(), reqFile);
            return body;
        }

    }
}
