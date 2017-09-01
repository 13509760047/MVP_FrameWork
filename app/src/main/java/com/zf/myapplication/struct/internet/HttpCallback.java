package com.zf.myapplication.struct.internet;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * 2033152950
 * Created by zf on 2017/8/25 0025.
 */

public abstract class HttpCallback<Response> implements ICallback {


    @Override
    public <V extends Object> void onSuccess(V result) {
        Gson gson = new Gson();
        Class<?> clazz = resolveClass(this);
        Response response = (Response) gson.fromJson((String) result, clazz);
        onSucces(response);
    }

    public abstract void onSucces(Response response);

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
