package com.zf.myapplication.base;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/8/29 0029 下午 5:32
 */

public class DynamicHandler implements InvocationHandler {
    private final HashMap<String, Method> map = new HashMap<>(1);

    private WeakReference<Object> Ref;

    public DynamicHandler(Object object) {
        Ref = new WeakReference<Object>(object);
    }

    public void addMethod(String name, Method method) {
        map.put(name, method);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object... args) throws Throwable {
        Object handler = Ref.get();
        if (handler != null) {
            String methodName = method.getName();
            method = map.get(methodName);
            if (method != null) {
                return method.invoke(handler, args);
            }
            return null;
        }
        return null;
    }
}
