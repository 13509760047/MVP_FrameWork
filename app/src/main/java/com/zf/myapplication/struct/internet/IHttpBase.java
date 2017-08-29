package com.zf.myapplication.struct.internet;

import java.util.Map;

/**
 * 2033152950
 * Created by zf on 2017/8/25 0025.
 */

public interface IHttpBase {

    /**
     * post请求
     *
     * @param url      请求地址
     * @param params   请求参数
     * @param tag      标签
     * @param callback 回调
     */
    public void post(String url, Map<String, Object> params, Object tag, ICallback callback);

    /**
     * get请求
     *
     * @param url      请求地址
     * @param params   请求参数
     * @param tag      标签
     * @param callback 回调
     */
    public void get(String url, Map<String, Object> params, Object tag, ICallback callback);

    /**
     * 取消
     * @param tag
     */
    public void cancel(Object tag);
}
