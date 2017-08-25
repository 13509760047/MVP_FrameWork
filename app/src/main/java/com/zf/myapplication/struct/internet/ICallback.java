package com.zf.myapplication.struct.internet;

/**
 * creater：zf
 * qq：2033152950
 * time：2017/8/25 0025 下午 5:48
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
