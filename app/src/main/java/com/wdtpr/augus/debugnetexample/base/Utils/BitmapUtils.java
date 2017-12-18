package com.wdtpr.augus.debugnetexample.base.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by augus on 2017/12/2.
 */

public class BitmapUtils {



    public static String bitmapToBase64Str(String sourcePath, int reqWidth, int reqHeight) {
        // 照片編碼(Base64)字串格式
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(sourcePath, options);
        options.inSampleSize = calculateFitSize(reqWidth, reqHeight, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;

        Bitmap dst = BitmapFactory.decodeFile(sourcePath, options);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        dst.compress(Bitmap.CompressFormat.JPEG, 80, os);
        byte[] bytes = os.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public static Bitmap pathGetbitmap(String sourcePath, int reqWidth, int reqHeight) {
        // 照片編碼(Base64)字串格式
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(sourcePath, options);
        options.inSampleSize = calculateFitSize(reqWidth, reqHeight, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(sourcePath, options);
    }

    private static int calculateFitSize(int reqWidth, int reqHeight, BitmapFactory.Options options) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
