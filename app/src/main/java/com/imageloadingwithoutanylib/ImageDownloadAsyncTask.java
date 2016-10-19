package com.imageloadingwithoutanylib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Ayesha on 19-10-2016.
 */

public class ImageDownloadAsyncTask extends AsyncTask<String, Void, Bitmap> {
    private IImageLoadingListener imageLoadingListener;

    public ImageDownloadAsyncTask(IImageLoadingListener imageLoadingListener) {
        this.imageLoadingListener = imageLoadingListener;
    }


    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            imageLoadingListener.onImageDownloadSuccess(result);
        } else {
            imageLoadingListener.onImageDownloadFailure();
        }
    }
}

