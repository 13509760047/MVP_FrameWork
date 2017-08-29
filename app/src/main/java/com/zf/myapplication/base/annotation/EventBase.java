package com.zf.myapplication.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *creater: zf
 * qq: 2033152950
 * time:2017/8/29 0029 下午 5:04
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventBase {
    Class listenType();
    String listenSet();
    String methodName();
}
