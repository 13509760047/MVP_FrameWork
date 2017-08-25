package com.zf.myapplication.struct.internet;

/**
 * 2033152950
 * Created by zf on 2017/8/25 0025.
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
