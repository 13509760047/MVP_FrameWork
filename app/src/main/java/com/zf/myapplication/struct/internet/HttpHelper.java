package com.zf.myapplication.struct.internet;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class HttpHelper implements IHttpBase {

    private static IHttpBase mIhttpBase = null;

    private static HttpHelper instance;

    private HttpHelper(){}

    public static HttpHelper obtain(){
        synchronized (HttpHelper.class) {
            if (instance == null) {
                instance = new HttpHelper();
            }
        }
        return instance;
    }

    public static void init(IHttpBase ihttpBase){
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
