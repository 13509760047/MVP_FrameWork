package com.zf.myapplication.base.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/8/29 0029 下午 5:09
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@EventBase(listenType = View.OnClickListener.class, listenSet = "setOnClickListener", methodName = "onClick")
public @interface Click {
    int[] value();
}
