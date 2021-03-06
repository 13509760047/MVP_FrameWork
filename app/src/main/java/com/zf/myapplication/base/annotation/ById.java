package com.zf.myapplication.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/8/28 0028 下午 5:46
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ById {
    int value();
}
