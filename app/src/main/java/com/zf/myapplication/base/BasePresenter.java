package com.zf.myapplication.base;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2017/8/19 0019.
 */

public abstract class BasePresenter<T> {

    protected T IView;

    public void setIView(@NonNull T IView) {
        this.IView = IView;
    }

    public void cancelIView() {
        IView = null;
    }
}
