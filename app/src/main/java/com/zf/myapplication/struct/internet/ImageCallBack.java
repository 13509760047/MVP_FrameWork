package com.zf.myapplication.struct.internet;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/9/1 0001 下午 4:48
 */

public abstract class ImageCallBack implements ICallback{

    @Override
    public <V> void onSuccess(V result) {
        byte[] bytes = (byte[]) result;

    }
}
