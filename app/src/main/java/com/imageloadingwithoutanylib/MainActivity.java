package com.imageloadingwithoutanylib;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IImageLoadingListener {
    private Button mBtnLoadImage;
    private ImageView mIvImage;
    private ProgressDialog mProgressDialog;
   // public static final String IMAGE_URL = "https://api.learn2crack.com/android/images/donut.png";
    public static final String IMAGE_URL = "http://api.androidhive.info/images/sample.jpg";
//	    public static final String IMAGE_URL = "http://www.9ori.com/store/media/images/8ab579a656.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnLoadImage = (Button) findViewById(R.id.btn_load_image);
        mIvImage = (ImageView) findViewById(R.id.iv_image);
        mBtnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog = new ProgressDialog(MainActivity.this);
                mProgressDialog.setMessage("Loading...");
                mProgressDialog.setIndeterminate(false);
                mProgressDialog.show();
                new ImageDownloadAsyncTask(MainActivity.this).execute(IMAGE_URL);
            }
        });
    }

    @Override
    public void onImageDownloadSuccess(Bitmap bitmap) {
        mProgressDialog.dismiss();
        mIvImage.setImageBitmap(bitmap);
    }

    @Override
    public void onImageDownloadFailure() {
        mProgressDialog.dismiss();
        Toast.makeText(this, "Error Loading Image", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mProgressDialog.isShowing() || mProgressDialog != null) {
            mProgressDialog.dismiss();
        }

    }
}
