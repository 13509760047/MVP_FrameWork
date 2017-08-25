package com.zf.myapplication.struct.internet;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public interface ICallback {
    /**
     * 成功
     * @param result
     */
    void onSuccess(String result);

    /**
     * 失败
     * @param error
     */
    void onFailure(String error);
}
