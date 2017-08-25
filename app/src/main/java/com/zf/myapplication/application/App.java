package com.zf.myapplication.application;

import android.app.Application;

import com.zf.myapplication.struct.internet.HttpHelper;
import com.zf.myapplication.struct.internet.OkhttpRequest;

/**
 * Created by Administrator on 2017/8/19 0019.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new OkhttpRequest());
    }
}
