package com.zf.myapplication.struct.internet;

import android.os.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 2033152950
 * Created by zf on 2017/8/19 0019.
 */

public class OkhttpRequest implements IHttpBase {

    private OkHttpClient okHttpClient;

    private Handler mHandler;

    public OkhttpRequest() {
        okHttpClient = new OkHttpClient();
        mHandler = new Handler();
    }

    @Override
    public void post(String url, Map<String, Object> params, Object tag, final ICallback callback) {
        Request.Builder Request = new Request.Builder();
        Request.tag(tag);
        Request.url(url);
        if (params != null) {
            FormBody.Builder body = new FormBody.Builder();
            for (Map.Entry<String, Object> key : params.entrySet()) {
                body.add(key.getKey(), String.valueOf(key.getValue()));
            }
            Request.post(body.build());
        }
        Request.header("User-Agent ", "a");
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
    public void get(String url, Map<String, Object> params, Object tag, final ICallback callback) {
        Request.Builder Request = new Request.Builder();
        StringBuffer sb = new StringBuffer();
        sb.append(url);
        if (params != null) {
            for (Map.Entry<String, Object> key : params.entrySet()) {
                sb.append("&").append(key.getKey()).append("=").append(String.valueOf(key.getValue()));
            }
        }
        Request.url(sb.toString());
        Request.tag(tag);
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
    public void IamgeLoad(String url, Object tag, final ICallback callback) {
        Request.Builder Request = new Request.Builder();
        Request.tag(tag);
        Request.url(url);
        Request.header("User-Agent ", "a");
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

                    byte[] bytes = new byte[1024];
                    InputStream is = null;
                    is = response.body().byteStream();
                    long length = response.body().contentLength();
                    long sum = 0;
                    int len = 0;
                    while ((len = is.read(bytes)) != -1){

                    }

                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
//                                callback.onSuccess();
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
    public void cancel(Object tag) {
        Dispatcher dispatcher = okHttpClient.dispatcher();
        synchronized (dispatcher) {
            for (Call call : dispatcher.queuedCalls()) {
                if (tag.equals(call.request().tag())) {
                    call.cancel();
                }
            }
            for (Call call : dispatcher.runningCalls()) {
                if (tag.equals(call.request().tag())) {
                    call.cancel();
                }
            }
        }
    }
}
