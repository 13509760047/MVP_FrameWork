package com.zf.myapplication.util;

import android.support.annotation.NonNull;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/8/19 0019.
 */

public class OkhttpRequest {


    private static OkhttpRequest okhttpRequest = null;

    private String url = null;

    private OkHttpClient okHttpClient = null;

    private OkhttpRequest() {
        okHttpClient = new OkHttpClient();
    }

    private OkhttpRequest newInstence() {
        if (okhttpRequest == null) {
            synchronized (this) {
                if (okhttpRequest == null) {
                    return new OkhttpRequest();
                }
            }
        }
        return okhttpRequest;
    }



    public void post(@NonNull String url, RequestBody requestBody, @NonNull Callback responseCallback) {
        Request.Builder RequestBuilder = new Request.Builder();

        RequestBuilder.url(url);
        if (requestBody != null) {
            RequestBuilder.post(requestBody);
        }

        Request request = RequestBuilder.build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(responseCallback);
    }

    public void get(@NonNull String url, RequestBody requestBody, @NonNull Callback responseCallback){
        Request.Builder RequestBuilder = new Request.Builder();

        RequestBuilder.url(url);
        if (requestBody != null) {
            RequestBuilder.get();
        }

        Request request = RequestBuilder.build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(responseCallback);
    }




}
