package com.zf.myapplication.activity;

import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.zf.myapplication.R;
import com.zf.myapplication.base.BaseActivity;
import com.zf.myapplication.base.annotation.ById;
import com.zf.myapplication.base.annotation.Click;
import com.zf.myapplication.base.annotation.ContentView;
import com.zf.myapplication.bspatch.ApkExtruct;
import com.zf.myapplication.bspatch.Bspatch;
import com.zf.myapplication.struct.Helper;

import java.io.File;


@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity<MainPrasenter> {




    @ById(R.id.images)
    private ImageView images;


    @Override
    protected MainPrasenter initPrasenter() {
        return new MainPrasenter();
    }

    @Override
    protected void init() {

        if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        } else {
            doBspatch();
        }

        Helper.obtain().loadImage(this,
                "http://image.uczzd.cn/17064951196925499644.gif?id=0&from=export", images);
    }

    private void doBspatch() {
        final File destApk = new File(Environment.getExternalStorageDirectory(), "dest.apk");
        final File patch = new File(Environment.getExternalStorageDirectory(), "apk.patch");

        Bspatch.bsPatch(ApkExtruct.extract(this),
                destApk.getAbsolutePath(),
                patch.getAbsolutePath());

        if (destApk.exists())
            ApkExtruct.install(this, destApk.getAbsolutePath());
    }

    @Click(R.id.btn)
    private void onclick(View view) {
        Helper.obtain().loadImage(this,
                "http://image.uczzd.cn/17064951196925499644.gif?id=0&from=export", images);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                doBspatch();
            }
        }
    }
}
