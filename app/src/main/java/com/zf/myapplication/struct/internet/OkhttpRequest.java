package com.zf.myapplication.struct.internet;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/19 0019.
 */

public class OkhttpRequest implements IHttpBase {

    private OkHttpClient okHttpClient;

    private Handler mHandler;

    public OkhttpRequest() {
        okHttpClient = new OkHttpClient();
        mHandler = new Handler();
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        Request.Builder Request = new Request.Builder();
        Request.url(url);
        if (params != null) {
            FormBody.Builder body = new FormBody.Builder();
            for (Map.Entry<String, Object> key : params.entrySet()) {
                body.add(key.getKey(), String.valueOf(key.getValue()));
            }
            Request.post(body.build());
        }
        Request.header("User-Agent", "a");
        okHttpClient.newCall(Request.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(result);
                        }
                    });
                } else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(response.message());
                        }
                    });
                }
            }
        });
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        Request.Builder Request = new Request.Builder();
        StringBuffer sb = new StringBuffer();
        sb.append(url);
        if (params != null) {
            for (Map.Entry<String, Object> key : params.entrySet()) {
                sb.append("&").append(key.getKey()).append("=").append(String.valueOf(key.getValue()));
            }
        }
        Request.url(sb.toString());
        Request.header("User-Agent", "a");
        okHttpClient.newCall(Request.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(result);
                        }
                    });
                } else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(response.message());
                        }
                    });
                }
            }
        });
    }
}
