package com.zf.myapplication.base;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.zf.myapplication.base.annotation.ById;
import com.zf.myapplication.base.annotation.Click;
import com.zf.myapplication.base.annotation.ContentView;
import com.zf.myapplication.base.annotation.EventBase;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/8/29 0029 上午 9:57
 */

public class ViewUtil {

    public static void injectContentView(@NonNull Activity activity) {
        Class<?> clazz = activity.getClass();
        if (clazz.getAnnotations() != null) {
            if (clazz.isAnnotationPresent(ContentView.class)) {
                ContentView inject = clazz.getAnnotation(ContentView.class);
                activity.setContentView(inject.value());
            }
        }
    }

    public static void injectById(@NonNull Activity activity) {
        Class<?> clazz = activity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getAnnotations() != null) {
                    if (field.isAnnotationPresent(ById.class)) {
                        //关闭安全监测 提高性能
                        field.setAccessible(true);
                        ById inject = field.getAnnotation(ById.class);
                        field.set(activity, activity.findViewById(inject.value()));
                    }
                }
            } catch (Exception e) {
                Log.e("ById", "not found view id!");
            }
        }
    }

    public static void injectEvents(@NonNull Activity activity) {
        Class a = activity.getClass();
        Method[] methods = a.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Click.class)) {
                Click click = method.getAnnotation(Click.class);
                int[] viewids = click.value();
                EventBase eventbase = click.annotationType().getAnnotation(EventBase.class);
                String listenSet = eventbase.listenSet();
                Class<?> listenType = eventbase.listenType();
                String methodName = eventbase.methodName();
                DynamicHandler dy = new DynamicHandler(activity);
                Object listen = Proxy.newProxyInstance(listenType.getClassLoader(),
                        new Class<?>[]{listenType}, dy);
                dy.addMethod(methodName, method);
                for (int viewid : viewids) {
                    try {
                        Method byid = a.getMethod("findViewById", int.class);
                        byid.setAccessible(true);
                        View view = (View) byid.invoke(activity, viewid);
                        Method set = view.getClass().getMethod(listenSet, listenType);
                        set.setAccessible(true);
                        set.invoke(activity, listen);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
