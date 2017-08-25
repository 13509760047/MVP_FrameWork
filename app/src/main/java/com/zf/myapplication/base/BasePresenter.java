package com.zf.myapplication.base;

import android.support.annotation.NonNull;

/**
 *  2033152950
 * Created by zf on 2017/8/12 0025.
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
