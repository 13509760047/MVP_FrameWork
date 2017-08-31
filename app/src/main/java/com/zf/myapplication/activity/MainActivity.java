package com.zf.myapplication.activity;

import android.view.View;
import android.widget.ImageView;

import com.zf.myapplication.R;
import com.zf.myapplication.base.BaseActivity;
import com.zf.myapplication.base.annotation.ById;
import com.zf.myapplication.base.annotation.Click;
import com.zf.myapplication.base.annotation.ContentView;
import com.zf.myapplication.struct.Helper;


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
        Helper.obtain().loadImage(this,
                "http://image.uczzd.cn/17064951196925499644.gif?id=0&from=export", images);
    }

    @Click(R.id.btn)
    private void onclick(View view) {
        Helper.obtain().loadImage(this,
                "http://image.uczzd.cn/17064951196925499644.gif?id=0&from=export", images);
    }

}
