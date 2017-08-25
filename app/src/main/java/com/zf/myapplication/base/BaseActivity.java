package com.zf.myapplication.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zf.myapplication.R;

/**
 *  2033152950
 * Created by zf on 2017/8/12 0025.
 */
public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {

    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = initPrasenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setIView((V)this);
    }

    @Override
    protected void onDestroy() {
        presenter.cancelIView();
        super.onDestroy();
    }

    protected abstract T initPrasenter();
}
