package com.zf.myapplication.struct;

import com.zf.myapplication.struct.internet.ICallback;
import com.zf.myapplication.struct.internet.IHttpBase;

import java.util.Map;

/**
 * 2033152950
 * Created by zf on 2017/8/25 0025.
 */

public class Helper implements IHttpBase {

    private static IHttpBase mIhttpBase = null;

    private static Helper instance;

    private Helper(){}

    public static Helper obtain(){
        synchronized (Helper.class) {
            if (instance == null) {
                instance = new Helper();
            }
        }
        return instance;
    }

    public static void addHttp(IHttpBase ihttpBase){
        mIhttpBase = ihttpBase;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        mIhttpBase.post(url,params,callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
      mIhttpBase.get(url,params,callback);
    }
}
