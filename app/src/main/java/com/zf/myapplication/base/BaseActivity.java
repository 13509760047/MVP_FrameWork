package com.zf.myapplication.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 2033152950
 * Created by zf on 2017/8/12 0025.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtil.injectContentView(this);
        ViewUtil.injectById(this);
//        ViewUtil.injectEvents(this);
        presenter = initPrasenter();
        init();
    }

    @Override
    protected void onDestroy() {
        presenter.cancelIView();
        super.onDestroy();
    }

    protected abstract T initPrasenter();

    protected abstract void init();

}
