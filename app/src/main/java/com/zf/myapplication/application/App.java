package com.zf.myapplication.application;

import android.app.Application;

import com.zf.myapplication.struct.Helper;
import com.zf.myapplication.struct.internet.OkhttpRequest;
import com.zf.myapplication.struct.picture.GlideImage;

/**
 * 2033152950
 * Created by zf on 2017/8/19 0019.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        Helper.addHttp(new OkhttpRequest());
        Helper.addHttp(new OkhttpRequest());
        Helper.addIImage(new GlideImage());
//        ImageHelper.addIImage(new GlideImage());

    }
}
