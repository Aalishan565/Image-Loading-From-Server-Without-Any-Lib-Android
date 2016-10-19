package com.imageloadingwithoutanylib;

import android.graphics.Bitmap;

/**
 * Created by Ayesha on 19-10-2016.
 */

public interface IImageLoadingListener {
    void onImageDownloadSuccess(Bitmap bitmap);

    void onImageDownloadFailure();
}
