package com.zf.myapplication.struct;

import android.content.Context;
import android.widget.ImageView;

import com.zf.myapplication.struct.internet.ICallback;
import com.zf.myapplication.struct.internet.IHttpBase;
import com.zf.myapplication.struct.picture.IPictureBase;

import java.util.Map;

/**
 * 2033152950
 * Created by zf on 2017/8/25 0025.
 */

public class Helper implements IHttpBase, IPictureBase {

    private static IHttpBase mIhttpBase = null;

    private static IPictureBase iPictureBase = null;

    private static Helper instance;

    private Helper() {
    }

    public static Helper obtain() {
        synchronized (Helper.class) {
            if (instance == null) {
                instance = new Helper();
            }
        }
        return instance;
    }

    public static void addHttp(IHttpBase ihttpBase) {
        mIhttpBase = ihttpBase;
    }

    public static void addIImage(IPictureBase miPictureBase) {
        iPictureBase = miPictureBase;
    }

    @Override
    public void post(String url, Map<String, Object> params, Object tag, ICallback callback) {
        mIhttpBase.post(url, params, tag, callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, Object tag, ICallback callback) {
        mIhttpBase.get(url, params, tag, callback);
    }

    @Override
    public void downLoad(String url, Object tag, ICallback callback) {

    }

    @Override
    public void cancel(Object tag) {
        mIhttpBase.cancel(tag);
    }

    @Override
    public <C extends Context> void loadImage(C c, String ImagePath, ImageView view) {
        iPictureBase.loadImage(c, ImagePath, view);
    }
}
