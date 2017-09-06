package com.zf.myapplication.bspatch;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/9/6 0006 下午 3:02
 */

public class Bspatch {

    static {
        System.loadLibrary("Bspatch-lib");
    }
    public static native void bsPatch(String oldPath, String newPath, String patchPath);
}
