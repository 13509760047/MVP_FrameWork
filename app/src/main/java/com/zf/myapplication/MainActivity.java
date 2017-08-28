package com.zf.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import com.zf.myapplication.base.BaseActivity;
import com.zf.myapplication.base.BasePresenter;
import com.zf.myapplication.struct.Helper;

public class MainActivity extends BaseActivity {
    private ImageView images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = (ImageView) findViewById(R.id.images);
        Helper.obtain().loadImage(this,
                "http://image.uczzd.cn/11647118377183585510.jpg?id=0&from=export", images);
    }

    @Override
    protected BasePresenter initPrasenter() {
        return null;
    }
}
