package com.zf.myapplication.struct.internet;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * Created by Administrator on 2017/8/25 0025.
 */

public abstract class HttpCallback<Response> implements ICallback {

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clazz = resolveClass(this);
        Response response = (Response) gson.fromJson(result, clazz);
        onSuccess(response);
    }

    public abstract void onSuccess(Response response);

    /**
     * 获取Resonse的Class
     *
     * @param object this
     * @return (Resonse).Class
     */
    private Class<?> resolveClass(Object object) {
        Type type = object.getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType) (type)).getActualTypeArguments();
        return (Class<?>) types[0];
    }


}
