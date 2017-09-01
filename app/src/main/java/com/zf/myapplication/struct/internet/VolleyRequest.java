package com.zf.myapplication.struct.internet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * 2033152950
 * Created by zf on 2017/8/25 0025.
 */

public class VolleyRequest implements IHttpBase {

    private static RequestQueue Queue;

    private Handler mHandler;


    public VolleyRequest(Context context) {
        Queue = Volley.newRequestQueue(context);
        mHandler = new Handler();
    }

    @Override
    public void post(String url, final Map<String, Object> params, Object tag, final ICallback callback) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(response);
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(error.toString());
                    }
                });
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (params == null) {
                    Map<String, String> map = new HashMap<>();
                    for (Map.Entry<String, Object> key : params.entrySet()) {
                        map.put(key.getKey(), String.valueOf(key.getValue()));
                    }
                    return map;
                } else {
                    return null;
                }
            }
        };
        stringRequest.setTag(tag);
        Queue.add(stringRequest);
    }

    @Override
    public void get(String url, Map<String, Object> params, Object tag, final ICallback callback) {
        StringBuffer sb = new StringBuffer();
        sb.append(url);
        if (params != null) {
            for (Map.Entry<String, Object> key : params.entrySet()) {
                sb.append("&").append(key.getKey()).append("=").append(String.valueOf(key.getValue()));
            }
        }
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                sb.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(response);
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(error.toString());
                    }
                });
            }
        });
        stringRequest.setTag(tag);
        Queue.add(stringRequest);
    }

    @Override
    public void IamgeLoad(String url, Object tag, final ICallback callback) {
        ImageRequest imageRequest = new ImageRequest(
                url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(final Bitmap response) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccess(response);
                            }
                        });
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(error.toString());
                    }
                });
            }
        });
        imageRequest.setTag(tag);
        Queue.add(imageRequest);
    }

    @Override
    public void cancel(Object tag) {

    }
}
